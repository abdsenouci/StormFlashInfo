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

    private EditText ObjBonPlan, DescBonPlan, DateDeb, DateFin, IdCat, IdLieu;
    private Button btnInsert;
    int CategorieId = ;
    int LieuId = ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_bon_plan);

        ObjBonPlan = (EditText)findViewById(R.id.ObjBonPlan);
        DescBonPlan = (EditText)findViewById(R.id.DescBonPlan);
        DateDeb = (EditText)findViewById(R.id.DateDeb);
        DateFin = (EditText)findViewById(R.id.DateFin);
        IdCat = CategorieId;
        IdLieu = LieuId
        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        HashMap postData = new HashMap();
        postData.put("TxtObjBonPlan", ObjBonPlan.getText().toString());
        postData.put("TxtDescBonPlan", DescBonPlan.getText().toString());
        postData.put("TxtDateDeb", DateDeb.getText().toString());
        postData.put("TxtDateFin", DateFin.getText().toString());
        postData.put("TxtIdCat", IdCat.getText().toString());
        postData.put("TxtIdLieu", IdLieu.getText().toString());
        postData.put("mobile", "android");


        PostResponseAsyncTask taskInsert = new PostResponseAsyncTask(NouveauBonPlanActivity.this,
                postData, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                Log.d(LOG, s);
                if(s.contains("success")){
                    Toast.makeText(NouveauBonPlanActivity.this, "Insert Successfully", Toast.LENGTH_LONG).show();
                    Intent in = new Intent(                    Toast.makeText(NouveauBonPlanActivity.this, "Insert Successfully", Toast.LENGTH_LONG).show();
.this, ListeLieuxActivity.class);
                    startActivity(in);
                }
            }
        });
        taskInsert.execute("http://10.0.2.2:80/AjouterBonPlan.php");
    }
}
