package com.example.abdallah.stormflashinfo;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class BonPlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int id = intent.getIntExtra("IdBonPlan", -1);
        BonPlan bp = DataListes.BonPlans.get(intent.getIntExtra("position",(-1)));
        setContentView(R.layout.activity_bon_plan);
        TextView obj = findViewById(R.id.textView4);
        Button nomLieu = findViewById(R.id.button);
        TextView periode = findViewById(R.id.textView30);
        TextView desc = findViewById(R.id.textView5);

        obj.setText(bp.ObjBonPlan);
        nomLieu.setText(bp.NomLieu);
        periode.setText(bp.DateDeb);
        desc.setText(bp.DescBonPlan);

    }
}
