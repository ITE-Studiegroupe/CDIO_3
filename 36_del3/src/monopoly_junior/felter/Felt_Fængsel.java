package monopoly_junior.felter;

import java.awt.Color;

import gui_fields.GUI_Field;
import gui_fields.GUI_Jail;

/**
 * Klassen: Felt_Fængsel
 * @author Gruppe_36
 * Klassen styrer feltet Fængsel
 */

public class Felt_Fængsel extends Felt{

	private boolean erFængsel;

	/**
	 * Denne metode henter attributter til konstruktøren fra super-klassen Felt	
	 * @param feltNr
	 * @param feltNavn
	 * @param erFængsel
	 * @param bgFarve
	 * @param tekstFarve
	 */
	public Felt_Fængsel(String feltNavn, boolean erFængsel, Color bgFarve, Color tekstFarve) {
		super(feltNavn, bgFarve, tekstFarve);
		this.erFængsel = erFængsel;
	}
	/**
	 * Metoden returnerer erFængsel i form af en boolean
	 * @return erFængsel
	 */
	public boolean erFængsel() {
		return erFængsel;
	}
	@Override
	public GUI_Field tilGUIFelt() {
		GUI_Field felt = new GUI_Jail();
		felt.setSubText(super.getFeltNavn());
		felt.setBackGroundColor(super.getBgFarve());
		felt.setForeGroundColor(super.getTekstFarve());
		return felt;
	}


}
