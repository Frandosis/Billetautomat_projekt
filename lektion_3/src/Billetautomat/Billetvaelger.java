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


    public void sortList(ArrayList<Billet> l) {
        Collections.sort(l, Billet.BilTypeAndZoneComparator);

    }

    public void sortBilletPrice(ArrayList<Billet> l) {
        Collections.sort(l, Billet.BilPriceComparator);
    }


    public Billetvaelger() {
    }

    public void addBillet(int typeindex, int zoneindex) {
        // check if index are valid
        if(typeindex < 0 || zoneindex < 0 ||
                typeindex > type.sizeOfBilletType() || zoneindex > type.sizeOfZoneType()){
            System.out.println("Billettype eksisterer ikke");
            return;
        }
        
        String typename = type.getBilletType(typeindex);
        String zonename = type.getZoneType(zoneindex);
        int price = type.getBilletPrice(typeindex) + type.getZonePrice(zoneindex);

        Billet x = new Billet(typename, zonename, typeindex, zoneindex, price);
        liste.add(x);
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
                    int deletions = 0;
                    System.out.println(liste.size());
                    for (int i = 0; i < liste.size(); i++) {
                        Billet bl = liste.get(i);
                        
                        if (bl.getTypeindex() == typeindex && bl.getZoneindex() == zoneindex && deletions < amount) {
                            System.out.println("inside");
                            liste.remove(i);
                            i--;
                            deletions++;
                        }
             
                    }
                    System.out.println(deletions);
               }
                System.out.println("outside");
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

                System.out.println(bl);

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
