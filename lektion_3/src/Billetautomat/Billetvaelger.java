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
import javax.swing.*;

public class Billetvaelger {

    Billetautomat automat;
    Scanner s = new Scanner(System.in);
    Billettype type;
    ArrayList<Billet> liste = new ArrayList<Billet>();

    public void sortList(ArrayList<Billet> l) {
        Collections.sort(l, Billet.BilTypeAndZoneComparator);

    }

    public Billetvaelger(Billetautomat b) {
        automat = b;
        type = new Billettype(automat);
    }

    public void addBillet(ArrayList<Billet> l, int typeindex, int zoneindex, int amount) {
        // check if index are valid
        if (typeindex < 0 || zoneindex < 0
                || typeindex >= type.sizeOfBilletType() || zoneindex >= type.sizeOfZoneType()) {
            System.out.println("Ticket type doesn't exist.");
            return;
        }
        if (amount < 0) {
            System.out.println("There can't be an negative amount");
            return;
        }
        String typename = type.getBilletType(typeindex);
        String zonename = type.getZoneType(zoneindex);
        int price = type.getBilletPrice(typeindex) + type.getZonePrice(zoneindex);

        for (int i = 0; i < amount; i++) {
            Billet x = new Billet(typename, zonename, typeindex, zoneindex, price);
            l.add(x);
        }

        sortList(l);
    }

    public ArrayList<Billet> getTicketList() {
        return liste;
    }

    public void setPrice() {

        type.setPrice();
    }

    public void setZonePrice() {

        type.setZonePrice();
    }

    public void removeBillet(int typeindex, int zoneindex, int amount) {
        if (liste.isEmpty()) {
            System.out.println("Checkout bag is empty");
            return;
        } else {
            if (typeindex < 0 || zoneindex < 0
                    || typeindex >= type.sizeOfBilletType() || zoneindex >= type.sizeOfZoneType()) {
                System.out.println("Ticket type doesn't exist");
                return;
            }
            if (amount > 0) {
                int deletions = 0;
                for (int i = 0; i < liste.size(); i++) {
                    Billet bl = liste.get(i);

                    if (bl.getTypeindex() == typeindex && bl.getZoneindex() == zoneindex && deletions < amount) {
                        liste.remove(i);
                        i--;
                        deletions++;
                    }

                }
            }
        }
    }

