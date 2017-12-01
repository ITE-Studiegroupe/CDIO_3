package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import monopoly_junior.Konto;

public class setKontoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Konto konto = new Konto();
		konto.setPengeBeholdning(100);
		int actual = konto.getPengeBeholdning();
		int expected = 100;
		assertEquals(actual, expected);
	}

}
