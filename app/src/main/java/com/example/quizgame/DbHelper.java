package com.example.quizgame;

import static android.os.Build.ID;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.*;
import android.util.Log;

import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "users";
    public static final String COL1 = "ID";
    public static final String COL2= "username";
    public static final String COL3 = "password";
    public static final String COL4 = "email";
    public static final String COL5 = "degisikmax";
    public static final String COL6 = "bilgimax";

    public DbHelper(Context context) {

        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+COL2+" TEXT, "
                +COL3 +" TEXT, "+COL4+" TEXT, "+COL5+" INTEGER, "+COL6+" INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " +TABLE_NAME);
        onCreate(db);
    }

    public Boolean insertData(String username,String password,String email,int degisikmax,int bilgimax){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username",username);
        values.put("password",password);
        values.put("email",email);
        values.put("degisikmax",degisikmax);
        values.put("bilgimax",bilgimax);


        long result = db.insert("users",null,values);
        if(result == -1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select *from users where username =?",new String[]{username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select *from users where username =? and password=?",new String[]{username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT *FROM "+ TABLE_NAME;
        Cursor data = db.rawQuery(query,null);
        return data;
    }

    public UserData getsingleuserdata(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME + " where ID="+id, null);


        if(cursor!=null)
            cursor.moveToFirst();
        UserData users  = new UserData(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                Integer.parseInt(cursor.getString(4)),
                Integer.parseInt(cursor.getString(5)));

        return users;
    }


    public void getdegisikupdate(int id,int degisikskor){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "UPDATE users SET degisikmax = "+degisikskor+" WHERE ID =  "+id;
        db.execSQL(query);

    }

    public void getbilgiupdate(int id,int bilgiskor){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "UPDATE users SET bilgimax = "+bilgiskor+" WHERE ID =  "+id;
        db.execSQL(query);

    }



}