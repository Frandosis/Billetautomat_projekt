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

/**
 *
 * @author Nikolaj Landberg
 */
public class Billettype {

    Billetautomat automat;
    ArrayList<String> type = new ArrayList<String>();
    ArrayList<Integer> price = new ArrayList<Integer>();
    Zonetyper zone;
    Scanner s = new Scanner(System.in);

    private int voksenpris;
    private int boernepris;
    private int cykelpris;

    public Billettype(Billetautomat b) {
        automat = b;
        zone = new Zonetyper (automat);
        voksenpris = 24;
        boernepris = 12;
        cykelpris = 30;
        if (price.isEmpty()) {
            price.add(voksenpris);
            price.add(boernepris);
            price.add(cykelpris);
        }

        if (type.isEmpty()) {
            type.add("Adult Ticket");
            type.add("Child Ticket");
            type.add("Cykel Ticket");

            if (type.isEmpty()) {
                type.add("Voksen Billet");
                type.add("Boerne Billet");
                type.add("Cykel Billet");

            }
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
        boolean admin = automat.isAdmin();
        System.out.println(automat.isAdmin());
        if (admin == true) {
            boolean isDone = false;
            int choice = -1;

            while (isDone != true) {
                System.out.println("Press 1 to set the adult ticket price\nPress 2 to set the child ticket price\nPress 3 to set the bicycle ticket price\nPress 0 when done.");
                choice = s.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Set adult ticket price:");
                        voksenpris = s.nextInt();
                        automat.setpriceLog("Voksen", voksenpris);
                        price.remove(0);
                        price.add(0, voksenpris);
                        break;
                    case 2:
                        System.out.println("Set child ticket price:");
                        boernepris = s.nextInt();
                        automat.setpriceLog("Boerne", boernepris);
                        price.remove(1);
                        price.add(1, boernepris);
                        break;
                    case 3:
                        System.out.println("Set bicycle ticket price:");
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
            System.err.println("Couldn't set price - missing admin approval");
        }
    }
}
