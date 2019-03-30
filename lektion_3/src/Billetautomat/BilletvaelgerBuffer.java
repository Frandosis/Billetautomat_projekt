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
    private int typeindex;
    private int zoneindex;
    private int amount;
    public BilletvaelgerBuffer(){
        typeindex = 0;
        zoneindex = 0;
        amount = 0;
    }
    
    public void setTypeindex(int ti){
        typeindex = ti;
    }
    
    public void setZoneindex(int zi){
        zoneindex = zi;
    }
    
    public void setAmount(int a){
        amount = a;
    }
    
    public int getTypeindex(){
        return typeindex;
    }
    
    public int getZoneindex(){
        return zoneindex;
    }
    
    public int getAmount(){
        return amount;
    }
}
