package com.example.abdallah.stormflashinfo;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashMap;

public class NouveauBonPlanActivity extends AppCompatActivity implements View.OnClickListener
{
    final String LOG = " NouveauBonPlanActivity";

    static String FinalDateDeb;
    static String FinalDateFin;

    private DatePickerDialog.OnDateSetListener DateDebList;
    private DatePickerDialog.OnDateSetListener DateFinList;
    private EditText ObjBonPlan, DescBonPlan;

    EditText DateDeb, DateFin;
    Button btnInsert;
    String IdCategorie;
    String IdLieu;
    int CategorieId = 0;
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
        DateDeb.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Calendar cal = Calendar.getInstance();
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);

                DatePickerDialog dialog = new DatePickerDialog
                        (NouveauBonPlanActivity.this, android.R.style.Theme_Holo_Dialog_MinWidth,
                                DateDebList, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }

        });
        DateDebList = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String A = String.valueOf(year);
                String M = String.valueOf(month);
                String J = String.valueOf(day);
                FinalDateDeb = A + "/" + M + "/" + J;
            }
        };


        DateFin = findViewById(R.id.DateFin);
        DateFin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Calendar cal = Calendar.getInstance();
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);

                DatePickerDialog dialog = new DatePickerDialog
                        (NouveauBonPlanActivity.this, android.R.style.Theme_Holo_Dialog_MinWidth,
                                DateFinList, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }

        });
        DateFinList = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String A = String.valueOf(year);
                String M = String.valueOf(month);
                String J = String.valueOf(day);
                FinalDateFin = A + "/" + M + "/" + J;
            }
        };

        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(this);

        IdCategorie = String.valueOf(CategorieId);
        IdLieu = String.valueOf(LieuId);

    }


    @Override
    public void onClick(View v)
    {
        HashMap<String,String> postData = new HashMap<>();
        postData.put("TxtObjBonPlan", ObjBonPlan.getText().toString());
        postData.put("TxtDescBonPlan", DescBonPlan.getText().toString());
        postData.put("TxtDateDeb", FinalDateDeb);
        postData.put("TxtDateFin", FinalDateFin);
        postData.put("TxtIdCat", IdCategorie);
        postData.put("TxtIdLieu", IdLieu);
        //postData.put("Mobile", "Android");

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
                    Intent in = new Intent(NouveauBonPlanActivity.this, ListeBonPlansActivity.class);
                    startActivity(in);
                }
                else
                    finish();
            }
        });
        taskInsert.execute("http://10.0.2.2:8888/StormFlash/AjoutBonPlan2.php");
    }
}