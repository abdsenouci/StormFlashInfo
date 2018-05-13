package com.example.abdallah.stormflashinfo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class launcherActivity extends AppCompatActivity
{

    String HttpURL_Lieu = "http://10.0.2.2:8888/StormFlash/LieuTotal.php";
    String HttpURL_BonPlan = "http://10.0.2.2:8888/StormFlash/BonPlanTotal.php";
    String HttpURL_Horaires = "http://10.0.2.2:8888/StormFlash/HorairesTotal.php";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_launcher);
        new NewJsonParser(this).execute();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent intent = new Intent(launcherActivity.this, menuActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    /*
    private class JsonParser extends AsyncTask<Void, Void, Void>
    {
        public Context context;

        String JsonStringLieu;
        String JsonStringBonPlan;
        String JsonStringHoraire;


        ArrayList<String> ListLieu;
        ArrayList<String> ListBonPlan;
        ArrayList<String> ListHoraire;

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

            HttpServiceClass httpServiceClassLieu = new HttpServiceClass(HttpURL_Lieu);
            HttpServiceClass httpServiceClassBonPlan = new HttpServiceClass(HttpURL_BonPlan);
            HttpServiceClass httpServiceClassHoraires = new HttpServiceClass(HttpURL_Horaires);

            try
            {
                httpServiceClassLieu.ExecutePostRequest();
                httpServiceClassBonPlan.ExecutePostRequest();
                httpServiceClassHoraires.ExecutePostRequest();

                if (httpServiceClassLieu.getResponseCode() == 200 && httpServiceClassBonPlan.getResponseCode() == 200 &&
                   httpServiceClassHoraires.getResponseCode() == 200)
                {

                    JsonStringLieu = httpServiceClassLieu.getResponse();
                    JsonStringBonPlan = httpServiceClassBonPlan.getResponse();
                    JsonStringHoraire = httpServiceClassHoraires.getResponse();


                    if (JsonStringLieu != null && JsonStringBonPlan != null && JsonStringHoraire != null)
                    {
                        JSONArray jsonArrayLieu = null;
                        JSONArray jsonArrayBonPlan = null;
                        JSONArray jsonArrayHoraire = null;

                        try
                        {
                           jsonArrayLieu = new JSONArray(JsonStringLieu);
                            JSONObject jsonObject;
                            String lieuString;
                            ListLieu = new ArrayList<>();

                            for (int i = 0; i < jsonArrayLieu.length(); i++)
                            {
                                jsonObject = jsonArrayLieu.getJSONObject(i);

                                lieuString = jsonObject.getString("IdLieu") + "_-_"
                                        + jsonObject.getString("NomLieu") + "_-_"
                                + jsonObject.getString("AdrLieu") + "_-_"
                                + jsonObject.getString("CpLieu") + "_-_"
                                + jsonObject.getString("TelLieu") + "_-_"
                                + jsonObject.getString("IdCat") + "_-_"
                                + jsonObject.getString("IdHoraires");

                                ListLieu.add(lieuString);

                            }

                           jsonArrayBonPlan = new JSONArray(JsonStringBonPlan);
                           JSONObject jsonObjectBonPlan;
                           String bonplanString;
                           ListBonPlan = new ArrayList<>();

                           for (int i = 0; i < jsonArrayBonPlan.length(); i++)
                            {
                                jsonObjectBonPlan = jsonArrayBonPlan.getJSONObject(i);

                                 bonplanString = jsonObjectBonPlan.getString("IdBonPlan") + "_-_"
                                         + jsonObjectBonPlan.getString("ObjBonPlan") + "_-_"
                                         + jsonObjectBonPlan.getString("DescBonPlan") + "_-_"
                                         + jsonObjectBonPlan.getString("DateDeb") + "_-_"
                                         + jsonObjectBonPlan.getString("DateFin") + "_-_"
                                         + jsonObjectBonPlan.getString("IdCat") + "_-_"
                                         + jsonObjectBonPlan.getString("IdLieu");

                                 ListBonPlan.add(bonplanString);

                            }

                            jsonArrayHoraire = new JSONArray(JsonStringHoraire);
                            JSONObject jsonObjectHoraire;
                            String AllHoraire;
                            ListHoraire = new ArrayList<>();

                            for (int i = 0; i < jsonArrayHoraire.length(); i++)
                            {
                                jsonObjectHoraire = jsonArrayHoraire.getJSONObject(i);

                                AllHoraire = jsonObjectHoraire.getString("IdHoraires") + "_-_"
                                          + jsonObjectHoraire.getString("Lundi") + "_-_"
                                          + jsonObjectHoraire.getString("Mardi") + "_-_"
                                          + jsonObjectHoraire.getString("Mercredi") + "_-_"
                                          + jsonObjectHoraire.getString("Jeudi") + "_-_"
                                          + jsonObjectHoraire.getString("Vendredi") + "_-_"
                                          + jsonObjectHoraire.getString("Samedi") + "_-_"
                                          + jsonObjectHoraire.getString("Dimanche");

                                  ListHoraire.add(AllHoraire);
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
                    Toast.makeText(context, httpServiceClassLieu.getErrorMessage(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(context, httpServiceClassBonPlan.getErrorMessage(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(context, httpServiceClassHoraires.getErrorMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if (ListLieu != null || ListBonPlan != null || ListHoraire != null)
            {
                DataListes.Lieux = new ArrayList<>();
                DataListes.BonPlans = new ArrayList<>();
                DataListes.Horaires = new ArrayList<>();

                DataListes.setLieux(ListeLieux);
                DataListes.setBonPlans(ListeBonPlan);
                DataListes.setHoraires(ListeHoraire);
            }
            return null;
        }
    }*/
}