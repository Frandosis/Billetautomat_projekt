/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Billetautomat;

import java.util.Scanner;
import java.util.ArrayList;

public class Billetvaelger {

    class Billet {

        String typename;
        String zonename;
        int price;

        public Billet(String type, String zone, int sumprice) {
            this.typename = type;
            this.zonename = zone;
            this.price = sumprice;
        }

    }

    Scanner s = new Scanner(System.in);
    Billettype type = new Billettype();
    ArrayList<Billet> liste = new ArrayList<Billet>();

    private int antalbillet;

    public Billetvaelger() {
        antalbillet = 0;
    }

    public void addBillet(int typeindex, int zoneindex) {

        String typename = type.getBilletType(typeindex);
        String zonename = type.getZoneType(zoneindex);
        int price = type.getBilletPrice(typeindex) + type.getZonePrice(zoneindex);

        Billet x = new Billet(typename, zonename, price);
        liste.add(x);
        antalbillet++;

    }

    public ArrayList<Billet> getTicketList() {
        return liste;
    }

    public void removeBillet(int typeindex, int zoneindex, int amount) {

        if (amount > 0) {
            String typename = type.getBilletType(typeindex);
            String zonename = type.getZoneType(zoneindex);
            int price = type.getBilletPrice(typeindex) + type.getZonePrice(zoneindex);

            Billet x = new Billet(typename, zonename, price);
            for (int i = 0; i < amount; i++) {
                liste.remove(x);

            }
        }

    }

    public void billetVaelgerUI() {

    }

    public void antalBilletter(int antal) {

    }

}
