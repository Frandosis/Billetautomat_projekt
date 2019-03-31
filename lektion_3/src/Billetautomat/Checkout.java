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
        }
        return sum;
       } catch (Exception e){
           e.printStackTrace();
       }
       return -1;
    }

    public String betalBillet(int indsatPenge) {
        int sum;
        String as;

        sum = sumList();
        
        
        if(indsatPenge < sum){
            as = "you need to pay more the total was " + sum; 
            betalt = false;
            return as;
        }
            
        if (sum <= indsatPenge) {
            betalt = true;
            as = udskrivBilletter();
            return as;
        }
            as = "-1";
        return as; 

    }

    public String udskrivBilletter() {
        String prnt = "";
        if(betalt == true){
        ArrayList<Billet> billetlist = bilvalg.getTicketList();

        for (int i = 0; i < billetlist.size(); i++) {

            Billet x = billetlist.get(i);
            prnt += udskrivBillet(x);
            automat.udskrivningLog(x.getTypename(), x.getZonename(), x.getPrice());
        }
        bilvalg.clearList();
        betalt = false;
        return prnt;
        } else {
            System.out.println("You haven't payed enough!");
            betalBillet(indsatPenge);
            udskrivBilletter();
            return prnt;
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
                        betalBillet(indsatPenge);
                        udskrivBilletter();
                        break;
                    case 2:
                        String no = bilvalg.printBilletList(list); //useless string return.
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
        public String udskrivBillet(Billet x) {
        String prnt;
        prnt = "##########B##T##########\n";
        prnt = prnt + "# Borgen Trafikselskab #\n";
        prnt = prnt +"#                      #\n";
        prnt = prnt +"#     " + x.getTypename() + "    #\n";
        prnt = prnt + "# " + x.getZonename() + "  #\n";
        prnt = prnt +"#        " + x.getPrice() + " kr.        #\n";
        prnt = prnt +"#                      #\n";
        //ystem.out.println("# Du har " + automat.getBalance() + " kr til gode #");
        prnt = prnt + "##########B##T##########\n\n";
        return prnt;
    }
        public void udskrivTestBillet(Billet x) {
        System.out.println("##########B##T##########");
        System.out.println("# Borgen Trafikselskab #");
        System.out.println("#                      #");
        System.out.println("#     Test Billet      #");
        System.out.printf("#%17s     #\n",x.getTypename());
        System.out.printf("#%16s      #\n",x.getZonename());
        System.out.println("#        " + x.getPrice() + " kr.        #");
        System.out.println("#                      #");
        //ystem.out.println("# Du har " + automat.getBalance() + " kr til gode #");
        System.out.println("##########B##T##########");
        System.out.println();
    }
}
