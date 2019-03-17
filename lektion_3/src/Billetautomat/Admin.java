/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Billetautomat;

import Billetautomat.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Admin {

    boolean runAd;
    int choice;
    Billetautomat automat;
    Billetvaelger bilvalg;
    Checkout check;
    Scanner adminscan = new Scanner(System.in);

    public Admin(Billetvaelger bv, Billetautomat a, Checkout c) {
        bilvalg = bv;
        automat = a;
        check = c;
    }

    public void AdminUI() {
        runAd = false;
        while (runAd != true) {
            System.out.println("press 1 to set price\npress 2 to set zone price\npress 3 to print transaktion logbook\npress 4 to change password\npress 5 to print test tickets\npress 0 to end Admin");
            choice = adminscan.nextInt();

            switch (choice) {
                case 1:
                    setPrice();
                    break;
                case 2:
                    setZonePrice();
                    break;
                case 3:
                    automat.printTransaktion();
                    break;
                case 4:
                    automat.changePassword();
                    break;
                case 5:
                    printTestBillet();
                    break;
                case 0:
                    runAd = true;
                    break;
            }
        }
    }

    public void setPrice() {
        
        bilvalg.setPrice();

    }

    public void setZonePrice() {

        bilvalg.setZonePrice();

    }
    public void printTestBillet(){
        ArrayList<Billet> l = bilvalg.getAllTypeList();
        for(int i = 0; i < l.size(); i++){
            check.udskrivTestBillet(l.get(i));
        }
        
    }
}
