/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Billetautomat;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
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
        
        public String getTypename(){
            return this.typename;
        }
        
        public String getZonename(){
            return this.zonename;
        }
        
        public int getPrice(){
            return this.price;
        }
        public Comparator <Billet> BilTypeComparator = new Comparator<Billet>(){
            
        }
    }

    Scanner s = new Scanner(System.in);
    Billettype type = new Billettype();
    ArrayList<Billet> liste = new ArrayList<Billet>();

    private int antalbillet;
    
    public int getAntalbillet(){
        return antalbillet;
    }
    
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
        try {
            if (liste.isEmpty()) {
                System.out.println("Indkøbskurven er tom");
            } else {

                if (amount > 0) {
                    String typename = type.getBilletType(typeindex);
                    String zonename = type.getZoneType(zoneindex);
                    int price = type.getBilletPrice(typeindex) + type.getZonePrice(zoneindex);

                    Billet x = new Billet(typename, zonename, price);
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

    public void printBilletList() {
        if (liste.isEmpty()) {
            System.out.println("Indkøbskurven er tom");
        } else {

            for (int i = 0; i < antalbillet; i++) {

                Billet x = liste.get(i);

                if (x.typename == "Voksen Billet") {
                    
                    
                }
            }
        }

    }

    public void billetVaelgerUI() {

    }

}
