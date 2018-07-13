package model;

import enumi.TipRadnika;

public class Radnik {
   private String ime;
   private String prezime;
   private String korisnickoIme;
   private int sifra;
   private double jmbg;
   private TipRadnika tipRadnika;

   public Radnik(String ime, String prezime, String korisnickoIme, String sifra, double jmbg, TipRadnika tipRadnika) {
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickoIme = korisnickoIme;
		this.jmbg = jmbg;
		this.tipRadnika = tipRadnika;
		this.sifra = Utill.passworGenerator(sifra);
   }
   
   public String write() {
	   return ime+"|"+ prezime +"|"+ korisnickoIme+"|"+ jmbg+"|"+ tipRadnika + "|" + sifra;
   }
   
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Radnik other = (Radnik) obj;
		if (Double.doubleToLongBits(jmbg) != Double.doubleToLongBits(other.jmbg))
			return false;
		return true;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public double getJmbg() {
		return jmbg;
	}

	public void setJmbg(double jmbg) {
		this.jmbg = jmbg;
	}

	public TipRadnika getTipRadnika() {
		return tipRadnika;
	}

	public void setTipRadnika(TipRadnika tipRadnika) {
		this.tipRadnika = tipRadnika;
	}
      
}
