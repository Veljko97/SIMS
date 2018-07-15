package model;

import java.io.Serializable;
import java.util.Date;

import enumi.SmerMotora;
import enumi.TipValute;
import enumi.TipVozila;

public abstract class NaplatnoMesto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3065123934541241680L;
	protected int idMesta;
	protected double udaljenostVozila;
	protected boolean aktivna;
	public StanjeRampe stanjeRampe;
	protected NaplatnaStanica nplatnaStanica;

	protected void ukljuciMotor(SmerMotora smer) {

	}

	protected void iskljuciMotor() {

	}

	protected void obrniMotor(SmerMotora smer) {

	}

	protected void spustenoDoKraja() {

	}

	protected void podignutaDoKraja() {

	}

	protected void promeniStanje(StanjeRampe novoStanje) {
		// TODO: implement
	}

	protected void promenaUdaljenosti(double udaljenosti) {
		// TODO: implement
	}
	
	protected void zabeleziGresku() {
		
	}

	public abstract void izvrsiTransakciju(TipVozila tipVozila, TipValute tipValute, double vrednost, Date datum);

	public NaplatnoMesto(int idMesta, double udaljenostVozila, boolean aktivna, StanjeRampe stanjeRampe, NaplatnaStanica na) {
		super();
		this.idMesta = idMesta;
		this.udaljenostVozila = udaljenostVozila;
		this.aktivna = aktivna;
		this.stanjeRampe = stanjeRampe;
		this.nplatnaStanica = na;
	}

	public NaplatnoMesto() {
		super();
	}

	public int getIdMesta() {
		return idMesta;
	}

	public void setIdMesta(int idMesta) {
		this.idMesta = idMesta;
	}

	public double getUdaljenostVozila() {
		return udaljenostVozila;
	}

	public void setUdaljenostVozila(double udaljenostVozila) {
		this.udaljenostVozila = udaljenostVozila;
	}

	public boolean isAktivna() {
		return aktivna;
	}

	public void setAktivna(boolean aktivna) {
		this.aktivna = aktivna;
	}

	public StanjeRampe getStanjeRampe() {
		return stanjeRampe;
	}

	public void setStanjeRampe(StanjeRampe stanjeRampe) {
		this.stanjeRampe = stanjeRampe;
	}

	public NaplatnaStanica getNplatnaStanica() {
		return nplatnaStanica;
	}

	public void setNplatnaStanica(NaplatnaStanica nplatnaStanica) {
		this.nplatnaStanica = nplatnaStanica;
	}
	
	
}
