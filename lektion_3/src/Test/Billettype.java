/*
    List structure:
Index:  type:           price:
    0   Voksen Billet   Voksen
    1   Boerne Billet   Boerne
    2   Cykel Billet    Cykel
 */
package Test;

import Billetautomat.*;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Nikolaj Landberg
 */
public class Billettype {

    Billetautomat automat;
    ArrayList<String> type = new ArrayList<String>();
    ArrayList<Integer> price = new ArrayList<Integer>();
    Zonetyper zone = new Zonetyper();
    Scanner s = new Scanner(System.in);
    
    private int voksenpris;
    private int boernepris;
    private int cykelpris;
    private int zonetype;

    public Billettype() {
        voksenpris = 24;
        boernepris = 12;
        cykelpris = 30;
        if(price.isEmpty()){
            price.add(voksenpris);
            price.add(boernepris);
            price.add(cykelpris);
        }
        if (type.isEmpty()){
            type.add("Voksen Billet");
            type.add("Boerne Billet");
            type.add("Cykel Billet");
        }
    }

    public String getBilletType(int index){
        return type.get(index);
    }
    public int getBilletPrice(int index){
        return price.get(index);
    }

    public String getZoneType(int index) {
        return zone.getZoneType(index);

    }

    public int getZonePrice(int index) {
        return zone.getZonePrice(index);
    }

    public void setZoneType(int index) {
        zonetype = index;
    }

    public void setPrice() {
        if (automat.isAdmin()) {
            boolean isDone = false;
            int choice = -1;

            while (isDone != true) {
                System.out.println("Tryk 1 for at saette voksen billet pris\nTryk 2 for at sætte børne billet pris\ntryk 3 for at sættte cykel billetpris\ntryk 0 for at afslutte.");
                choice = s.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Saet voksen billetpris:");
                        voksenpris = s.nextInt();
                        price.remove(0);
                        price.add(0, voksenpris);
                        break;
                    case 2:
                        System.out.println("Saet boerne billetpris:");
                        boernepris = s.nextInt();
                        price.remove(1);
                        price.add(1, boernepris);
                        break;
                    case 3:
                        System.out.println("Saet cykel billetpris:");
                        cykelpris = s.nextInt();
                        price.remove(2);
                        price.add(2, cykelpris);
                        break;
                    case 0:
                        isDone = true;
                        break;
                }
            }

        } else {
            System.err.println("Kunne ikke saette pris - Kræver administrator tilladelse");
        }
    }

    public void udskrivBillet(int typeindex, int zoneindex) {
        System.out.println("##########B##T##########");
        System.out.println("# Borgen Trafikselskab #");
        System.out.println("#                      #");
        System.out.println("#    "+type.get(typeindex)+"     #");
        System.out.println("#    " + zone.getZoneType(zoneindex) + ": " + zone.getZonePrice(zoneindex) + "     #");
        System.out.println("#        " + (voksenpris + zone.getZonePrice(zoneindex)) + " kr.        #");
        System.out.println("#                      #");
        System.out.println("# Du har " + automat.getBalance() + " kr til gode #");
        System.out.println("##########B##T##########");
        System.out.println();
    }

    public void udskrivBoerneBillet(int typeindex, int zoneindex) {
        System.out.println("##########B##T##########");
        System.out.println("# Borgen Trafikselskab #");
        System.out.println("#                      #");
        System.out.println("#    Boerne Billet     #");
        System.out.println("#    " + zone.getZoneType(zonetype) + ": " + zone.getZonePrice(zonetype) + "     #");
        System.out.println("#        " + (boernepris + zone.getZonePrice(zonetype)) + " kr.        #");
        System.out.println("#                      #");
        System.out.println("# Du har " + automat.getBalance() + " kr til gode #");
        System.out.println("##########B##T##########");
        System.out.println();
    }

    public void udskrivCykelBillet(int typeindex, int zoneindex) {
        System.out.println("##########B##T##########");
        System.out.println("# Borgen Trafikselskab #");
        System.out.println("#                      #");
        System.out.println("#     Cykel Billet     #");
        System.out.println("#    " + zone.getZoneType(zonetype) + ": " + zone.getZonePrice(zonetype) + "     #");
        System.out.println("#        " + (cykelpris + zone.getZonePrice(zonetype)) + " kr.        #");
        System.out.println("#                      #");
        System.out.println("# Du har " + automat.getBalance() + " kr til gode #");
        System.out.println("##########B##T##########");
        System.out.println();
    }
}
