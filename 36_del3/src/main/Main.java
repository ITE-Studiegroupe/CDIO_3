package main;

import java.awt.Color;

import gui.GUIFører;
import monololy_junior.Brik;
import monololy_junior.Chancekort;
import monololy_junior.Konto;
import monololy_junior.Plade;
import monololy_junior.Spiller;
import monololy_junior.Terning;
import monololy_junior.felter.Felt;
import monololy_junior.felter.Felt_Chance;
import monololy_junior.felter.Felt_Forretning;
import monololy_junior.felter.Felt_Fængsel;
import monololy_junior.felter.Felt_Helle;
import monololy_junior.felter.Felt_Start;

public class Main {

	public static void main(String[] args) {
		int antalSpillere;
		int nSpillerNr;
		Plade plade;
		Spiller[] spillere;
		Spiller spiller;
		Terning terning = new Terning();
		Chancekort chancekort = new Chancekort();
		Felt[] felter;

		plade = new Plade();
		plade.bygPlade();
		felter = plade.getFelter();
		GUIFører gui = new GUIFører();
		gui.skabGUI(felter);
		antalSpillere = gui.visVælgAntalSpillere();
		spillere = new Spiller[antalSpillere];

		for (int i = 0; i < spillere.length; i++) {
			String returNavn = gui.visIndtastNavn();
			spillere[i] = new Spiller();
			spillere[i].setSpillerNavn(returNavn);
			Brik brik = new Brik();
			Color farve = gui.visVælgFarve(spillere[i]);
			brik.setBrikFarve(farve);
			spillere[i].setBrik(brik);
			Konto konto = new Konto();
			konto.setPengeBeholdning(30);
			spillere[i].setKonto(konto);
		}
		nSpillerNr = 0;
		gui.skabSpillere(spillere);

		while (true) {

			spiller = spillere[nSpillerNr];
			
			gui.visKastTerninger(spiller);
			
			int kast = terning.kastTerning();
			int feltNr = spiller.getBrik().getBrikPlacering();
			gui.visTerning(kast);
			spiller.getBrik().rykBrik(kast);
			int nytFeltNr = spiller.getBrik().getBrikPlacering();
			gui.rykBrik(nSpillerNr, nytFeltNr, feltNr);
			
			

			// nuværendeSpiller++;
			// if(nuværendeSpiller>=antalSpillere) {
			// nuværendeSpiller= nuværendeSpiller-antalSpillere;
			// }

		}

	}

}
