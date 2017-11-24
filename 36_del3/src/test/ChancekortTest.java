package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import monololy_junior.Chancekort;
import monololy_junior.Plade;

class ChancekortTest {

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

		Plade plade = new Plade();
		plade.bygPlade();

		for (int i = 0; i < 8; i++) {

			plade.trækChancekort();

			Chancekort chancekort = new Chancekort();
			chancekort = plade.trækChancekort();

			System.out.println(chancekort.getChanceKortTekst());

		}

	}

}
