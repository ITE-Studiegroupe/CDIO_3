package monololy_junior;

public class Raflebæger {
	private Terning terning = new Terning();

	public int getSum() {
		int terning1 = terning.getVærdi();
		int terning2 = terning.getVærdi();
		return terning1 + terning2;
	}

}
