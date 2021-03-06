package com.example.abdallah.stormflashinfo;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BonPlanActivity extends AppCompatActivity {

    int category;
    Context context;
    int[] colors;
    int positionLieu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bon_plan);
        Intent intent = getIntent();
        Toolbar toolbar = findViewById(R.id.toolbar);
        Utils.setTitle(toolbar,DataListes.Categories[intent.getIntExtra("color",-1)]);
        category = intent.getIntExtra("color",-1);
        context = this;
        colors = Utils.getColors(context, category);
        this.initColors();
        BonPlan bp = DataListes.BonPlans.get(intent.getIntExtra("position",(-1)));
        positionLieu=DataListes.getPositionLieuById(bp.IdLieu);
        TextView obj = findViewById(R.id.textView4);
        Button nomLieu = findViewById(R.id.btnBPLieu);
        TextView periode = findViewById(R.id.textView30);
        TextView desc = findViewById(R.id.textView5);

        obj.setText(bp.ObjBonPlan);
        nomLieu.setText(bp.NomLieu);
        periode.setText("du "+bp.DateDeb+" au "+bp.DateFin);
        desc.setText(bp.DescBonPlan);

    }
    public void initColors()
    {
        AppBarLayout appBar = findViewById(R.id.appbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Button btn = findViewById(R.id.btnBPLieu);

        toolbar.setBackgroundColor(colors[0]);
        appBar.setBackgroundColor(colors[0]);
        btn.setBackgroundColor(colors[1]);
    }

    public void afficherLieu(View v)
    {
        Intent intent = new Intent(context, LieuActivity.class);
        intent.putExtra("color", category);
        intent.putExtra("position", positionLieu);
        context.startActivity(intent);
    }
}
