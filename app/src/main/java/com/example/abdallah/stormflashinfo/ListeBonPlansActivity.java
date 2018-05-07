package com.example.abdallah.stormflashinfo;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;
import java.util.concurrent.TimeUnit;



public class ListeBonPlansActivity extends AppCompatActivity
{
    int category;
    Context context;
    LinearLayout layout;
    int[] colors;
    static List<BonPlan> BonPlans;
    BonPlan bp;

    //Variables pour le JSON
    String HttpURL = "http://10.0.2.2:80/BonPlan.php";


    private static void setListe(List<BonPlan> liste)
    {
        BonPlans = liste;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_bon_plans);
        Intent intent = getIntent();
        category = intent.getIntExtra("color",-1);
        context = this;
        layout = findViewById(R.id.linearBonPlan);
        layout.setBackgroundColor(ContextCompat.getColor(this,android.R.color.white));
        colors = getColors(category);
        newBonPlan();
        new JsonParser(this).execute();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        genererListe();

        initColors(colors);
    }

    public void genererListe()
    {
        String data;
        for(int i = 0; i < BonPlans.size(); i++)
        {
            if (BonPlans.get(i).IdCat == category)
            {
                TextView txt = new TextView(this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(10, 5, 5, 10);
                data = BonPlans.get(i).NomLieu + "\n" + BonPlans.get(i).ObjBonPlan + "\nDu " + BonPlans.get(i).DateDeb + " au " + BonPlans.get(i).DateFin;
                txt.setText(data);
                txt.setId(i);
                txt.setBackgroundColor(colors[1]);
                txt.setHeight(200);
                txt.setPadding(10, 10, 10, 10);
                bp = BonPlans.get(i);
                txt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent intent = new Intent(context, BonPlanActivity.class);
                        intent.putExtra("color", category);
                        intent.putExtra("IdBonPlan", bp.IdBonPlan);
                        intent.putExtra("NomLieu", bp.NomLieu);
                        intent.putExtra("ObjBonPlan", bp.ObjBonPlan);
                        intent.putExtra("DateDeb", bp.DateDeb);
                        intent.putExtra("DateFin", bp.DateFin);
                        intent.putExtra("IdLieu", bp.IdLieu);
                        intent.putExtra("DescBonPlan", bp.DescBonPlan);

                        context.startActivity(intent);

                    }
                });
                layout.addView(txt, lp);
            }
        }
    }

        public void newBonPlan()
        {
            FloatingActionButton fab = findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, NouveauBonPlanActivity.class);
                    intent.putExtra("color",category);
                    startActivity(intent);
                }
            });

    }

    private class JsonParser extends AsyncTask<Void, Void, Void>
    {
        public Context context;

        String JsonString;

        List<BonPlan> ListBonPlan;

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

                            BonPlan bonPlan;

                            ListBonPlan = new ArrayList<BonPlan>();


                            for (int i = 0; i < jsonArray.length(); i++)
                            {
                                bonPlan = new BonPlan();
                                jsonObject = jsonArray.getJSONObject(i);

                                bonPlan.ObjBonPlan = jsonObject.getString("ObjBonPLan");
                                bonPlan.DateDeb = jsonObject.getString("DateDeb");
                                bonPlan.DateFin = jsonObject.getString("DateFin");
                                bonPlan.NomLieu = jsonObject.getString("nomLieu");
                                bonPlan.IdCat = jsonObject.getInt("IdCat");
                                bonPlan.IdBonPlan = jsonObject.getInt("IdBonPlan");
                                bonPlan.IdLieu = jsonObject.getInt("IdLieu");
                                bonPlan.DescBonPlan = jsonObject.getString("DescBonPlan");

                                ListBonPlan.add(bonPlan);

                            }
                        }

                        catch (JSONException e)
                        {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
                //System.out.println("ONSORTDELABOUCLE2");
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

            if (ListBonPlan != null)
            {
                ListeBonPlansActivity.setListe(ListBonPlan);
            }

            return null;
        }

    }




    public void initColors(int[] colors)
    {
        AppBarLayout appBar = findViewById(R.id.appbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //FloatingActionButton fbtn = findViewById(R.id.floatingActionButton);
        toolbar.setBackgroundColor(colors[0]);
        appBar.setBackgroundColor(colors[0]);
        //fbtn.setBackgroundColor(colors[2]);
    }

    public int[] getColors(int colorCode) {
        int[] colors = new int[3];
        switch (colorCode) {
            case 0:
                colors[0] = ContextCompat.getColor(this,R.color.category0);
                colors[1] = ContextCompat.getColor(this,R.color.category0Off);
                colors[2] = ContextCompat.getColor(this,R.color.category0Btn);
                break;
            case 1:
                colors[0] = ContextCompat.getColor(this,R.color.category1);
                colors[1] = ContextCompat.getColor(this,R.color.category1Off);
                colors[2] = ContextCompat.getColor(this,R.color.category1Btn);
                break;
            case 2:
                colors[0] = ContextCompat.getColor(this,R.color.category2);
                colors[1] = ContextCompat.getColor(this,R.color.category2Off);
                colors[2] = ContextCompat.getColor(this,R.color.category2Btn);
                break;
            case 3:
                colors[0] = ContextCompat.getColor(this,R.color.category3);
                colors[1] = ContextCompat.getColor(this,R.color.category3Off);
                colors[2] = ContextCompat.getColor(this,R.color.category3Btn);
                break;
            case 4:
                colors[0] = ContextCompat.getColor(this,R.color.category4);
                colors[1] = ContextCompat.getColor(this,R.color.category4Off);
                colors[2] = ContextCompat.getColor(this,R.color.category4Btn);
                break;
            case 5:
                colors[0] = ContextCompat.getColor(this,R.color.category5);
                colors[1] = ContextCompat.getColor(this,R.color.category5Off);
                colors[2] = ContextCompat.getColor(this,R.color.category5Btn);
                break;
            case 6:
                colors[0] = ContextCompat.getColor(this,R.color.category6);
                colors[1] = ContextCompat.getColor(this,R.color.category6Off);
                colors[2] = ContextCompat.getColor(this,R.color.category6Btn);
                break;
            default:
                colors[0] = ContextCompat.getColor(this,R.color.colorPrimary);
                colors[1] = ContextCompat.getColor(this,R.color.colorPrimaryDark);
                colors[2] = ContextCompat.getColor(this,R.color.colorAccent);
                break;
        }
        return colors;
    }


}