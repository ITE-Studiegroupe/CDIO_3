package monololy_junior.felter;

import java.awt.Color;

import monololy_junior.Spiller;

/**
 * Klassen: Felt_Forretning
 * @author Gruppe_36
 * Klassen har til formål at kontrollere om felterne har en ejer
 * Hvis ikke, kan klassen sætte en spiller som ejer
 */

public class Felt_Forretning extends Felt {

	private int pris;
	private Spiller ejer;
	
/**
 * Denne metode, henter metoder fra super-klassen, Felt	
 * @param feltNr
 * @param navn
 * @param pris
 * @param bgFarve
 * @param tekstFarve
 */
	public Felt_Forretning(int feltNr, String navn, int pris, Color bgFarve, Color tekstFarve) {
		feltNavn = navn;
		this.feltNr = feltNr;
		this.pris = pris;
		this.bgFarve = bgFarve;
		this.tekstFarve = tekstFarve;
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
}
