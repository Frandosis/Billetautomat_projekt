/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Billetautomat;

import Billetautomat.*;
import java.util.Scanner;

/**
 *
 * @author Valdemar Landberg
 * 
 */
public class NewClass {
    public static void main(String[] arg){
        Billetautomat automat = new Billetautomat();
        Billetvaelger b = new Billetvaelger(automat);
        Checkout c = new Checkout(b, automat);
        boolean run=true; 
        Scanner scan = new Scanner(System.in);
        boolean run=true; 
        
        boolean admin = false;
        boolean backflag = false;
        boolean isPassword = false;
        String passTry = "";
        int menuPick;
        while(run != false){
            
            System.out.println("Press 1: To go too the ticket selecter.\nPress 2: To pay and print your ticket.\nPress 3 to enter admin mode.\nPress 0 to end");
            menuPick= scan.nextInt();
            switch(menuPick) {
                case 1:
                    bv.billetVaelgerUI();
                    break; 
                case 2: 
                    c.checkoutUI();
                    break;
                case 3:
                        System.out.println("Input password:");
                        passTry = scan.next();
                       
                        if(passTry.equals(auto.getPassword())){
                            System.out.println("Correct password!");
                            isPassword = true;
                            System.out.println(isPassword);
                        } else{
                            System.out.println("Wrong password!");
                        }
                    if(isPassword == true){
                        System.out.println("Entering Admin mode:");
                    isPassword = false;
                    auto.setAdmin(true);
                    a.AdminUI();
                    auto.setAdmin(false);
                    }
                    break;
                case 4:
                   
                    break;
                case 0:
                run = false;
                break;
            }
        }
    }
}
