package model;

import java.util.Date;

import enumi.TipValute;
import enumi.TipVozila;

public class Transakcija {
	private int idStanice;
	private int idMesta;
	private TipVozila vrstaVozila;

	private Date vremeTransakcije;

	private double cena;

	private TipValute tipValute;

	public Transakcija(int idStanice, int idMesta, TipVozila vrstaVozila, Date vremeTransakcije, double cena, TipValute tipValute) {
		super();
		this.idStanice = idStanice;
		this.idMesta = idMesta;
		this.vrstaVozila = vrstaVozila;
		this.vremeTransakcije = vremeTransakcije;
		this.cena = cena;
		this.tipValute = tipValute;
	}

	public Transakcija() {
		super();
	}
	
	public String write() {
		return "" + idStanice + "|" + idMesta + "|" + vrstaVozila + "|" + vremeTransakcije.getTime() + "|" + cena + "|" + tipValute;
	}
	
	
	@Override
	public String toString() {
		return "Transakcija [idStanice=" + idStanice + ", idMesta=" + idMesta + ", vrstaVozila=" + vrstaVozila
				+ ", vremeTransakcije=" + vremeTransakcije + ", cena=" + cena + ", tipValute=" + tipValute + "]";
	}

	public TipVozila getVrstaVozila() {
		return vrstaVozila;
	}

	public void setVrstaVozila(TipVozila vrstaVozila) {
		this.vrstaVozila = vrstaVozila;
	}

	public Date getVremeTransakcije() {
		return vremeTransakcije;
	}

	public void setVremeTransakcije(Date vremeTransakcije) {
		this.vremeTransakcije = vremeTransakcije;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public TipValute getTipValute() {
		return tipValute;
	}

	public void setTipValute(TipValute tipValute) {
		this.tipValute = tipValute;
	}
}

