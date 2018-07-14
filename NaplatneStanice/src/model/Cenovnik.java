package model;


import java.util.ArrayList;
import java.util.Date;

import enumi.TipVozila;

public class Cenovnik {
	private Date datumAktivnosti;

	private boolean aktivnost;

	public ArrayList<Cena> cena;

	public void dodajCenu(double dinarCena, double evroCena, TipVozila tipVozila) {
		// TODO: implement
	}

	public void obrisiCenu(TipVozila tipVozila) {
		// TODO: implement
	}

	public void izmeniCenu(TipVozila tipVozila, double dinarCena, double evroCena) {
		// TODO: implement
	}

	public java.util.Collection<Cena> getCena() {
		if (cena == null)
			cena = new ArrayList<Cena>();
		return cena;
	}

	public java.util.Iterator getIteratorCena() {
		if (cena == null)
			cena = new ArrayList<Cena>();
		return cena.iterator();
	}

	public void setCena(ArrayList<Cena> newCena) {
		removeAllCena();
		for (java.util.Iterator iter = newCena.iterator(); iter.hasNext();)
			addCena((Cena) iter.next());
	}

	public void addCena(Cena newCena) {
		if (newCena == null)
			return;
		if (this.cena == null)
			this.cena = new ArrayList<Cena>();
		if (!this.cena.contains(newCena))
			this.cena.add(newCena);
	}

	public void removeCena(Cena oldCena) {
		if (oldCena == null)
			return;
		if (this.cena != null)
			if (this.cena.contains(oldCena))
				this.cena.remove(oldCena);
	}

	public void removeAllCena() {
		if (cena != null)
			cena.clear();
	}
}

