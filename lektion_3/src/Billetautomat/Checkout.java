/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Billetautomat;
import java.util.Scanner;

public class Checkout {
    boolean betalt=false; 
    
    public boolean betalbillet(int sumprice,boolean betalt){
        Scanner tastatur = new Scanner(System.in);
        int indsatPenge;
        
        while(betalt != true){
        System.out.println("Du skal betale " + sumprice + " kr.");
        
        indsatPenge = tastatur.nextInt();
        tastatur.nextLine();
        
            sumprice = sumprice - indsatPenge;
            if(sumprice<0){
              sumprice = -1 * sumprice;  
              System.out.println("Du har betalt for meget så du får nu dine" + sumprice + " kr. tilbage");
              sumprice = 0;
            }
                if(sumprice == 0){
                    betalt = true;                   
                    }     
}
    return betalt;
}
    
    
    
}

