package spillogik;

import gui.GUIFører;
import monololy_junior.Plade;
import monololy_junior.Spiller;
import monololy_junior.felter.Felt;
import monololy_junior.felter.Felt_Chance;
import monololy_junior.felter.Felt_Forretning;
import monololy_junior.felter.Felt_Fængsel;

public class Spillelogik {

	// Spillogikkens atributter.
	int antalSpillere;
	int nuværendeSpiller;

	private static Plade plade;
	GUIFører guiFører;
	Spiller[] spillere;

	// Opretter nyt plade objekt.
	Plade pladeObjekt = new Plade();

	// Opretter getter.metode til plade.
	public Plade getBygPlade() {
		return plade;
	}

	GUIFører guiObjekt = new GUIFører();
	
	//antalSpillere == return visVælgAntalSpillere

	final static int MIN_POINT = 0;

	public static void CDIO3_logik(int kast, Spiller spiller, Felt felt) {
		
		if (felt instanceof Felt_Forretning) {
			
			Felt_Forretning feltF = (Felt_Forretning)felt;
			
			if (feltF.harEjer()) {
				
				feltF.getEjer().getKonto().indsætPenge(feltF.getPris());
				
				if (!spiller.getKonto().indsætPenge(-feltF.getPris())) {
//					Spiller vinder = null;
//					int max = 0;
//					for (int i = 0; i < antalSpillere; i++) {
//						int penge = spiller.getKonto().getPengeBeholdning();
//						if (penge > max) {
//							max = penge;
//							vinder = spillere[i];
//						}
//					}
//					if (gui.visSpilSlutSpilIgen(vinder, spillere[nSpillerNr])) {
//						// Genstart spil
//					} else
//						System.exit(0);
				}
			} else {
				if (spiller.getKonto().indsætPenge(-feltF.getPris())) {
					spiller.tilføjFelt(feltF);
				} else {

				}
			}
		} else if (felt instanceof Felt_Chance) {
			chancekort = plade.trækChancekort();
			gui.visChanceKort(chancekort);
			if (chancekort.getKortType() == 1) {
				if (!spiller.getKonto().indsætPenge(-chancekort.getVærdi()))
				
			} else if (chancekort.getKortType() == 2) {
				if (spiller.getKonto().indsætPenge(chancekort.getVærdi())) {
				}
			} else if (chancekort.getKortType() == 3) {
				// spillere[nuværendeSpiller].getBrik().rykBrik(chancekort.getVærdi());
				gui.rykBrik(nSpillerNr, chancekort.getVærdi(), spillere[0].getBrik().getBrikPlacering());
				// gui.rykBrik(nuværendeSpiller, felt., placering);
			}
		} else if (felt instanceof Felt_Fængsel) {
			
		}

	}

}
