package monololy_junior;
import java.awt.Color;
import java.util.Arrays;

public class Spiller {
	private String spillerNavn;
	private Felt[] ejetFelter;
	private Konto konto;
	private Brik brik;

	public String getSpillerNavn() {
		return spillerNavn;
	}

	public void setSpillerNavn(String spillerNavn) {
		this.spillerNavn = spillerNavn;
	}

	public void tilføjFelt(Felt spillerFelt) {
		Felt[] nytFelt = Arrays.copyOf(ejetFelter, ejetFelter.length + 1);
		nytFelt[nytFelt.length-1] = spillerFelt;
		Felt[] ejetFelter = nytFelt;
	}
	
	public void checkToEns(Felt købtFelt) {
		for(int i = 1;i<ejetFelter.length;i++) {
			Color farve1 = ejetFelter[i].getFeltFarve();
			Color farve2 = købtFelt.getFeltFarve();
			if(farve1.getRGB()==farve2.getRGB()) {
				int købtFeltVærdi = købtFelt.getVærdi()*2;
				købtFelt.setVærdi(købtFeltVærdi);
				ejetFelter[i].setVærdi(købtFeltVærdi);
			}
		}
	}
	
	public Brik getBrik() {
		return brik;
	}

	public void setBrik(Brik brik) {
		this.brik = brik;
	}

	public void setKonto(Konto konto) {
		this.konto = konto;
	}

	public Konto getKonto() {
		return konto;
	}
}
