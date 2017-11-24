package monololy_junior.felter;

import java.awt.Color;

public class Felt_Fængsel extends Felt{
	private boolean erFængsel;
	
	public Felt_Fængsel(String tekst, boolean erFængsel, Color bgFarve, Color tekstFarve) {
		feltNavn = tekst;
		this.erFængsel = erFængsel;
		this.bgFarve = bgFarve;
		this.tekstFarve = tekstFarve;
	}

	public boolean erFængsel() {
		return erFængsel;
	}

	public void setErFængsel(boolean erFængsel) {
		this.erFængsel = erFængsel;

	}

}
