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
    
    public int sumList(){
      int sum = 0;
      ArrayList<Billet> list = bilvalg.getTicketList();
      for (int i = 0; i < list.size(); i++){
          Billet b = list.get(i);
          sum += b.getPrice();
      }
      return sum;
    }
    
    public boolean betalbillet(int sum) {
        Scanner tastatur = new Scanner(System.in);
        int indsatPenge;

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
        return betalt;
    }

    public void udskrivBilletter(ArrayList<Billet> liste, int antalbillet) {

        for (int i = 0; i < antalbillet; i++) {

            Billet x = liste.get(i);
            biltype.udskrivBillet(x.getTypeindex(), x.getZoneindex());

        }
    }

}
