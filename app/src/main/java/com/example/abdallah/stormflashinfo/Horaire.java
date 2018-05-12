package com.example.abdallah.stormflashinfo;

import android.widget.TextView;

public class Horaire {
    public int IdHoraire;
    public int[][] planning;

    public Horaire(int idHoraire, String lundi, String mardi, String mercredi, String jeudi, String vendredi, String samedi, String dimanche) {
        IdHoraire = idHoraire;
        planning = new int[7][3];
        this.setJour(lundi,0);
        this.setJour(mardi, 1);
        this.setJour(mercredi, 2);
        this.setJour(jeudi, 3);
        this.setJour(vendredi, 4);
        this.setJour(samedi, 5);
        this.setJour(dimanche, 6);
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

    private void setJour(String jour, int index)
    {
        String[] parsed = jour.split(".");
        planning[index][0]= Integer.valueOf(parsed[0]);
        planning[index][1]= Integer.valueOf(parsed[1]);
        planning[index][2]= Integer.valueOf(parsed[2]);
    }

    public void setTextView(TextView tv, int index)
    {
        if (this.planning[index][0]==1)
        {
            String horaires = "de " + planning[index][1] + "h à " + planning[index][2] + "h";
            tv.setText(horaires);
        }else
        {
            tv.setText("Fermé");
        }
    }
}
