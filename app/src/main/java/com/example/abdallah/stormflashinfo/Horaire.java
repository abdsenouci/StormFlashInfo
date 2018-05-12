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
    public int[][] planning;

    public Horaire(int idHoraire, String lundi, String mardi, String mercredi, String jeudi, String vendredi, String samedi, String dimanche) {
        IdHoraire = idHoraire;
        Lundi = lundi;
        Mardi = mardi;
        Mercredi = mercredi;
        Jeudi = jeudi;
        Vendredi = vendredi;
        Samedi = samedi;
        Dimanche = dimanche;
        planning = new int[7][3];
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

    public void parseAll()
    {
        this.setJour(this.Lundi,0);
        this.setJour(this.Mardi, 1);
        this.setJour(this.Mercredi, 2);
        this.setJour(this.Jeudi, 3);
        this.setJour(this.Vendredi, 4);
        this.setJour(this.Samedi, 5);
        this.setJour(this.Dimanche, 6);
    }

    private void setJour(String jour, int id)
    {
        String[] parsed = jour.split(".");
        planning[id][0]= Integer.valueOf(parsed[0]);
        planning[id][1]= Integer.valueOf(parsed[1]);
        planning[id][2]= Integer.valueOf(parsed[2]);
    }

}
