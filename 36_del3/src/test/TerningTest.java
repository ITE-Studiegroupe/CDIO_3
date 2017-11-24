package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import monololy_junior.Terning;

class TerningTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		Terning terning = new Terning();
		int side1 = 0;
		int side2 = 0;
		int side3 = 0;
		int side4 = 0;
		int side5 = 0;
		int side6 = 0;

		for (int i = 0; i < 10000; i++) {
			int fordeling = terning.getAntalØjne();
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

		System.out.println("Resultat: " + side1 + " " + side2 + " " + side3 + " " + side4 + " " + side5 + " " + side6);

	}

}