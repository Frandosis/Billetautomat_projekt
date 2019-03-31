/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Billetautomat;

import Billetautomat.*;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author Valdemar Landberg
 * 
 */
public class BrugerMenu {
    public static void main(String[] arg){
        Billetautomat auto = new Billetautomat();
        Billetvaelger bv = new Billetvaelger(auto);
        Checkout c = new Checkout(bv, auto);
        Admin a = new Admin(bv, auto, c);
        Scanner scan = new Scanner(System.in);
        
        JFrame mainFrame = new JFrame("Main menu");
        BrugerMenuPanel panel = new BrugerMenuPanel(mainFrame, bv, c);
        
        mainFrame.add(panel);
        
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // reagér på luk
        mainFrame.pack();                       // sæt vinduets størrelse
        mainFrame.setVisible(true);                      // åbn vinduet
        
    }
}
