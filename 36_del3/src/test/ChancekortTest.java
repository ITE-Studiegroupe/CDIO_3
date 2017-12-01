package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import monopoly_junior.Chancekort;
import monopoly_junior.Plade;

public class ChancekortTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Plade plade = new Plade();
		plade.bygPlade();

		Chancekort chancekort;
		for (int i = 0; i < 8; i++) {

			plade.trækChancekort();

			chancekort = plade.trækChancekort();

			System.out.println(chancekort.getChanceKortTekst());

		};
	}

}
