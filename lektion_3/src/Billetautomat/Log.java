package Billetautomat;

import java.util.Date;

public class Log {

    private Date tidspunkt = new Date();
    private String handling = "";
    private String billettype = "";
    private String zoner = "";
    private int beløb = 0;
    private int ID = 0;

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

}
