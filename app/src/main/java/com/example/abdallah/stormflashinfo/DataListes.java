package com.example.abdallah.stormflashinfo;

import java.util.ArrayList;

public class DataListes {
    public static ArrayList<BonPlan> BonPlans;
    public static ArrayList<Lieu> Lieux;
    public static ArrayList<Horaire> Horaires;

    public static ArrayList<BonPlan> setBonPlans(ArrayList<String> list) {
       for(String s:list)
       {
           BonPlans.add(new BonPlan());
       }
    }
}
