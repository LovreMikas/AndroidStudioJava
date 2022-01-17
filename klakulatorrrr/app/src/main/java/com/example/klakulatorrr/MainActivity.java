package com.example.klakulatorrr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private Button clear;
    private Button nula;
    private Button jedan;
    private Button dva;
    private Button tri;
    private Button cetri;
    private Button pett;
    private Button sest;
    private Button sedan;
    private Button osam;
    private Button devet;
    private Button jednakoo;
    private Button pluss;
    private Button mnozenje;
    private Button dijeljenje;
    private Button oduzimanje;
    private TextView rezultatt;
    private TextView ekrann;
    private final char JEDNAKO  = 0;
    private final char ZBORJI = '+';
    private final char ODUZMI  = '-';
    private final char POMNOZI  = '*';
    private final char DIJELI  = '/';
    private double vr1 = Double.NaN;
    private double vr2;
    private char RADNJA;
    private boolean slom;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();
        nula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekrann.setText(ekrann.getText().toString() + "0");
            }

        });
        jedan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekrann.setText(ekrann.getText().toString() + "1");
            }

        });
        dva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekrann.setText(ekrann.getText().toString() + "2");
            }

        });
        tri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekrann.setText(ekrann.getText().toString() + "3");
            }

        });
        cetri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekrann.setText(ekrann.getText().toString() + "4");
            }

        });
        pett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekrann.setText(ekrann.getText().toString() + "5");
            }

        });
        sest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekrann.setText(ekrann.getText().toString() + "6");
            }

        });
        sedan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekrann.setText(ekrann.getText().toString() + "7");
            }

        });
        osam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekrann.setText(ekrann.getText().toString() + "8");
            }

        });
        devet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ekrann.setText(ekrann.getText().toString() + "9");
            }

        });
        pluss.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                oba();
                if(slom){
                    slom = false;
                    return;
                }
                else {
                    RADNJA = ZBORJI;
                    rezultatt.setText(String.valueOf(vr1) + "+");
                    ekrann.setText(null);
                }

            }

        });
        oduzimanje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oba();
                if(slom){
                    slom = false;
                    return;
                }
                else {
                    RADNJA = ODUZMI;
                    rezultatt.setText(String.valueOf(vr1) + "-");
                    ekrann.setText(null);
                }


            }

        });
        dijeljenje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oba();
                if(slom){
                    slom = false;
                    return;
                }
                else {
                    RADNJA = DIJELI;
                    rezultatt.setText(String.valueOf(vr1) + "/");
                    ekrann.setText(null);
                }

            }

        });
        mnozenje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oba();
                if(slom){
                    slom = false;
                    return;
                }
                else {
                    RADNJA = POMNOZI;
                    rezultatt.setText(String.valueOf(vr1) + "*");
                    ekrann.setText(null);
                }


            }

        });
        jednakoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oba();
                if(slom){
                    slom = false;
                    return;
                }
                else {
                    RADNJA = JEDNAKO;
                    rezultatt.setText(rezultatt.getText().toString() + String.valueOf(vr2) + "=" + String.valueOf(vr1));
                    ekrann.setText(null);
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ekrann.getText().length() > 0) {
                CharSequence name = ekrann.getText().toString();
                ekrann.setText(name.subSequence(0, name.length() - 1));
            }
            else{
                vr1 = Double.NaN;
                vr2 = Double.NaN;
                ekrann.setText(null);
                rezultatt.setText(null);
                }


            }
        });
    }
    private void setupUIViews(){
        clear = findViewById(R.id.ocisti);
        nula = findViewById(R.id.nu);
        jedan = findViewById(R.id.je);
        dva = findViewById(R.id.dv);
        tri = findViewById(R.id.tr);
        cetri = findViewById(R.id.cet);
        pett = findViewById(R.id.pet);
        sest = findViewById(R.id.se);
        sedan = findViewById(R.id.sed);
        osam = findViewById(R.id.os);
        devet = findViewById(R.id.dev);
        jednakoo = findViewById(R.id.jednako);
        pluss = findViewById(R.id.plus);
        mnozenje = findViewById(R.id.mnozi);
        dijeljenje = findViewById(R.id.dijeli);
        oduzimanje = findViewById(R.id.minus);
        rezultatt = findViewById(R.id.rezultat);
        ekrann = findViewById(R.id.ekran);

    }
    public void oba() {
        try {
            if (!Double.isNaN(vr1)) {
                vr2 = Double.parseDouble(ekrann.getText().toString());
                switch (RADNJA) {
                    case ZBORJI:
                        vr1 = vr1 + vr2;
                        break;
                    case ODUZMI:
                        vr1 = vr1 - vr2;
                        break;
                    case POMNOZI:
                        vr1 = vr1 * vr2;
                        break;
                    case DIJELI:
                        vr1 = vr1 / vr2;
                        break;
                    case JEDNAKO:
                        break;
                }
            } else {
                vr1 = Double.parseDouble(ekrann.getText().toString());
            }

        }catch(Exception e){
            vr1 = Double.NaN;
            vr2 = Double.NaN;
            ekrann.setText(null);
            rezultatt.setText(null);
            Toast.makeText(MainActivity.this, "Nepravilno koristenje znakova", Toast.LENGTH_SHORT).show();
            slom = true;
        }
    }
}


