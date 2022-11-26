package com.example.jawaban_uts_revandra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class tampil_Berita extends AppCompatActivity {
    private RecyclerView rvBerita;
    private ArrayList<Berita> listBerita = new ArrayList<>();
    private BeritaAdapter beritaAdapter;
    Drawable bgBaru;
    TextView judul;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_berita);
        rvBerita = findViewById(R.id.rvBerita);
        judul = findViewById(R.id.JudulPage);
        LinearLayout bg = findViewById(R.id.background);
        if(CariBerita.preferensi.equals("Pariwisata")){
        bgBaru = ContextCompat.getDrawable(bg.getContext(), R.drawable.bg1);
        judul.setTextColor(getResources().getColor(R.color.text));}
        else if(CariBerita.preferensi.equals("Sport")){
            bgBaru = ContextCompat.getDrawable(bg.getContext(), R.drawable.bg2);
            judul.setTextColor(getResources().getColor(R.color.white));}
        else if(CariBerita.preferensi.equals("Politics")){
            bgBaru = ContextCompat.getDrawable(bg.getContext(), R.drawable.bg3);
            judul.setTextColor(getResources().getColor(R.color.text));
        }
        else if(CariBerita.preferensi.equals("Entertainment")){
            bgBaru = ContextCompat.getDrawable(bg.getContext(), R.drawable.bg6);
            judul.setTextColor(getResources().getColor(R.color.white));}
        else if(CariBerita.preferensi.equals("Crime")){
            bgBaru = ContextCompat.getDrawable(bg.getContext(), R.drawable.bg5);
            judul.setTextColor(getResources().getColor(R.color.white));}
        bg.setBackground(bgBaru);






//        Intent getter = getIntent();
//        int umur = getter.getIntExtra("Umur", 100);
//        String pref = getter.getStringExtra("Preferensi");
        addBerita(CariBerita.umur, CariBerita.preferensi);
        beritaAdapter = new BeritaAdapter(this, listBerita);
        rvBerita.setLayoutManager(new LinearLayoutManager(this));
        rvBerita.setAdapter(beritaAdapter);


    }
    public void addBerita(int umur, String pref){
        if (pref.equals("Pariwisata")){
            listBerita.add(new Berita("Yogyakarta", "11 Oktober 2022","Pariwisata", R.drawable.yogya, getString(R.string.yogyakarta)));
            listBerita.add(new Berita("Lawang Sewu", "18 Januari 2022","Pariwisata", R.drawable.lawangsewu, getString(R.string.lawangSewu)));
            listBerita.add(new Berita("Borobudur", "8 Juni 2022","Pariwisata", R.drawable.borobudur, getString(R.string.borobudur)));
            listBerita.add(new Berita("Pulau Gili", "22 Agustus 2022","Pariwisata", R.drawable.gili, getString(R.string.gili)));
            listBerita.add(new Berita("Prambanan", "3 November 2021","Pariwisata", R.drawable.prambanan, getString(R.string.prambanan)));
            listBerita.add(new Berita("Bromo", "15 Oktober 2022","Pariwisata", R.drawable.bromo, getString(R.string.bromo)));
            listBerita.add(new Berita("Balekambang", "26 September 2022","Pariwisata", R.drawable.balekambang, getString(R.string.balekambang)));
            listBerita.add(new Berita("Sanur", "24 Juni 2022","Pariwisata", R.drawable.sanur, getString(R.string.sanur)));
            listBerita.add(new Berita("Goa Gajah", "24 Maret 2021","Pariwisata", R.drawable.gajah, getString(R.string.gajah)));
            listBerita.add(new Berita("Bali Safari", "25 Januari 2022","Pariwisata", R.drawable.safari, getString(R.string.safari)));
        }
        else if (pref.equals("Sport")){
            if (umur >= 17){listBerita.add(new Berita("Kanjuruhan", "14 Oktober 2022","Sport", R.drawable.kanjuruhan, getString(R.string.kanjuruhan)));}
            listBerita.add(new Berita("Alexis Expargaro", "14 Oktober 2022","Sport", R.drawable.motogp, getString(R.string.motogp)));
            listBerita.add(new Berita("Bulu Tangkis", "14 Oktober 2022","Sport", R.drawable.bulu, getString(R.string.bulutangkis)));
            listBerita.add(new Berita("Hasil TGIPF", "14 Oktober 2022","Sport", R.drawable.tgpif, getString(R.string.TGPIF)));
            listBerita.add(new Berita("Rank FIFA Timnas", "14 Oktober 2022","Sport", R.drawable.rank, getString(R.string.rank)));
        }
        else if (pref.equals("Politics")) {
            if (umur >= 17) {
                listBerita.add(new Berita("NasDem Kawal Jokowi", "15 Oktober 2022", "Politics", R.drawable.nasdem, getString(R.string.nasdem)));
                listBerita.add(new Berita("18 Partai Lolos", "14 Oktober 2022", "Politics", R.drawable.partai, getString(R.string.partai)));
                listBerita.add(new Berita("PDIP no Premanisme", "14 Oktober 2021","Politics", R.drawable.premanisme, getString(R.string.premanisme)));
            }
            listBerita.add(new Berita("Mars Perindo", "30 Agustus 2022", "Politics", R.drawable.perindo, getString(R.string.perindo)));
            listBerita.add(new Berita("Bagi Sepedah", "21 Desember 2021", "Politics", R.drawable.sepedah, getString(R.string.sepedah)));
        }
        else if (pref.equals("Entertainment")){
            if(umur >= 25){listBerita.add(new Berita("Ikatan Cinta", "15 Oktober 2022","Entertainment", R.drawable.ikatan, getString(R.string.ikatan)));
                listBerita.add(new Berita("Tentang Dirimu", "14 Oktober 2022","Entertainment", R.drawable.jamrud, getString(R.string.jamrud)));
                listBerita.add(new Berita("Cinta Alesha", "12 September 2022","Entertainment", R.drawable.alesha, getString(R.string.alesha)));
            }
            if(umur >= 15){listBerita.add(new Berita("Lesti Kejora", "14 Oktober 2022","Entertainment", R.drawable.lesti, getString(R.string.lesti)));}
            listBerita.add(new Berita("AMI Award", "14 Oktober 2022","Entertainment", R.drawable.ded, getString(R.string.ded)));
        }
        else if (pref.equals("Crime")){
            if(umur < 17){TextView a = findViewById(R.id.JudulPage);a.setText("Maaf Tidak Ada Berita Terbaru");}
            else {
                listBerita.add(new Berita("WNA Kanada", "24 September 2022", "Crime", R.drawable.kanada, getString(R.string.kanada)));
                listBerita.add(new Berita("Bencana Seminyak", "29 September 2022", "Crime", R.drawable.tenggelam, getString(R.string.tenggelam)));
                listBerita.add(new Berita("WN Selandia", "14 Oktober 2022", "Crime", R.drawable.bom, getString(R.string.bom)));
                listBerita.add(new Berita("Kasus Penggelapan", "11 Oktober 2022", "Crime", R.drawable.peradilan, getString(R.string.peradilan)));
                listBerita.add(new Berita("TNI Pukul Security", "10 Oktober 2022", "Crime", R.drawable.tni, getString(R.string.tni)));
            }}}
}