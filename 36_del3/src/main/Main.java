package main;

import java.awt.Color;

import controller.GUIFører;
import monololy_junior.Brik;
import monololy_junior.Chancekort;
import monololy_junior.Konto;
import monololy_junior.Plade;
import monololy_junior.Raflebæger;
import monololy_junior.Spiller;
import monololy_junior.felter.Felt;
import monololy_junior.felter.Felt_Chance;
import monololy_junior.felter.Felt_Forretning;

public class Main {

	public static void main(String[] args) {
		int antalSpillere;
		int nuværendeSpiller;
		Plade plade;
		Spiller[] spillere;
		Raflebæger bæger;
		Chancekort chancekort = new Chancekort();

		plade = new Plade();
		plade.bygPlade();
		GUIFører gui = new GUIFører();
		gui.skabGUI(plade.getFelter());
		antalSpillere = gui.visVælgAntalSpillere();
		spillere = new Spiller[antalSpillere];

		for (int i = 0; i < spillere.length; i++) {
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
		bæger = new Raflebæger();

		while (true) {

			gui.visKastTerninger(spillere[nuværendeSpiller]);
			int terning1 = bæger.getSumt1();
			int terning2 = bæger.getSumT2();
			gui.visTerninger(terning1, terning2);
			gui.rykBrik(nuværendeSpiller, terning1 + terning2);
			spillere[nuværendeSpiller].getBrik().setBrikPlacering(terning1 + terning2);
			Felt[] felter = plade.getFelter();
			Felt felt = felter[terning1 + terning2];

			if (felt instanceof Felt_Forretning) {
				if (((Felt_Forretning) felt).harEjer()) {
					((Felt_Forretning) felt).getEjer().getKonto().indsætPenge(-((Felt_Forretning) felt).getPris());
					if(spillere[nuværendeSpiller].getKonto().indsætPenge(-((Felt_Forretning) felt).getPris())) {
						
					}
									}
				else {
					if (spillere[nuværendeSpiller].getKonto().indsætPenge(-((Felt_Forretning) felt).getPris())) {
					spillere[nuværendeSpiller].tilføjFelt(((Felt_Forretning) felt));
					((Felt_Forretning) felt).setEjer(spillere[nuværendeSpiller]);
					}
					else {
						
					}
				}
			}
			else if (felt instanceof Felt_Chance) {
				chancekort = plade.trækChancekort();
				gui.visChanceKort(chancekort);
				if(chancekort.getKortType()== 1) {
					if(spillere[nuværendeSpiller].getKonto().indsætPenge(-chancekort.getVærdi()));
					
					}
				else if(chancekort.getKortType()==2) {
					if(spillere[nuværendeSpiller].getKonto().indsætPenge(chancekort.getVærdi())) {				
					}
					else {
						
					}
				}
				
				
			}

		}

	}
}
