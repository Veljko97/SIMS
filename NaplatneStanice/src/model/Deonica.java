package model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Deonica implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double udaljenost;
	private int idDeonice;
	private ArrayList<Cenovnik> cenovnik;
	private Grad polazniGrad;
	private Grad odredisniGrad;

	public Deonica() {
		super();
	}

	public Deonica(int idDeonice,double udaljenost, Grad polazniGrad, Grad odredisniGrad) {
		super();
		this.udaljenost = udaljenost;
		this.idDeonice = idDeonice;
		this.cenovnik = new ArrayList<Cenovnik>();
		this.polazniGrad = polazniGrad;
		this.odredisniGrad = odredisniGrad;
	}

	public void dodajCenovnik(Date datumAktivnosti) {
		int lastId = -1;
		for(Cenovnik cen : cenovnik) {
			if(cen.getIdCenovnika() > lastId) {
				lastId = cen.getIdCenovnika();
			}
		}
		lastId++;
		this.cenovnik.add(new Cenovnik(lastId, datumAktivnosti));
	}

	public void obrisiCenovnik(int idCenovnika) {
		for(Cenovnik cen : cenovnik) {
			if(cen.getIdCenovnika()==idCenovnika) {
				cenovnik.remove(cen);
			}
		}
	}

	public void izmeniCenovnik() {

	}

	public double getUdaljenost() {
		return udaljenost;
	}

	public void setUdaljenost(double udaljenost) {
		this.udaljenost = udaljenost;
	}

	public int getIdDeonice() {
		return idDeonice;
	}

	public void setIdDeonice(int idDeonice) {
		this.idDeonice = idDeonice;
	}

	public ArrayList<Cenovnik> getCenovnik() {
		return cenovnik;
	}

	public void setCenovnik(ArrayList<Cenovnik> cenovnik) {
		this.cenovnik = cenovnik;
	}

	public Grad getPolazniGrad() {
		return polazniGrad;
	}

	public void setPolazniGrad(Grad polazniGrad) {
		this.polazniGrad = polazniGrad;
	}

	public Grad getOdredisniGrad() {
		return odredisniGrad;
	}

	public void setOdredisniGrad(Grad odredisniGrad) {
		this.odredisniGrad = odredisniGrad;
	}
}

