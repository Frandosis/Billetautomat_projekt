/*
 I denne underklasse har jeg valgt at dele alle de forskellige zone typer op, og sætte dem ind i et array.
 Så får de denne opstilling
Index:      zone:       price:
    0       zone 2      factor * 0;
    1       zone 3      factor * 1;
    2       zone 4      factor * 2;
    3       zone 5      factor * 3;
    4       zone 6      factor * 4;
    5       zone 7      factor * 5;
    6       zone 8      factor * 6;
    7       zone 9      factor * 7;
    8       zonealle    factor * 8;
 */
package Billetautomat;

import Billetautomat.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Zonetyper {

    ArrayList<Integer> price = new ArrayList<Integer>();
    ArrayList<String> type = new ArrayList<String>();
    Billetautomat automat;
    Scanner key = new Scanner(System.in);

    private int factor;

    public Zonetyper(Billetautomat b) {
        automat = b;
        factor = 5;
        if (price.isEmpty()) {
            for (int i = 0; i <= 8; i++) {
                price.add(factor * i);
            }
        }
        if (type.isEmpty()) {
            for (int j = 2; j <= 9; j++) {
                type.add(j + " zoner");
            }
            type.add("all zones");
        }
    }

    public int sizeOfPrice() {
        return price.size();
    }

    public int sizeOfType() {
        return type.size();
    }

    public void setZonePrice() {
        boolean admin = automat.isAdmin();
        if (admin == true) {

            System.out.println("Input a new price factor for zone tickets:");
            System.out.println("Eks. zone2 = factor * 0 og zone3 = factor * 1");
            int f = key.nextInt();
            if (f >= 0) {
                factor = f;
                automat.zonepriceLog(f);
            }
            while (price.isEmpty() != true) {
                price.clear();
            }

            for (int i = 0; i <= 8; i++) {
                price.add(factor * i);
            }
        }
    }

    public String getZoneType(int index) {
        return type.get(index);
    }

    public int getZonePrice(int index) {
        return price.get(index);

    }
}
