/*
Changelog vers. 2:
Addition:
BilletMenu:
* User Interface.
* montør mode.

Billetautomat:
* function getAntalBilletterSolgt().
* function haevBalance().
* Installer password:
* function getPassword().
* function changePassword(). 

Changes:
Billetautomat.java:
* function getSamletSalgsbeloeb() add a fail-state when inputting the wrong password.
* function indsaetPenge() made sure you can't add negative input.
* function udskrivBillet() added a installator mode for printing the ticket.
* function udskrivBillet() made sure you can't print ticket unless balance matches or are above the price.
* function udskrivBillet() made sure the balance matches the price subtraction.
*/

package Billetautomat;

import java.util.Scanner;

public class BilletMenu
{
	public static void main(String[] arg)
	{
            Scanner sc = new Scanner(System.in); // opret scanner-objekt
            int setPris = 24;
            int valg = -1;
            boolean montoerMode = false;
            
		Billetautomat automat = new Billetautomat(setPris);
		
            
                
            while (valg != 0){
            System.out.println("Billetautomat:");
            System.out.println("Prisen for en billet: " + automat.getBilletpris());
            System.out.println("Tryk 1 for at indsaette penge, 2 for billet, 3 for balance, 4 for montoer mode, 0 for at afslutte");
            valg = sc.nextInt();
            
            switch (valg){
                case 1:
                    System.out.println("Skriv beloeb:");
                    int beloeb = sc.nextInt();
                    automat.indsaetPenge(beloeb);
                    break;
                    
                case 2:
                    automat.udskrivBillet(montoerMode);
                    break;
                
                case 3:
                    int bal = automat.getBalance();
                    System.out.println("Balancen er " +bal);
                    break;
               
                case 4:
                    //initialiser montør mode.
                    System.out.println("For at aktivere montoer mode skriv kodeordet:");
                    String password = sc.next();
                    if(password.equals(automat.getPassword())) montoerMode = true;
                    else{
                        System.out.println("Forkert kodeord.");
                        break;
                    }
                    
                    System.out.println("Velkommen montoer.");
                    int montoerValg = -1;
                    while (montoerMode == true){
                        System.out.println("Montoer mode:");
                        System.out.println("Tryk 1 for at printe test billetter, 2 for at aendre prisen, 3 for at aendre kode, \n4 for at tjekke dagens salg, 5 for at nulstille, 6 for at tjekke transaktionerne, \n0 for at lukke montoer mode");
                        montoerValg = sc.nextInt();
                        
                        switch (montoerValg){
                            case 1:
                                System.out.println("Test printer billet vent venligst...");
                                automat.udskrivBillet(montoerMode);
                                break;
                            
                            case 2:
                                boolean isPositive = false;
                                
                                while (isPositive != true){
                                
                                
                                    System.out.println("Indtast den nye billetpris:");
                                    int nyPris = sc.nextInt();
                                
                                    if (nyPris < 0){
                                        System.out.println("Du maa ikke saette en negativ pris.");
                                    } else{
                                        automat.setBilletpris(password, nyPris);
                                   
                                        isPositive = true;
                                    }
                                }
                                break;
                                
                            case 3:
                                System.out.println("Goer klar til at aendre koden...");
                                automat.changePassword(password);
                                System.out.println("Opdaterer den nye kode...");
                                password = automat.getPassword();
                                System.out.println("koden er opdateret.");
                                
                                break;
                            
                            case 4:
                                System.out.println("Dagens antal billetter solgt: " + automat.getAntalBilletterSolgt(password));
                                System.out.println("Ved prisen: " + automat.getBilletpris());
                                System.out.println("Samlet salg for dagen: " + automat.getSamletSalgsbeloeb(password));
                                
                                break;
                            
                            case 5:
                                System.out.println("Nulstiller nu for dagen");
                                automat.resetDay(password);
                                
                                break;
                                
                            case 6:
                            System.out.println("Udskriver Transaktion");
                            automat.printTransaktion(password);
                                
                            break;
                                
                            case 0:
                                password = "";
                                montoerMode = false;
                                
                                System.out.println("Lukker montoer mode.");
                                break;
                        }
                    }
                    
                break;
            }
            
            }
            System.out.println("Tak fordi du brugte BT - Du faar nu den resterende balance på "+automat.getBalance());
            automat.haevBalance();
            System.out.println("Balancen er nu: " + automat.getBalance() + "\nHav en god dag!");
            
	}
}