/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Billetautomat;

import java.util.Scanner;
import java.util.ArrayList;
import Billetautomat.*;

public class Checkout {

    Billettype biltype;
    boolean betalt = false;

    public boolean betalbillet(int sumprice, boolean betalt) {
        Scanner tastatur = new Scanner(System.in);
        int indsatPenge;

        while (betalt != true) {
            System.out.println("Du skal betale " + sumprice + " kr.");

            indsatPenge = tastatur.nextInt();
            tastatur.nextLine();
            
                while(indsatPenge<=0){
                    System.out.println("Du kan ikke indseatte negative penge! \n skriv et positiv tal.");
                    indsatPenge = tastatur.nextInt();
                    tastatur.nextLine();
                }
            
                sumprice = sumprice - indsatPenge;
            
                if (sumprice < 0) {
                    sumprice = -1 * sumprice;
                    System.out.println("Du har betalt for meget så du får nu dine " + sumprice + "kr tilbage.");
                    sumprice = 0;
                }
                
                if (sumprice == 0) {
                    betalt = true;
                }
        }
        return betalt;
    }

    public void udskrivBilletter(ArrayList<Billet> liste, int antalbillet) {

        for (int i = 0; i < antalbillet; i++) {

            Billet x = liste.get(i);
            biltype.udskrivBillet(x.getTypeindex(), x.getZoneindex());

        }
    }

}
