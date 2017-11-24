package main;

import java.awt.Color;

import gui.GUIFører;
import monololy_junior.Brik;
import monololy_junior.Chancekort;
import monololy_junior.Konto;
import monololy_junior.Plade;
import monololy_junior.Spiller;
import monololy_junior.Spillere;
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
		Spillere spillere;
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

		String[] navne = new String[antalSpillere];
		Color[] farver = new Color[antalSpillere];
		for (int i = 0; i < antalSpillere; i++) {
			navne[i] = gui.visIndtastNavn();
			farver[i] = gui.visVælgFarve(navne[i]);
		}
		spillere = new Spillere(antalSpillere, 30, navne, farver);
		gui.skabSpillere(spillere);

		while (!spillere.spillerHarTabt()) {

			spiller = spillere.getSpiller(spillere.getNSpillerNr());
			
			gui.visKastTerninger(spiller);
			
			int kast = terning.kastTerning();
			gui.visTerning(kast);
			spiller.getBrik().rykBrik(kast);		
			gui.rykBrik(spiller);
			
			Spillelogik.CDIO3_logik(kast, spillere, plade);
			
			gui.opdaterKontoer(spillere);
			spillere.næsteSpillersTur();
		}
		if (!gui.visSpilSlutSpilIgen(spillere))
			System.exit(0);

	}

}
