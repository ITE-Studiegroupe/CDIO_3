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
 * Klasse: Controller
 * @author Gruppe_36
 * Klassen har til formål at kontrollere spillet
 */
public class Controller {

	private int antalSpillere;
	private Plade plade;
	private SpillerListe spillere;
	private Spiller spiller;
	private GUIFører gui = GUIFører.getInstans();

	public void spilKontrol() {

		plade = new Plade();
		plade.bygPlade();

		gui.skabGUI(plade.getFelter());

		antalSpillere = gui.visVælgAntalSpillere(); //Returnerer antallet af spillere brugeren har valgt

		String[] navne = new String[antalSpillere];
		Color[] farver = new Color[antalSpillere];
		for (int i = 0; i < antalSpillere; i++) {
			navne[i] = gui.visIndtastNavn();
			if (navne[i].equals("")) navne[i] = "Spiller "+(i+1); //Opretter spiller som navn, hvis brugeren ikke har 
			farver[i] = gui.visVælgFarve(navne[i]);
		}
		
		spillere = new SpillerListe(antalSpillere, 30, navne, farver); //Sætter parameter fra SpillerLsite
		gui.skabSpillere(spillere);

		//Kører så længe ingen spillere har tabt
		while (!spillere.spillerHarTabt()) {

			spiller = spillere.getSpiller(spillere.getNuvSpillerNr());

			gui.visKastTerninger(spiller);

			int kast = spillere.kastTerning();
			gui.visTerning(kast);
			spiller.getBrik().rykBrik(kast);		
			gui.rykBrik(spiller);

			Spillelogik.CDIO3_logik(spillere, plade);//Kalder spillelogik

			gui.opdaterKontoer(spillere);
			spillere.næsteSpillersTur();
		}
		
		//Vises når en spiller har tabt
		gui.visSpilSlut(spillere);
		System.exit(0);

	}
}
