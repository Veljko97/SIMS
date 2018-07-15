package model;

import java.io.Serializable;

public class Grad implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int postanskiBroj;

	private String naziv;

	public Grad(int postanskiBroj, String naziv) {
		super();
		this.postanskiBroj = postanskiBroj;
		this.naziv = naziv;
	}

	public Grad() {
		super();
	}
	
	@Override
	public String toString() {
		return "" + naziv;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + postanskiBroj;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grad other = (Grad) obj;
		if (postanskiBroj != other.postanskiBroj)
			return false;
		return true;
	}

	public int getPostanskiBroj() {
		return postanskiBroj;
	}

	public void setPostanskiBroj(int postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}

