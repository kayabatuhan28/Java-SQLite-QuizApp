package com.example.quizgame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button girisyap;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.usernameLogin);
        password = findViewById(R.id.passwordLogin);
        girisyap = findViewById(R.id.girisButton);
        db = new DbHelper(this);
    }



    public void girisyap (View view){

        String user = username.getText().toString();
        String pass = password.getText().toString();

        if(TextUtils.isEmpty(user)||TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Lütfen Boş Bilgi Bırakmayınız!", Toast.LENGTH_SHORT).show();
        }
        else{
            Boolean checkuserpass = db.checkusernamepassword(user,pass);
            if(checkuserpass == true){
                Toast.makeText(this, "Giriş Başarılı.Hoşgediniz "+user, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),AnaMenu.class);
                startActivity(intent);
                finish();
            }
            else{
                Toast.makeText(this, "Giriş Başarısız..", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void kayitol(View view){
        Intent intent = new Intent(this,Kayitol.class);
        startActivity(intent);
        finish();
    }



}