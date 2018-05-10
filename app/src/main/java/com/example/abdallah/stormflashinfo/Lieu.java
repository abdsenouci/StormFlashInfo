package com.example.abdallah.stormflashinfo;

public class Lieu
{
    public int IdLieu;
    public String NomLieu;
    public String AdresseLieu;
    public int Cp;
    public int Tel;
    public int IdCat;
    public int IdHor;

    public Lieu(int id, String nom, String adresse, int cp, int tel, int idCat, int idHor)
    {
        IdLieu = id;
        NomLieu = nom;
        AdresseLieu = adresse;
        Cp = cp;
        Tel = tel;
        IdCat = idCat;
        IdHor = idHor;
    }
}
