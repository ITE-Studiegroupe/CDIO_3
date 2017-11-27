package monololy_junior;

import java.awt.Color;
import java.util.Arrays;

import monololy_junior.felter.Felt_Forretning;

/**
 * Denne klasse har til formål styre spillerne i spillet.
 * 
 * @author Gruppe 36
 * @category Information expert
 *
 */

public class Spiller {
	private String spillerNavn;
	private int spillerNr;
	private boolean erIFængsel;
	private Felt_Forretning[] ejetFelter = new Felt_Forretning[0];
	private Felt_Forretning[] toEnsFelter;
	private Konto konto;
	private Brik brik;
	private boolean toEns;
	
	public boolean erIFængsel() {
		return erIFængsel;
	}

	public void setErIFængsel(boolean erIFængsel) {
		this.erIFængsel = erIFængsel;
	}

	public int getSpillerNr() {
		return spillerNr;
	}

	public void setSpillerNr(int spillerNr) {
		this.spillerNr = spillerNr;
	}

	public String getSpillerNavn() {
		return spillerNavn;
	}

	public void setSpillerNavn(String spillerNavn) {
		this.spillerNavn = spillerNavn;
	}

	public Brik getBrik() {
		return brik;
	}

	public void setBrik(Brik brik) {
		this.brik = brik;
	}

	public void setKonto(Konto konto) {
		this.konto = konto;
	}

	public Konto getKonto() {
		return konto;
	}
	
	public boolean harToEns() {
		return toEns;
	}
	
	public Felt_Forretning[] getToEnsFelter() {
		return toEnsFelter;
	}
	
	public boolean harPasseretStart() {
		int tidlPlacering = brik.getTidlPlacering();
		int nuvPlacering = brik.getBrikPlacering();
		return (nuvPlacering < tidlPlacering);
	}

	/**
	 * @param Tager i mod et objekt af vores klasse Felt.
	 * Klassen tilFøjFelt bruges, når en spiller har landet på et felt, 
	 * der ikke ejes af nogen. Hvis der ikke er en ejer tilføjes/købes 
	 * feltet af spilleren. Hvis en spiller har et andet felt i forvejen
	 * med samme farve, ændres værdien af den to felter med det dobbelte.
	 * Med klassen Arrays fra java.util bruger vi en metode til at kopiere et array.
	 */
	
	public void tilføjFelt(Felt_Forretning købtFelt) {
		Felt_Forretning ensFelt = checkToEns(købtFelt);
		toEns = (ensFelt != null);
		
		Felt_Forretning[] nytFelt = Arrays.copyOf(ejetFelter, ejetFelter.length + 1);
		nytFelt[nytFelt.length - 1] = købtFelt;
		ejetFelter = nytFelt;
		købtFelt.setEjer(this);
		
		toEnsFelter = new Felt_Forretning[] {købtFelt, ensFelt};
	}
	
	/**
	 * 
	 * @param Tager i mod det felt som købes af spillereren.
	 * Checker om spilleren har to ens felter.
	 * Vi bruger klassen Color til at holde styr på felternes farver.
	 */

	private Felt_Forretning checkToEns(Felt_Forretning købtFelt) {
		for (int i = 1; i < ejetFelter.length; i++) {
			Color farve1 = ejetFelter[i].getBgFarve();
			Color farve2 = købtFelt.getBgFarve();
			if (farve1.getRGB() == farve2.getRGB()) {
				forøgVærdi(ejetFelter[i]);
				forøgVærdi(købtFelt);
				return ejetFelter[i];
			}
		}
		return null;
	}
	
	/**
	 * @param Tager i mod det felt som købes af spillereren.
	 * Forøger værdien af de to felter med samme farve til det dobbelte.
	 */

	private void forøgVærdi(Felt_Forretning købtFelt) {
		int forøget = købtFelt.getPris() * 2;
		købtFelt.setPris(forøget);

	}

}
