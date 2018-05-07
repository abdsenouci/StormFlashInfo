package com.example.abdallah.stormflashinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.AsyncTask;

import java.util.HashMap;

public class NouveauBonPlanActivity extends AppCompatActivity implements View.OnClickListener
{
    final String LOG = " NouveauBonPlanActivity";

    private EditText ObjBonPlan, DescBonPlan;
    private Button btnInsert, DateDeb, DateFin;
    int CategorieId = -1;
    int LieuId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_bon_plan);

        Intent intent = getIntent();
        CategorieId = intent.getIntExtra("color", -1);


        ObjBonPlan = findViewById(R.id.ObjBonPlan);
        DescBonPlan = findViewById(R.id.DescBonPlan);
        DateDeb = findViewById(R.id.DateDeb);
        DateFin = findViewById(R.id.DateFin);
        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(this);

    }

    String IdCategorie = String.valueOf(CategorieId);
    String IdLieu = String.valueOf(LieuId);

    @Override
    public void onClick(View v) {
        HashMap postData = new HashMap();
        postData.put("TxtObjBonPlan", ObjBonPlan.getText().toString());
        postData.put("TxtDescBonPlan", DescBonPlan.getText().toString());
        postData.put("TxtDateDeb", DateDeb.getText().toString());
        postData.put("TxtDateFin", DateFin.getText().toString());
        postData.put("TxtIdCat", IdCategorie.toString());
        postData.put("TxtIdLieu", IdLieu.toString());
        postData.put("Mobile", "android");


        PostResponseAsyncTask taskInsert = new PostResponseAsyncTask(NouveauBonPlanActivity.this,
                postData, new AsyncResponse()
        {
            @Override
            public void processFinish(String s)
            {
                Log.d(LOG, s);
                if(s.contains("success"))
                {
                    Toast.makeText(NouveauBonPlanActivity.this, "Insert Successfully", Toast.LENGTH_LONG).show();
                    Intent in = new Intent(NouveauBonPlanActivity.this, ListeLieuxActivity.class);
                    startActivity(in);
                }
            }
        });
        taskInsert.execute("http://10.0.2.2:8888/StormFlash/AjouterBonPlan.php");
    }
}
