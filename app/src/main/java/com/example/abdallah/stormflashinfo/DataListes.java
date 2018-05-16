package com.example.abdallah.stormflashinfo;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DataListes {
    public static ArrayList<Lieu> Lieux;
    public static ArrayList<BonPlan> BonPlans;
    public static ArrayList<Horaire> Horaires;
    public static String[] Categories = {"Bar", "Restaurant", "Culture", "Sport", "Concert","NightClub", "Cinéma"};


    public static void setLieux(ArrayList<String> list)
    {
        String[] parsed = new String[7];
        for(String s:list)
        {
            parsed=s.split("_-_");
            Lieux.add(new Lieu(Integer.valueOf(parsed[0]), parsed[1], parsed[2], Integer.valueOf(parsed[3]), Integer.valueOf(parsed[4]), Integer.valueOf(parsed[5]), Integer.valueOf(parsed[6])));
        }
    }

    public static void setBonPlans(ArrayList<String> list)
    {
        String[] parsed = new String[7];
        for(String s:list)
        {
            parsed=s.split("_-_");
            for(Lieu l:Lieux)
            {
                if(Integer.valueOf(parsed[6]) == l.IdLieu)
                {
                    BonPlans.add(new BonPlan(Integer.valueOf(parsed[0]), parsed[1], parsed[2], parsed[3], parsed[4], Integer.valueOf(parsed[5]), Integer.valueOf(parsed[6]), l.NomLieu));
                }
            }
        }
    }

    public static void setHoraires(ArrayList<String> list)
    {
        String[] parsed = new String[7];
        for(String s:list)
        {
            parsed=s.split("_-_");
            Horaires.add(new Horaire(Integer.valueOf(Integer.valueOf(parsed[0])), parsed[1], parsed[2], parsed[3], parsed[4], parsed[5], parsed[6], parsed[7]));
        }
    }

    public static int newIdHoraire()
    {
        int res = 0;
        for(Horaire h : Horaires)
        {
            if(h.IdHoraire>res)
            {
                res=h.IdHoraire;
            }
        }
        res++;
        return res;
    }
}
