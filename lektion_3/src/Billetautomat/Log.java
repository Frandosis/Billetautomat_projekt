package Billetautomat;

import java.util.Date;

public class Log {

    private Date tidspunkt = new Date();
    private String handling = "";
    private String billettype = "";
    private String zoner = "";
    private int beløb = 0;
    private int ID = 0;
    private int antal = 0;

    public Date getTidspunkt() {
        return tidspunkt;
    }

    public String getHandling() {
        return handling;
    }

    public String getBillettype() {
        return billettype;
    }

    public String getZoner() {
        return zoner;
    }//test^2

    public int getBeløb() {
        return beløb;
    }//test

    public int getID() {
        return ID;
    }

    Log(String handling, String billettype, String zoner, int beløb, int ID) {
        this.handling = handling;
        this.zoner = zoner;
        this.billettype = billettype;
        this.beløb = beløb;
        this.ID = ID;

    }

    @Override
    public String toString() {
        if (ID == 1) {
            return "hej";
        }
        return "Log{" + "tidspunkt=" + tidspunkt + ", handling=" + handling + ", billettype=" + billettype + ", bel\u00f8b=" + beløb + ", ID=" + ID + '}';
    }

    Log(String handling, int beløb, int ID) {
        this.handling = handling;
        this.beløb = beløb;
        this.ID = ID;
    }

    Log(String handling, String billettype, String zoner, int antal, int beløb, int ID) {
        this.handling = handling;
        this.billettype = billettype;
        this.zoner = zoner;
        this.antal = antal;
        this.beløb = beløb;
        this.ID = ID;
    }

}
