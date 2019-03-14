/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
package Billetautomat;

/**
 *
 * @author Nikolaj Landberg
 */
public class Checkout {
    boolean betalt=false; 
    
    public boolean betalbillet(sumprice,betalt);
    
    
}


     public betalbillet(int sumprice,boolean betalt){
        Scanner tastatur = new Scanner(System.in);
        int indsatPenge=-1;
        
        while(indsatPenge != 0){
        system.out.print("Du skal betale " + sumprice " kr.");
        indsatPenge = tastatur.nextint();
        sumprice = sumprice - indsatPenge;
        if(sumprice = 0){
        return betalt true;
}
}
     
}