package com.example.jawaban_uts_revandra;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CariBerita extends AppCompatActivity {
    Spinner spinnerText;
//    String mSpinnerText;
    public static String dateMessage;
    public static String status;
    EditText tanggal;
    TextView umurTGL;
    Button cari;
    public static int umur;
    public static String preferensi;
    LinearLayout UMR;
    FloatingActionButton logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_berita);
        cari = findViewById(R.id.cari);
        umurTGL = findViewById(R.id.Umur);
        UMR = findViewById(R.id.UMR);
        spinnerText = findViewById(R.id.Status);
        tanggal = findViewById(R.id.Date);
        tanggal.setKeyListener(null);
        logout = findViewById(R.id.Logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(CariBerita.this).create();
//            alertDialog.setTitle("Alert");
                alertDialog.setMessage("Apakah Ingin keluar?");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Iya",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                MainActivity.logOut();
                                Intent intent = new Intent(CariBerita.this, MainActivity.class);
                                startActivity(intent);
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        return;
                    }
                });
                alertDialog.show();
            }
        });

        //Button Listener
        cari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cari_berita();
            }
        });

        // Making spinner & the adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.statuses, R.layout.item);
        adapter.setDropDownViewResource(R.layout.dropitem);
        spinnerText.setAdapter(adapter);
        if (spinnerText != null){
//            spinnerText.setOnItemSelectedListener(this);
        }

        //Making the popup
        tanggal.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){showDataPicker();}
            }
        });
        tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDataPicker();
            }
        });
        if(CariBerita.status != "yes"){UMR.setVisibility(View.INVISIBLE);}
        else {tanggal.setText(dateMessage); umurTGL.setText(umur+" Tahun");}

    }
    public void showDataPicker(){
        DialogFragment dateFragment = new DatePickerFragment();
        dateFragment.show(getSupportFragmentManager(), "date-picker");}

    public void processDatePicker(int day, int month, int year){
        String day_string = Integer.toString(day);
        String month_string = Integer.toString(month+1);
        String year_string = Integer.toString(year);
        dateMessage = day_string + "-" + month_string + "-" + year_string;
        Calendar currentDate = new GregorianCalendar();
        umur = currentDate.get(Calendar.YEAR) - year;
        if (month > currentDate.get(Calendar.MONTH) || (month == currentDate.get(Calendar.MONTH) &&
                day > currentDate.get(Calendar.DAY_OF_MONTH)))
        {umur--;}
        UMR.setVisibility(View.VISIBLE);
        CariBerita.status = "yes";
        umurTGL.setText(umur+" Tahun");
        tanggal.setText(dateMessage);
    }
    public void cari_berita(){
//        String preferensi = spinnerText.getSelectedItem().toString();
        preferensi = spinnerText.getSelectedItem().toString();

        Intent tampilkan = new Intent(CariBerita.this, tampil_Berita.class);
//        tampilkan.putExtra("Umur",umur);
//        tampilkan.putExtra("Preferensi",preferensi);
        startActivity(tampilkan);
    }



//    //Spinner Logic
//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        mSpinnerText = adapterView.getItemAtPosition(i).toString();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//    }
}