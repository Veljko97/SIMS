package model;

public class Main {

	public static void main(String[] args) {
		Centrala cent = Centrala.getInstance();
		/*cent.dodajGrad(22000, "Sr.Mitrovica");
		cent.dodajGrad(11000, "Beograd");
		cent.dodajStanicu(22000);
		cent.dodajStanicu(11000);
		cent.dodajDeonicu(1000, 22000, 11000);
		cent.getNaplatneStanice().get(0).dodajNaplatnoMesto(TipNaplatnogMesta.FIZICKA);
		cent.getNaplatneStanice().get(1).dodajNaplatnoMesto(TipNaplatnogMesta.FIZICKA);
		cent.getNaplatneStanice().get(0).getMesta().get(0).izvrsiTransakciju(TipVozila.KATEGORIJA1, TipValute.DINAR, 100, new Date());
		cent.getNaplatneStanice().get(1).getMesta().get(0).izvrsiTransakciju(TipVozila.KATEGORIJA1, TipValute.DINAR, 100, new Date());
		cent.getNaplatneStanice().get(1).detaljanIzvestaj();
		cent.dodajRadnika("Admin", "Admin", "admin", "admin", 1234567890, TipRadnika.administrator, 1);
		dodavanjeCene dodaj = new dodavanjeCene();
		cent.getDeonice().get(0).dodajCenovnik(new Date());
		cent.getDeonice().get(0).getCenovnik().get(0).setAktivnost(true);
		cent.getDeonice().get(0).getCenovnik().get(0).setCena(dodaj.returnValue());*/
		cent.end();
	}


}
