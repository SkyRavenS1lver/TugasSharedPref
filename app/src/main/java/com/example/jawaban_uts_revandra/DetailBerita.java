package com.example.jawaban_uts_revandra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailBerita extends AppCompatActivity {
    TextView juduls;
    TextView tanggals;
    ImageView gambars;
    TextView descs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);
        juduls = findViewById(R.id.txt_name);
        tanggals = findViewById(R.id.txt_tanggal);
        gambars = findViewById(R.id.IMG);
        descs = findViewById(R.id.txt_desc);
        Intent getter = getIntent();
        String judul = getter.getStringExtra("judul");
        String tanggal = getter.getStringExtra("tanggal");
        int noGambar = getter.getIntExtra("noGambar", 0);
        String desc = getter.getStringExtra("desc");
        juduls.setText(judul);
        tanggals.setText(tanggal);
        gambars.setImageResource(noGambar);
        descs.setText(desc);
    }
}