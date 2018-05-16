package com.example.abdallah.stormflashinfo;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class NouveauBonPlanActivity extends AppCompatActivity implements View.OnClickListener
{
    final String LOG = " NouveauBonPlanActivity";
    static String FinalDateDeb;
    static String FinalDateFin;

    private DatePickerDialog.OnDateSetListener DateDebList;
    private DatePickerDialog.OnDateSetListener DateFinList;
    private EditText ObjBonPlan, DescBonPlan;

    Spinner spinnerLieux;
    ArrayAdapter<String> adapterLieux;
    EditText DateDeb, DateFin;
    Button btnInsert;
    int CategorieId;
    int LieuId = -200;

    List<String> listeLieuxStr;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_bon_plan);

        Intent intent = getIntent();

        ArrayList<Lieu> listeLieux = new ArrayList<>();
        listeLieuxStr = new ArrayList<>();



        CategorieId = intent.getIntExtra("color", -1);
        ObjBonPlan = findViewById(R.id.ObjBonPlan);
        DescBonPlan = findViewById(R.id.DescBonPlan);
        Spinner spinnerCat = findViewById(R.id.spinnerCat);
        List<String> listeCat = Arrays.asList(DataListes.Categories);
        ArrayAdapter<String> adapterCat = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, listeCat);
        adapterCat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCat.setAdapter(adapterCat);
        spinnerCat.setSelection(CategorieId);
        spinnerCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                CategorieId = position;
                setLieux(position);
                adapterLieux = new ArrayAdapter<>(NouveauBonPlanActivity.this,
                        android.R.layout.simple_spinner_item, listeLieuxStr);
                adapterLieux.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerLieux.setAdapter(adapterLieux);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        spinnerLieux = findViewById(R.id.AdrLieu);
        adapterLieux = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, listeLieuxStr);
        adapterLieux.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLieux.setAdapter(adapterLieux);
        spinnerLieux.setSelection(0,false);
        spinnerLieux.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                LieuId = DataListes.Lieux.get(position).IdLieu;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

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

        btnInsert = findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(this);
    }

    public void setLieux(int idCat)
    {
        listeLieuxStr = new ArrayList<>();
        for(int i=0;i<DataListes.Lieux.size();i++)
        {
            if(idCat>=0)
            {
                if(DataListes.Lieux.get(i).IdCat==CategorieId)
                {
                    listeLieuxStr.add(DataListes.Lieux.get(i).NomLieu);
                }
            }else
            {
                listeLieuxStr.add(DataListes.Lieux.get(i).NomLieu);
            }
        }
    }

    public void execut_task_bonplan()
    {
        HashMap<String,String> postData = new HashMap<>();
        postData.put("TxtObjBonPlan", ObjBonPlan.getText().toString());
        postData.put("TxtDescBonPlan", DescBonPlan.getText().toString());
        postData.put("TxtDateDeb", FinalDateDeb);
        postData.put("TxtDateFin", FinalDateFin);
        postData.put("TxtIdCat", String.valueOf(CategorieId));
        postData.put("TxtIdLieu", String.valueOf(LieuId));
        //postData.put("Mobile", "Android");

        PostResponseAsyncTask taskInsert = new PostResponseAsyncTask(NouveauBonPlanActivity.this,
                postData, new AsyncResponse()
        {
            @Override
            public void processFinish(String s)
            {
                Log.d(LOG, s);
                /*if(s.contains("success"))
                {
                    Toast.makeText(NouveauBonPlanActivity.this, "Insert Successfully", Toast.LENGTH_LONG).show();
                    Intent in = new Intent(NouveauBonPlanActivity.this, ListeBonPlansActivity.class);
                    startActivity(in);
                }
                else*/
                finish();
            }
        });
        taskInsert.execute("http://10.0.2.2:80/AjoutBonPlan2.php");
    }

    @Override
    public void onClick(View v)
    {
        if (!ObjBonPlan.getText().toString().equals("") && !DescBonPlan.getText().toString().equals("") && !DateDeb.getText().toString().equals("")
                && !DateFin.getText().toString().equals(""))
        {
            if (LieuId == -200)
            {
                Toast toast = Toast.makeText(NouveauBonPlanActivity.this, "Veuillez selectionner un lieu", Toast.LENGTH_SHORT);
                toast.show();
            }
            else
                execut_task_bonplan();
        }
        else
        {
            Toast toast = Toast.makeText(NouveauBonPlanActivity.this, "Veuillez remplir tout les champs du bonplan", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}