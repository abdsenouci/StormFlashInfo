package com.example.abdallah.stormflashinfo;

public class Horaire {
    public int IdHoraire;
    public String Lundi;
    public String Mardi;
    public String Mercredi;
    public String Jeudi;
    public String Vendredi;
    public String Samedi;
    public String Dimanche;

    public Horaire(int idHoraire, String lundi, String mardi, String mercredi, String jeudi, String vendredi, String samedi, String dimanche) {
        IdHoraire = idHoraire;
        Lundi = lundi;
        Mardi = mardi;
        Mercredi = mercredi;
        Jeudi = jeudi;
        Vendredi = vendredi;
        Samedi = samedi;
        Dimanche = dimanche;
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

    public int[][] parseJours()
    {

        int[][] res = {{0,1,2,3,4,5,6}{this.Lundi, this.Mardi, this.Mercredi, this.}};
    }

}
