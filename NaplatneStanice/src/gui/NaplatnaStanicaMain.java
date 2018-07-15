package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import enumi.TipRadnika;
import enumi.TipValute;
import enumi.TipVozila;
import model.Cena;
import model.Cenovnik;
import model.Centrala;
import model.Deonica;
import model.NaplatnaStanica;
import model.Transakcija;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class NaplatnaStanicaMain {

	private JFrame frame;
	private JTextField txtPocetiDatum;
	private JTextField txtKrajniDatum;
	private JTextField txtOdabranaValuta;
	private JTextField txtOdabranoVozilo;
	private Centrala cent = Centrala.getInstance();
	NaplatnaStanica naplatna = null;
	private JTextField txtIddeonice;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInDialog login = new LogInDialog();
					if(login.returnValue(TipRadnika.RADNIKNAPLATE)) {
						NaplatnaStanicaMain window = new NaplatnaStanicaMain();
						window.frame.setVisible(true);
						Centrala.getInstance().end();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NaplatnaStanicaMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 486, 281);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		for(NaplatnaStanica na : cent.getNaplatneStanice()) {
			if(na.getIdStanice() == cent.getUlogovani().getIdRadnogMesta()) {
				naplatna = na;
			}
		}
		
		JButton btnPoValuti = new JButton("Izvestaj po Valuti");
		btnPoValuti.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Transakcija> trans;
				try {
					trans = naplatna.izvestajTipValute(TipValute.valueOf(txtOdabranaValuta.getText().toUpperCase()));
					FileWriter fw = new FileWriter(new File("Centrala\\"+naplatna.getIdStanice()+ "\\izvestaj.txt"));
					for(Transakcija tr : trans) {
						fw.write(tr.toString() + "\n");
					}
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton button = new JButton("Detaljan Izvestaj");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Transakcija> trans;
				try {
					trans = naplatna.detaljanIzvestaj();
					FileWriter fw = new FileWriter(new File("Centrala\\"+naplatna.getIdStanice()+ "\\izvestaj.txt"));
					for(Transakcija tr : trans) {
						fw.write(tr.toString() + "\n");
					}
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnIzvestajPoTipu = new JButton("Izvestaj po Vozilima");
		btnIzvestajPoTipu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Transakcija> trans;
				try {
					trans = naplatna.izvestajTipaVozila(TipVozila.valueOf(txtOdabranoVozilo.getText().toUpperCase()));
					FileWriter fw = new FileWriter(new File("Centrala\\"+naplatna.getIdStanice()+ "\\izvestaj.txt"));
					for(Transakcija tr : trans) {
						fw.write(tr.toString() + "\n");
					}
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnDatumskiIzvestaj = new JButton("Datumski Izvestaj");
		btnDatumskiIzvestaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateFormat form = new SimpleDateFormat("dd.mm.yyyy");
				ArrayList<Transakcija> trans;
				try {
					trans = naplatna.izvestajDatum(form.parse(txtPocetiDatum.getText()), form.parse(txtKrajniDatum.getText()));
					FileWriter fw = new FileWriter(new File("Centrala\\"+naplatna.getIdStanice()+ "\\izvestaj.txt"));
					for(Transakcija tr : trans) {
						fw.write(tr.toString() + "\n");
					}
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		txtPocetiDatum = new JTextField();
		txtPocetiDatum.setText("Poceti Datum");
		txtPocetiDatum.setColumns(10);
		
		txtKrajniDatum = new JTextField();
		txtKrajniDatum.setText("Krajni Datum");
		txtKrajniDatum.setColumns(10);
		
		txtOdabranaValuta = new JTextField();
		txtOdabranaValuta.setText("Odabrana Valuta");
		txtOdabranaValuta.setColumns(10);
		
		txtOdabranoVozilo = new JTextField();
		txtOdabranoVozilo.setText("Odabrano Vozilo");
		txtOdabranoVozilo.setColumns(10);
		
		JButton btnDodajCenovnik = new JButton("Dodaj Cenovnik");
		btnDodajCenovnik.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				for(Deonica deo : naplatna.getDeonice()) {
					if(deo.getIdDeonice() == Integer.parseInt(txtIddeonice.getText())) {
						dodavanjeCene c = new dodavanjeCene();
						ArrayList<Cena> cene = c.returnValue();
						if(!cene.isEmpty()) {
							deo.dodajCenovnik(new Date());
							deo.getCenovnik().get(deo.getCenovnik().size()-1).setCena(cene);
						}
					}
				}
				
			}
		});
		
		txtIddeonice = new JTextField();
		txtIddeonice.setText("idDeonice");
		txtIddeonice.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnIzvestajPoTipu, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
							.addComponent(btnDatumskiIzvestaj, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnPoValuti, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(btnDodajCenovnik))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtPocetiDatum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtKrajniDatum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtOdabranaValuta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(39)
									.addComponent(button, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(txtOdabranoVozilo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(35, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtIddeonice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(210, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDodajCenovnik)
						.addComponent(txtIddeonice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDatumskiIzvestaj)
						.addComponent(txtPocetiDatum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtKrajniDatum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIzvestajPoTipu)
						.addComponent(txtOdabranoVozilo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPoValuti)
						.addComponent(txtOdabranaValuta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
