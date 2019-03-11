/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Billetautomat;

import java.util.Scanner;

/**
 *
 * @author Nikolaj Landberg
 */
public class Billettype {

    Billetautomat automat;
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
                        break;
                    case 2:
                        System.out.println("Saet boerne billetpris:");
                        boernepris = s.nextInt();
                        break;
                    case 3:
                        System.out.println("Saet cykel billetpris:");
                        cykelpris = s.nextInt();
                        break;
                    case 0:
                        isDone = true;
                        break;
                }
            }

        } else {
            System.err.println("Kunne ikke saette pris - forkert kode");
        }
    }

    public void udskrivVoksenBillet() {
        System.out.println("##########B##T##########");
        System.out.println("# Borgen Trafikselskab #");
        System.out.println("#                      #");
        System.out.println("#    Voksen Billet     #");
        System.out.println("#    " + zone.getZoneType(zonetype) + ": " + zone.getZonePrice(zonetype) + "     #");
        System.out.println("#        " + (voksenpris + zone.getZonePrice(zonetype)) + " kr.        #");
        System.out.println("#                      #");
        System.out.println("# Du har " + automat.getBalance() + " kr til gode #");
        System.out.println("##########B##T##########");
        System.out.println();
    }

    public void udskrivBoerneBillet() {
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

    public void udskrivCykelBillet() {
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
