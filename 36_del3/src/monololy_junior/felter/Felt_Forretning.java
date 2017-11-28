package monololy_junior.felter;

import java.awt.Color;

import monololy_junior.Spiller;

public class Felt_Forretning extends Felt {

	private int pris;
	private Spiller ejer;
	
	public Felt_Forretning(int feltNr, String navn, int pris, Color bgFarve, Color tekstFarve) {
		feltNavn = navn;
		this.feltNr = feltNr;
		this.pris = pris;
		this.bgFarve = bgFarve;
		this.tekstFarve = tekstFarve;
	}
	
	
	public boolean harEjer() {
		return (ejer != null);
	}
	
	public void setEjer(Spiller spiller) {
		if (ejer == null) ejer = spiller;
	}
	
	public Spiller getEjer() {
		return ejer;
	}
	
	public void setPris(int p) {
		pris = p;
	}
	
	public int getPris() {
		return pris;
	}
}
