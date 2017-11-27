package monololy_junior.felter;

import java.awt.Color;

import monololy_junior.Spiller;
/**
 * Denne klasse har til formål holde styr på felterne.
 * 
 * @author Gruppe 36
 * @category Information expert
 *
 */
public class Felt {
	
	
	protected Color bgFarve;
	protected Color tekstFarve;
	protected String feltNavn;
	protected int feltNr;

	
	public int getFeltNr() {
		return feltNr;
	}

	public void setFeltNr(int feltNr) {
		this.feltNr = feltNr;
	}

	public Color getBgFarve() {
		return bgFarve;
	}

	public void setBgFarve(Color bgFarve) {
		this.bgFarve = bgFarve;
	}

	public Color getTekstFarve() {
		return tekstFarve;
	}

	public void setTekstFarve(Color tekstFarve) {
		this.tekstFarve = tekstFarve;
	}

	public String getFeltNavn() {
		return feltNavn;
	}

	public void setFeltNavn(String feltTekst) {
		this.feltNavn = feltTekst;
	}

}
