package com.example.abdallah.stormflashinfo;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        int[] colors = Utils.getColors(this,category);
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

    public void chooseLieux(View view) { Lieux(category); }

    public void chooseBonPlan(View view) { BonPlan(category); }

    public void Lieux(int category) {
        Intent intent = new Intent(this, ListeLieuxActivity.class);
        intent.putExtra("color",category);
        startActivity(intent);
    }

    public void BonPlan(int category) {
        Intent intent = new Intent(this, ListeBonPlansActivity.class);
        intent.putExtra("color",category);
        startActivity(intent);
    }
}
