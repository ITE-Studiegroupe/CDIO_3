package monololy_junior.felter;

import java.awt.Color;

/**
 * Klassen: Felt_Start.
 * Sub-klasse til Felt
 * @author Gruppe_36
 * Klassen styrer feltet Start
 */

public class Felt_Start extends Felt{

	private int præmie;

/**
 * Denne metode, kalder metoder fra super-klassen, Felt
 * @param feltNr
 * @param tekst
 * @param præmie
 * @param bgFarve
 * @param tekstFarve
 */
	public Felt_Start (int feltNr, String tekst, int præmie, Color bgFarve, Color tekstFarve) {
		super(feltNr, tekst, bgFarve, tekstFarve);
		this.præmie = præmie;
		
	}
/**
 * Denne metode returnerer præmie 
 * @return præmie
 */
	public int getPræmie() {
		return præmie;
	}	
	
}
