package monololy_junior.felter;

import java.awt.Color;

import monololy_junior.Spiller;
/**
 * Klassen: Felt
 * @author Gruppe 36
 * @category Information expert
 * Denne klasse har til formål holde styr på felterne.
 */
public class Felt {
	
	
	private Color bgFarve;
	private Color tekstFarve;
	private String feltNavn;
	private int feltNr;

	public Felt(int feltNr, String feltNavn, Color bgFarve, Color tekstFarve) {
		this.feltNr = feltNr;
		this.feltNavn = feltNavn;
		this.bgFarve = bgFarve;
		this.tekstFarve = tekstFarve;
	}
	
/**
 * Metoden returnerer feltNr
 * @return feltNr
 */
	public int getFeltNr() {
		return feltNr;
	}
	
/**
 * Metoden sætter værdien af feltNr
 * @param feltNr
 */
	public void setFeltNr(int feltNr) {
		this.feltNr = feltNr;
	}

/**
 * Metoden returnerer bgFarve
 * @return bgFarve
 */
	public Color getBgFarve() {
		return bgFarve;
	}

/**
 * Metoden sætter bgFarve	
 * @param bgFarve
 */
	public void setBgFarve(Color bgFarve) {
		this.bgFarve = bgFarve;
	}

/**
 * Metoden returnerer tekstFarve
 * @return tekstFarve
 */
	public Color getTekstFarve() {
		return tekstFarve;
	}

/**
 * Metoden sætter tekstFarve	
 * @param tekstFarve
 */
	public void setTekstFarve(Color tekstFarve) {
		this.tekstFarve = tekstFarve;
	}

/**
 * Metoden returnerer feltNavn	
 * @return feltNavn
 */
	public String getFeltNavn() {
		return feltNavn;
	}

/**
 * Metoden sætter feltTekst	
 * @param feltTekst
 */
	public void setFeltNavn(String feltTekst) {
		this.feltNavn = feltTekst;
	}

}
