package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class LiderTablosu extends AppCompatActivity {
    UserData users;
    TextView degisikskor,bilgiskor,kullaniciadi,yas;
    int idtut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lider_tablosu);
        DbHelper db = new DbHelper(this);
        users = db.getsingleuserdata(2);
        degisikskor = findViewById(R.id.liderdegisikskor);
        bilgiskor = findViewById(R.id.liderbilgiskor);
        kullaniciadi = findViewById(R.id.liderusername);
        yas = findViewById(R.id.age);

        yas.setText("23");
        kullaniciadi.setText(""+users.getUsername());
        degisikskor.setText(""+users.getDegisikmax());
        bilgiskor.setText(""+users.getBilgimax());

    }

    public void lidermenudon(View view){
        Intent intent = new Intent(this,AnaMenu.class);
        startActivity(intent);
    }


}