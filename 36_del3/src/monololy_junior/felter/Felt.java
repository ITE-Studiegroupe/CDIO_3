package monololy_junior.felter;

import java.awt.Color;

import monololy_junior.Spiller;
/**
 * Klassen: Felt
 * @author Gruppe 36
 * @category Information expert
 * Denne klasse har til formål holde styr på felterne.
 */
public abstract class Felt {
	
	
	private Color bgFarve;
	private Color tekstFarve;
	private String feltNavn;

	public Felt(String feltNavn, Color bgFarve, Color tekstFarve) {
		this.feltNavn = feltNavn;
		this.bgFarve = bgFarve;
		this.tekstFarve = tekstFarve;
	}
	

/**
 * Metoden returnerer bgFarve
 * @return bgFarve
 */
	public Color getBgFarve() {
		return bgFarve;
	}


/**
 * Metoden returnerer tekstFarve
 * @return tekstFarve
 */
	public Color getTekstFarve() {
		return tekstFarve;
	}


/**
 * Metoden returnerer feltNavn	
 * @return feltNavn
 */
	public String getFeltNavn() {
		return feltNavn;
	}

}
