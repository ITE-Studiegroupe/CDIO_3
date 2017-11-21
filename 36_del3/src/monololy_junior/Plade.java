package monololy_junior;

import java.awt.Color;

public class Plade {
	private int antalFelter;
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
		
		
		felter[0] = new Felt();
		felter[0].setFeltNavn("Start!");
		felter[0].setFeltFarve(Color.WHITE);
		felter[0].setVærdi(0);
		felter[0].setFeltType(4);
		
		felter[1] = new Felt();
		felter[1].setFeltNavn("Burgerbaren");
		felter[1].setFeltFarve(Color.red);
		felter[1].setVærdi(1); //prisen på feltet
		felter[1].setFeltType(2);
		
		felter[2] = new Felt();
		felter[2].setFeltNavn("Pizzahuset");
		felter[2].setFeltFarve(Color.red);
		felter[2].setVærdi(1); //prisen på feltet
		felter[2].setFeltType(2);
		
		felter[3] = new Felt();
		felter[3].setFeltNavn("Chancekort");
		felter[3].setFeltFarve(Color.WHITE);
		felter[3].setVærdi(0);
		felter[3].setFeltType(3);
		
		felter[4] = new Felt();
		felter[4].setFeltNavn("Slikbutikken");
		felter[4].setFeltFarve(Color.BLUE);
		felter[4].setVærdi(1); //prisen på feltet
		felter[4].setFeltType(2);
		
		felter[5] = new Felt();
		felter[5].setFeltNavn("Iskiosken");
		felter[5].setFeltFarve(Color.BLUE);
		felter[5].setVærdi(1);
		felter[5].setFeltType(2);
		
		felter[6] = new Felt();
		felter[6].setFeltNavn("Fængslet");
		felter[6].setFeltFarve(Color.BLACK);
		felter[6].setVærdi(0); //prisen på feltet
		felter[6].setFeltType(1);
	
		felter[7] = new Felt();
		felter[7].setFeltNavn("Museet");
		felter[7].setFeltFarve(Color.PINK);
		felter[7].setVærdi(2); //prisen på feltet
		felter[7].setFeltType(2);
		
		felter[8] = new Felt();
		felter[8].setFeltNavn("Biblioteket");
		felter[8].setFeltFarve(Color.PINK);
		felter[8].setVærdi(2);
		felter[8].setFeltType(2);
		
		felter[9] = new Felt();
		felter[9].setFeltNavn("Chancekort");
		felter[9].setFeltFarve(Color.WHITE);
		felter[9].setVærdi(0);
		felter[9].setFeltType(3);
		
		felter[10] = new Felt();
		felter[10].setFeltNavn("Skaterparken");
		felter[10].setFeltFarve(Color.YELLOW);
		felter[10].setVærdi(2); //prisen på feltet
		felter[10].setFeltType(2);
		
		felter[11] = new Felt();
		felter[11].setFeltNavn("Swimmingpoolen");
		felter[11].setFeltFarve(Color.YELLOW);
		felter[11].setVærdi(2); //prisen på feltet
		felter[11].setFeltType(2);
		
		felter[12] = new Felt();
		felter[12].setFeltNavn("Gratis parkering");
		felter[12].setFeltFarve(Color.WHITE);
		felter[12].setVærdi(0);
		felter[12].setFeltType(4);
		
		felter[13] = new Felt();
		felter[13].setFeltNavn("Spillehallen");
		felter[13].setFeltFarve(Color.ORANGE);
		felter[13].setVærdi(3);
		felter[13].setFeltType(2);
		
		felter[14] = new Felt();
		felter[14].setFeltNavn("Biogragen");
		felter[14].setFeltFarve(Color.ORANGE);
		felter[14].setVærdi(3); //prisen på feltet
		felter[14].setFeltType(2);
		
		felter[15] = new Felt();
		felter[15].setFeltNavn("Chancekort");
		felter[15].setFeltFarve(Color.WHITE);
		felter[15].setVærdi(0);
		felter[15].setFeltType(3);
		
		felter[16] = new Felt();
		felter[16].setFeltNavn("Legetøjsbutikken");
		felter[16].setFeltFarve(Color.CYAN);
		felter[16].setVærdi(3); //prisen på feltet
		felter[16].setFeltType(2);
		
		felter[17] = new Felt();
		felter[17].setFeltNavn("Dyrehandelen");
		felter[17].setFeltFarve(Color.CYAN);
		felter[17].setVærdi(3);
		felter[17].setFeltType(2);
		
		felter[18] = new Felt();
		felter[18].setFeltNavn("Gå i fængslet");
		felter[18].setFeltFarve(Color.BLACK);
		felter[18].setVærdi(0); //prisen på feltet
		felter[18].setFeltType(1);
		
		felter[19] = new Felt();
		felter[19].setFeltNavn("Bowlinghallen");
		felter[19].setFeltFarve(Color.GREEN);
		felter[19].setVærdi(4);
		felter[19].setFeltType(2);
		
		felter[20] = new Felt();
		felter[20].setFeltNavn("Zoo");
		felter[20].setFeltFarve(Color.GREEN);
		felter[20].setVærdi(4); //prisen på feltet
		felter[20].setFeltType(2);
		
		felter[21] = new Felt();
		felter[21].setFeltNavn("Chancekort");
		felter[21].setFeltFarve(Color.WHITE);
		felter[21].setVærdi(0);
		felter[21].setFeltType(3);
		
		felter[22] = new Felt();
		felter[22].setFeltNavn("Vandlandet");
		felter[22].setFeltFarve(Color.BLUE);
		felter[22].setVærdi(4); //prisen på feltet
		felter[22].setFeltType(2);
		
		felter[23] = new Felt();
		felter[23].setFeltNavn("Strandpromenaden");
		felter[23].setFeltFarve(Color.BLUE);
		felter[23].setVærdi(5);
		felter[23].setFeltType(2);
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
}
