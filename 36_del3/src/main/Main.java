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
import spillogik.Spillelogik;

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
		GUIFører gui = GUIFører.getInstans();
		gui.skabGUI(felter);
		antalSpillere = gui.visVælgAntalSpillere();
		spillere = new Spiller[antalSpillere];

		for (int i = 0; i < spillere.length; i++) {
			String returNavn = gui.visIndtastNavn();
			spillere[i] = new Spiller();
			spillere[i].setSpillerNavn(returNavn);
			spillere[i].setSpillerNr(i);
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
			gui.visTerning(kast);
			int feltNr = spiller.getBrik().getBrikPlacering();
			spiller.getBrik().rykBrik(kast);		
			gui.rykBrik(spiller, feltNr);
			
			Spillelogik.CDIO3_logik(kast, spiller, plade);

			// nuværendeSpiller++;
			// if(nuværendeSpiller>=antalSpillere) {
			// nuværendeSpiller= nuværendeSpiller-antalSpillere;
			// }

			nSpillerNr++;
			if (nSpillerNr >= antalSpillere) nSpillerNr = 0;
		}

	}

}
