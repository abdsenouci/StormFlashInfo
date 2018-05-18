package com.example.abdallah.stormflashinfo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.example.abdallah.stormflashinfo.DataListes.newIdHoraire;

public class NouveauLieuActivity extends AppCompatActivity implements View.OnClickListener
{
    final String LOG = " NouveauLieuActivity";

    private EditText NomLieu, AdrLieu, CpLieu, TelLieu;
    EditText Lu1, Lu2, Ma1, Ma2, Me1, Me2, Je1, Je2, Ve1, Ve2, Sa1, Sa2, Di1, Di2;
    Switch Lun, Mar, Mer, Jeu, Ven, Sam, Dim;
    Button btnInsert;

    int CategorieId;
    int HoraireId = newIdHoraire();


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
        AdrLieu = findViewById(R.id.AdrLieu);
        CpLieu = findViewById(R.id.CpLieu);
        TelLieu = findViewById(R.id.TelLieu);

        Lun = findViewById(R.id.LunSwitch);
        Lun.setChecked(true);
        Lu1 = findViewById(R.id.Lu1);
        Lu2 = findViewById(R.id.Lu2);

        Mar = findViewById(R.id.MarSwitch);
        Mar.setChecked(true);
        Ma1 = findViewById(R.id.Ma1);
        Ma2 = findViewById(R.id.Ma2);

        Mer = findViewById(R.id.MerSwitch);
        Mer.setChecked(true);
        Me1 = findViewById(R.id.Me1);
        Me2 = findViewById(R.id.Me2);

        Jeu = findViewById(R.id.JeuSwitch);
        Jeu.setChecked(true);
        Je1 = findViewById(R.id.Je1);
        Je2 = findViewById(R.id.Je2);

        Ven = findViewById(R.id.VenSwitch);
        Ven.setChecked(true);
        Ve1 = findViewById(R.id.Ve1);
        Ve2 = findViewById(R.id.Ve2);

        Sam = findViewById(R.id.SamSwitch);
        Sam.setChecked(true);
        Sa1 = findViewById(R.id.Sa1);
        Sa2 = findViewById(R.id.Sa2);

        Dim = findViewById(R.id.DimSwitch);
        Dim.setChecked(true);
        Di1 = findViewById(R.id.Di1);
        Di2 = findViewById(R.id.Di2);

        Lun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setVisible(Lun,Lu1,Lu2);
            }
        });

        Mar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setVisible(Mar,Ma1,Ma2);
            }
        });

        Mer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setVisible(Mer,Me1,Me2);
            }
        });

        Jeu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setVisible(Jeu,Je1,Je2);
            }
        });

        Ven.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setVisible(Ven,Ve1,Ve2);
            }
        });

        Sam.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setVisible(Sam,Sa1,Sa2);
            }
        });

        Dim.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setVisible(Dim,Di1,Di2);
            }
        });

        btnInsert = findViewById(R.id.btnAnnulerLieu);
        //btnInsert.setOnClickListener(this);
    }

    public String concat_horaire(Switch Day, EditText part_one, EditText part_two)
    {
        String res;
        String two = part_one.getText().toString();
        String tree = part_two.getText().toString();

        if(Day.isChecked())
        {
            res =  1 + "µ" + two + "µ" + tree;
        }
        else
        {
            res = 0 + "µ";
        }

        return (res);
    }

    public void setVisible(Switch s, EditText e1, EditText e2)
    {
        if(s.isChecked())
        {
            e1.setVisibility(View.VISIBLE);
            e2.setVisibility(View.VISIBLE);
        }else
        {
            e1.setVisibility(View.INVISIBLE);
            e2.setVisibility(View.INVISIBLE);
        }
    }

    public void execut_task_lieu()
    {
        Log.e("CCCCCCCCCCCCC", AdrLieu.getText().toString());
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
                //finish();
            }
        });
        taskInsert_lieu.execute("http://10.0.2.2:8888/StormFlash/AjoutLieu2.php");
    }

    public void execut_task_horaires()
    {
       
        HashMap<String,String> postData = new HashMap<>();
        postData.put("TxtIdHoraire", String.valueOf(HoraireId));
        postData.put("TxtLundi", concat_horaire(Lun, Lu1, Lu2));
        postData.put("TxtMardi", concat_horaire(Mar, Ma1, Ma2));
        postData.put("TxtMercredi", concat_horaire(Mer, Me1, Me2));
        postData.put("TxtJeudi", concat_horaire(Jeu, Je1, Je2));
        postData.put("TxtVendredi", concat_horaire(Ven, Ve1, Ve2));
        postData.put("TxtSamedi", concat_horaire(Sam, Sa1, Sa2));
        postData.put("TxtDimanche", concat_horaire(Dim, Di1, Di2));


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

    public int gest_error(Switch btn, EditText h1, EditText h2)
    {
        if (btn.isChecked() && !h1.getText().toString().equals("") && !h2.getText().toString().equals(""))
        {
            return (1);
        }
        else if (!btn.isChecked() && h1.getText().toString().equals("") && h2.getText().toString().equals(""))
        {
            return (1);
        }
        else
            return (0);

    }

    @Override
    public void onClick(View v)
    {
        if (!NomLieu.getText().toString().equals("") && !AdrLieu.getText().toString().equals("") && !CpLieu.getText().toString().equals("") && !TelLieu.getText().toString().equals(""))
        {
            if (gest_error(Lun, Lu1, Lu2) == 1 && gest_error(Mar, Ma1, Ma2) == 1 && gest_error(Mer, Me1, Me2) == 1 && gest_error(Jeu, Je1, Je2) == 1
                    && gest_error(Ven, Ve1, Ve2) == 1 && gest_error(Sam, Sa1, Sa2) == 1 && gest_error(Dim, Di1, Di2) == 1)
            {
                execut_task_lieu();
                execut_task_horaires();
                Toast toast = Toast.makeText(NouveauLieuActivity.this, "Le lieu a été ajouté", Toast.LENGTH_SHORT);
                toast.show();
            }
            else
            {
                Toast toast = Toast.makeText(NouveauLieuActivity.this, "Veuillez remplir tout les champs", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}