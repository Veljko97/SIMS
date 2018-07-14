package model;

import java.util.Date;

import enumi.TipValute;
import enumi.TipVozila;

public class FizickaNaplata extends NaplatnoMesto {

	@Override
	public void izvrsiTransakciju(int idStanice, int idMesta, TipVozila tipVozila, TipValute tipValute, double vrednost, Date datum) {
		Transakcija transakcija = new Transakcija(idStanice, idMesta, tipVozila, datum, vrednost, tipValute);

	}

}
