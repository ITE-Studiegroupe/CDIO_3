package monololy_junior.felter;

import java.awt.Color;

public class Felt_Chance extends Felt{
	
	public Felt_Chance(int feltNr, String tekst, Color bgFarve, Color tekstFarve) {
		feltNavn = tekst;
		this.feltNr = feltNr;
		this.bgFarve = bgFarve;
		this.tekstFarve = tekstFarve;
	}
	
}
