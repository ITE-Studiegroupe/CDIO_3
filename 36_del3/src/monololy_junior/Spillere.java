package monololy_junior;

import java.awt.Color;

public class Spillere {

	private Spiller[] spillere;
	private Spiller vinder;
	private Spiller taber;
	private boolean spillerHarTabt;
	private int antalSpillere;
	private int nSpillerNr;

	public Spillere (int antal, int startKap ,String[] navne, Color[] farver) {
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
		nSpillerNr = 0;
	}
	
	
	
	public void næsteSpillersTur() {
		nSpillerNr++;
		if (nSpillerNr >= antalSpillere) nSpillerNr = 0;
		if (spillere[nSpillerNr].erIFængsel()) {
			spillere[nSpillerNr].setErIFængsel(false);
			næsteSpillersTur();
		}
	}
	
	public int getNSpillerNr() {
		return nSpillerNr;
	}
	
	public boolean spillerHarTabt() {
		return spillerHarTabt;
	}

	public Spiller getTaber() {
		return taber;
	}


	public void setTaber(Spiller taber) {
		this.taber = taber;
		spillerHarTabt = true;
	}


	public Spiller getSpiller(int indeks) {
		return spillere[indeks];
	}


	public int getAntalSpillere() {
		return antalSpillere;
	}

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
