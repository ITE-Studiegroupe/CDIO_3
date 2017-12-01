package monopoly_junior.felter;

import java.awt.Color;

import monopoly_junior.Spiller;

/**
 * Klassen: Felt_Forretning
 * @author Gruppe_36
 * Klassen har til formål at kontrollere om felterne har en ejer
 * Hvis ikke, kan klassen sætte en spiller som ejer
 */

public class Felt_Forretning extends Felt {

	private int pris;
	private Spiller ejer;
	private int feltNr;

	/**
	 * Denne metode henter attributter til konstruktøren fra super-klassen Felt	
	 * @param feltNr
	 * @param feltNavn
	 * @param pris
	 * @param bgFarve
	 * @param tekstFarve
	 */
	public Felt_Forretning(int feltNr, String feltNavn, int pris, Color bgFarve, Color tekstFarve) {
		super(feltNavn, bgFarve, tekstFarve);
		this.pris = pris;
		this.feltNr = feltNr;
	}

	/**
	 * Metode der kontrollerer om feltet har en ejer
	 * Returnerer true hvis feltet har en ejer, hvis ikke returnerer den false
	 * @return true eller false
	 */
	public boolean harEjer() {
		return (ejer != null);
	}

	/**
	 * Metoden sætter værdien spiller, som ejer
	 * Hvis feltet ikke har en ejer
	 * @param spiller
	 */
	public void setEjer(Spiller spiller) {
		if (ejer == null) ejer = spiller;
	}

	/**
	 * Metoden returnerer ejer
	 * @return ejer
	 */
	public Spiller getEjer() {
		return ejer;
	}

	/**
	 * Metoden sætter pris	
	 * @param p
	 */
	public void setPris(int p) {
		pris = p;
	}

	/**
	 * Metoden returnerer pris
	 * @return pris
	 */
	public int getPris() {
		return pris;
	}

	public int getFeltNr() {
		return feltNr;
	}
}
