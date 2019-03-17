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
        Log L = new Log("Der blev indsat" + beloeb + " kroner", beloeb, 1);
        Hlog.add(L);
    }

    public void udbetalingLog(int beloeb) {
        Log L = new Log("Der blev udbetalt" + beloeb + " kroner", beloeb, 3);
        Hlog.add(L);
    }

    public void udskrivningLog(String type, String zone, int beloeb) {
        Log L = new Log("Der blev udskrevet billet typen:" + type + "med " + zone + "antal zoner til en pris af" + beloeb + "kr.", type, zone, beloeb, 2);
        Hlog.add(L);
    }

    public void setAdmin(boolean flag) {
        isAdmin = flag;
    }

    public void zonepriceLog(int beloeb) {
        Log L = new Log("Ny zone price" + beloeb + " kroner", beloeb, 4);
        Hlog.add(L);
    }

    public void setpriceLog(String type, int beloeb) {
        Log L = new Log("Ny price" + beloeb + " kroner af typen: " + type, beloeb, 5);
        Hlog.add(L);
    }

    public void passwordLog(String beloeb) {
        Log L = new Log("Ny pass:" + beloeb, 6);
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
            System.out.println("Transaktion log skriv følgende for:");
            System.out.println("1. Hele log 2.Købs log 3. Admin log");
            String valg = sc.next();
            switch (valg) {
                case "1":// print hele log
                    System.out.println("Hele loggen for automaten");
                    for (Log L : Hlog) {
                        System.out.println(L.toString());
                    }
                    break;
                case "2"://  køb log
                    System.out.println("Købs log. skriv følgende for:");
                    System.out.println("1. Hele købs log 2.Købs log udfra beløb 3. Købs log udfra billetype");
                    String valgkøb = sc.next();
                    switch (valgkøb) {

                        case "1":// hele køb loggen
                            System.out.println("Hele købs log:");
                            for (Log L : Hlog) {
                                if (L.getID() == 1) {
                                    System.out.println(L.toString());
                                }
                            }
                            break;
                        case "2":// beløb spe
                            System.out.println("Skriv min. beløb:");
                            String minS = sc.next();
                            int min = Integer.parseInt(minS);
                            System.out.println("Skriv max. beløb:");
                            String maxS = sc.next();
                            int max = Integer.parseInt(maxS);
                            System.out.println("Købs log fra" + min + "kr. til" + max + "kr.");
                            for (Log L : Hlog) {
                                if (L.getID() == 1 && L.getBeløb() >= min && L.getBeløb() <= max) {
                                    System.out.println(L.toString());
                                }
                            }

                            break;

                        case "3":// billettype spe
                            System.out.println("Skrive billetype der visses log for:");
                            String bilS = sc.next();
                            for (Log L : Hlog) {
                                if (L.getID() == 1 && L.getBillettype() == bilS) {
                                    System.out.println(L.toString());
                                }
                            }

                            break;
                    }
                case "3": // admin stuff
                    System.out.println("Vælg admin log:");
                    System.out.println("1. Hele admin log 2. Mulighed for at vælge spec:");
                    String adminstuff = sc.next();
                    switch (adminstuff) {

                        case "1":// hele admin loggen
                            System.out.println("Hele admin log:");
                            for (Log L : Hlog) {
                                if (L.getID() != 1) {
                                    System.out.println(L.toString());
                                }
                            }
                            break;
                        case "2":// admin valg
                            System.out.println("Vælg admin handlings log:");
                            System.out.println("1- ? 2- ? 3-?");
                            String adminh = sc.next();
                            if (adminh == "1") {
                                for (Log L : Hlog) {
                                    if (L.getID() != 2) {
                                        System.out.println(L.toString());
                                    }
                                }
                            } else if (adminh == "2") {
                                for (Log L : Hlog) {
                                    if (L.getID() != 3) {
                                        System.out.println(L.toString());
                                    }
                                }
                            } else if (adminh == "3") {
                                for (Log L : Hlog) {
                                    if (L.getID() != 4) {
                                        System.out.println(L.toString());
                                    }
                                }
                            } else {
                                System.out.println("dafug det ikke et nummer mellem 1-3");
                            }

                    }
            }
        } else {
            System.err.println("Kunne ikke udskrive transtaktionerne - forkert kode");
        }

    }
}
