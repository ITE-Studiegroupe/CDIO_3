package spillogik;

import gui.GUIFører;
import monololy_junior.Brik;
import monololy_junior.Chancekort;
import monololy_junior.Konto;
import monololy_junior.Plade;
import monololy_junior.Spiller;
import monololy_junior.SpillerListe;
import monololy_junior.felter.Felt;
import monololy_junior.felter.Felt_Chance;
import monololy_junior.felter.Felt_Forretning;
import monololy_junior.felter.Felt_Fængsel;
import monololy_junior.felter.Felt_Start;

public class Spillelogik {

	// Spillogikkens atributter.
	private static GUIFører gui = GUIFører.getInstans();
	private static Felt felt;
	private static Konto konto;
	private static Brik brik;

	public static void CDIO3_logik(int kast, SpillerListe spillere, Plade plade) {

		Spiller spiller = spillere.getSpiller(spillere.getNuvSpillerNr());
		brik = spiller.getBrik();
		int feltNr = brik.getBrikPlacering();
		felt = plade.getFelter()[feltNr];
		konto = spiller.getKonto();

		if (felt instanceof Felt_Forretning) {

			Felt_Forretning feltF = (Felt_Forretning) felt;
			int pris = feltF.getPris();
			
			if (feltF.harEjer()) {
	
				feltF.getEjer().getKonto().indsætPenge(pris);

				if (!konto.indsætPenge(-pris)) {
					spillere.setTaber(spiller);
				}
			} 
			else {
				gui.setFeltEjer(spiller);
				if (konto.indsætPenge(-pris)) {
					spiller.tilføjFelt(feltF);
				} 
				else {
					spillere.setTaber(spiller);
				}
			}
		} 
		else if (felt instanceof Felt_Chance) {
			Chancekort chancekort = plade.trækChancekort();
			int v = chancekort.getVærdi();
			gui.visChanceKort(chancekort);
			
			int p = 1;
			switch(chancekort.getKortType()) {
			case 1:
				p*=-1; //hvis der skal trækkes penge skal p være i minus
				
			case 2:
				if (!konto.indsætPenge(v*p)) {
					spillere.setTaber(spiller);
				}
				break;
				
			case 3:
				spiller.getBrik().setBrikPlacering(v);
				gui.rykBrik(spiller);
			}
		} 
		else if (felt instanceof Felt_Fængsel) {
			if (!((Felt_Fængsel)felt).erFængsel()) {
				brik.setBrikPlacering(plade.FÆNGSEL);
				gui.rykBrik(spiller);
				spiller.setErIFængsel(true);
			}
		}
		else if (felt instanceof Felt_Start) {
			
		}
		else {
			
		}

	}

}
