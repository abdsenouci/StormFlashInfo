package com.example.abdallah.stormflashinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NouveauLieuActivity extends AppCompatActivity implements View.OnClickListener
{
    final String LOG = " NouveauLieuActivity";

    private EditText NomLieu, AdrLieu, CpLieu, TelLieu;
    EditText Lu1, Lu2, Ma1, Ma2, Me1, Me2, Je1, Je2, Ve1, Ve2, Sa1, Sa2, Di1, Di2;
    Switch Lun, Mar, Mer, Jeu, Ven, Sam, Dim;
    Button btnInsert;

    int CategorieId;
    int HoraireId = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_lieu);

        Spinner spinnerCat = findViewById(R.id.spinnerCat);
        List<String> listeCat = Arrays.asList(DataListes.Categories);

        ArrayAdapter<String> adapterCat = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, listeCat);

        adapterCat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCat.setAdapter(adapterCat);
        spinnerCat.setSelection(CategorieId);
        spinnerCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                CategorieId = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView)
            {
                // your code here
            }
        });

        NomLieu = findViewById(R.id.NomLieu);
        AdrLieu = findViewById(R.id.spinnerLieux);
        CpLieu = findViewById(R.id.CpLieu);
        TelLieu = findViewById(R.id.TelLieu);

        Lun = findViewById(R.id.LunSwitch);
        Lu1 = findViewById(R.id.Lu1);
        Lu2 = findViewById(R.id.Lu2);

        Mar = findViewById(R.id.MarSwitch);
        Ma1 = findViewById(R.id.Ma1);
        Ma2 = findViewById(R.id.Ma2);

        Mer = findViewById(R.id.MerSwitch);
        Me1 = findViewById(R.id.Me1);
        Me2 = findViewById(R.id.Me2);

        Jeu = findViewById(R.id.JeuSwitch);
        Je1 = findViewById(R.id.Je1);
        Je2 = findViewById(R.id.Je2);

        Ven = findViewById(R.id.VenSwitch);
        Ve1 = findViewById(R.id.Ve1);
        Ve2 = findViewById(R.id.Ve2);

        Sam = findViewById(R.id.SamSwitch);
        Sa1 = findViewById(R.id.Sa1);
        Sa2 = findViewById(R.id.Sa2);

        Dim = findViewById(R.id.DimSwitch);
        Di1 = findViewById(R.id.Di1);
        Di2 = findViewById(R.id.Di2);

    }

    public String concat_horaire(Switch Day, EditText part_one, EditText part_two)
    {
        String res;
        String one;
        String two;
        String tree;

        one = String.valueOf(Day);
        two = part_one.getText().toString();
        tree = part_two.getText().toString();

        res =  one + "." + two + "." + tree;

        return (res);
    }

    public void execut_task_lieu()
    {
        HashMap<String,String> postData = new HashMap<>();
        postData.put("TxtNomLieu", NomLieu.getText().toString());
        postData.put("TxtAdrLieu", AdrLieu.getText().toString());
        postData.put("TxtTelLieu", TelLieu.getText().toString());
        postData.put("TxtCpLieu", CpLieu.getText().toString());
        postData.put("TxtIdCat", String.valueOf(CategorieId));
        postData.put("TxtIdHoraires", String.valueOf(HoraireId));
        //postData.put("Mobile", "Android");

        PostResponseAsyncTask taskInsert_lieu = new PostResponseAsyncTask(NouveauLieuActivity.this,
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
        taskInsert_lieu.execute("http://10.0.2.2:8888/StormFlash/AjoutLieu2.php");
    }

    public void execut_task_horaires()
    {
        HashMap<String,String> postData = new HashMap<>();
        postData.put("TxtLundi", concat_horaire(Lun, Lu1, Lu2));
        postData.put("TxtMardi", concat_horaire(Mar, Ma1, Ma2));
        postData.put("TxtMercredi", concat_horaire(Mer, Me2, Me2));
        postData.put("TxtJeudi", concat_horaire(Jeu, Je1, Je2));
        postData.put("TxtVendredi", concat_horaire(Ven, Ve1, Ve2));
        postData.put("TxtSamedi", concat_horaire(Sam, Sa1, Sa2));
        postData.put("TxtDimanche", concat_horaire(Dim, Di1, Di2));
        postData.put("TxtIdHoraire", String.valueOf(HoraireId));


        PostResponseAsyncTask taskInsert_horaires = new PostResponseAsyncTask(NouveauLieuActivity.this,
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
        taskInsert_horaires.execute("http://10.0.2.2:8888/StormFlash/AjoutHoraires.php");
    }

    @Override
    public void onClick(View v)
    {
        execut_task_lieu();
        execut_task_horaires();
    }
}