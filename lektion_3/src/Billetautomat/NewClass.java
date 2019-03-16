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
        Billetvaelger b = new Billetvaelger();
        Checkout c = new Checkout(b);
        boolean run=true; 
        Scanner scan = new Scanner(System.in);
        boolean admin = false;
        int password = 1234;
        int passTry;
        int menuPick;
        while(run != false){
            
            System.out.println("Press 1: to crate a ticket.\nPress 2: to pay and print your ticket.\nPress 3 to enter admin mode.\nPress 4 for log.");
            menuPick= scan.nextInt();
            switch(menuPick) {
                case 1:
                    b.billetVaelgerUI();
                    break; 
                case 2: 
                    c.checkoutUI();
                    break;
                case 3:
                    if(admin == false){
                    System.out.println("enter the password.");
                    passTry = scan.nextInt();
                            if(passTry == password){
                             admin = true;
                             System.out.println("you are now logged in!");
                        }else{
                            System.out.println("wrong password!");
                            }
                    }else{
                    System.out.println("you are already logged in!");
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
