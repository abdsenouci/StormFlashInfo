package com.example.abdallah.stormflashinfo;

import android.content.Context;
import android.os.AsyncTask;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NouveauBonPlanActivity extends AppCompatActivity implements View.OnClickListener
{
    final String LOG = " NouveauBonPlanActivity";

    String IdCategorie;
    String IdLieu;

    String HttpURL = "http://10.0.2.2:8888/StormFlash/ListeLieux.php";


    private EditText ObjBonPlan, DescBonPlan, DateDeb, DateFin;
    private Button btnInsert;
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
        DateFin = findViewById(R.id.DateFin);
        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(this);

        IdCategorie = String.valueOf(CategorieId);
        IdLieu = String.valueOf(LieuId);
    }

    private class JsonParser extends AsyncTask<Void, Void, Void>
    {
        public Context context;

        String JsonString;

        List<Lieu> ListLieu;

        public JsonParser(Context context)
        {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0)
        {

            HttpServiceClass httpServiceClass = new HttpServiceClass(HttpURL);

            try
            {
                httpServiceClass.ExecutePostRequest();


                if (httpServiceClass.getResponseCode() == 200)
                {

                    JsonString = httpServiceClass.getResponse();


                    if (JsonString != null)
                    {
                        JSONArray jsonArray = null;

                        try
                        {
                            jsonArray = new JSONArray(JsonString);

                            JSONObject jsonObject;

                            Lieu lieu;

                            ListLieu = new ArrayList<Lieu>();


                            for (int i = 0; i < jsonArray.length(); i++)
                            {
                                lieu = new Lieu();
                                jsonObject = jsonArray.getJSONObject(i);

                                lieu.NomLieu = jsonObject.getString("NomLieu");
                                lieu.AdresseLieu = jsonObject.getString("AdrLieu");
                                lieu.IdLieu = jsonObject.getInt("IdLieu");
                                lieu.Cp = jsonObject.getInt("CpLieu");
                                lieu.Tel = jsonObject.getInt("TelLieu");
                                lieu.IdCat = jsonObject.getInt("IdCat");
                                lieu.IdHor = jsonObject.getInt("IdHoraires");

                                ListLieu.add(lieu);

                            }
                        }

                        catch (JSONException e)
                        {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
                else
                {
                    Toast.makeText(context, httpServiceClass.getErrorMessage(), Toast.LENGTH_SHORT).show();
                }
            }


            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if (ListLieu != null)
            {
                ListeLieuxActivity.setListe(ListLieu);
            }

            return null;
        }

    }

    @Override
    public void onClick(View v)
    {
        HashMap postData = new HashMap();
        postData.put("TxtObjBonPlan", ObjBonPlan.getText().toString());
        postData.put("TxtDescBonPlan", DescBonPlan.getText().toString());
        postData.put("TxtDateDeb", DateDeb.getText().toString());
        //postData.put("TxtDateDeb", "28/10/2018");
        postData.put("TxtDateFin", DateFin.getText().toString());
        //postData.put("TxtDateFin", "30/11/2018");
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
            }
        });
        taskInsert.execute("http://10.0.2.2:8888/StormFlash/AjoutBonPlan2.php");
    }
}
