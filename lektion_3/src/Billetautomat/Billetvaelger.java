/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Billetautomat;

import java.util.Scanner;
import java.util.ArrayList;

public class Billetvaelger {
    class Billet{
     String typename;
     String zonename;
     int price;
     
     public Billet(String type, String zone, int sumprice){
         this.typename = type;
         this.zonename = zone;
         this.price = sumprice;
     }
     
    }
    
    Scanner s = new Scanner(System.in);
    Billettype type = new Billettype();
    ArrayList<Billet> Billetliste = new ArrayList<Billet>();
    
    private int antalvoksen;
    private int antalboerne;
    private int antalcykel;
    
    public Billetvaelger(){
        antalvoksen = 0;
        antalboerne = 0;
        antalcykel = 0;
    }
    public void addBillet(){
        
    }
    public void billetVaelgerUI(){
        
        
    }
    
    public void antalBilletter(int antal){
        
    }
    
}
