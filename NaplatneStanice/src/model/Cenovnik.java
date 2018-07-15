package model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import enumi.TipVozila;

public class Cenovnik implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date datumAktivnosti;
	
	private int idCenovnika;
	
	private boolean aktivnost;

	public ArrayList<Cena> cena;
	
	public Cenovnik(int idCenovnika,Date datumAktivnosti) {
		super();
		this.idCenovnika = idCenovnika;
		this.datumAktivnosti = datumAktivnosti;
		if(datumAktivnosti.after(new Date())) {
			this.aktivnost = false;
		}else {
			this.aktivnost = true;
		}
		this.cena = new ArrayList<Cena>();
	}

	public void dodajCenu(double dinarCena, double evroCena, TipVozila tipVozila) {
		boolean flag = false;
		for(Cena c:cena) {
			if(c.getTipVozila() == tipVozila) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			cena.add(new Cena(dinarCena,evroCena,tipVozila));
		}
	}

	public void obrisiCenu(TipVozila tipVozila) {
		for(Cena c:cena) {
			if(c.getTipVozila() == tipVozila) {
				cena.remove(c);
			}
		}
	}

	public void izmeniCenu(TipVozila tipVozila, double dinarCena, double evroCena) {
		for(Cena c:cena) {
			if(c.getTipVozila() == tipVozila) {
				c.setDinarCena(dinarCena);
				c.setEvroCena(evroCena);
			}
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cenovnik other = (Cenovnik) obj;
		if (idCenovnika != other.idCenovnika)
			return false;
		return true;
	}

	public Date getDatumAktivnosti() {
		return datumAktivnosti;
	}

	public void setDatumAktivnosti(Date datumAktivnosti) {
		this.datumAktivnosti = datumAktivnosti;
	}

	public boolean isAktivnost() {
		return aktivnost;
	}

	public void setAktivnost(boolean aktivnost) {
		this.aktivnost = aktivnost;
	}

	public int getIdCenovnika() {
		return idCenovnika;
	}

	public void setIdCenovnika(int idCenovnika) {
		this.idCenovnika = idCenovnika;
	}

	public ArrayList<Cena> getCena() {
		return cena;
	}

	public void setCena(ArrayList<Cena> cena) {
		this.cena = cena;
	}
	
	
}

