package monopoly_junior.felter;

import java.awt.Color;

import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;

/**
 * Klassen: Felt_Chancekort
 * Sub-klasse til Felt
 * @author Gruppe_36
 * Klassen har til formål at styre chancekort felterne
 */

public class Felt_Chance extends Felt{

	/**
	 * Denne metode henter attributter til konstruktøren fra super-klassen Felt	
	 * @param feltNr
	 * @param feltNavn
	 * @param bgFarve
	 * @param tekstFarve
	 */
	public Felt_Chance(String feltNavn, Color bgFarve, Color tekstFarve) {
		super(feltNavn, bgFarve, tekstFarve);
	}

	@Override
	public GUI_Field tilGUIFelt() {
		return new GUI_Chance(
				"?",
				super.getFeltNavn(),
				"",
				super.getBgFarve(),
				super.getTekstFarve());
	}

}
