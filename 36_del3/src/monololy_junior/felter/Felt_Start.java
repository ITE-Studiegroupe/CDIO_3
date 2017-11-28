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
 * @param navn
 * @param præmie
 * @param bgFarve
 * @param tekstFarve
 */
	public Felt_Start (int feltNr, String navn, int præmie, Color bgFarve, Color tekstFarve) {
		feltNavn = navn;
		this.feltNr = feltNr;
		this.præmie = præmie;
		this.bgFarve = bgFarve;
		this.tekstFarve = tekstFarve;
		
	}
/**
 * Denne metode returnerer præmie 
 * @return præmie
 */
	public int getPræmie() {
		return præmie;
	}	
	
}
