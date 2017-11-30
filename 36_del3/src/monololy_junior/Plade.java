package monololy_junior;

import java.awt.Color;
import monololy_junior.felter.Felt;
import monololy_junior.felter.Felt_Chance;
import monololy_junior.felter.Felt_Forretning;
import monololy_junior.felter.Felt_Fængsel;
import monololy_junior.felter.Felt_Helle;
import monololy_junior.felter.Felt_Start;
/**
 * Denne klasse har til formål at holde på informationer omkring de 24 forskellige felter 
 * og de 8 chancekort.
 * 
 * @author Gruppe 36
 * @category Information expert
 *
 */
public class Plade {
	
	
	public final int FÆNGSEL = 6;
	private Chancekort[] chancekort = new Chancekort[8];
	private Felt[] felter = new Felt[24];

	
	public void bygPlade() {
		bygFelter();
		bygChancekort();
		
	}

	//Bygfelter metode
	private void bygFelter() {
		
		felter[0] = new Felt_Start(Tekst.TekstFeltNavne.TEKSTER[0], 3, Color.WHITE, Color.BLACK);
		
		felter[1] = new Felt_Forretning(1, Tekst.TekstFeltNavne.TEKSTER[1], 1, Color.RED, Color.BLACK);
		
		felter[2] = new Felt_Forretning(2, Tekst.TekstFeltNavne.TEKSTER[2], 1, Color.RED, Color.BLACK);
		
		felter[3] = new Felt_Chance(Tekst.TekstFeltNavne.TEKSTER[3], Color.GRAY, Color.ORANGE);
		
		felter[4] = new Felt_Forretning(4, Tekst.TekstFeltNavne.TEKSTER[4], 1, Color.BLUE, Color.BLACK);
		
		felter[5] = new Felt_Forretning(5, Tekst.TekstFeltNavne.TEKSTER[5], 1, Color.BLUE, Color.BLACK);
		
		felter[6] = new Felt_Fængsel(Tekst.TekstFeltNavne.TEKSTER[6], true, Color.BLACK, Color.WHITE);
		
		felter[7] = new Felt_Forretning(7, Tekst.TekstFeltNavne.TEKSTER[7], 2, Color.PINK, Color.BLACK);
		
		felter[8] = new Felt_Forretning(8, Tekst.TekstFeltNavne.TEKSTER[8], 2, Color.PINK, Color.BLACK);
		
		felter[9] = new Felt_Chance(Tekst.TekstFeltNavne.TEKSTER[9], Color.GRAY, Color.ORANGE);
		
		felter[10] = new Felt_Forretning(10, Tekst.TekstFeltNavne.TEKSTER[10], 2, Color.YELLOW, Color.BLACK);
		
		felter[11] = new Felt_Forretning(11, Tekst.TekstFeltNavne.TEKSTER[11], 2, Color.YELLOW, Color.BLACK);
		
		felter[12] = new Felt_Helle(Tekst.TekstFeltNavne.TEKSTER[12], Color.WHITE, Color.BLACK);
		
		felter[13] = new Felt_Forretning(13, Tekst.TekstFeltNavne.TEKSTER[13], 3, Color.ORANGE, Color.BLACK);
		
		felter[14] = new Felt_Forretning(14, Tekst.TekstFeltNavne.TEKSTER[14], 3, Color.ORANGE, Color.BLACK);
		
		felter[15] = new Felt_Chance(Tekst.TekstFeltNavne.TEKSTER[15], Color.GRAY, Color.ORANGE);
		
		felter[16] = new Felt_Forretning(16, Tekst.TekstFeltNavne.TEKSTER[16], 3, Color.CYAN, Color.BLACK);
		
		felter[17] = new Felt_Forretning(17, Tekst.TekstFeltNavne.TEKSTER[17], 3, Color.CYAN, Color.BLACK);
		
		felter[18] = new Felt_Fængsel(Tekst.TekstFeltNavne.TEKSTER[18], false, Color.BLACK, Color.WHITE);
		
		felter[19] = new Felt_Forretning(19, Tekst.TekstFeltNavne.TEKSTER[19], 4, Color.GREEN, Color.BLACK);
		
		felter[20] = new Felt_Forretning(20, Tekst.TekstFeltNavne.TEKSTER[20], 4, Color.GREEN, Color.BLACK);
		
		felter[21] = new Felt_Chance(Tekst.TekstFeltNavne.TEKSTER[21], Color.GRAY, Color.ORANGE);
		
		felter[22] = new Felt_Forretning(22, Tekst.TekstFeltNavne.TEKSTER[22], 4, Color.BLUE, Color.BLACK);
		
		felter[23] = new Felt_Forretning(23, Tekst.TekstFeltNavne.TEKSTER[23], 4, Color.BLUE, Color.BLACK);
		}
	
	/**
	 * Typer af chancekort:<br> 
	 * 1. betal penge <br>
	 * 2. få penge <br>
	 * 3. ryk felter <br>
	 */

	private void bygChancekort() {
		
		chancekort[0] = new Chancekort(3, 1, Tekst.TekstChancekort.TEKSTER[0]);
		
		chancekort[1] = new Chancekort(20, 3, Tekst.TekstChancekort.TEKSTER[1]);
		
		chancekort[2] = new Chancekort(4, 1, Tekst.TekstChancekort.TEKSTER[2]);
		
		chancekort[3] = new Chancekort(13, 3, Tekst.TekstChancekort.TEKSTER[3]);
		
		chancekort[4] = new Chancekort(6, 3, Tekst.TekstChancekort.TEKSTER[4]);
		
		chancekort[5] = new Chancekort(1, 2, Tekst.TekstChancekort.TEKSTER[5]);
		
		chancekort[6] = new Chancekort(2, 2, Tekst.TekstChancekort.TEKSTER[6]);
		
		chancekort[7] = new Chancekort(4, 2, Tekst.TekstChancekort.TEKSTER[7]);
			
		}
	/**
	 * Træk et random chancekort
	 * 
	 */
		public  Chancekort trækChancekort() {
		int trukketChancekort = ((int) (Math.random()*chancekort.length));
		return chancekort[trukketChancekort];

		}
		
		/**
		 * Returnerer 
		 * @return
		 */
		
		public Felt[] getFelter() {
			return felter;
		}
}
