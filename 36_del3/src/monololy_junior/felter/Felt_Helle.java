package monololy_junior.felter;

import java.awt.Color;
/**
 * Klasse: Felt_Helle
 * Sub-llasse til Felt
 * @author Gruppe_36
 * Klassen styrer du felter som giver spilleren helle
 */

public class Felt_Helle extends Felt {

/**
 * Denne metode, kalder metoder fra super-klassen, Felt
 * @param feltNr
 * @param tekst
 * @param bgFarve
 * @param tekstFarve
 */
	public Felt_Helle(int feltNr, String tekst, Color bgFarve, Color tekstFarve) {
		feltNavn = tekst;
		this.feltNr = feltNr;
		this.bgFarve = bgFarve;
		this.tekstFarve = tekstFarve;
	}
}
