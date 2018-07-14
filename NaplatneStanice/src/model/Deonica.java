package model;


import java.util.ArrayList;

public class Deonica {
	private double udaljenost;
	private int idDeonice;
	private ArrayList<Cenovnik> cenovnik;
	private Grad polazniGrad;
	private Grad odredisniGrad;

	public Deonica() {
		super();
	}

	public Deonica(double udaljenost, int idDeonice, ArrayList<Cenovnik> cenovnik, Grad polazniGrad,
			Grad odredisniGrad) {
		super();
		this.udaljenost = udaljenost;
		this.idDeonice = idDeonice;
		this.cenovnik = cenovnik;
		this.polazniGrad = polazniGrad;
		this.odredisniGrad = odredisniGrad;
	}

	public void dodajCenovnik() {
		this.cenovnik.add(new Cenovnik());
	}

	public void obrisiCenovnik() {
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

