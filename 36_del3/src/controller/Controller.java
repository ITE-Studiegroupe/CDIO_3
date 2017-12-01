package controller;

import java.awt.Color;
import java.util.ArrayList;

import gui.GUIFører;
import monopoly_junior.Plade;
import monopoly_junior.Spiller;
import monopoly_junior.SpillerListe;
import monopoly_junior.Terning;
import monopoly_junior.felter.Felt;
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

	public void spilKontrol() {

		plade = new Plade(); //laver plade objekt
		plade.bygPlade();

		gui.skabGUI(plade.getFelter());

		antalSpillere = gui.visVælgAntalSpillere();

		ArrayList<String> navne = new ArrayList<String>();;
		Color[] farver = new Color[antalSpillere];
		for (int i = 0; i < antalSpillere; i++) {
			String navn = gui.visIndtastNavn();
			if (navn.equals("")) navn = "Spiller "+(i+1);
			else if (navne.contains(navn)) navn += " "+(i+1);
			navne.add(navn);
			
			farver[i] = gui.visVælgFarve(navn);
		}	
		spillere = new SpillerListe(antalSpillere, 20, navne.toArray(new String[0]), farver);
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
