package com.example.abdallah.stormflashinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class NouveauLieuActivity extends AppCompatActivity implements View.OnClickListener
{
    final String LOG = " NouveauLieuActivity";

    EditText NomLieu, AdrLieu, CpLieu, TelLieu,
            Lu1, Lu2, Ma1,Ma2, Me1, Me2, Je1, Je2, Ve1, Ve2, Sa1,Sa2, Di1, Di2;
    Switch Lun, Mar, Mer, Jeu, Ven, Sam;
    Button btnInsert;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_lieu);
    }
}
