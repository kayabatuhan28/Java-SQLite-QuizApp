package com.example.quizgame;

import android.media.MediaPlayer;

public class MüzikKontrol {
    private int indeks;
    Müzikler müzikler = new Müzikler();
    MediaPlayer mp;

    public int getIndeks() {
        return indeks;
    }

    public int soruyagöremüzik(String cevaplar){
        if(cevaplar == "Sünnetsizler"){
            return 0;
        }
        else if(cevaplar == "Apaçiler"){
            return 4;
        }
        else if(cevaplar == "Hayatım Leyla" ){
            return 6;
        }
        else if(cevaplar == "Kasım Seren"){
            return 7;
        }
        else if(cevaplar == "Saniye"){
            return 8;
        }
        else if(cevaplar == "Depresyon Stayla"){
            return 9;
        }
        else if(cevaplar == "Dj Yıldırım"){
            return 10;
        }
        else{
            return 800;
        }

    }


}