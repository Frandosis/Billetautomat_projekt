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
    
    Billetautomat automat;
    Billetvaelger bilvalg;
    boolean betalt = false;
    Scanner tastatur = new Scanner(System.in);
    public Checkout(Billetvaelger b, Billetautomat b1){
        bilvalg = b;
        automat = b1;
    }
    public int sumList() {
       try{
        int sum = 0;

        ArrayList<Billet> list = bilvalg.getTicketList();
        if (list.isEmpty()){
            System.out.println("Checkout bag is empty");
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            Billet b = list.get(i);
            sum += b.getPrice();
            System.out.println(sum);
        }
        return sum;
       } catch (Exception e){
           e.printStackTrace();
       }
       return -1;
    }

    public void betalBillet() {
        int sum = 0;
        int indsatPenge;

        sum = sumList();
        
        
        while (betalt != true) {
            
            if(sum == -1){
            sum = 0;
            }else{
                System.out.println("Du skal betale " + sum + " kr.");
            indsatPenge = tastatur.nextInt();
            tastatur.nextLine();
            automat.indkastLog(indsatPenge);

            while (indsatPenge < 0) {
                System.out.println("Du kan ikke indseatte negative penge! \nskriv et positiv tal.");
                indsatPenge = tastatur.nextInt();
                tastatur.nextLine();
                automat.indkastLog(indsatPenge);
                
            }

            sum = sum - indsatPenge;

            if (sum < 0) {
                sum = -1 * sum;
                System.out.println("Du har betalt for meget så du får nu dine " + sum + "kr tilbage.");
                automat.udbetalingLog(sum);
                sum = 0;
            }
            }
            if (sum == 0) {
                betalt = true;
            }
            
        }

    }

    public void udskrivBilletter() {
        if(betalt == true){
        ArrayList<Billet> billetlist = bilvalg.getTicketList();

        for (int i = 0; i < billetlist.size(); i++) {

            Billet x = billetlist.get(i);
            udskrivBillet(x);
            automat.udskrivningLog(x.getTypename(), x.getZonename(), x.getPrice());
        }
        bilvalg.clearList();
        betalt = false;
        return;
        } else {
            System.out.println("You haven't payed enough!");
            betalBillet();
            udskrivBilletter();
            return;
        }
            }

    public void checkoutUI() {
        try {
            boolean done = false;
            int choice;
            ArrayList<Billet> list = bilvalg.getTicketList();
            while (done != true) {
                System.out.println("Choose a feature\npress 1 to pay for tickets\npress 2 to print list of tickets\npress 3 to make changes in the list\npress 4 to clear list\npress 0 to end.");
                choice = tastatur.nextInt();
                switch (choice) {
                    case 1:
                        betalBillet();
                        udskrivBilletter();
                        break;
                    case 2:
                        bilvalg.printBilletList(list);
                        break;
                    case 3:
                        bilvalg.billetVaelgerUI();
                        break;
                    case 4:
                        bilvalg.clearList();
                        break;

                    case 0:
                        done = true;
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public void udskrivBillet(Billet x) {
        System.out.println("##########B##T##########");
        System.out.println("# Borgen Trafikselskab #");
        System.out.println("#                      #");
        System.out.printf("#%17s     #\n",x.getTypename());
        System.out.printf("#%14s        #\n",x.getZonename());
        System.out.println("#        " + x.getPrice() + " kr.        #");
        System.out.println("#                      #");
        //ystem.out.println("# Du har " + automat.getBalance() + " kr til gode #");
        System.out.println("##########B##T##########");
        System.out.println();
    }
        public void udskrivTestBillet(Billet x) {
        System.out.println("##########B##T##########");
        System.out.println("# Borgen Trafikselskab #");
        System.out.println("#                      #");
        System.out.println("#    "+x.getTypename()+"     #");
        System.out.println("#    " + x.getZonename() +"     #");
        System.out.println("#        " + x.getPrice() + " kr.        #");
        System.out.println("#                      #");
        //ystem.out.println("# Du har " + automat.getBalance() + " kr til gode #");
        System.out.println("##########B##T##########");
        System.out.println();
    }
}
