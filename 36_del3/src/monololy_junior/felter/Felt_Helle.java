package monololy_junior.felter;

import java.awt.Color;

public class Felt_Helle extends Felt {

	public Felt_Helle(int feltNr, String tekst, Color bgFarve, Color tekstFarve) {
		feltNavn = tekst;
		this.feltNr = feltNr;
		this.bgFarve = bgFarve;
		this.tekstFarve = tekstFarve;
	}
}
