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
    int i;
    Context context;
    LinearLayout layout;
    int[] colors;
    BonPlan bp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_bon_plans);
        Intent intent = getIntent();
        category = intent.getIntExtra("color",-1);
        context = this;
        layout = findViewById(R.id.linearBonPlan);
        layout.setBackgroundColor(ContextCompat.getColor(this,android.R.color.white));
        colors = Utils.getColors(context, category);

       genererListe();

        initColors(colors);
        newBonPlan();
    }

    public void genererListe()
    {
        String data;
        for(i = 0; i < DataListes.BonPlans.size(); i++)
        {
            if (DataListes.BonPlans.get(i).IdCat == category)
            {
                TextView txt = new TextView(this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(10, 5, 5, 10);
                data = DataListes.BonPlans.get(i).NomLieu + "\n" + DataListes.BonPlans.get(i).ObjBonPlan + "\nDu " + DataListes.BonPlans.get(i).DateDeb + " au " + DataListes.BonPlans.get(i).DateFin;
                txt.setText(data);
                txt.setId(i);
                txt.setBackgroundColor(colors[1]);
                txt.setHeight(200);
                txt.setPadding(10, 10, 10, 10);
                bp = DataListes.BonPlans.get(i);
                txt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Intent intent = new Intent(context, BonPlanActivity.class);
                        intent.putExtra("color", category);
                        intent.putExtra("position", i);
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

    public void initColors(int[] colors)
    {
        AppBarLayout appBar = findViewById(R.id.appbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //FloatingActionButton fbtn = findViewById(R.id.floatingActionButton);
        toolbar.setBackgroundColor(colors[0]);
        appBar.setBackgroundColor(colors[0]);
        //fbtn.setBackgroundColor(colors[2]);
    }

}