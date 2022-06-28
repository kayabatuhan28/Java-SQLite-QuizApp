package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AnaMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_menu);
    }

    public void oyunbaslat(View view){
        Intent intent = new Intent(this,OyunEkrani.class);
        startActivity(intent);
        finish();
    }

    public void bilgisorular(View view){
        Intent intent = new Intent(this,BilgiOyunEkrani.class);
        startActivity(intent);
        finish();
    }

    public void cikis(View view){
        //Çıkış İşlemi ==> System.exit(0);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void lidertablosu(View view){
        Intent intent = new Intent(this,LiderTablosu.class);
        startActivity(intent);
        finish();
    }
}