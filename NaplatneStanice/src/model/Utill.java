package model;

public class Utill {
	public static int passworGenerator(String sifra) {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sifra == null) ? 0 : sifra.hashCode());
		return result;
	}
	
}
