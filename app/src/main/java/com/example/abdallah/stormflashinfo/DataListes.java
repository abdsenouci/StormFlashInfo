package com.example.abdallah.stormflashinfo;

import java.util.ArrayList;

public class DataListes {
    public static ArrayList<BonPlan> BonPlans;
    public static ArrayList<Lieu> Lieux;
    public static ArrayList<Horaire> Horaires;

    public static ArrayList<BonPlan> setBonPlans(ArrayList<String> list) {
        String[] parsed = new String[7];
       for(String s:list)
       {
           parsed=s.split("_-_");
           BonPlans.add(new BonPlan(Integer.valueOf(parsed[0]), parsed[1], parsed[2], parsed[3], parsed[4], Integer.valueOf(parsed[5]), Integer.valueOf(parsed[6])));
       }
    }






}
