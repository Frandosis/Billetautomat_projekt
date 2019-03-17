package Billetautomat;

//  Model af en simpel billetautomat til enkeltbilletter med en fast pris.
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import Billetautomat.*;

public class Billetautomat {

    private ArrayList<Log> Hlog = new ArrayList<>();
    private boolean isAdmin;
    Date tid;
    private String kode; //Default montør kode.

    public Billetautomat() {
        isAdmin = false;
        kode = "1234";
    }

    public void indkastLog(int beloeb) {
        Log L = new Log("A user inserted " + beloeb + " kr.", beloeb, 1);
        Hlog.add(L);
    }

    public void udbetalingLog(int beloeb) {
        Log L = new Log("There was returned " + beloeb + " kr.", beloeb, 3);
        Hlog.add(L);
    }

    public void udskrivningLog(String type, String zone, int beloeb) {
        Log L = new Log("A ticket of the type: " + type + " with " + zone + " amount of zones at the price " + beloeb + "kr.", type, zone, beloeb, 2);
        Hlog.add(L);
    }

    public void setAdmin(boolean flag) {
        isAdmin = flag;
    }

    public void zonepriceLog(int beloeb) {
        Log L = new Log("New zone price" + beloeb + " kr.", beloeb, 4);
        Hlog.add(L);
    }

    public void setpriceLog(String type, int beloeb) {
        Log L = new Log("New price" + beloeb + " kr. of the type: " + type, beloeb, 5);
        Hlog.add(L);
    }

    public void passwordLog(String beloeb) {
        Log L = new Log("New password:" + beloeb, 6);
        Hlog.add(L);
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getPassword() {
        return kode;
    }

    /* Ændrer kodeord */
    public void changePassword() {
        Scanner sc = new Scanner(System.in);
        boolean isDone = false;
        while (isDone == false) {

            if (isAdmin == true) {
                System.out.println("Write a new password:");
                String kode1 = sc.next();
                System.out.println("Write the new password again:");
                String kode2 = sc.next();

                if (kode1.equals(kode2)) {
                    System.out.println("the password has changed");
                    kode = kode1;
                    passwordLog(kode1);
                    isDone = true;
                } else {
                    System.out.println("The password was not the same try agian.");
                }

            } else {
                System.out.println("The password could not be changed - No administrator permission");
                isDone = true;
            }
        }
    }


    /* printer transaktionen */
    public void printTransaktion() {
        if (isAdmin == true) {
            //for (String element : transaktion) {
//                System.out.println(element);
//            }

            Scanner sc = new Scanner(System.in);
            System.out.println("Transaction log write the followning number:");
            System.out.println("1. The whole log 2. The purchase log 3. The Admin log");
            String valg = sc.next();
            switch (valg) {
                case "1":// print hele log
                    System.out.println("The whole log for ticket machine");
                    for (Log L : Hlog) {
                        System.out.println(L.toString());
                    }
                    break;
                case "2"://  køb log
                    System.out.println("The purchase log. write the followning number for:");
                    System.out.println("1. the whole purchase log 2.purchase log scearh price 3. purchase log scearh tickettype");
                    String valgkøb = sc.next();
                    switch (valgkøb) {

                        case "1":// hele køb loggen
                            System.out.println("The purchase log:");
                            for (Log L : Hlog) {
                                if (L.getID() == 1) {
                                    System.out.println(L.toString());
                                }
                            }
                            break;
                        case "2":// beløb spe
                            System.out.println("Write a minimum price:");
                            String minS = sc.next();
                            int min = Integer.parseInt(minS);
                            System.out.println("Write maximum price:");
                            String maxS = sc.next();
                            int max = Integer.parseInt(maxS);
                            System.out.println("purchase log from " + min + "kr. to " + max + "kr.");
                            for (Log L : Hlog) {
                                if (L.getID() == 1 && L.getBeløb() >= min && L.getBeløb() <= max) {
                                    System.out.println(L.toString());
                                }
                            }

                            break;

                        case "3":// billettype spe
                            System.out.println("write a tickettype to show log for that type:");
                            String bilS = sc.next();
                            for (Log L : Hlog) {
                                if (L.getID() == 1 && L.getBillettype() == bilS) {
                                    System.out.println(L.toString());
                                }
                            }

                            break;
                    }
                case "3": // admin stuff
                    System.out.println("admin log:");
                    System.out.println("1. Whole admin log 2. Specific admin Action log:");
                    String adminstuff = sc.next();
                    switch (adminstuff) {

                        case "1":// hele admin loggen
                            System.out.println("Whole admin log:");
                            for (Log L : Hlog) {
                                if (L.getID() != 1) {
                                    System.out.println(L.toString());
                                }
                            }
                            break;
                        case "2":// admin valg
                            System.out.println("pick an admin action log:");
                            System.out.println("1.Change password \n2. Change ticket price \n3. Change zone price");
                            String adminh = sc.next();
                            if (adminh == "1") {
                                for (Log L : Hlog) {
                                    if (L.getID() == 4) {
                                        System.out.println(L.toString());
                                    }
                                }
                            } else if (adminh == "2") {
                                for (Log L : Hlog) {
                                    if (L.getID() == 5) {
                                        System.out.println(L.toString());
                                    }
                                }
                            } else if (adminh == "3") {
                                for (Log L : Hlog) {
                                    if (L.getID() == 6) {
                                        System.out.println(L.toString());
                                    }
                                }
                            } else {
                                System.out.println("a number between 1-3");
                            }

                    }
            }
        } else {
            System.err.println("could not print transaction - Wrong password");
        }

    }
}
