package Billetautomat; //test
public class BenytBilletautomat
{
	public static void main(String[] arg)
	{
		Billetautomat automat = new Billetautomat(24);
		System.out.println("Installatoeren har installeret en ny billetautomat");
		System.out.println();
		System.out.println("En kunde vil koebe en billet");
		int pris = automat.getBilletpris();
		System.out.println("Billetprisen er: " + pris + " kroner");
		System.out.println("Kunden putter 100 kroner i automaten");
		automat.indsaetPenge(100);
		System.out.println("Balancen er nu paa " + automat.getBalance() + " kroner");
		automat.udskrivBillet(false);
		System.out.println("Balancen er nu paa " + automat.getBalance() + " kroner");
	}
        //bæ
}