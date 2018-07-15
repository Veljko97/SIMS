package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import enumi.TipNaplatnogMesta;
import model.Centrala;
import model.Grad;
import model.NaplatnaStanica;

public class unosNaplatnogMestaTest {
	NaplatnaStanica naplatna = new NaplatnaStanica(3,new Grad(), Centrala.getInstance());

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertTrue(naplatna.getNaplatnaMesta().size() == 0);
		naplatna.dodajNaplatnoMesto(TipNaplatnogMesta.ELEKTRONSKA);
		assertTrue(naplatna.getNaplatnaMesta().size() == 1);
	}

}
