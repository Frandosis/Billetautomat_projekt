package Billetautomat;


import java.util.Comparator;
import Billetautomat.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Valdemar Landberg
 */
public class Billet {
     private String typename;
     private String zonename;
     private int typeindex;
     private int zoneindex;
     private int price;

        public Billet(String type, String zone, int typein, int zonein, int sumprice) {
            this.typename = type;
            this.zonename = zone;
            this.typeindex = typein;
            this.zoneindex = zonein;
            this.price = sumprice;
        }
        
        public int getTypeindex(){
            return typeindex;
        }
        
        public int getZoneindex(){
            return zoneindex;
        }
        
        public String getTypename(){
            return typename;
        }
        
        public String getZonename(){
            return zonename;
        }
        
        public int getPrice(){
            return price;
        }
        public static Comparator <Billet> BilTypeComparator = new Comparator<Billet>(){
            public int compare(Billet b1, Billet b2){
                String BilletType1 = b1.getTypename().toUpperCase();
                String BilletType2 = b2.getTypename().toUpperCase();
                
                // Ascending order.
                return BilletType1.compareTo(BilletType2);
            }
        };
        public static Comparator <Billet> BilZoneComparator = new Comparator<Billet>(){
            public int compare(Billet b1, Billet b2){
                String BilletZone1 = b1.getZonename ().toUpperCase();
                String BilletZone2 = b2.getZonename().toUpperCase();
                
                return BilletZone1.compareTo(BilletZone2);
                
            }
        };
        public static Comparator <Billet> BilPriceComparator = new Comparator<Billet>(){
            public int compare(Billet b1, Billet b2){
                int BilletPrice1 = b1.getPrice();
                int BilletPrice2 = b2.getPrice();
                
                // Ascending order.
                return BilletPrice1 - BilletPrice2;
                
            }
        };
    }

