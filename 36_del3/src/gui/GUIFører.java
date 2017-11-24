package gui;

import java.awt.Color;

import Tekst.TekstSpil;
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
import monololy_junior.Spillere;
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
	private GUI_Player[] guiSpillere;
	private GUI gui;
	private static final GUIFører INSTANS = new GUIFører();

	private GUIFører() {}

	public static GUIFører getInstans() {
		return INSTANS;
	}


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

	public void skabSpillere(Spillere spillere) {
		int antalSpillere = spillere.getAntalSpillere();
		guiSpillere = new GUI_Player[antalSpillere];

		Konto spillerKonto;
		Brik spillerBrik;
		GUI_Car guiBrik;
		for (int i = 0; i < antalSpillere; i++) {
			spillerKonto = spillere.getSpiller(i).getKonto();
			spillerBrik = spillere.getSpiller(i).getBrik();
			guiBrik = new GUI_Car();
			guiBrik.setPrimaryColor(spillerBrik.getBrikFarve());

			guiSpillere[i] = new GUI_Player(spillere.getSpiller(i).getSpillerNavn(), 
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

	public void visTerning(int t) {
		gui.setDie(t);
	}

	public Color visVælgFarve(String navn) {
		String besked = String.format(TekstSpil.TEKSTER[2], navn);
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
		String valg = gui.getUserSelection(TekstSpil.TEKSTER[0], "2","3","4");

		return Integer.parseInt(valg);
	}

	public String visIndtastNavn() {
		return gui.getUserString(TekstSpil.TEKSTER[1]);
	}

	public void visKastTerninger(Spiller spiller) {
		String navn = spiller.getSpillerNavn();
		String besked = String.format(TekstSpil.TEKSTER[3], navn);

		gui.getUserButtonPressed(besked, "Kast");
	}

	public void visBesked(String besked) {
		gui.showMessage(besked);
	}

	public void visSpilSlut(Spillere spillere) {
		Spiller taber = spillere.getTaber();
		Spiller vinder = spillere.getVinder();
		String vNavn = vinder.getSpillerNavn();
		int vPenge = vinder.getKonto().getPengeBeholdning();
		String tNavn = taber.getSpillerNavn();
		String besked = String.format(TekstSpil.TEKSTER[5], vNavn, vPenge, tNavn);

		gui.showMessage(besked);
	}

	public void rykBrik(Spiller spiller) {

		int nuPlads = FRA24TIL40[spiller.getBrik().getTidlPlacering()];
		int nyPlads = FRA24TIL40[spiller.getBrik().getBrikPlacering()];
		int spillerNr = spiller.getSpillerNr();
		
		guiFelter[nuPlads].setCar(guiSpillere[spillerNr], false);
		guiFelter[nyPlads].setCar(guiSpillere[spillerNr], true);
	}
	
	public void setFeltEjer(Spiller spiller) {
		int feltNr = FRA24TIL40[spiller.getBrik().getBrikPlacering()];
		GUI_Street felt = (GUI_Street)guiFelter[feltNr];
		felt.setOwnerName(spiller.getSpillerNavn());
		felt.setBorder(spiller.getBrik().getBrikFarve());
	}
	
	public void opdaterKontoer(Spillere spillere) {
		
		for (int i = 0; i < spillere.getAntalSpillere(); i++) {
			int balance = spillere.getSpiller(i).getKonto().getPengeBeholdning();
			guiSpillere[i].setBalance(balance);
		}
		
	}
}
