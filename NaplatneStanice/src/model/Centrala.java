package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import enumi.TipRadnika;
import enumi.TipValute;
import enumi.TipVozila;
import io.Readers;
import io.Writers;

public class Centrala implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8299916437995677382L;
	private int idDeonica = 1;
	private int idStanica = 1;
	private Radnik ulogovani;
	private ArrayList<Radnik> radnici;
	private ArrayList<NaplatnaStanica> naplatneStanice;
	private ArrayList<Grad> gradovi;
	private ArrayList<Deonica> deonice;
	private static Centrala single;
	
	private Centrala() {
		this.radnici = Readers.radniciReader();
		this.naplatneStanice = Readers.staniceReader();
		this.gradovi = Readers.gradReader();
		this.deonice = Readers.deonicaReader();
	}
	
	public void end() {
		Writers.deonicaWriter(deonice);
		Writers.staniceWriter(naplatneStanice);
		Writers.gradWriter(gradovi);
		Writers.radniciWriter(radnici);
	}

	public static Centrala getInstance() {
		if (single == null) {
			single = new Centrala();
		}
		return single;
	}

	public void dodajRadnika(Radnik rad) {
		this.radnici.add(rad);
	}
	
	
	public void obrisiRadnika(double jmbg){
		for (Radnik radnik : this.radnici) {
			if (radnik.getJmbg() == jmbg){
				this.radnici.remove(radnik);
				break;
			}
		}
	}
	
	public void dodajStanicu(int idGrad){
		Grad grad = new Grad();
		boolean flag = false;
		for(Grad g:gradovi) {
			if(idGrad == g.getPostanskiBroj()) {
				grad = g;
				flag = true;
			}
		}
		if (flag) {
			naplatneStanice.add(new NaplatnaStanica(idStanica++, grad));
		}
	}
	
	public void dodajGrad(int postanskiBroj, String naziv) {
		gradovi.add(new Grad(postanskiBroj,naziv));
	}
	
	public void dodajDeonicu(double udaljenost, int polazniGrad, int odredisniGrad) {
		Grad pGrad = new Grad();
		Grad oGrad = new Grad();
		boolean flagP = false;
		boolean flagO = false;
		for(Grad g:gradovi) {
			if(polazniGrad == g.getPostanskiBroj()) {
				pGrad = g;
				flagP = true;
			}
			if(odredisniGrad == g.getPostanskiBroj()) {
				oGrad = g;
				flagO = true;
			}
		}
		if(flagP && flagO) {
			Deonica deo = new Deonica(idDeonica++,udaljenost, pGrad, oGrad);
			deonice.add(deo);
			for(NaplatnaStanica ns : naplatneStanice) {
				if(ns.getGrad().equals(pGrad) || ns.getGrad().equals(oGrad)) {
					ns.dodajDeonicu(deo);
				}
			}
		}
	}
	
	public ArrayList<Transakcija> detaljanIzvestaj(){
		ArrayList<Transakcija> trans = new ArrayList<Transakcija>();
		String line;
		String files[];
		String tokens[];
		File file = new File("Centrala");
		files = file.list();
		if(file.exists()) {
			try {
				for(String st:files) {
					if(new File("Centrala\\" + st).isDirectory()) {
						file = new File("Centrala\\" + st + "\\transakcije.txt");
						BufferedReader br = new BufferedReader(new FileReader(file));
						while((line = br.readLine()) != null) {
							tokens = line.split("\\|");
							trans.add(new Transakcija(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), TipVozila.valueOf(tokens[2]), new Date(Long.parseLong(tokens[3])), Double.parseDouble(tokens[4]), TipValute.valueOf(tokens[5])));
						}
						br.close();
					}
				}
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
		String[] files;
		String line;
		String tokens[];
		File file = new File("Centrala");
		files = file.list();
		try {
			for(String st:files) {
				if(new File("Centrala\\" + st).isDirectory()) {
					file = new File("Centrala\\" + st + "\\transakcije.txt");
					BufferedReader br = new BufferedReader(new FileReader(file));
					while((line = br.readLine()) != null) {
						tokens = line.split("\\|");
						tran = new Transakcija(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), TipVozila.valueOf(tokens[2]), new Date(Long.parseLong(tokens[3])), Double.parseDouble(tokens[4]), TipValute.valueOf(tokens[5]));
						if(tran.getVrstaVozila() == tipVozila) {
							trans.add(tran);
						}
					}
					br.close();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trans;
	}

	public ArrayList<Transakcija> izvestajTipValute(TipValute tipValute){
		ArrayList<Transakcija> trans = new ArrayList<Transakcija>();
		Transakcija tran;
		String[] files;
		String line;
		String tokens[];
		File file = new File("Centrala");
		files = file.list();
		try {
			for(String st:files) {
				if(new File("Centrala\\" + st).isDirectory()) {
					file = new File("Centrala\\" + st + "\\transakcije.txt");
					BufferedReader br = new BufferedReader(new FileReader(file));
					while((line = br.readLine()) != null) {
						tokens = line.split("\\|");
						tran = new Transakcija(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), TipVozila.valueOf(tokens[2]), new Date(Long.parseLong(tokens[3])), Double.parseDouble(tokens[4]), TipValute.valueOf(tokens[5]));
						if(tran.getTipValute() == tipValute) {
							trans.add(tran);
						}
					}
					br.close();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trans;
	}
	
	public ArrayList<Transakcija> izvestajDatum(Date pocetni, Date krajni){
		ArrayList<Transakcija> trans = new ArrayList<Transakcija>();
		Transakcija tran;
		String[] files;
		String line;
		String tokens[];
		File file = new File("Centrala");
		files = file.list();
		try {
			for(String st:files) {
				if(new File("Centrala\\" + st).isDirectory()) {
					file = new File("Centrala\\" + st + "\\transakcije.txt");
					BufferedReader br = new BufferedReader(new FileReader(file));
					while((line = br.readLine()) != null) {
						tokens = line.split("\\|");
						tran = new Transakcija(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), TipVozila.valueOf(tokens[2]), new Date(Long.parseLong(tokens[3])), Double.parseDouble(tokens[4]), TipValute.valueOf(tokens[5]));
						if(tran.getVremeTransakcije().before(krajni) && tran.getVremeTransakcije().after(pocetni)) {
							trans.add(tran);
						}
					}
					br.close();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trans;
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

	public int getIdDeonica() {
		return idDeonica;
	}

	public void setIdDeonica(int idDeonica) {
		this.idDeonica = idDeonica;
	}

	public int getIdStanica() {
		return idStanica;
	}

	public void setIdStanica(int idStanica) {
		this.idStanica = idStanica;
	}

	public Radnik getUlogovani() {
		return ulogovani;
	}

	public void setUlogovani(Radnik ulogovani) {
		this.ulogovani = ulogovani;
	}

	public ArrayList<Grad> getGradovi() {
		return gradovi;
	}

	public void setGradovi(ArrayList<Grad> gradovi) {
		this.gradovi = gradovi;
	}

	public ArrayList<Deonica> getDeonice() {
		return deonice;
	}

	public void setDeonice(ArrayList<Deonica> deonice) {
		this.deonice = deonice;
	}
	
}
