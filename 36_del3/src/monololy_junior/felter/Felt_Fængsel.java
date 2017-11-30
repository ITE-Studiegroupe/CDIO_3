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
 * Denne metode henter attributter til konstruktøren fra super-klassen Felt	
 * @param feltNr
 * @param tekst
 * @param erFængsel
 * @param bgFarve
 * @param tekstFarve
 */
	public Felt_Fængsel(String tekst, boolean erFængsel, Color bgFarve, Color tekstFarve) {
		super(tekst, bgFarve, tekstFarve);
		this.erFængsel = erFængsel;
	}
/**
 * Metoden returnerer erFængsel i form af en boolean
 * @return erFængsel
 */
	public boolean erFængsel() {
		return erFængsel;
	}


}
