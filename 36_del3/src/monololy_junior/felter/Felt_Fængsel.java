package monololy_junior.felter;

import java.awt.Color;

public class Felt_Fængsel extends Felt{
	private boolean erFængsel;
	private String forklaring;
	
	public Felt_Fængsel(String tekst, String forklaring, boolean erFængsel, Color bgFarve, Color tekstFarve) {
		feltNavn = tekst;
		this.forklaring = forklaring;
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

	public String getForklaring() {
		return forklaring;
	}

	public void setForklaring(String forklaring) {
		this.forklaring = forklaring;
	}

}
