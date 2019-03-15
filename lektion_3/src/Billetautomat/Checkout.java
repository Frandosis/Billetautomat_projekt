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
    Billetvaelger bilvalg;
    Billettype biltype;
    boolean betalt = false;
    Scanner tastatur = new Scanner(System.in);
    
    public int sumList(){
      int sum = 0;
      
      ArrayList<Billet> list = bilvalg.getTicketList();
      
      for (int i = 0; i < list.size(); i++){
          Billet b = list.get(i);
          sum += b.getPrice();
          System.out.println(sum);
      }
      return sum;
    }
    
    public void betalbillet() {
        int sum=1;
        int indsatPenge;
        
        sumList();
        while (betalt != true) {
            System.out.println("Du skal betale " + sum + " kr.");

            indsatPenge = tastatur.nextInt();
            tastatur.nextLine();
            
                while(indsatPenge<=0){
                    System.out.println("Du kan ikke indseatte negative penge! \nskriv et positiv tal.");
                    indsatPenge = tastatur.nextInt();
                    tastatur.nextLine();
                }
            
                sum = sum - indsatPenge;
            
                if (sum < 0) {
                    sum = -1 * sum;
                    System.out.println("Du har betalt for meget så du får nu dine " + sum + "kr tilbage.");
                    sum = 0;
                }
                
                if (sum == 0) {
                    betalt = true;
                }
        }
        
    }

    public void udskrivBilletter() {
           ArrayList<Billet> billetlist = bilvalg.getTicketList(); 
           
        for (int i = 0; i < billetlist.size(); i++) {
            
            Billet x = billetlist.get(i);
            biltype.udskrivBillet(x.getTypeindex(), x.getZoneindex());

        }
    }
    public void checkoutUI(){
        boolean done = false;
        int choice;
        while(done != true){
            System.out.println("Choose a feature\npress 1 to pay for tickets\npress 2 to print ticket\npress 0 to end.");
            choice = tastatur.nextInt();
            switch (choice) {
            case 1:
            betalbillet();
                break;
            case 2:
                udskrivBilletter();
                break;
            case 0:
                done = true;
                break;
        }
    }}
}
    