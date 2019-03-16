/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Billetautomat;
import Billetautomat.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
   boolean runAd = false;
   int choice;
   Billetvaelger bilvalg;
   Scanner adminscan = new Scanner(System.in);
   
   public Admin (Billetvaelger bv){
        bilvalg = bv;
    }
   
   public void AdminUI(){
   while(runAd != true){
       System.out.println("1 to set price\n 2 to set zone price");
       choice = adminscan.nextInt();
        
       switch(choice){
            case 1:
               setPrice();
               break;
            case 2:
                setZonePrice();
            case 0:
                runAd = true;
                break;
       }
   }   
   }
   
    public void setPrice(){
       
        bilvalg.setPrice();
   
   
    
    }
     public void setZonePrice(){
       
        bilvalg.setZonePrice();
   
   
    
    }
}
