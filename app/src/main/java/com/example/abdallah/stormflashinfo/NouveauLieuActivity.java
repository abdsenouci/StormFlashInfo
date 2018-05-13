package com.example.abdallah.stormflashinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class NouveauLieuActivity extends AppCompatActivity
{
    final String LOG = " NouveauLieuActivity";

    private EditText NomLieu, AdrLieu, CpLieu, TelLieu;
    EditText Lu1, Lu2, Ma1, Ma2, Me1, Me2, Je1, Je2, Ve1, Ve2, Sa1, Sa2, Di1, Di2;
    Switch Lun, Mar, Mer, Jeu, Ven, Sam, Dim;
    Button btnInsert;

    int CategorieId;
    int HoraireId;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_lieu);

        /*NomLieu = findViewById(R.id.NomLieu);
        AdrLieu = findViewById(R.id.spinnerLieux);
        CpLieu = findViewById(R.id.CpLieu);
        TelLieu = findViewById(R.id.TelLieu);

        Lun = findViewById(R.id.LunSwitch);
        Lu1 = findViewById(R.id.Lu1);
        Lu2 = findViewById(R.id.Lu2);

        Mar = findViewById(R.id.MarSwitch);
        Ma1 = findViewById(R.id.Ma1);
        Ma2 = findViewById(R.id.Ma2);

        Mer = findViewById(R.id.MerSwitch);
        Me1 = findViewById(R.id.Me1);
        Me2 = findViewById(R.id.Me2);

        Jeu = findViewById(R.id.JeuSwitch);
        Je1 = findViewById(R.id.Je1);
        Je2 = findViewById(R.id.Je2);

        Ven = findViewById(R.id.VenSwitch);
        Ve1 = findViewById(R.id.Ve1);
        Ve2 = findViewById(R.id.Ve2);

        Sam = findViewById(R.id.SamSwitch);
        Sa1 = findViewById(R.id.Sa1);
        Sa2 = findViewById(R.id.Sa2);

        Dim = findViewById(R.id.DimSwitch);
        Di1 = findViewById(R.id.Di1);
        Di2 = findViewById(R.id.Di2);*/

    }
}
