package com.example.imanage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText password,username;
    Button ok;
    ImageView image1;
    ImageView image2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password = (EditText)findViewById(R.id.password);
        username = (EditText)findViewById(R.id.username);
        ok =(Button)findViewById(R.id.ok);
        image1 = (ImageView)findViewById(R.id.image1);
        image2 =(ImageView)findViewById(R.id.image2);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
                startActivity(intent);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
                startActivity(intent);
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String usernameKey = username.getText().toString();
                    String passwordKey = password.getText().toString();

                    if (usernameKey.equals("admin") && passwordKey.equals("123")){
                        //jika login berhasil
                        Toast.makeText(getApplicationContext(), "LOGIN SUKSES",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Welcome.class);
                        MainActivity.this.startActivity(intent);
                        finish();
                    }else {
                        //jika login gagal
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Username atau Password Anda salah!")
                                .setNegativeButton("Retry", null).create().show();
                    }
            }
        });
    }
}
