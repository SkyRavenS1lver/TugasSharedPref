package com.example.jawaban_uts_revandra;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Boolean isLogin;
    public static String KEY = "Login_Key";
    public static String KEY_USERNAME = "Username_Key";
    public static SharedPreferences sharedPreferences;
    private final String sharedPrefFile = "com.example.jawaban_uts_revandra";
    EditText et1,et2;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        btn1 = findViewById(R.id.btn1);
        sharedPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        isLogin = sharedPreferences.getBoolean(KEY, false);
        et1.setText(sharedPreferences.getString(KEY_USERNAME, ""));
        if(isLogin){
            Intent intent = new Intent(MainActivity.this, CariBerita.class);
            startActivity(intent);
        }



    }

    public void login(View view){
        String username = "pakjoko";
        String password = "yangpentingcuan";
        if(et1.getText().toString().equals(username) && et2.getText().toString().equals(password)){
            Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(KEY,true);
            editor.putString(KEY_USERNAME,et1.getText().toString());
            editor.apply();
            Intent intent = new Intent(MainActivity.this, CariBerita.class);
            startActivity(intent);
        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//            alertDialog.setTitle("Alert");
            alertDialog.setMessage("Mohon Maaf Password atau Username salah!");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }
    public static void logOut(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY,false);
        editor.apply();
    }
}