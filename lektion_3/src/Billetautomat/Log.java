
package Billetautomat;

import java.util.Date;


public class Log {

    public Log(String handling, String billettype, int beløb) {
        this.handling = handling;
        this.billettype = billettype;
        this.beløb = beløb;
        
    }
    
    private Date tidspunkt = new Date();
    private String handling = "";
    private String billettype = "";
    private int beløb = 0;

}//test



