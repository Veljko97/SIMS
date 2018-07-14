package model;

import java.util.ArrayList;
import java.util.Date;

import enumi.TipRadnika;

public class Centrala {
	private ArrayList<Radnik> radnici;
	private ArrayList<NaplatnaStanica> naplatneStanice;

	public Centrala() {

	}

	public void dodajRadnika(String ime, String prezime, String korisnickoIme, String sifra, double jmbg, TipRadnika tipRadnika) {
		this.radnici.add(new Radnik(ime, prezime,korisnickoIme, sifra, jmbg, tipRadnika));
	}
	
	public void obrisiRadnika(double jmbg){
		for (Radnik radnik : this.radnici) {
			if (radnik.getJmbg() == jmbg){
				this.radnici.remove(radnik);
				break;
			}
		}
	}
	
	public void dodajStanicu(String lokacija, int idStanice){
		
	}

	public ArrayList<Radnik> getRadnici() {
		return radnici;
	}

	public void setRadnici(ArrayList<Radnik> radnici) {
		this.radnici = radnici;
	}

	public ArrayList<NaplatnaStanica> getNaplatneStanice() {
		return naplatneStanice;
	}

	public void setNaplatneStanice(ArrayList<NaplatnaStanica> naplatneStanice) {
		this.naplatneStanice = naplatneStanice;
	}

}
