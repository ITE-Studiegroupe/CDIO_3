package monololy_junior;

import java.awt.Color;

import controller.GUIFører;
import monololy_junior.felter.Felt;
import monololy_junior.felter.Felt_Chance;
import monololy_junior.felter.Felt_Forretning;
import monololy_junior.felter.Felt_Fængsel;
import monololy_junior.felter.Felt_Helle;
import monololy_junior.felter.Felt_Start;

public class Plade {
	
	/**
	 * Denne klasse har til formål at holde på informationer omkring de 24 forskellige felter 
	 * og de 8 chancekort.
	 * 
	 * @author Gruppe 36
	 * @category Information expert
	 *
	 */
	
	private Chancekort[] chancekort = new Chancekort[8];
	private Felt[] felter = new Felt[24];
	
	/**
	 * 1. felter hvor der ikke sker noget 
	 * 2. felter der kan købes eller ejes af nogen 
	 * 3. felter der er chancekort 
	 * 4. felter hvor man får penge (start) 
	 */
	
	public void bygPlade() {
		bygFelter();
		bygChancekort();
		
	}

	//Bygfelter metode
	private void bygFelter() {
		
		felter[0] = new Felt_Start("Start!", 4, Color.WHITE, Color.BLACK);
		
		felter[1] = new Felt_Forretning("Burgerbaren", 1, Color.RED, Color.BLACK);
		
		felter[2] = new Felt_Forretning("Pizzahuset", 1, Color.RED, Color.BLACK);
		
		felter[3] = new Felt_Chance("Chancekort", Color.GRAY, Color.ORANGE);
		
		felter[4] = new Felt_Forretning("Slikbutikken", 1, Color.BLUE, Color.BLACK);
		
		felter[5] = new Felt_Forretning("Iskiosken", 1, Color.BLUE, Color.BLACK);
		
		felter[6] = new Felt_Fængsel("Fængslet", "forklaring", true, Color.BLACK, Color.WHITE);
		
		felter[7] = new Felt_Forretning("Museet", 2, Color.PINK, Color.BLACK);
		
		felter[8] = new Felt_Forretning("Biblioteket", 2, Color.PINK, Color.BLACK);
		
		felter[9] = new Felt_Chance("Chancekort", Color.GRAY, Color.ORANGE);
		
		felter[10] = new Felt_Forretning("Skaterparken", 2, Color.YELLOW, Color.BLACK);
		
		felter[11] = new Felt_Forretning("Swimmingpoolen", 2, Color.YELLOW, Color.BLACK);
		
		felter[12] = new Felt_Helle("Gratis parkering", Color.WHITE, Color.BLACK);
		
		felter[13] = new Felt_Forretning("Spillehallen", 3, Color.ORANGE, Color.BLACK);
		
		felter[14] = new Felt_Forretning("Biografen", 3, Color.ORANGE, Color.BLACK);
		
		felter[15] = new Felt_Chance("Chancekort", Color.GRAY, Color.ORANGE);
		
		felter[16] = new Felt_Forretning("Legetøjsbutikken", 3, Color.CYAN, Color.BLACK);
		
		felter[17] = new Felt_Forretning("Dyrehandelen", 3, Color.CYAN, Color.BLACK);
		
		felter[18] = new Felt_Fængsel("Gå i fængslet", "", false, Color.BLACK, Color.WHITE);
		
		felter[19] = new Felt_Forretning("Bowlinghallen", 4, Color.GREEN, Color.BLACK);
		
		felter[20] = new Felt_Forretning("Zoo", 4, Color.GREEN, Color.BLACK);
		
		felter[21] = new Felt_Chance("Chancekort", Color.GRAY, Color.ORANGE);
		
		felter[22] = new Felt_Forretning("Vandlandet", 4, Color.BLUE, Color.BLACK);
		
		felter[23] = new Felt_Forretning("Strandpromenaden", 4, Color.BLUE, Color.BLACK);
		}
	
	/**
	 * Typer af chancekort:<br> 
	 * 1. betal penge <br>
	 * 2. få penge <br>
	 * 3. ryk felter <br>
	 */

	private void bygChancekort() {
		
		chancekort[0] = new Chancekort(3, 1, "Du skylder banken penge! Betal 3kr.");
		
		chancekort[1] = new Chancekort(20, 3, "Du har lyst til at se på dyr, ryk til Zoo");
		
		chancekort[2] = new Chancekort(4, 1, "Banken har fødselsdag, betal 4kr.");
		
		chancekort[3] = new Chancekort(13, 3, "Du vil spille på flippermaskiner, ryk til Spillehallen");
		
		chancekort[4] = new Chancekort(6, 3, "Du er kæmpe fan af Egon Olsen, ryk til Fængsel");
		
		chancekort[5] = new Chancekort(1, 2, "Du har fundet 1kr på gaden, det er den lykkedag! Du får 1kr.");
		
		chancekort[6] = new Chancekort(2, 2, "Du har smadret din sparegris. Du får 2kr.");
		
		chancekort[7] = new Chancekort(4, 2, "Du har solgt din javabog. Du får 4kr.");
			
		}
	/**
	 * Træk et random chancekort
	 * 
	 */
		public  Chancekort trækChancekort() {
		int trukketChancekort = ((int) (Math.random()*chancekort.length));
		return chancekort[trukketChancekort];

		}
		
		public Felt[] getFelter() {
			return felter;
		}
}
