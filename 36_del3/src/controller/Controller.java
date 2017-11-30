package controller;

import java.awt.Color;

import gui.GUIFører;
import monololy_junior.Plade;
import monololy_junior.Spiller;
import monololy_junior.SpillerListe;
import monololy_junior.Terning;
import monololy_junior.felter.Felt;
import spillogik.Spillelogik;
/**
 * Controller klassen har til formål at holde spillet i gang, og sørger for spillernes interaktion med systemet. 
 * Antal spillere vælges, spillernes navne skrives ind og spillere vælger farve. 
 * @author Gruppe 36
 *
 */
public class Controller {
	
	private int antalSpillere;
	private Plade plade;
	private SpillerListe spillere;
	private Spiller spiller;
	private GUIFører gui = GUIFører.getInstans();
	private Felt[] felter;

	public void spilKontrol() {

		plade = new Plade(); //laver plade objekt
		plade.bygPlade();
		felter = plade.getFelter();

		gui.skabGUI(felter);

		antalSpillere = gui.visVælgAntalSpillere();

		String[] navne = new String[antalSpillere];
		Color[] farver = new Color[antalSpillere];
		for (int i = 0; i < antalSpillere; i++) {
			navne[i] = gui.visIndtastNavn();
			if (navne[i].equals("")) navne[i] = "Spiller "+(i+1);
			farver[i] = gui.visVælgFarve(navne[i]);
		}	
		spillere = new SpillerListe(antalSpillere, 30, navne, farver);
		gui.skabSpillere(spillere);

		while (!spillere.spillerHarTabt()) {

			spiller = spillere.getSpiller(spillere.getNuvSpillerNr());

			gui.visKastTerninger(spiller);

			int kast = spillere.kastTerning();
			gui.visTerning(kast);
			spiller.getBrik().rykBrik(kast);		
			gui.rykBrik(spiller);

			Spillelogik.CDIO3_logik(spillere, plade);

			gui.opdaterKontoer(spillere);
			spillere.næsteSpillersTur();
		}
		gui.visSpilSlut(spillere);
		System.exit(0);

	}
}
