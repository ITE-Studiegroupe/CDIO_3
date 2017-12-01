package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import monopoly_junior.Terning;

public class TerningTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
			Terning terning = new Terning();
			int side1 = 0;
			int side2 = 0;
			int side3 = 0;
			int side4 = 0;
			int side5 = 0;
			int side6 = 0;


			for (int i = 0; i < 10000; i++) {
				int fordeling = terning.kastTerning();
		
				if (1 == fordeling)
					side1++;
				else if (2 == fordeling)
					side2++;
				else if (3 == fordeling)
					side3++;
				else if (4 == fordeling)
					side4++;
				else if (5 == fordeling)
					side5++;
				else if (6 == fordeling)
					side6++;
				
			}
			int samlet = side1 + side2 + side3 + side4 + side5 + side6;


			System.out.println("Resultat: " + side1 + " " + side2 + " " + side3 + " " + side4 + " " + side5 + " " + side6);
			System.out.println("Samlet antal: " + samlet); //for at tjekke at der ikke kommer nogle værdier udenfor 1-6

			}

}
