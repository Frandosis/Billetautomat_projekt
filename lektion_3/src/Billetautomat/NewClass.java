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
        
        int menuPick;
        while(run != false){
            
            System.out.println("Press 1: to crate a ticket\nPress 2: to pay and print your ticket");
            menuPick= scan.nextInt();
            switch(menuPick) {
                case 1:
                b.billetVaelgerUI();
                break; 
                case 2: 
                c.checkoutUI();
                break;
                case 0:
                run = false;
                break;
            }
        }
    }
}
