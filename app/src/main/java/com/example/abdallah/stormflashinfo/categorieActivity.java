package com.example.abdallah.stormflashinfo;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class categorieActivity extends AppCompatActivity {
    int category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie);
        Intent intent = getIntent();
        category = intent.getIntExtra("color",-1);
        int[] colors = getColors(category);
        initColors(colors);
    }

    public void initColors(int[] colors){
        AppBarLayout appBar = findViewById(R.id.appbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Button btnLieux = findViewById(R.id.btnLieux);
        Button btnBonsPlans = findViewById(R.id.btnBonsPlans);
        toolbar.setBackgroundColor(colors[0]);
        appBar.setBackgroundColor((colors[0]));
        btnLieux.setBackgroundColor(colors[1]);
        btnBonsPlans.setBackgroundColor(colors[1]);
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

    public void chooseLieux(View view) { Lieux(view, category); }

    public void chooseBonPlan(View view) { BonPlan(view, category); }

    public void Lieux(View view, int category) {
        Intent intent = new Intent(this, ListeLieuxActivity.class);
        intent.putExtra("color",category);
        startActivity(intent);
    }

    public void BonPlan(View view, int category) {
        Intent intent = new Intent(this, ListeBonPlansActivity.class);
        intent.putExtra("color",category);
        startActivity(intent);
    }
}
