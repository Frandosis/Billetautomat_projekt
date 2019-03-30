/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Billetautomat;

/**
 *
 * @author Valdemar Landberg
 */
public class BilletvaelgerBuffer {
    public int typeindex;
    public int zoneindex;
    public int amount;
    
    public void setTypeindex(int ti){
        typeindex = ti;
    }
    
    public void setZoneindex(int zi){
        zoneindex = zi;
    }
    
    public void setAmount(int a){
        amount = a;
    }
}
