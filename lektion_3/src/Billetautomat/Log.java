package Billetautomat;

import java.util.Date;
import Billetautomat.*;

public class Log {

    private Date tidspunkt = new Date();
    private String handling = "";
    private String billettype = "";
    private String zoner = "";
    private int beløb = 0;
    private int ID = 0;
    
    public Date getTidspunkt(){
        return tidspunkt;
    }
    
    public String getHandling(){
        return handling;
    }
    
    public String getBillettype(){
        return billettype;
    }
    
    public String getZoner(){
        return zoner;
    }
    
    public int getBeløb(){
        return beløb;
    }
    
    public int getID(){
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

}
