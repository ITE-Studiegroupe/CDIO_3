package monopoly_junior.felter;

import java.awt.Color;

/**
 * Klassen: Felt_Chancekort
 * Sub-klasse til Felt
 * @author Gruppe_36
 * Klassen har til formål at styre chancekort felterne
 */

public class Felt_Chance extends Felt{
	
/**
 * Denne metode henter attributter til konstruktøren fra super-klassen Felt	
 * @param feltNr
 * @param feltNavn
 * @param bgFarve
 * @param tekstFarve
 */
	public Felt_Chance(String feltNavn, Color bgFarve, Color tekstFarve) {
		super(feltNavn, bgFarve, tekstFarve);
	}
	
}
