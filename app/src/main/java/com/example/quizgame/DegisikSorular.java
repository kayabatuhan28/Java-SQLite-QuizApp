package com.example.quizgame;

import java.util.ArrayList;

public class DegisikSorular {
    private ArrayList<String> sorular = new ArrayList<String>();
    private ArrayList<String> cevaplar = new ArrayList<String>();
    private ArrayList<String> abutton = new ArrayList<String>();
    private ArrayList<String> bbutton = new ArrayList<String>();
    private ArrayList<String> cbutton = new ArrayList<String>();
    private ArrayList<String> dbutton= new ArrayList<String>();

    public DegisikSorular(){
        sorular.add("İsmi Bülent olan kişinin ismi nedir?"); cevaplar.add("Bülent");
        abutton.add("Bülent");  bbutton.add("Ahmet"); cbutton.add("Muhtalip"); dbutton.add("Emre");

        sorular.add("Duymakta olduğunuz rapin sanatçısı kimdir?");  cevaplar.add("Sünnetsizler");
        abutton.add("ArsızBela"); bbutton.add("Sünnetsizler");  cbutton.add("McDuvarÇatlağı"); dbutton.add("Fakobaba");

        sorular.add("Duymakta olduğunuz şarkıyı kim söylemektedir?");  cevaplar.add("Kasım Seren");
        abutton.add("Kasım Seren");  bbutton.add("Cankan"); cbutton.add("Ciguli"); dbutton.add("Arsız Bela");

        sorular.add("Duymakta olduğunuz şarkının adı nedir?");  cevaplar.add("Hayatım Leyla");
        abutton.add("Yaranamadım");  bbutton.add("Hayatım Leyla"); cbutton.add("Lanet Olsun"); dbutton.add("Sensiz Ben");

        sorular.add("Duymakta olduğunuz akımı hangi youtuber çıkarmıştır?");  cevaplar.add("Saniye");
        abutton.add("Orkun Işıtmak");  bbutton.add("Enes Batur"); cbutton.add("Saniye"); dbutton.add("Efe Uygaç");

        sorular.add("Duymakta olduğunuz şarkıyı kim söylemektedir?");  cevaplar.add("Depresyon Stayla");
        abutton.add("Depresyon Stayla");  bbutton.add("Asi Bela"); cbutton.add("İsyankar 26"); dbutton.add("Mc Yaralı");

        sorular.add("Duymakta olduğunuz rapi kim söylemektedir?");  cevaplar.add("Dj Yıldırım");
        abutton.add("Dj Yıldırım");  bbutton.add("Dj Yumurta"); cbutton.add("Dj Kafasız"); dbutton.add("Bela 76");

        sorular.add("Papaz John Locke'nin kilisesindeki mum sayısı kaç adettir?"); cevaplar.add("162");
        abutton.add("125");  bbutton.add("154"); cbutton.add("136"); dbutton.add("162");

        sorular.add("Duymakta olduğunuz döneminin popüler olan şarkısını popüler edenler kimdir?"); cevaplar.add("Apaçiler");
        abutton.add("Tırrekler");  bbutton.add("DızzoBremınlar"); cbutton.add("Apaçiler");  dbutton.add("Particiler");


    }
    public void indexsil(int indeks){
        sorular.remove(indeks);
        cevaplar.remove(indeks);
        abutton.remove(indeks);
        bbutton.remove(indeks);
        cbutton.remove(indeks);
        dbutton.remove(indeks);
    }


    public ArrayList<String> getSorular(){
        return sorular;
    }

    public ArrayList<String> getCevaplar(){
        return cevaplar;
    }

    public ArrayList<String> getAbutton(){
        return abutton;
    }

    public ArrayList<String> getBbutton(){
        return bbutton;
    }

    public ArrayList<String> getCbutton(){
        return cbutton;
    }

    public ArrayList<String> getDbutton(){
        return dbutton;
    }
}