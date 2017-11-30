package monololy_junior;

import java.awt.Color;

/**
 * Klasse: SpillerListe
 * @author Gruppe_36
 * Klassen holder styr på de forskellige spillere i spillet
 */

public class SpillerListe {

	private Spiller[] spillere;
	private Spiller vinder;
	private Spiller taber;
	private Terning terning;
	private boolean spillerHarTabt;
	private int antalSpillere;
	private int nuvSpillerNr;

/**
 * Skaber og opretter antal spillere
 * Opretter start kapital, navn og farve på brik
 * 
 * @param antal
 * @param startKap
 * @param navne
 * @param farver
 */
	public SpillerListe (int antal, int startKap ,String[] navne, Color[] farver) {
		spillere = new Spiller[antal];
		for (int i = 0; i < antal; i++) {
			spillere[i] = new Spiller();
			spillere[i].setSpillerNavn(navne[i]);
			spillere[i].setSpillerNr(i);
			Brik brik = new Brik();
			brik.setBrikFarve(farver[i]);
			spillere[i].setBrik(brik);
			Konto konto = new Konto();
			konto.setPengeBeholdning(startKap);
			spillere[i].setKonto(konto);
		}
		antalSpillere = antal;
		spillerHarTabt = false;
		nuvSpillerNr = 0;
		terning = new Terning();
	}
	
/**
 * Returnerer værdien af terninge kast
 * @return terning.kastTerning();
 */
	
	public int kastTerning() {
		return terning.kastTerning();
	}
	
/**
 * Kontrollerer hvilken spillers tur det er, hvis nuværende spiller er i fængsel springes vedkommende over	
 */
	public void næsteSpillersTur() {
		nuvSpillerNr++;
		if (nuvSpillerNr >= antalSpillere) nuvSpillerNr = 0;
		if (spillere[nuvSpillerNr].erIFængsel()) {
			spillere[nuvSpillerNr].setErIFængsel(false);
			næsteSpillersTur();
		}
	}
	
/**
 * Returnerer nuværende spillernummer	
 * @return nuvSpillerNr
 */
	public int getNuvSpillerNr() {
		return nuvSpillerNr;
	}
	
/**
 * 	Returnerer true/false om en spiller har tabt
 * @return spillerHarTabt
 */
	public boolean spillerHarTabt() {
		return spillerHarTabt;
	}

/**
 * 	Returnerer den spiller der har tabt
 * @return taber
 */
	public Spiller getTaber() {
		return taber;
	}

/**
 * Sætter en spiller som taber, hvis vedkommende har tabt
 * @param taber
 */
	public void setTaber(Spiller taber) {
		this.taber = taber;
		spillerHarTabt = true;
	}

/**
 * Returnerer den spiller på index der er givet
 * @param indeks
 * @return spillere[indeks]
 */
	public Spiller getSpiller(int indeks) {
		return spillere[indeks];
	}

/**
 * Returnerer antal spillere
 * @return
 */
	public int getAntalSpillere() {
		return antalSpillere;
	}

/**
 * 	Returnerer den spiller med flest, ved at sammenligne pengebeholdning
 * @return vinder
 */
	public Spiller getVinder() {
		int max = 0;
		for (int i = 0; i < antalSpillere; i++) {
			int penge = spillere[i].getKonto().getPengeBeholdning();
			if (penge > max) {
				max = penge;
				vinder = spillere[i];
		}
		}
		return vinder;
	}
}
