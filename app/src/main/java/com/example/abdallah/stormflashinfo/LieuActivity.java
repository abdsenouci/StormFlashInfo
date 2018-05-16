package com.example.abdallah.stormflashinfo;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
        this.initColors();
        TextView Adr = findViewById(R.id.AdrView);
        TextView Tel = findViewById(R.id.TelView);
        TextView Lun = findViewById(R.id.LunView);
        TextView Mar = findViewById(R.id.MarView);
        TextView Mer = findViewById(R.id.MerView);
        TextView Jeu = findViewById(R.id.JeuView);
        TextView Ven = findViewById(R.id.VenView);
        TextView Sam = findViewById(R.id.SamView);
        TextView Dim = findViewById(R.id.DimView);
        lieu = DataListes.Lieux.get(intent.getIntExtra("position", (-1)));
        int positionHoraire = Horaire.getPositionHoraire(lieu.IdHor);
        Horaire horaire = DataListes.Horaires.get(positionHoraire);

        Adr.setText(lieu.AdresseLieu);
        Tel.setText(lieu.Tel);
        horaire.setTextView(Lun, 0);
        horaire.setTextView(Mar, 1);
        horaire.setTextView(Mer, 2);
        horaire.setTextView(Jeu, 3);
        horaire.setTextView(Ven, 4);
        horaire.setTextView(Sam, 5);
        horaire.setTextView(Dim, 6);
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
