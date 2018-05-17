package com.example.abdallah.stormflashinfo;

import android.content.Intent;
import android.widget.TextView;

import java.util.ArrayList;

public class Horaire {
    public int IdHoraire;
    String lundi, mardi, mercredi, jeudi, vendredi, samedi, dimanche;
    public Horaire(int idHoraire, String lundi, String mardi, String mercredi, String jeudi, String vendredi, String samedi, String dimanche) {
        IdHoraire = idHoraire;
        this.lundi=lundi;
        this.mardi=mardi;
        this.mercredi=mercredi;
        this.jeudi=jeudi;
        this.vendredi=vendredi;
        this.samedi=samedi;
        this.dimanche=dimanche;
    }

    public static int getPositionHoraire(int idHoraire)
    {
        int position = -1;
        for(int i=0; i<DataListes.Horaires.size(); i++)
        {
            if (DataListes.Horaires.get(i).IdHoraire == idHoraire)
            {
                position = i;
            }
        }
        return position;
    }

    private int[] setJour(String jour)
    {
        int[] res = new int[3];
        if(jour.substring(0,1).equals("1"))
        {
            String[] parsed = jour.split("µ");
            res[0]= Integer.valueOf(parsed[0]);
            res[1]= Integer.valueOf(parsed[1]);
            res[2]= Integer.valueOf(parsed[2]);
        }else
        {
            res[0]= Integer.valueOf(jour.substring(0,1));
        }
        return res;
    }

    public void setTextView(TextView tv, String jour)
    {
        int[] res = setJour(jour);
        String reponse;
        if (res[0]==1)
        {
            reponse = "de " + res[1] + "h à " + res[2] + "h";
        }else
        {
            reponse= "Fermé";
        }
        tv.setText(reponse);
    }
}
