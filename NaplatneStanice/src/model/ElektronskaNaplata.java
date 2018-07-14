package model;

import java.util.Date;

import enumi.TipValute;
import enumi.TipVozila;

public class ElektronskaNaplata extends NaplatnoMesto {

	public ElektronskaNaplata() {
		super();

	}

	public ElektronskaNaplata(int idMesta, double udaljenostVozila, boolean aktivna, StanjeRampe stanjeRampe) {
		super(idMesta, udaljenostVozila, aktivna, stanjeRampe);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void izvrsiTransakciju(int idStanice, int idMesta, TipVozila tipVozila, TipValute tipValute, double vrednost, Date datum) {
		Transakcija transakcija = new Transakcija(idStanice, idMesta, tipVozila, datum, vrednost, tipValute);

	}

}
