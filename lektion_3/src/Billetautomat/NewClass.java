/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Billetautomat;

import Billetautomat.*;

/**
 *
 * @author Valdemar Landberg
 * 
 */
public class NewClass {
    public static void main(String[] arg){
        Billetvaelger b = new Billetvaelger();
        Checkout c = new Checkout(b);
        b.billetVaelgerUI();
        c.checkoutUI();
              
        
    }
}
