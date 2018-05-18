package com.example.abdallah.stormflashinfo;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class LieuActivity extends AppCompatActivity
{
    int category;
    Context context;
    int[] colors;
    Lieu lieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lieu);
        Intent intent = getIntent();
        category = intent.getIntExtra("color",-1);
        context = this;
        colors = Utils.getColors(context, category);
        lieu = DataListes.Lieux.get(intent.getIntExtra("position", (-1)));
        Toolbar toolbar = findViewById(R.id.toolbar);
        Utils.setTitle(toolbar,lieu.NomLieu);
        int positionHoraire = Horaire.getPositionHoraire(lieu.IdHor);
        Horaire horaire = DataListes.Horaires.get(positionHoraire);
        initColors();
        TextView Adr = findViewById(R.id.AdrView);
        TextView Tel = findViewById(R.id.TelView);
        TextView Lun = findViewById(R.id.LunView);
        TextView Mar = findViewById(R.id.MarView);
        TextView Mer = findViewById(R.id.MerView);
        TextView Jeu = findViewById(R.id.JeuView);
        TextView Ven = findViewById(R.id.VenView);
        TextView Sam = findViewById(R.id.SamView);
        TextView Dim = findViewById(R.id.DimView);


        Adr.setText(lieu.AdresseLieu);
        String strHoraire="0"+String.valueOf(lieu.Tel);
        Tel.setText(strHoraire);

        Log.e("AAAAAAAAAAAAAAAA", horaire.lundi);
        horaire.setTextView(Lun, horaire.lundi);
        horaire.setTextView(Mar, horaire.mardi);
        horaire.setTextView(Mer, horaire.mercredi);
        horaire.setTextView(Jeu, horaire.jeudi);
        horaire.setTextView(Ven, horaire.vendredi);
        horaire.setTextView(Sam, horaire.samedi);
        horaire.setTextView(Dim, horaire.dimanche);
    }

    public void initColors()
    {
        AppBarLayout appBar = findViewById(R.id.appbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(lieu.NomLieu);
        toolbar.setBackgroundColor(colors[0]);
        appBar.setBackgroundColor(colors[0]);

    }
}
