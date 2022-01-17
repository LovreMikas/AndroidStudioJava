package com.example.lovremikastest;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  TextView txt;
  EditText unos ;
  EditText unos1 ;
  EditText unos2 ;
  EditText unos3 ;
  Button btn;
  Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unos = findViewById(R.id.editTextTextPersonName);
        unos1 = findViewById(R.id.editTextTextPersonName2);
        unos2=findViewById(R.id.editTextTextPersonName3);
        unos3=findViewById(R.id.editTextTextPersonName4);
        btn=findViewById(R.id.button);
        btn1=findViewById(R.id.button2);
        txt = findViewById(R.id.textView);
            View.OnClickListener slusac = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (unos.getText().toString().isEmpty() ||
                            unos1.getText().toString().isEmpty() ||
                            unos2.getText().toString().isEmpty() ||
                            unos3.getText().toString().isEmpty()) {
                        txt.setText("Niste unjeli jedan od podataka");
                    } else {

                        SQLiteDatabase sqLiteDatabase = getBaseContext().openOrCreateDatabase("Knjige.db", MODE_PRIVATE, null);
                        try {
                            sqLiteDatabase.execSQL("CREATE TABLE Knjiga( ime_knjige TEXT,autor TEXT,izdavacka_kuca TEXT,godina_izdanja TEXT ) ;");
                        } catch (Exception ex) {
                            txt.setText("tabica vec postoji u bazi" + ex.toString());
                            String sql="INSERT INTO Knjiga VALUES ( '"+unos.getText().toString()+"' ,'"+unos1.getText().toString()+"', '"+unos2.getText().toString()+"','"+unos3.getText().toString()+"');";
                            sqLiteDatabase.execSQL(sql);
                            Cursor query=sqLiteDatabase.rawQuery( "SELECT * FROM Knjiga",
                                    null) ;
                            query.close();
                            sqLiteDatabase.close();
                            txt.setText("podatci unjeti");

                        }
                    }

                }

                };
            btn.setOnClickListener(slusac);
            View.OnClickListener slusac1 = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SQLiteDatabase sqLiteDatabase =getBaseContext().openOrCreateDatabase("Knjige.db",MODE_PRIVATE,null);
                    Cursor query=sqLiteDatabase.rawQuery( "SELECT * FROM Knjiga",null);
                    Integer brojac = query.getCount();
                    for(int i=0;i<brojac;i++){
                        if(query.moveToNext()) {
                            String ime_redatelja = query.getString(0);
                            String autor = query.getString(1);
                            String izdavacka_kuca = query.getString(2);
                            String godina_izdanja = query.getString(3);
                            txt.append("Ime redatelja :" + ime_redatelja + " "+ "Autor:" + autor +" " + "izdavacka kuca:" + izdavacka_kuca + " "+ " godina_izdanja:" + godina_izdanja );



                        }
                    }
                }
            };
            btn1.setOnClickListener(slusac1);
            }
}