package monololy_junior.felter;

import java.awt.Color;

/**
 * Klassen: Felt_Fængsel
 * @author Gruppe_36
 * Klassen styrer feltet Fængsel
 */

public class Felt_Fængsel extends Felt{
	
	private boolean erFængsel;
	
/**
 * Denne metode, henter metoder fra super-klassen Felt	
 * @param feltNr
 * @param tekst
 * @param erFængsel
 * @param bgFarve
 * @param tekstFarve
 */
	public Felt_Fængsel(int feltNr, String tekst, boolean erFængsel, Color bgFarve, Color tekstFarve) {
		feltNavn = tekst;
		this.feltNr = feltNr;
		this.erFængsel = erFængsel;
		this.bgFarve = bgFarve;
		this.tekstFarve = tekstFarve;
	}
/**
 * Metoden returnerer erFængsel i form af en boolean
 * @return erFængsel
 */
	public boolean erFængsel() {
		return erFængsel;
	}


}
