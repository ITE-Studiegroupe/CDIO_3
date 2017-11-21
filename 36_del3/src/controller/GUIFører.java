package controller;

import java.awt.Color;

import gui_fields.GUI_Car;
import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;
import gui_fields.GUI_Jail;
import gui_fields.GUI_Player;
import gui_fields.GUI_Refuge;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;
import gui_main.GUI;
import monololy_junior.Brik;
import monololy_junior.Chancekort;
import monololy_junior.Konto;
import monololy_junior.Spiller;
import monololy_junior.felter.Felt;
import monololy_junior.felter.Felt_Chance;
import monololy_junior.felter.Felt_Forretning;
import monololy_junior.felter.Felt_Fængsel;
import monololy_junior.felter.Felt_Start;

public class GUIFører {
	private final int[] FRA40TIL24 = new int[] { 0, 1, 1, 2, 2, 3, 4, 4, 5, 5, 6, 7, 7, 8, 8, 9, 10, 10, 11, 11, 12,
			13, 13, 14, 14, 15, 16, 16, 17, 17, 18, 19, 19, 20, 20, 21, 22, 22, 23, 23 };

	private final int[] FRA24TIL40 = new int[] { 0, 2, 4, 5, 7, 9, 10, 12, 14, 15, 17, 19, 20, 22, 24, 25, 27, 29,
			30, 32, 34, 35, 37, 39 };

	private GUI_Field[] guiFelter = new GUI_Field[40];
	GUI_Player[] guiSpillere;
	GUI gui;


	public void skabGUI(Felt[] felter) {
		skabFelter(felter);

		gui = new GUI(guiFelter);
	}

	private void skabFelter(Felt[] felter) {

		Felt felt;
		int konverteret;
		for (int i = 0; i < guiFelter.length; i++) {
			
			konverteret = FRA40TIL24[i];
			felt = felter[konverteret];
			
			if (felt instanceof Felt_Forretning) {
				guiFelter[i] = new GUI_Street(
						felt.getFeltNavn(),
						((Felt_Forretning) felt).getPris()+"kr.",
						"", 
						((Felt_Forretning) felt).getPris()+"kr.", 
						felt.getBgFarve(),
						felt.getTekstFarve());
			}
			else if (felt instanceof Felt_Chance) {
				guiFelter[i] = new GUI_Chance(
						"?",
						felt.getFeltNavn(),
						"",
						felt.getBgFarve(),
						felt.getTekstFarve());
			}
			else if (felt instanceof Felt_Fængsel) {
				guiFelter[i] = new GUI_Jail();
				guiFelter[i].setSubText(felt.getFeltNavn());
				guiFelter[i].setBackGroundColor(felt.getBgFarve());
				guiFelter[i].setForeGroundColor(felt.getTekstFarve());
				guiFelter[i].setDescription(((Felt_Fængsel)felt).getForklaring());
			}
			else if (felt instanceof Felt_Start) {
				guiFelter[i] = new GUI_Start(
						felt.getFeltNavn(),
						"modtag "+((Felt_Start)felt).getPræmie()+"kr.",
						"",
						felt.getBgFarve(),
						felt.getTekstFarve());
			}
			else {
				guiFelter[i] = new GUI_Refuge();
				guiFelter[i].setBackGroundColor(felt.getBgFarve());
				guiFelter[i].setForeGroundColor(felt.getTekstFarve());
				guiFelter[i].setSubText(felt.getFeltNavn());
			}
		}
	}
	
	public void skabSpillere(Spiller[] spillere) {
		int antalSpillere = spillere.length;
		/////////////////////
		guiSpillere = new GUI_Player[antalSpillere]; ///Kunne måske undlades??
		//////////////////7

		Konto spillerKonto;
		Brik spillerBrik;
		GUI_Car guiBrik;
		for (int i = 0; i < antalSpillere; i++) {
			spillerKonto = spillere[i].getKonto();
			spillerBrik = spillere[i].getBrik();
			guiBrik = new GUI_Car();
			guiBrik.setPrimaryColor(spillerBrik.getBrikFarve());

			guiSpillere[i] = new GUI_Player(spillere[i].getSpillerNavn(), 
					spillerKonto.getPengeBeholdning(), 
					guiBrik);

			gui.addPlayer(guiSpillere[i]);
			guiFelter[0].setCar(guiSpillere[i], true);
		}

	}

	public void  visChanceKort(Chancekort kort) {
		String kortTekst = kort.getChanceKortTekst();
		gui.displayChanceCard(kortTekst);
	}
	
	public void visTerninger(int t1, int t2) {
		gui.setDice(t1, t2);
	}
	
	public Color visVælgFarve(Spiller spiller) {
		String navn = spiller.getSpillerNavn();
		String besked = navn +", vælg din bils farve.";
		String[] farverStreng = new String[] {"Blå", "Rød", "Grøn", "Pink", "Gul", "Sort", "Hvid"};
		Color[] farver = new Color[] {Color.BLUE, Color.RED, Color.GREEN, Color.PINK, Color.YELLOW,
				Color.BLACK, Color.WHITE};
		Color farve = Color.WHITE;
		
		String valg = gui.getUserSelection(besked, 
				farverStreng[0],
				farverStreng[1],
				farverStreng[2],
				farverStreng[3],
				farverStreng[4],
				farverStreng[5],
				farverStreng[6]);
		
		for (int i = 0; i < farver.length; i++) {
			if (valg.equals(farverStreng[i])) {
				farve = farver[i];
				break;
			}
		}
		
		
		return farve;
	}
	
	public int visVælgAntalSpillere() {
		String besked = "Vælg antal spillere.";

		return Integer.parseInt(gui.getUserSelection(besked, "2","3","4"));
	}
	
	public String visIndtastNavn() {
		String besked = "Indtast dit navn";
		
		return gui.getUserString(besked);
	}
	
	public void visKastTerninger(Spiller spiller) {
		String navn = spiller.getSpillerNavn();
		String besked = navn+", din tur til at kaste";
		
		gui.getUserButtonPressed(besked, "Kast");
	}
}
