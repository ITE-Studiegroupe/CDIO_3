package monololy_junior.felter;

import java.awt.Color;

/**
 * Klassen: Felt_Chancekort
 * Sub-klasse til Felt
 * @author Gruppe_36
 * Klassen har til formål at styre chancekort felterne
 */

public class Felt_Chance extends Felt{
	
/**
 * Metoden henter metoderne fra super-klassen, Felt	
 * @param feltNr
 * @param tekst
 * @param bgFarve
 * @param tekstFarve
 */
	public Felt_Chance(int feltNr, String tekst, Color bgFarve, Color tekstFarve) {
		super(feltNr, tekst, bgFarve, tekstFarve);
	}
	
}
