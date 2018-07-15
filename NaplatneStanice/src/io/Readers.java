package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import enumi.TipRadnika;
import model.Deonica;
import model.Grad;
import model.NaplatnaStanica;
import model.Radnik;

public class Readers {
	public static ArrayList<Deonica> deonicaReader() {
		ArrayList<Deonica> deo = new ArrayList<Deonica>();
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File("Centrala\\Deonice.dat")));
			deo = (ArrayList<Deonica>) is.readObject();
			is.close();
		} catch (Exception e) {
			
		}
		return deo;
	}
	
	public static ArrayList<Grad> gradReader() {
		ArrayList<Grad> deo = new ArrayList<Grad>();
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File("Centrala\\Gradovi.dat")));
			deo = (ArrayList<Grad>) is.readObject();
			is.close();
		} catch (Exception e) {
			
		}
		return deo;
	}
	
	public static ArrayList<NaplatnaStanica> staniceReader() {
		ArrayList<NaplatnaStanica> deo = new ArrayList<NaplatnaStanica>();
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File("Centrala\\NaplatneStanice.dat")));
			deo = (ArrayList<NaplatnaStanica>) is.readObject();
			is.close();
		} catch (Exception e) {
			
		}
		return deo;
	}
	
	public static ArrayList<Radnik> radniciReader() {
		ArrayList<Radnik> deo = new ArrayList<Radnik>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("Centrala\\Radnici.txt")));
			String line;
			while((line = br.readLine()) != null) {
				String[] token = line.split("\\|");
				deo.add(new Radnik(token[0], token[1], token[2], Integer.parseInt(token[5]), Double.parseDouble(token[3]), TipRadnika.valueOf(token[4]),Integer.parseInt(token[6])));
			}
			br.close();
		} catch (Exception e) {
			
		}
		return deo;
	}
}
