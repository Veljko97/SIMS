package model;

import enumi.TipVozila;

public class Cena {
	private double dinarCena;

	private double evroCena;

	private TipVozila tipVozila;

	public Cena() {
		super();
	}

	public Cena(double dinarCena, double evroCena, TipVozila tipVozila) {
		super();
		this.dinarCena = dinarCena;
		this.evroCena = evroCena;
		this.tipVozila = tipVozila;
	}

	public double getDinarCena() {
		return dinarCena;
	}

	public void setDinarCena(double dinarCena) {
		this.dinarCena = dinarCena;
	}

	public double getEvroCena() {
		return evroCena;
	}

	public void setEvroCena(double evroCena) {
		this.evroCena = evroCena;
	}

	public TipVozila getTipVozila() {
		return tipVozila;
	}

	public void setTipVozila(TipVozila tipVozila) {
		this.tipVozila = tipVozila;
	}
}

