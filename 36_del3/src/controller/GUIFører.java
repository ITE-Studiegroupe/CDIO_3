package controller;

import java.awt.Color;

import gui_fields.GUI_Car;
import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Refuge;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;
import gui_main.GUI;
import monololy_junior.Brik;
import monololy_junior.Chancekort;
import monololy_junior.Felt;
import monololy_junior.Konto;
import monololy_junior.Spiller;

public class GUIFører {
	private final int[] FRA40TIL24 = new int[] { 0, 1, 1, 2, 2, 3, 4, 4, 5, 5, 6, 7, 7, 8, 8, 9, 10, 10, 11, 11, 12,
			13, 13, 14, 14, 15, 16, 16, 17, 17, 18, 19, 19, 20, 20, 21, 22, 22, 23, 23 };

	private final int[] FRA24TIL40 = new int[] { 0, 2, 4, 5, 7, 9, 10, 12, 14, 15, 17, 19, 20, 22, 24, 25, 27, 29,
			30, 32, 34, 35, 37, 39 };
	
	private GUI_Field[] guiFelter = new GUI_Field[40];
	GUI_Player[] guiSpillere;
	GUI gui;
	
	
	public void skabGUI(Felt[] felter, Chancekort[] kort) {
		skabChanceKort(kort);
		skabFelter(felter);
		
		gui = new GUI(guiFelter);
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
	
	private void  skabChanceKort(Chancekort[] kort) {
		
	}
	
	private void skabFelter(Felt[] felter) {
		
		Felt felt;
		int type;
		int konverteret;
		for (int i = 0; i < guiFelter.length; i++) {
			konverteret = FRA40TIL24[i];
			felt = felter[konverteret];
			type = felt.getFeltType();
			
			switch(type) {
			case 1: //felter hvor der ikke sker noget
				guiFelter[i] = new GUI_Refuge();
				guiFelter[i].setBackGroundColor(felt.getFeltFarve());
				guiFelter[i].setSubText(felt.getFeltNavn());
			break;
			
			case 2: //felter der kan købes eller ejes af nogen
				guiFelter[i] = new GUI_Street(
						felt.getFeltNavn(),
						felt.getVærdi()+"kr.",
						"", 
						felt.getVærdi()+"kr.", 
						felt.getFeltFarve(),
						Color.black);
			break;
			
			case 3: //felter der er chancekort 
				guiFelter[i] = new GUI_Chance(
						"?",
						felt.getFeltNavn(),
						"",
						felt.getFeltFarve(),
						Color.orange);
			break;
			
			case 4: //felter hvor man får penge (start) 
				guiFelter[i] = new GUI_Start(
						felt.getFeltNavn(),
						"modtag 2kr.",
						"",
						felt.getFeltFarve(),
						Color.black);
			break;
			
			}
		}
	}
	
	

}
