package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import enumi.TipValute;
import enumi.TipVozila;
import model.Transakcija;

class TransakcijaTest {

	@Test
	void testWrite() {
		Date dat = new Date();
		Transakcija tr = new Transakcija(1, 2, TipVozila.KATEGORIJA1A, dat, 120, TipValute.DINAR);
		String st = tr.write();
		String tokens[]  = st.split("\\|");
		assertEquals(tokens[0],"1");
		assertEquals(tokens[1],"2");
		assertEquals(tokens[2],TipVozila.KATEGORIJA1A.toString());
		assertEquals(Long.parseLong(tokens[3]),dat.getTime());
		assertEquals(Double.parseDouble(tokens[4]), 120);
		assertEquals(tokens[5], TipValute.DINAR.toString());
	}

}
