package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Kayitol extends AppCompatActivity {
    EditText username,email,password,repassword;
    Button btnregister;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayitol);

        username = findViewById(R.id.username);
        email = findViewById(R.id.usernameLogin);
        password = findViewById(R.id.passwordLogin);
        repassword = findViewById(R.id.repassword);
        btnregister = findViewById(R.id.kayitolbutton);

        db = new DbHelper(this);

    }

    public void üyelikolustur(View view) {
        String user = username.getText().toString();
        String pass = password.getText().toString();
        String repass = repassword.getText().toString();
        String mail = email.getText().toString();

        Boolean EmailKontrol = EmailCheck(email);
        Boolean pass_uzunluk_kontrol = PassSize(pass.length());
        Boolean pass_esitlik_kontrol = PassRematch(pass,repass);
        Boolean checkuser = db.checkusername(user);

        if(EmailKontrol == true && pass_uzunluk_kontrol == true && pass_uzunluk_kontrol == true && pass_esitlik_kontrol == true){
            if(checkuser == false){
                Boolean insert = db.insertData(user, pass, mail, 0, 0);
                if(insert == true){
                    Toast.makeText(this, "Başarıyla Kayıt Olundu", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
            else{
                Toast.makeText(this, "Bu Kullanıcı Zaten Var!", Toast.LENGTH_SHORT).show();
            }

        }else{
        }


    }

    public void registerDön(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }


    private boolean EmailCheck(EditText email){
        String emailInput = email.getText().toString();
        if(Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){

            return true;
        }else{
            Toast.makeText(this, "Geçersiz Email!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean PassSize(int size){
        if(size >= 6){
            return true;
        }
        else{
            Toast.makeText(this, "Şifre 6 Karakterden Küçük Olamaz!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean PassRematch(String pass,String repass){
        if(pass.equals(repass)){
            return true;
        }
        else{
            Toast.makeText(this, "Parolayı Aynı Giriniz!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean EmptyCheck(String user,String pass,String repass,String mail){
        if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)|| TextUtils.isEmpty(repass)||TextUtils.isEmpty(mail)){
            Toast.makeText(this, "Boş Alan Bırakmayın!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }

    private boolean UsernameCheck(int size){
        if(size <= 6){
            Toast.makeText(this, "Kullanıcı Adı 7 Karakterden Az Olamaz1 ", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }


}