    public boolean billetEquals(Billet b1, Billet b2) {
        if (b1.getTypeindex() == b2.getTypeindex() && b1.getZoneindex() == b2.getZoneindex()) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Billet> getAllTypeList() {
        ArrayList<Billet> pricelist = new ArrayList<Billet>();

        for (int i = 0; i < type.sizeOfBilletType(); i++) {
            for (int j = 0; j < type.sizeOfZoneType(); j++) {
                addBillet(pricelist, i, j, 1);
            }
        }
        return pricelist;
    }

    public String printPriceList() {
        String msg = printBilletList(getAllTypeList());
        return msg;
    }

    public String printBilletList(ArrayList<Billet> l) {
        String msg;
        if (l.isEmpty()) {
            msg = "Checkout bag is empty";
            System.out.println(msg);
            return msg;
        } else {

            if (l.size() == 1) {
                int amount = l.size();
                Billet x = l.get(0);
                System.out.println("Ticket type:    Zone amount:     Price:     Amount billetter:");
                msg = "Ticket type:    Zone amount:     Price:     Amount billetter:\n";
                msg += String.format("%13s%15s%11d%22d%n", x.getTypename(), x.getZonename(), x.getPrice(), amount);
                System.out.printf("%13s%15s%11d%22d%n", x.getTypename(), x.getZonename(), x.getPrice(), amount);
                return msg;
            }

            int sum = 0;
            int amount = 0;
            System.out.println("Ticket type:    Zone amount:     Price:     Amount billetter:");
            msg = "Ticket type:    Zone amount:     Price:     Amount billetter:\n";

            for (int i = 1; i < l.size(); i++) {
                Billet prev = l.get(i - 1);
                Billet cur = l.get(i);

                if (billetEquals(prev, cur) != true) {
                    amount++;
                    System.out.printf("%13s%15s%11d%22d%n", prev.getTypename(), prev.getZonename(), prev.getPrice(), amount);
                    msg += String.format("%13s%15s%11d%22d%n", prev.getTypename(), prev.getZonename(), prev.getPrice(), amount);
                    sum += prev.getPrice() * amount;
                    amount = 0;
                } else {
                    amount++;
                }
                if (i == l.size() - 1) {
                    amount++;
                    sum += cur.getPrice() * amount;
                    System.out.printf("%13s%15s%11d%22d%n", cur.getTypename(), cur.getZonename(), cur.getPrice(), amount);
                    msg += String.format("%13s%15s%11d%22d%n", cur.getTypename(), cur.getZonename(), cur.getPrice(), amount);
                }
            }
            System.out.println("\nTotal sum price = " + sum);
            msg += "\nTotal sum price = " + sum;
            return msg;
        }

    }

    public int keyboardIntepreter(char key, boolean isType) {
        if (isType == true) {
            if (key == '1') {
                return 0;
            }
            if (key == '2') {
                return 1;
            }
            if (key == '3') {
                return 2;
            }
        } else {
            if (key == '2') {
                return 0;
            }
            if (key == '3') {
                return 1;
            }
            if (key == '4') {
                return 2;
            }
            if (key == '5') {
                return 3;
            }
            if (key == '6') {
                return 4;
            }
            if (key == '7') {
                return 5;
            }
            if (key == '8') {
                return 6;
            }
            if (key == '9') {
                return 7;
            }
            if (key == 'a' || key == 'A') {
                return 8;
            }
        }
        return -1;
    }

    public void clearList() {
        liste.clear();
    }

   /* public void billetVaelgerGUI(Billetvaelger b) {
        JFrame frame = new JFrame("Billetvaelger GUI");
        BilletvaelgerPanel panel = new BilletvaelgerPanel(b, frame);
        frame.add(panel);                          // vis panelet i vinduet

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // reagér på luk
        frame.pack();                       // sæt vinduets størrelse
        frame.setVisible(true);                      // åbn vinduet

    }*/

    public void billetVaelgerUI() {
        boolean isDone = false;
        int choice = -1;
        while (isDone != true) {
            System.out.println("Choose a feature\npress 1 for addding tickets\npress 2 for removing tickets\npress 3 for printing list\npress 4 to clear checkout list\npress 5 to print a list of prices\npress 0 to end.");
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Choose a type of ticket\nAdult (press 1) - Child (press 2) - Bicycle (press 3)");

                    int typeindex = keyboardIntepreter(s.next().charAt(0), true);
                    System.out.println("Choose amount of zones\n2 zones (press 2) up to 9 zones (press 9) or all zones (press a)");

                    int zoneindex = keyboardIntepreter(s.next().charAt(0), false);
                    System.out.println("Choose an amount of tickets");
                    int amount = -1;
                    while (amount < 0) {
                        amount = s.nextInt();
                        if (amount < 0) {
                            System.out.println("Amount can't be less than zero");
                        }
                    }

                    addBillet(liste, typeindex, zoneindex, amount);

                    break;

                case 2:
                    System.out.println("Choose a type of ticket\nAdult (press 1) - Child (press 2) - Bicycle (press 3)");
                    typeindex = keyboardIntepreter(s.next().charAt(0), true);
                    System.out.println("Choose amount of zones\n2 zones (press 2) up to 9 zones (press 9) or all zones (press a)");
                    zoneindex = keyboardIntepreter(s.next().charAt(0), false);
                    System.out.println("Choose an amount of tickets to be removed");
                    amount = -1;
                    while (amount < 0) {
                        amount = s.nextInt();
                        if (amount < 0) {
                            System.out.println("Amount can't be less than zero");
                        }
                    }

                    removeBillet(typeindex, zoneindex, amount);

                    break;

                case 3:
                    printBilletList(liste);

                    break;

                case 4:
                    clearList();
                    break;

                case 5:
                    printPriceList();
                    break;

                case 0:
                    isDone = true;
                    break;
            }
        }
    }

}
