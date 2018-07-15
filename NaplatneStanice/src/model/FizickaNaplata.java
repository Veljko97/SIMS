package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import enumi.TipValute;
import enumi.TipVozila;

public class FizickaNaplata extends NaplatnoMesto {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4041298286850204311L;

	public FizickaNaplata(int idMesta, NaplatnaStanica na) {
		super(idMesta, 0, true, new Spusta(), na);
	}

	@Override
	public void izvrsiTransakciju(TipVozila tipVozila, TipValute tipValute, double vrednost, Date datum) {
		Transakcija transakcija = new Transakcija(this.naplatnaStanica.getIdStanice(), this.idMesta, tipVozila, datum, vrednost, tipValute);
		this.getNaplatnaStanica().getCentrala().getTransakcije().add(transakcija);
		File file = new File("Centrala\\"+this.naplatnaStanica.getIdStanice()+"\\transakcije.txt");
		if(file.exists()) {
			try {
				FileWriter fw = new FileWriter(file,true);
				fw.write(transakcija.write()+"\n");
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			
			try {
				FileWriter fw = new FileWriter(file);
				fw.write(transakcija.write()+"\n");
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}