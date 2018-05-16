package com.example.abdallah.stormflashinfo;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

public class BonPlanActivity extends AppCompatActivity {

    int category;
    Context context;
    int[] colors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bon_plan);
        Intent intent = getIntent();
        category = intent.getIntExtra("color",-1);
        context = this;
        colors = Utils.getColors(context, category);
        this.initColors();
        BonPlan bp = DataListes.BonPlans.get(intent.getIntExtra("position",(-1)));
        TextView obj = findViewById(R.id.textView4);
        Button nomLieu = findViewById(R.id.btnBPLieu);
        TextView periode = findViewById(R.id.textView30);
        TextView desc = findViewById(R.id.textView5);

        obj.setText(bp.ObjBonPlan);
        nomLieu.setText(bp.NomLieu);
        periode.setText(bp.DateDeb);
        desc.setText(bp.DescBonPlan);

    }
    public void initColors()
    {
        AppBarLayout appBar = findViewById(R.id.appbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Button btn = findViewById(R.id.btnBPLieu);

        toolbar.setBackgroundColor(colors[0]);
        appBar.setBackgroundColor(colors[0]);

    }
}
