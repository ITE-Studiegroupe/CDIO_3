package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gui.GUIFører;
import monopoly_junior.Plade;

public class responstidTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		long t0 = System.currentTimeMillis();
		Plade plade = new Plade();
		plade.bygPlade();
		GUIFører.getInstans().skabGUI(plade.getFelter());
		long t1 = System.currentTimeMillis();
		System.out.println("Det tog "+ (t1-t0) + "ms");
		
		
	}

}
