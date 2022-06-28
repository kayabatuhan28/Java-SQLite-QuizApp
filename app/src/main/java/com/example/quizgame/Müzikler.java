package com.example.quizgame;

import android.media.MediaPlayer;
import java.util.ArrayList;

public class Müzikler {
    private ArrayList<Integer> playlist = new ArrayList<Integer>();

    public Müzikler(){
        playlist.add(0,R.raw.sunnetsiz);     playlist.add(1,R.raw.dogru);                 playlist.add(2,R.raw.yanlis);
        playlist.add(3,R.raw.gerilim);       playlist.add(4,R.raw.apaci);                 playlist.add(5,R.raw.count);
        playlist.add(6,R.raw.hayatimleyla);  playlist.add(7,R.raw.kasimseren_askbenimle); playlist.add(8,R.raw.bane);
        playlist.add(9,R.raw.depresyonstayla); playlist.add(10,R.raw.djyildirim);
    }

    public ArrayList<Integer> getPlaylist() {
        return playlist;
    }
}