package monopoly_junior.felter;

import java.awt.Color;

import gui_fields.GUI_Field;
import gui_fields.GUI_Refuge;
/**
 * Klasse: Felt_Helle
 * Sub-llasse til Felt
 * @author Gruppe_36
 * Klassen styrer du felter som giver spilleren helle
 */

public class Felt_Helle extends Felt {

/**
 * Denne metode henter attributter til konstruktøren fra super-klassen Felt	
 * @param feltNr
 * @param feltNavn
 * @param bgFarve
 * @param tekstFarve
 */
	public Felt_Helle(String feltNavn, Color bgFarve, Color tekstFarve) {
		super(feltNavn, bgFarve, tekstFarve);
	}

@Override
public GUI_Field tilGUIFelt() {
	GUI_Field felt = new GUI_Refuge();
	felt.setBackGroundColor(super.getBgFarve());
	felt.setForeGroundColor(super.getTekstFarve());
	felt.setSubText(super.getFeltNavn());
	return felt;
}
}
