package com.example.abdallah.stormflashinfo;

import android.content.Context;
import android.content.Intent;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ListeLieuxActivity extends AppCompatActivity
{
    int category;
    Context context;
    LinearLayout layout;
    int[] colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_lieux);
        Intent intent = getIntent();
        category = intent.getIntExtra("color",-1);
        context = this;
        layout = findViewById(R.id.linearLieu);
        layout.setBackgroundColor(ContextCompat.getColor(this,android.R.color.white));
        colors = Utils.getColors(context, category);
        genererListe();
        initColors();
        newLieu();
    }

    public void genererListe()
    {
        String data;
        for(int i = 0; i < DataListes.Lieux.size(); i++)
        {
            if (DataListes.Lieux.get(i).IdCat == category)
            {
                TextView txt = new TextView(this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(10, 5, 5, 10);
                data = DataListes.Lieux.get(i).NomLieu + "\n" + DataListes.Lieux.get(i).AdresseLieu + "\n Horaires : ";
                txt.setText(data);
                txt.setId(i);
                txt.setBackgroundColor(colors[1]);
                txt.setTextColor(ContextCompat.getColor(context,android.R.color.white));
                txt.setTextSize(20);
                txt.setPadding(10, 10, 10, 10);
                txt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent intent = new Intent(context, BonPlanActivity.class);
                        intent.putExtra("color", category);
                        intent.putExtra("position", v.getId());
                        context.startActivity(intent);

                    }
                });
                layout.addView(txt, lp);
            }
        }
    }

    public void initColors()
    {
        AppBarLayout appBar = findViewById(R.id.appbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(colors[0]);
        appBar.setBackgroundColor((colors[0]));
    }


    public void newLieu()
    {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NouveauLieuActivity.class);
                intent.putExtra("color",category);
                startActivity(intent);
            }
        });
    }

}
