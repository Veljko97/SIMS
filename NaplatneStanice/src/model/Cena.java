package model;

import java.io.Serializable;

import enumi.TipVozila;

public class Cena implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 524852808996588704L;

	private double dinarCena;

	private double evroCena;

	private TipVozila tipVozila;

	public Cena() {
		super();
	}

	public Cena(double dinarCena, double evroCena, TipVozila tipVozila) {
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

