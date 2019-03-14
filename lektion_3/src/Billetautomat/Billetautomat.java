package Billetautomat;

//  Model af en simpel billetautomat til enkeltbilletter med en fast pris.
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Billetautomat {

    private ArrayList<Log> Hlog = new ArrayList<>();
    private ArrayList<String> transaktion = new ArrayList<>();
    private boolean isAdmin = false;
    Date tid;
    private int pris;    // Prisen for én billet.
    private int balance = 0; // Hvor mange penge kunden p.t. har puttet i automaten
    private int antalBilletterSolgt = 0; // Antal billetter automaten i alt har solgt
    private String kode = "1234"; //Default montør kode.

    /**
     * Opret en billetautomat, der sælger billetter til en given billetpris.
     *
     * @param billetpris skal være større end nul (p.t. bliver det ikke tjekket)
     */
    /**
     * Opret en billetautomat, der sælger billetter til en given billetpris
     *
     * @param billetpris skal være større end nul (p.t. bliver det ikke tjekket)
     * @param startbalance mængden af penge automaten allerede indeholder
     */
    /* TO DO lav en funktion for at sætte startbalancen

	/**
	 * Giver prisen for en billet.
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    public int getBilletpris() {
        int resultat = pris;
        return resultat;
    }

    /**
     * Modtag nogle penge (i kroner) fra en kunde.
     */
    public void indsaetPenge(int beloeb) {

        if (beloeb >= 0) {
            balance = balance + beloeb;
        } else {
            System.err.println("Ingen negative beloeb");
        }

        System.out.println("Der blev indsat " + beloeb);
        Log L = new Log("Der blev indsat" + beloeb + " kroner", beloeb, 1);
        Hlog.add(L);

        //tid = new Date();
        //transaktion.add(tid + " der blev indsat " + beloeb + " kroner");
    }

    /**
     * Giver balancen (beløbet maskinen har modtaget til den næste billet).
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Udskriv en billet.
     */
    public void udskrivBillet(boolean isMontoer) {

        // Billetautomat mode
        if (balance >= pris && isMontoer == false) {
            antalBilletterSolgt = antalBilletterSolgt + 1;
            balance -= pris;          // Træk prisen fra balancen

            System.out.println("##########B##T##########");
            System.out.println("# Borgen Trafikselskab #");
            System.out.println("#                      #");
            System.out.println("#        Billet        #");
            System.out.println("#        " + pris + " kr.        #");
            System.out.println("#                      #");
            System.out.println("# Du har " + balance + " kr til gode #");
            System.out.println("##########B##T##########");
            System.out.println();
            tid = new Date();
            transaktion.add(tid + " der blev udskrevet en billet");
        } else {
            int mangel = pris - balance;
            System.out.println("Der er ikke betalt nok der mangler " + mangel + " kr.");
        }

        //Installatør mode gratis billeter
        if (isMontoer == true) {
            System.out.println("##########B##T##########");
            System.out.println("# Borgen Trafikselskab #");
            System.out.println("#                      #");
            System.out.println("#     Test Billet      #");
            System.out.println("#        " + pris + " kr.        #");
            System.out.println("#                      #");
            System.out.println("# Du har " + balance + " kr til gode #");
            System.out.println("##########B##T##########");
            System.out.println();
            tid = new Date();
            transaktion.add(tid + " der blev udskrevet en billet til en installatoer");
        }

    }

    /* Henter den interne kodeord */
    public String getPassword() {
        return kode;
    }

    /* Ændrer kodeord */
    public void changePassword(String montoerkode) {
        Scanner sc = new Scanner(System.in);
        boolean isDone = false;
        while (isDone == false) {

            if (montoerkode.equals(kode)) {
                System.out.println("Skriv din nye kode:");
                String kode1 = sc.next();
                System.out.println("Gentag kode:");
                String kode2 = sc.next();

                if (kode1.equals(kode2)) {
                    System.out.println("Koden er blevet aendret");
                    kode = kode1;
                    isDone = true;
                } else {
                    System.out.println("Koderne var ikke ens, proev igen.");
                }

            } else {
                System.out.println("Kunne ikke aendre koden - forkert kode");
                isDone = true;
            }
        }
    }

    /* Ændrer billetprisen */
    public void setBilletpris(String montoerkode, int nyPris) {
        if (montoerkode.equals(kode)) {
            pris = nyPris;
        } else {
            System.err.println("Kunne ikke saette pris - forkert kode");
        }
    }

    /* Regner det samlede salgsbeløb */
    public int getSamletSalgsbeloeb(String montoerkode) {
        if (montoerkode.equals(kode)) {
            return pris * antalBilletterSolgt;
        } else {
            System.err.println("Kunne ikke hente samlet billetsalg - forkert kode");
        }

        return -1;
    }

    /* sender antalbilletter solgt */
    public int getAntalBilletterSolgt(String montoerkode) {
        if (montoerkode.equals(kode)) {
            return antalBilletterSolgt;
        } else {
            System.err.println("Kunne ikke hente antal billetter solgt - forkert kode");
        }

        return -1;
    }

    /* hæver den resterende balance til brugeren */
    public void haevBalance() {
        System.out.println("Haever den resterende balance.");
        tid = new Date();
        transaktion.add(tid + " kunden fik " + balance + " kroner tilbage");
        balance -= balance;
    }

    /* nulstiller dagens salg*/
    public void resetDay(String montoerkode) {
        if (montoerkode.equals(kode)) {
            haevBalance();
            System.out.println("Haever nu dagens salg: " + getSamletSalgsbeloeb(kode));
            antalBilletterSolgt = 0;
            transaktion.clear();
        } else {
            System.err.println("Kunne ikke nulstille - forkert kode");
        }
    }

    /* printer transaktionen */
    public void printTransaktion(String montoerkode) {
        if (montoerkode.equals(kode)) {
            //for (String element : transaktion) {
//                System.out.println(element);
//            }

            Scanner sc = new Scanner(System.in);
            System.out.println("eay bby want sum fuk?");
            System.out.println("");
            String valg = sc.next();
            switch (valg) {
                case "1":// print hele log
                    for (Log L : Hlog) {
                        System.out.println(L.toString());
                    }
                    break;
                case "2"://  køb log

                    String valgkøb = sc.next();
                    switch (valgkøb) {

                        case "1":// hele køb loggen
                            System.out.println("Hele købs log:");
                            for (Log L : Hlog) {
                                if (L.ID == 1) {
                                    System.out.println(L.toString());
                                }
                            }
                            break;
                        case "2":// beløb spe
                            System.out.println("Skriv min.");
                            String minS = sc.next();
                            int min = Integer.parseInt(minS);
                            System.out.println("Skriv max.");
                            String maxS = sc.next();
                            int max = Integer.parseInt(maxS);
                            for (Log L : Hlog) {
                                if (L.ID == 1 && L.beløb >= min && L.beløb <= max) {
                                    System.out.println(L.toString());
                                }
                            }

                            break;

                        case 3:
                            break;
                    }
            }else {
            System.err.println("Kunne ikke udskrive transtaktionerne - forkert kode");
        }

        }
    }
