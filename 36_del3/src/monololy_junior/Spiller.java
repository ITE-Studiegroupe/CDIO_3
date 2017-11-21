package monololy_junior;

import java.awt.Color;
import java.util.Arrays;

/**
 * Denne klasse har til formål styre spillerne i spillet.
 * 
 * @author Gruppe 36
 * @category Information expert
 *
 */

public class Spiller {
	private String spillerNavn;
	private Felt[] ejetFelter;
	private Konto konto;
	private Brik brik;

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

	/**
	 * @param Tager i mod et objekt af vores klasse Felt.
	 * Klassen tilFøjFelt bruges, når en spiller har landet på et felt, 
	 * der ikke ejes af nogen. Hvis der ikke er en ejer tilføjes/købes 
	 * feltet af spilleren. Hvis en spiller har et andet felt i forvejen
	 * med samme farve, ændres værdien af den to felter med det dobbelte.
	 */
	
	public void tilføjFelt(Felt spillerFelt) {
		checkToEns(spillerFelt);
		Felt[] nytFelt = Arrays.copyOf(ejetFelter, ejetFelter.length + 1);
		nytFelt[nytFelt.length - 1] = spillerFelt;
		ejetFelter = nytFelt;
	}
	
	/**
	 * 
	 * @param Tager i mod det felt som købes af spillereren.
	 * Checker om spilleren har to ens felter.
	 */

	private void checkToEns(Felt købtFelt) {
		for (int i = 1; i < ejetFelter.length; i++) {
			Color farve1 = ejetFelter[i].getFeltFarve();
			Color farve2 = købtFelt.getFeltFarve();
			if (farve1.getRGB() == farve2.getRGB()) {
				forøgVærdi(ejetFelter[i]);
				forøgVærdi(købtFelt);
			}
		}
	}
	
	/**
	 * @param Tager i mod det felt som købes af spillereren.
	 * Forøger værdien af de to felter med samme farve til det dobbelte.
	 */

	private void forøgVærdi(Felt købtFelt) {
		int forøget = købtFelt.getVærdi() * 2;
		købtFelt.setVærdi(forøget);

	}

}
