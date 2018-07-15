package tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Centrala;

public class unosNaplatneStaniceTest {
	Centrala centrala = Centrala.getInstance();

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
		assertTrue(centrala.getNaplatneStanice().size() == 2);
		centrala.dodajStanicu(8); // ne postoji id tog grada
		assertTrue(centrala.getNaplatneStanice().size() == 2);
		centrala.dodajStanicu(11000); // postoji id tog grada
		assertTrue(centrala.getNaplatneStanice().size() == 3);
	}

}
