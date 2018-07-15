package model;

import java.util.Date;

import enumi.TipValute;
import enumi.TipVozila;

public class ElektronskaNaplata extends NaplatnoMesto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4647673374563802844L;

	public ElektronskaNaplata() {
		super();

	}

	public ElektronskaNaplata(int idMesta, NaplatnaStanica na) {
		super(idMesta, 0, true, new Spustena(), na);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void izvrsiTransakciju(TipVozila tipVozila, TipValute tipValute, double vrednost, Date datum) {
		System.out.println("Nije implementirano!");
	}

}
