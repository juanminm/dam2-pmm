package org.institutoserpis.juanminm.proyectofinal;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author Juan Miguel Navarro Martínez
 */

public class LoginActivity extends AppCompatActivity {

    public static final String LOGGED_PLAYER = "org.institutoserpis.juanminm.proyectofinal.LOGIN_PLAYER";

    EditText usernameInput;
    EditText passwordInput;
    Button loginButton;

    DatabaseHelper dbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DatabaseHelper(this);

        usernameInput = findViewById(R.id.activity_login_et_username);
        passwordInput = findViewById(R.id.activity_login_et_password);
        loginButton = findViewById(R.id.activity_login_btn_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();
        String[] userData = {username, password};
        String[] columns = {
                Globals.TABLE_PLAYER_FIELD_ID,
                Globals.TABLE_PLAYER_FIELD_NAME,
                Globals.TABLE_PLAYER_FIELD_MONEY
        };
        Cursor cursor;

        dbHelper.open();
        cursor = dbHelper.getItems(Globals.TABLE_PLAYER_NAME, columns, "name = ? AND password = ?",
                userData, Globals.TABLE_PLAYER_FIELD_ID);

        if (cursor.moveToFirst()) {
            Intent intent = new Intent(this, MainActivity.class);
            Player player = new Player(cursor.getLong(0), cursor.getString(1), cursor.getDouble(2));
            Bundle bundle = new Bundle();

            bundle.putSerializable(LOGGED_PLAYER, player);

            intent.putExtras(bundle);
            startActivity(intent);
        }

        if (!cursor.isClosed()) {
            cursor.close();
        }

        dbHelper.close();
    }

}
