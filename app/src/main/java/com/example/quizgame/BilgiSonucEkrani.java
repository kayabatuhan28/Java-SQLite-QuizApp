package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BilgiSonucEkrani extends AppCompatActivity {
    int yapilanskor,maxskor;
    TextView txtyapilanskor,txtmaxskor;
    UserData users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgi_sonuc_ekrani);
        DbHelper db = new DbHelper(this);
        txtyapilanskor = findViewById(R.id.yapıilanskor2);
        txtmaxskor = findViewById(R.id.enyuksekskor2);
        yapilanskor = getIntent().getIntExtra("oyunSkoru",0);
        txtyapilanskor.setText(""+yapilanskor);
        users = db.getsingleuserdata(1);
        maxskor = users.getBilgimax();
        if(yapilanskor > maxskor){
            maxskor = yapilanskor;
            db.getbilgiupdate(1,maxskor);
        }
        txtmaxskor.setText(""+maxskor);
    }

    public void anamenuyedon(View view){
        Intent intent = new Intent(this,AnaMenu.class);
        startActivity(intent);
        finish();
    }
}