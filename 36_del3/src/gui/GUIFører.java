package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import Tekst.TekstSpil;
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;
import monopoly_junior.Brik;
import monopoly_junior.Chancekort;
import monopoly_junior.Konto;
import monopoly_junior.Spiller;
import monopoly_junior.SpillerListe;
import monopoly_junior.felter.Felt;
import monopoly_junior.felter.Felt_Forretning;

/**
 * GUIFører singletonen håndterer og simplificerer kommunikationen med GUI'en.
 * @author Gruppe 36
 */
public class GUIFører {

	private GUI_Field[] guiFelter;
	private GUI_Player[] guiSpillere;
	private GUI gui;
	private static final GUIFører INSTANS = new GUIFører();
	private ArrayList<Color> farver = new ArrayList<Color>(Arrays.asList(Color.BLUE, Color.RED, Color.GREEN, Color.PINK, Color.YELLOW,
			Color.BLACK, Color.WHITE));
	private ArrayList<String> farverStreng = new ArrayList<String>(Arrays.asList("Blå", "Rød", "Grøn", "Pink", "Gul", "Sort", "Hvid"));
	

	/**
	 * Privat konstruktør
	 */
	private GUIFører() {}

	/**
	 * Returnerer GUIFører instansen.
	 * @return INSTANS GUIFører
	 */
	public static GUIFører getInstans() {
		return INSTANS;
	}

	/**
	 * Skaber felterne {@link #skabFelter(int, int, Object) se skabFelter()}
	 * og starter instantierer GUI'en.<br>
	 * <u><b>Kaldes før de andre metoder kan fungere.</b></u>
	 * @param felter Felt[]
	 */
	public void skabGUI(Felt[] felter) {
		skabFelter(felter);
		gui = new GUI(guiFelter);
	}

	/**
	 * Skaber de forskellige typer GUI felter udfra vores Felt underklasser.
	 * @param felter Felt[]
	 */
	private void skabFelter(Felt[] felter) {
		guiFelter = new GUI_Field[felter.length];
		
		for (int i = 0; i < guiFelter.length; i++)
			guiFelter[i] = felter[i].tilGUIFelt();
	}

	/**
	 * Skaber GUI spillerne udfra vores SpillerListe.
	 * @param spillere SpillerListe
	 */
	public void skabSpillere(SpillerListe spillere) {
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

	/**
	 * Viser det givne Chancekort i GUI'en.
	 * @param kort Chancekort
	 */
	public void  visChanceKort(Chancekort kort) {
		String kortTekst = kort.getChanceKortTekst();
		gui.displayChanceCard(kortTekst);
	}

	/**
	 * Viser en terning i GUI'en med det givne antal øjne.
	 * @param t int
	 */
	public void visTerning(int t) {
		gui.setDie(t);
	}

	/**
	 * Viser en personlig (med spillerens navn) vælg farve dialog med en liste brugeren kan vælge farve fra.<br>
	 * Den valgte farve returneres
	 * @param navn String
	 * @return den valgte farve Color
	 */
	public Color visVælgFarve(String navn) {
		String besked = String.format(TekstSpil.TEKSTER[2], navn);
		Color farve;

		String valg = gui.getUserSelection(besked, farverStreng.toArray(new String[0]));

		int i = farverStreng.indexOf(valg);
		farve = farver.get(i);
		
		farverStreng.remove(i);
		farver.remove(i);

		return farve;
	}

	/**
	 * Viser en dialog hvor man kan vælge antallet af spilllere.<br>
	 * Det valgte antal returneres.
	 * @return antal spillere int
	 */
	public int visVælgAntalSpillere() {
		String valg = gui.getUserSelection(TekstSpil.TEKSTER[0], "2","3","4");

		return Integer.parseInt(valg);
	}

	/**
	 * Viser en dialog med et inputfelt man skal taste sit navn i.<br>
	 * Den indtastet navn returneres.
	 * @return input String
	 */
	public String visIndtastNavn() {
		return gui.getUserString(TekstSpil.TEKSTER[1]);
	}

	/**
	 * Viser en dialog som beder spilleren om at kaste terningen.
	 * @param spiller Spiller
	 */
	public void visKastTerninger(Spiller spiller) {
		String navn = spiller.getSpillerNavn();
		String besked = String.format(TekstSpil.TEKSTER[3], navn);

		gui.getUserButtonPressed(besked, "Kast");
	}

	/**
	 * Viser en dialog om spillet er slut med vinderens og tabers navn.
	 * @param spillere SpillerListe
	 */
	public void visSpilSlut(SpillerListe spillere) {
		Spiller taber = spillere.getTaber();
		Spiller vinder = spillere.getVinder();
		String vNavn = vinder.getSpillerNavn();
		int vPenge = vinder.getKonto().getPengeBeholdning();
		String tNavn = taber.getSpillerNavn();
		String besked = String.format(TekstSpil.TEKSTER[5], vNavn, vPenge, tNavn);

		gui.showMessage(besked);
	}

	/**
	 * Rykker spillerens brik i GUI'en
	 * @param spiller Spiller
	 */
	public void rykBrik(Spiller spiller) {

		int nuPlads = spiller.getBrik().getTidlPlacering();
		int nyPlads = spiller.getBrik().getBrikPlacering();
		int spillerNr = spiller.getSpillerNr();
		
		guiFelter[nuPlads].setCar(guiSpillere[spillerNr], false);
		guiFelter[nyPlads].setCar(guiSpillere[spillerNr], true);
	}
	
	/**
	 * Sætter spilleren som ejeren af det felt hans brik står på, i GUI'en.
	 * @param spiller Spiller
	 */
	public void setFeltEjer(Spiller spiller) {
		int feltNr = spiller.getBrik().getBrikPlacering();
		GUI_Street felt = (GUI_Street)guiFelter[feltNr];
		felt.setOwnerName(spiller.getSpillerNavn());
		felt.setBorder(spiller.getBrik().getBrikFarve());
	}
	
	/**
	 * Sætter spillerens beholdning i GUI'en.
	 * @param spillere SpillerListe
	 */
	public void opdaterKontoer(SpillerListe spillere) {
		
		for (int i = 0; i < spillere.getAntalSpillere(); i++) {
			int balance = spillere.getSpiller(i).getKonto().getPengeBeholdning();
			guiSpillere[i].setBalance(balance);
		}
		
	}
	
	/**
	 * Sætter de givne felters pris i GUI'en.
	 * @param felter Felt_Forretning
	 */
	public void opdaterFeltPris(Felt_Forretning[] felter) {
		int feltNr;
		int pris;
		for (int i = 0; i<felter.length; i++) {
			feltNr = felter[i].getFeltNr();
			pris = felter[i].getPris();
			guiFelter[feltNr].setSubText(pris + "kr.");
		}
	}
}
