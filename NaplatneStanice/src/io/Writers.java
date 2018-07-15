package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Deonica;
import model.Grad;
import model.NaplatnaStanica;
import model.Radnik;

public class Writers {
	public static void deonicaWriter(ArrayList<Deonica> deonice) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("Centrala\\Deonice.dat")));
			os.writeObject(deonice);
			os.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void gradWriter(ArrayList<Grad> gradovi) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("Centrala\\Gradovi.dat")));
			os.writeObject(gradovi);
			os.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void staniceWriter(ArrayList<NaplatnaStanica> stanice) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("Centrala\\NaplatneStanice.dat")));
			os.writeObject(stanice);
			os.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void radniciWriter(ArrayList<Radnik> radnici) {
		try {
			FileWriter fw = new FileWriter(new File("Centrala\\Radnici.txt"));
			for(Radnik rad : radnici) {
				fw.write(rad.write()+"\n");
			}
			fw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
