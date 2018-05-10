package com.example.abdallah.stormflashinfo;

import android.content.Context;
import android.content.Intent;

import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;



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
        colors = getColors(category);

        //genererListe();
        initColors(colors);
    }

    /*public void genererListe()
    {
        String data;
        for(int i = 0; i < ListLieux.size(); i++)
        {
            if (ListLieux.get(i).IdCat == category)
            {
                TextView txt = new TextView(this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(10, 5, 5, 10);
                data = ListLieux.get(i).NomLieu + "\n" + ListLieux.get(i).AdresseLieu + "\n Horaires : ";
                txt.setText(data);
                txt.setId(i);
                txt.setBackgroundColor(colors[1]);
                txt.setHeight(200);
                txt.setPadding(10, 10, 10, 10);
                txt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent intent = new Intent(context, BonPlanActivity.class);
                        intent.putExtra("color", category);
                        context.startActivity(intent);

                    }
                });
                layout.addView(txt, lp);
            }
        }
    }*/


    public void initColors(int[] colors)
    {
        AppBarLayout appBar = findViewById(R.id.appbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(colors[0]);
        appBar.setBackgroundColor((colors[0]));
    }

    public int[] getColors(int colorCode) {
        int[] colors = new int[3];
        switch (colorCode) {
            case 0:
                colors[0] = ContextCompat.getColor(this,R.color.category0);
                colors[1] = ContextCompat.getColor(this,R.color.category0Off);
                colors[2] = ContextCompat.getColor(this,R.color.category0Btn);
                break;
            case 1:
                colors[0] = ContextCompat.getColor(this,R.color.category1);
                colors[1] = ContextCompat.getColor(this,R.color.category1Off);
                colors[2] = ContextCompat.getColor(this,R.color.category1Btn);
                break;
            case 2:
                colors[0] = ContextCompat.getColor(this,R.color.category2);
                colors[1] = ContextCompat.getColor(this,R.color.category2Off);
                colors[2] = ContextCompat.getColor(this,R.color.category2Btn);
                break;
            case 3:
                colors[0] = ContextCompat.getColor(this,R.color.category3);
                colors[1] = ContextCompat.getColor(this,R.color.category3Off);
                colors[2] = ContextCompat.getColor(this,R.color.category3Btn);
                break;
            case 4:
                colors[0] = ContextCompat.getColor(this,R.color.category4);
                colors[1] = ContextCompat.getColor(this,R.color.category4Off);
                colors[2] = ContextCompat.getColor(this,R.color.category4Btn);
                break;
            case 5:
                colors[0] = ContextCompat.getColor(this,R.color.category5);
                colors[1] = ContextCompat.getColor(this,R.color.category5Off);
                colors[2] = ContextCompat.getColor(this,R.color.category5Btn);
                break;
            case 6:
                colors[0] = ContextCompat.getColor(this,R.color.category6);
                colors[1] = ContextCompat.getColor(this,R.color.category6Off);
                colors[2] = ContextCompat.getColor(this,R.color.category6Btn);
                break;
            default:
                colors[0] = ContextCompat.getColor(this,R.color.colorPrimary);
                colors[1] = ContextCompat.getColor(this,R.color.colorPrimaryDark);
                colors[2] = ContextCompat.getColor(this,R.color.colorAccent);
                break;
        }
        return colors;
    }

    public void newLieu(View view) {
        Intent intent = new Intent(this, NouveauBonPlanActivity.class);
        intent.putExtra("color",category);
        startActivity(intent);
    }

}
