package org.institutoserpis.juanminm.leerjson2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Http Connection";

    private TextView estasEnTView;
    private Button obtenerLugarButton;
    private EditText latitudEText;
    private EditText longitudEText;
    private String salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        double latitud = 0;
        double longitud = 0;

        latitudEText = findViewById(R.id.activity_main_et_latitud);
        longitudEText = findViewById(R.id.activity_main_et_longitud);
        estasEnTView = findViewById(R.id.activity_main_tv_estas_en);
        obtenerLugarButton = findViewById(R.id.activity_main_btn_obtener_lugar);

        obtenerLugarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerLugar();
            }
        });
    }

    private void obtenerLugar() {
        double latitud = Double.parseDouble(latitudEText.getText().toString());
        double longitud = Double.parseDouble(longitudEText.getText().toString());
        String apiKey = "AIzaSyD3cPQg5xjHnaf5GKiOkZ9MFo02hYRN-U8";

        String url = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + latitud +
                "," + longitud + "&key=" + apiKey;

        new AsyncHttpTask().execute(url);
    }


    public class AsyncHttpTask extends AsyncTask<String, Void, Integer> {

        @Override
        protected Integer doInBackground(String... params) {
            InputStream inputStream;

            HttpURLConnection urlConnection;

            Integer result = 0;
            try {
                /* forming th java.net.URL object */
                URL url = new URL(params[0]);

                urlConnection = (HttpURLConnection) url.openConnection();

                 /* optional request header */
                urlConnection.setRequestProperty("Content-Type", "application/json");

                /* optional request header */
                urlConnection.setRequestProperty("Accept", "application/json");

                /* for Get request */
                urlConnection.setRequestMethod("GET");

                int statusCode = urlConnection.getResponseCode();

                /* 200 represents HTTP OK */
                if (statusCode ==  200) {

                    inputStream = new BufferedInputStream(urlConnection.getInputStream());

                    String response = convertInputStreamToString(inputStream);

                    parseResult(response);

                    result = 1; // Successful

                } else {
                    result = 0; //"Failed to fetch data!";
                }

            } catch (Exception e) {
                Log.d(TAG, e.getLocalizedMessage());
            }

            return result; //"Failed to fetch data!";
        }


        @Override
        protected void onPostExecute(Integer result) {
            /* Download complete. Lets update UI */

            if (result == 1) {
                estasEnTView.setText(salida);
            } else {
                Log.e(TAG, "Failed to fetch data!");
            }
        }
    }


    private String convertInputStreamToString(InputStream inputStream) throws IOException {

        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));

        String line;
        StringBuilder result = new StringBuilder();

        while((line = bufferedReader.readLine()) != null){
            result.append(line);
        }

        /* Close Stream */
        inputStream.close();

        return result.toString();
    }
    private void parseResult(String result) {

        try{
            JSONObject response = new JSONObject(result);

            String status = response.optString("status");

            if (status.equals("OK")) {
                JSONArray results = response.optJSONArray("results");
                JSONObject firstResult = results.optJSONObject(0);
                salida = firstResult.optString("formatted_address");
            } else {
                if(response.optString("error_message") != null &&
                        !response.optString("error_message").isEmpty()) {
                    salida = response.optString("error_message");
                }
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
    }

}