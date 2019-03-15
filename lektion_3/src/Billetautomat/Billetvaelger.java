/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Billetautomat;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import Billetautomat.*;

public class Billetvaelger {

    Scanner s = new Scanner(System.in);
    Billettype type = new Billettype();
    ArrayList<Billet> liste = new ArrayList<Billet>();

    private int antalbillet;

    public void sortList(ArrayList<Billet> l) {
        Collections.sort(l, Billet.BilTypeAndZoneComparator);

    }


    public void sortBilletPrice(ArrayList<Billet> l) {
        Collections.sort(l, Billet.BilPriceComparator);
    }

    public int getAntalbillet() {
        return antalbillet;
    }

    public Billetvaelger() {
        antalbillet = 0;
    }

    public void addBillet(int typeindex, int zoneindex) {

        String typename = type.getBilletType(typeindex);
        String zonename = type.getZoneType(zoneindex);
        int price = type.getBilletPrice(typeindex) + type.getZonePrice(zoneindex);

        Billet x = new Billet(typename, zonename, typeindex, zoneindex, price);
        liste.add(x);
        antalbillet++;
        sortList(liste);

    }

    public ArrayList<Billet> getTicketList() {
        return liste;
    }

    public void removeBillet(int typeindex, int zoneindex, int amount) {
        try {
            if (liste.isEmpty()) {
                System.out.println("Indkøbskurven er tom");
            } else {

                if (amount > 0) {
                    String typename = type.getBilletType(typeindex);
                    String zonename = type.getZoneType(zoneindex);
                    int price = type.getBilletPrice(typeindex) + type.getZonePrice(zoneindex);

                    Billet x = new Billet(typename, zonename, typeindex, zoneindex, price);
                    int i = 0;
                    while (liste.contains(x) && i < amount) {
                        liste.remove(x);
                        antalbillet--;

                        i++;
                    }
                }
            }

        } catch (Exception u) {
            u.printStackTrace();
        }
    }

    public void printBilletList(ArrayList<Billet> l) {
        if (l.isEmpty()) {
            System.out.println("Indkøbskurven er tom");
        } else {

            for (Billet bl : l) {

                System.out.println(bl.toString());

            }
        }

    }

    public void billetVaelgerUI() {
        boolean isDone = false;
        int choice = -1;
        while (isDone != true) {
            System.out.println("Choose a feature\npress 1 for addding tickets\npress 2 for removing tickets\npress 3 for printing list\npress 0 to end.");
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Choose a type of ticket - Voksen - Boerne - Cykel");
                    int typeindex = s.nextInt();
                    System.out.println("choose amount of zones - 2 zones up to all zones");
                    int zoneindex = s.nextInt();
                    System.out.println("Choose an amount of tickets");
                    int amount = -1;
                    while (amount < 0) {
                        amount = s.nextInt();
                        if (amount < 0) {
                            System.out.println("Amount can't be less than zero");
                        }
                    }

                    for (int i = 0; i < amount; i++) {
                        addBillet(typeindex, zoneindex);
                    }
                    break;

                case 2:
                    System.out.println("Choose type of ticket to be removed");
                    typeindex = s.nextInt();
                    System.out.println("Choose zone type to be removed");
                    zoneindex = s.nextInt();
                    System.out.println("Choose an amount of tickets to be removed");
                    amount = s.nextInt();

                    removeBillet(typeindex, zoneindex, amount);

                    break;

                case 3:
                    printBilletList(liste);
                    
                    break;

                case 0:
                    isDone = true;
                    break;
            }
        }
    }

}
