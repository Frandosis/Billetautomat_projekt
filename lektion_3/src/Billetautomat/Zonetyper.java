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
public class Zonetyper {

    Billetautomat automat = new Billetautomat();
    Scanner key = new Scanner(System.in);

    private int factor = 5;
    private int zone2;
    private int zone3;
    private int zone4;
    private int zone5;
    private int zone6;
    private int zone7;
    private int zone8;
    private int zone9;
    private int zonealle;

    public Zonetyper() {
        zone2 = factor * 0;
        zone3 = factor * 1;
        zone4 = factor * 2;
        zone5 = factor * 3;
        zone6 = factor * 4;
        zone7 = factor * 5;
        zone8 = factor * 6;
        zone9 = factor * 7;
        zonealle = factor * 8;
    }

    public void setZonePrice(String montoerkode) {
        if (montoerkode.equals(automat.getPassword())) {

            System.out.println("Indsæt en ny faktor for zonepriserne.");
            System.out.println("Eks. zone2 = factor * 0 og zone3 = factor * 1");
            int f = key.nextInt();
            if (f >= 0) {
                factor = f;
            }

        }
    }
}
