package monololy_junior;

public class Terning {
	private int antalØjne;
	
	
	private void kast() {
		int antalØjne = ((int) (Math.random()*6)+1);
		this.antalØjne = antalØjne;
		
	}
	
	public int getSum() {
		kast();
		return antalØjne;
	}

}

