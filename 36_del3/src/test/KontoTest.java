package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import monopoly_junior.Konto;

public class KontoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		Konto konto = new Konto();
		int succes = 0;
		konto.setPengeBeholdning(31);
		if(konto.indsætPenge(-31)) {
			succes++;
		}
		int actual = succes;
		int expected = 0; //det skal ikke lykkedes at hæve det samme beløb som der står på kontoen, da man ikke må have 0 på kontoen
		
		assertEquals(expected,actual);
	
	}
	
	@Test
	public void test2() {
		Konto konto = new Konto();
		int succes = 0;
		konto.setPengeBeholdning(31);
		if(konto.indsætPenge(-30)) {
			succes++;
		}
		int actual = succes;
		int expected = 1; //fordi det gerne skal lykkedes at trække 29, når der står 31
		
		assertEquals(expected,actual);
	}
	@Test
	public void test3() {
		Konto konto = new Konto();
		int succes = 0;
		konto.setPengeBeholdning(31);
		if(konto.indsætPenge(-32)) {
			succes++;
		}
		int actual = succes;
		int expected = 0;//det her må ikke lykkedes, da der ikke må trækkes over på kontoen 
		
		assertEquals(expected,actual);
	}


}
