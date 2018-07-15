package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import enumi.TipNaplatnogMesta;
import enumi.TipValute;
import enumi.TipVozila;

public class NaplatnaStanica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1684986487208601123L;
	private int idMesta = 1;
	private int idStanice;
	private Grad grad;
	private ArrayList<Deonica> deonice;
	private ArrayList<NaplatnoMesto> mesta;
	
	public NaplatnaStanica(int idStanice, Grad grad) {
		super();
		this.idStanice = idStanice;
		idMesta = 1;
		this.grad = grad;
		this.deonice = new ArrayList<Deonica>();
		this.mesta = new ArrayList<NaplatnoMesto>();
		File f = new File("Centrala\\"+ idStanice);
		f.mkdirs();
	}
	
	public NaplatnaStanica() {
		super();
	}
	
	public void dodajDeonicu(Deonica deonica) {
		deonice.add(deonica);
	}
	
	public void dodajNaplatnoMesto(TipNaplatnogMesta tip) {
		if(tip == TipNaplatnogMesta.FIZICKA) {
			FizickaNaplata fi = new FizickaNaplata(this.idMesta++,this);
			mesta.add(fi);
		}else {
			mesta.add(new ElektronskaNaplata(this.idMesta++,this));
		}
	}
	
	public ArrayList<Transakcija> detaljanIzvestaj(){
		ArrayList<Transakcija> trans = new ArrayList<Transakcija>();
		String line;
		String tokens[];
		File file = new File("Centrala\\"+idStanice+"\\transakcije.txt");
		if(file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				while((line = br.readLine()) != null) {
					tokens = line.split("\\|");
					trans.add(new Transakcija(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), TipVozila.valueOf(tokens[2]), new Date(Long.parseLong(tokens[3])), Double.parseDouble(tokens[4]), TipValute.valueOf(tokens[5])));
				}
				br.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return trans;
	}
	
	public ArrayList<Transakcija> izvestajTipaVozila(TipVozila tipVozila){
		ArrayList<Transakcija> trans = new ArrayList<Transakcija>();
		Transakcija tran;
		String line;
		String tokens[];
		File file = new File("Centrala\\"+idStanice+"\\transakcije.txt");
		if(file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				while((line = br.readLine()) != null) {
					tokens = line.split("\\|");
					tran = new Transakcija(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), TipVozila.valueOf(tokens[2]), new Date(Long.parseLong(tokens[3])), Double.parseDouble(tokens[4]), TipValute.valueOf(tokens[5]));
					if(tran.getVrstaVozila() == tipVozila) {
						trans.add(tran);
					}
				}
				br.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return trans;
	}

	public ArrayList<Transakcija> izvestajTipValute(TipValute tipValute){
		ArrayList<Transakcija> trans = new ArrayList<Transakcija>();
		Transakcija tran;
		String line;
		String tokens[];
		File file = new File("Centrala\\"+idStanice+"\\transakcije.txt");
		if(file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				while((line = br.readLine()) != null) {
					tokens = line.split("\\|");
					tran = new Transakcija(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), TipVozila.valueOf(tokens[2]), new Date(Long.parseLong(tokens[3])), Double.parseDouble(tokens[4]), TipValute.valueOf(tokens[5]));
					if(tran.getTipValute() == tipValute) {
						trans.add(tran);
					}
				}
				br.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return trans;
	}
	
	public ArrayList<Transakcija> izvestajDatum(Date pocetni, Date krajni){
		ArrayList<Transakcija> trans = new ArrayList<Transakcija>();
		Transakcija tran;
		String line;
		String tokens[];
		File file = new File("Centrala\\"+idStanice+"\\transakcije.txt");
		if(file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				while((line = br.readLine()) != null) {
					tokens = line.split("\\|");
					tran = new Transakcija(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), TipVozila.valueOf(tokens[2]), new Date(Long.parseLong(tokens[3])), Double.parseDouble(tokens[4]), TipValute.valueOf(tokens[5]));
					if(tran.getVremeTransakcije().before(krajni) && tran.getVremeTransakcije().after(pocetni)) {
						trans.add(tran);
					}
				}
				br.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return trans;
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

	public ArrayList<NaplatnoMesto> getMesta() {
		return mesta;
	}

	public void setMesta(ArrayList<NaplatnoMesto> mesta) {
		this.mesta = mesta;
	}
	
	
}
