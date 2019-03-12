/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Billetautomat;

import java.util.Scanner;

/**
 *
 * @author Nikolaj Landberg
 */
public class Billetvaelger {
    class billet{
     int type;
     int zone;
     
    }
    
    Scanner s = new Scanner(System.in);
    Billettype type = new Billettype();
    
    private int antalvoksen;
    private int antalboerne;
    private int antalcykel;
    
    public Billetvaelger(){
        antalvoksen = 0;
        antalboerne = 0;
        antalcykel = 0;
    }
    
    public void billetVaelgerMenu(){
        
    }
    
    public void antalBilletter(int antal){
        
    }
    
}
