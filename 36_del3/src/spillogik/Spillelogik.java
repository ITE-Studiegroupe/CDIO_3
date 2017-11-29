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

/**
 * Klasse: Spillelogik
 * @author Gruppe_36
 * Klassen har til formål at styre spillets regler
 */
public class Spillelogik {


/**
 * Metode der tager	imod et array af spillere og en plade
 * @param spillere
 * @param plade
 */
	public static void CDIO3_logik(SpillerListe spillere, Plade plade) {

/**
 * Finder ud af hvilken spiller det er 		
 */
		GUIFører gui = GUIFører.getInstans();
		Spiller spiller = spillere.getSpiller(spillere.getNuvSpillerNr());

/**
 * Brikkens placering lægges i en variabel feltNr
 * Finder det felt med det nummer		
 */
		Brik brik = spiller.getBrik();
		int feltNr = brik.getBrikPlacering();
		Felt felt = plade.getFelter()[feltNr];
		Konto konto = spiller.getKonto();

/**
 * Kontrollerer hvilket felt spilleren lander på, forretning
 * Hvis feltet har en ejer, skal spilleren betale ejeren
 * Kontrollerer om spilleren kan betale, hvis ikke har vedkommende tabt	
 */
		if (felt instanceof Felt_Forretning) {

			Felt_Forretning feltF = (Felt_Forretning) felt;
			int pris = feltF.getPris();
			
			if (feltF.harEjer()) {
	
				feltF.getEjer().getKonto().indsætPenge(pris);

				if (!konto.indsætPenge(-pris)) {
					spillere.setTaber(spiller);
				}
			} 
			
/**
 * Hvis feltet ikke har en ejer
 * Køber spilleren feltet
 * Kontrollerer om ejeren har to ens, hvis true, sættes prisen op
 * Hvis spilleren ikke har råd til feltet, taber spilleren			
 */
			else {
				gui.setFeltEjer(spiller);
				if (konto.indsætPenge(-pris)) {
					spiller.tilføjFelt(feltF);
					if (spiller.harToEns()) gui.opdaterFeltPris(spiller.getToEnsFelter());
				} 
				else {
					spillere.setTaber(spiller);
				}
			}
		} 
		
/**
 * Kontrollerer hvilket felt spilleren lander på, Chancekort
 * Spilleren trækker et chancekort
 * 		
 */
		else if (felt instanceof Felt_Chance) {
			Chancekort chancekort = plade.trækChancekort();
			int v = chancekort.getVærdi();
			gui.visChanceKort(chancekort);

/**
 * Kigger på hvilken slags chancekort spilleren trækker	
 * case1: Spiller skal betale penge		
 */
			int p = 1;
			switch(chancekort.getKortType()) {
			case 1:
				p*=-1; //hvis der skal trækkes penge skal p være i minus
/**
 * Spiller får penge				
 */
			case 2:
				if (!konto.indsætPenge(v*p)) {
					spillere.setTaber(spiller);
				}
				break;
/**
 * Spiller skal rykke til en anden placering				
 */
			case 3:
				spiller.getBrik().setBrikPlacering(v);
				gui.rykBrik(spiller);
				CDIO3_logik(spillere, plade);
			}
		}
		
/**
 * Kontrollerer hvilket felt spilleren lander på, fængsel
 * Den tjekker om man lander på "besøg i fængsel", og gør man det, sker der intet. Hvis man derimod lander på "gå i fængsel"
 * så rykker den spilleren, hen til fængslet. 		
 */
		else if (felt instanceof Felt_Fængsel) {
			if (!((Felt_Fængsel)felt).erFængsel()) {
				brik.setBrikPlacering(plade.FÆNGSEL);
				gui.rykBrik(spiller);
				spiller.setErIFængsel(true);
			}
		}
/**
 * spilleren for 4 point når start passeres		
 */
		if (spiller.harPasseretStart()) spiller.getKonto().indsætPenge(4); //4kr for at passere Start

	}

}
