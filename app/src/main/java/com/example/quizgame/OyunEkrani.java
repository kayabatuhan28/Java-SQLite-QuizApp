package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class OyunEkrani extends AppCompatActivity {
    Button a,b,c,d;
    String atext,btext,ctext,dtext,soru,cevaplar,dogrutut;
    DegisikSorular degisikSorular = new DegisikSorular();
    TextView soruekrani,skorekrani,sayac;
    boolean dogrumu,basıldı;
    int puan,say = 0;
    int indeks;
    final Handler handler = new Handler();
    Random r = new Random();
    MediaPlayer mp = new MediaPlayer();
    Müzikler müzikler = new Müzikler();
    MüzikKontrol müzikKontrol = new MüzikKontrol();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun_ekrani);
        soruekrani = findViewById(R.id.soruxml);
        skorekrani = findViewById(R.id.skortext);
        sayac = findViewById(R.id.trollsayac);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        basıldı = false;
        int sizetut = degisikSorular.getSorular().size();
        indeks =r.nextInt(sizetut);
        sorucagir();
    }

    public void a_basıldı(View view){

        if(basıldı == false){
            mp.reset();
            basıldı = true;
            sesgetir(3);
            atext = a.getText().toString();
            dogrumu = cevapkontrol(atext,indeks);
            sonucagoreislem(a);
        }
    }

    public void b_basıldı(View view){

        if(basıldı == false){
            mp.reset();
            basıldı = true;
            sesgetir(3);
            btext = b.getText().toString();
            dogrumu = cevapkontrol(btext,indeks);
            sonucagoreislem(b);
        }

    }

    public void c_basıldı(View view){

        if(basıldı == false){
            mp.reset();
            basıldı = true;
            sesgetir(3);
            ctext = c.getText().toString();
            dogrumu = cevapkontrol(ctext,indeks);
            sonucagoreislem(c);
        }
    }

    public void d_basıldı(View view){

        if(basıldı == false){
            mp.reset();
            basıldı = true;
            sesgetir(3);
            dtext = d.getText().toString();
            dogrumu=cevapkontrol(dtext,indeks);
            sonucagoreislem(d);
        }
    }

    public void sonucagoreislem(Button basilan){
        if(dogrumu == true){
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    dogru(basilan);
                }
            },3000);

        }
        else{
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    yanlis(basilan);
                }
            },3000);
        }
    }


    public boolean cevapkontrol(String buttontext,int soruindeks){
        if(degisikSorular.getCevaplar().get(soruindeks).equals(buttontext)){
            return true;
        }
        else{
            return false;
        }

    }

    public String dogrucevap(int indeks){
        dogrutut = degisikSorular.getCevaplar().get(indeks);
        return dogrutut;
    }

    //dogru stringin buttonlara yollanıp test edilmesi
    public Button yesildogrubutton(String gelenstring){
        if(a.getText().toString().equals(gelenstring)){
            return a;
        }
        else if(b.getText().toString().equals(gelenstring)){
            return b;
        }
        else if(c.getText().toString().equals(gelenstring)){
            return c;
        }
        else if(d.getText().toString().equals(gelenstring)){
            return d;
        }
        else{
            return null;
        }

    }



    public void sorucagir(){
        süre();
        soru =degisikSorular.getSorular().get(indeks);
        int müzikİndeks;
        cevaplar = degisikSorular.getCevaplar().get(indeks);
        atext = degisikSorular.getAbutton().get(indeks);
        btext = degisikSorular.getBbutton().get(indeks);
        ctext = degisikSorular.getCbutton().get(indeks);
        dtext = degisikSorular.getDbutton().get(indeks);
        müzikİndeks = müzikKontrol.soruyagöremüzik(cevaplar);
        if(müzikİndeks < 500){
            sesgetir(müzikİndeks);
        }

        if(degisikSorular.getSorular().size() > 0){
            soruekrani.setText(soru);
            a.setText(atext);
            b.setText(btext);
            c.setText(ctext);
            d.setText(dtext);
        }
        else{
            sonuc_ekraninagit();
        }


    }

    public void dogru(Button basilanbuton){
        sesgetir(1);
        puan = puan+1;
        skorekrani.setText("Doğru Cevap! Puanınız : "+puan);
        basilanbuton.setBackgroundColor(Color.GREEN);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                basilanbuton.setBackgroundColor(Color.rgb(118,31,135));
                arrayindexsil();
                if(degisikSorular.getSorular().size() > 0){
                    int sizetut = degisikSorular.getSorular().size();
                    indeks =r.nextInt(sizetut);
                    sorucagir();
                    basıldı = false;
                }
                else{
                    sonuc_ekraninagit();
                }
            }
        },1000);

    }

    public void yanlis(Button basilanbuton){
        sesgetir(2);
        Button dogrubutton =  yesildogrubutton(dogrucevap(indeks));//dogru buttonun geçiçi olarak tutulması
        dogrubutton.setBackgroundColor(Color.GREEN);
        basilanbuton.setBackgroundColor(Color.RED);
        skorekrani.setText("Yanlış Cevap! Oyun Bitti ");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                sonuc_ekraninagit();
            }
        },2000);
    }

    public void sonuc_ekraninagit(){
        Intent intent = new Intent(this,SonucEkrani.class);
        intent.putExtra("oyunSkoru",puan);
        skorekrani.setText("Oyun Bitti! Skorunuz : "+puan);
        startActivity(intent);
        finish();

    }

    public void sesgetir(int sarki_index){
        mp = MediaPlayer.create(this,müzikler.getPlaylist().get(sarki_index));
        mp.start();
    }

    public void arrayindexsil(){
        degisikSorular.indexsil(indeks);
    }

    public void süre(){

        new CountDownTimer(20000, 1000) {

            public void onTick(long p0) {
                if(basıldı == false && (p0/1000 > 0)){
                    sayac.setText("" + (p0 / 1000));
                    if(say == 0 && (p0/1000) <=3){
                        say = 1;
                        sesgetir(5);
                    }
                }
                else if((p0/1000 <= 1)){
                    onFinish();
                }
                else{
                    cancel();
                    say = 0;
                }

            }

            public void onFinish() {
                if(basıldı == false){
                    mp.release();
                    say = 0;
                    sonuc_ekraninagit();
                }
                say = 0;
            }
        }.start();


    }
}