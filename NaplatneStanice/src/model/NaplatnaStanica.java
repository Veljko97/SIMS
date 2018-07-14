package model;

import java.util.ArrayList;

public class NaplatnaStanica {

	private int idStanice;
	private Grad grad;
	private ArrayList<Deonica> deonice;
	
	public NaplatnaStanica(int idStanice, Grad grad, ArrayList<Deonica> deonice) {
		super();
		this.idStanice = idStanice;
		this.grad = grad;
		this.deonice = deonice;
	}
	
	public NaplatnaStanica() {
		super();
	}

	public int getIdStanice() {
		return idStanice;
	}
	public void setIdStanice(int idStanice) {
		this.idStanice = idStanice;
	}
	public Grad getGrad() {
		return grad;
	}
	public void setGrad(Grad grad) {
		this.grad = grad;
	}
	public ArrayList<Deonica> getDeonice() {
		return deonice;
	}
	public void setDeonice(ArrayList<Deonica> deonice) {
		this.deonice = deonice;
	}
	

}
