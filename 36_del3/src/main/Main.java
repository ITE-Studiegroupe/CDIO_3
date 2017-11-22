package main;

import java.awt.Color;

import controller.GUIFører;
import monololy_junior.Brik;
import monololy_junior.Konto;
import monololy_junior.Plade;
import monololy_junior.Raflebæger;
import monololy_junior.Spiller;

public class Main {



	public static void main(String[] args) {
		int antalSpillere;
		int nuværendeSpiller;
		Plade plade;
		GUIFører guiFører;
		Spiller[] spillere;
		Raflebæger bæger;
		
		plade = new Plade();
		plade.bygPlade();
		GUIFører gui = new GUIFører();
		gui.skabGUI(plade.getFelter());
		int antalspiller = gui.visVælgAntalSpillere();
		spillere = new Spiller[antalspiller];
		
		for (int i = 0; i<spillere.length; i++) {
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
		nuværendeSpiller = 0;
		
		gui.skabSpillere(spillere);
		gui.visKastTerninger(spillere[nuværendeSpiller]);
		
		
			
		}
	}


