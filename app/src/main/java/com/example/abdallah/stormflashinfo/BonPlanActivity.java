package com.example.abdallah.stormflashinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BonPlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bon_plan);
        TextView txt1 = findViewById(R.id.textView);
        TextView txt2 = findViewById(R.id.textView2);
        TextView txt3 = findViewById(R.id.textView3);
        TextView txt4 = findViewById(R.id.textView4);
        TextView txt5 = findViewById(R.id.textView5);
        Intent intent = getIntent();
        txt1.setText(intent.getStringExtra("NomLieu"));
        txt5.setText(intent.getStringExtra("DescBonPlan"));
        txt4.setText(intent.getStringExtra("ObjBonPlan"));


    }
}
