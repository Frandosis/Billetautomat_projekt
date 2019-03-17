/*
    List structure:
Index:  type:           price:
    0   Voksen Billet   Voksen
    1   Boerne Billet   Boerne
    2   Cykel Billet    Cykel
 */
package Billetautomat;

import java.util.Scanner;
import java.util.ArrayList;
import Billetautomat.*;

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

    public Billettype() {
        voksenpris = 24;
        boernepris = 12;
        cykelpris = 30;
        if (price.isEmpty()) {
            price.add(voksenpris);
            price.add(boernepris);
            price.add(cykelpris);
        }
        if (type.isEmpty()) {
            type.add("Voksen Billet");
            type.add("Boerne Billet");
            type.add("Cykel Billet");
        }
    }

    public int sizeOfZoneType() {
        return zone.sizeOfType();
    }

    public int sizeOfZonePrice() {
        return zone.sizeOfPrice();
    }

    public int sizeOfBilletType() {
        return type.size();
    }

    public int sizeOfBilletPrice() {
        return price.size();
    }

    public String getBilletType(int index) {
        return type.get(index);
    }

    public int getBilletPrice(int index) {
        return price.get(index);
    }

    public String getZoneType(int index) {
        return zone.getZoneType(index);

    }

    public int getZonePrice(int index) {
        return zone.getZonePrice(index);
    }

    public void setZonePrice() {
        zone.setZonePrice();
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
                        automat.setpriceLog("Voksen", voksenpris);
                        price.remove(0);
                        price.add(0, voksenpris);
                        break;
                    case 2:
                        System.out.println("Saet boerne billetpris:");
                        boernepris = s.nextInt();
                        automat.setpriceLog("Boerne", boernepris);
                        price.remove(1);
                        price.add(1, boernepris);
                        break;
                    case 3:
                        System.out.println("Saet cykel billetpris:");
                        cykelpris = s.nextInt();
                        automat.setpriceLog("cykel", cykelpris);
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
}
