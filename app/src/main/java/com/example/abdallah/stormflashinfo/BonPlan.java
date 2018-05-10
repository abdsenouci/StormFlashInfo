package com.example.abdallah.stormflashinfo;

public class BonPlan
{
    public int IdBonPlan;
    public String ObjBonPlan;
    public String DescBonPlan;
    public String DateDeb;
    public String DateFin;
    public int IdCat;
    public int IdLieu;

    public BonPlan(int id, String obj, String desc, String dateDeb, String dateFin, int idCat, int idLieu)
    {
        IdBonPlan = id;
        ObjBonPlan = obj;
        DescBonPlan = desc;
        DateDeb = dateDeb;
        DateFin = dateFin;
        IdCat = idCat;
        IdLieu = idLieu;
    }
}
