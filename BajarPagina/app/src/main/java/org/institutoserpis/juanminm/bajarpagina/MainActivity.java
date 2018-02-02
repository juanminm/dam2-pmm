package org.institutoserpis.juanminm.bajarpagina;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText urlField;
    private Spinner protocolSpinner;
    private TextView data;
    String link = "http://www.google.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urlField = findViewById(R.id.editText1);
        data = findViewById(R.id.textView2);
    }

    public void download(View view){
        String url = protocolSpinner.getSelectedItem().toString() + urlField.getText().toString();
        DownloadWebPage paginaWeb=new DownloadWebPage(this,data);

        paginaWeb.execute(url);
    }

}