package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import enumi.TipRadnika;
import enumi.TipValute;
import enumi.TipVozila;
import model.Centrala;
import model.Radnik;
import model.Transakcija;

public class CentralaMain {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Centrala cent = Centrala.getInstance();
	private JButton btnDodajKorisnika;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInDialog login = new LogInDialog();
					if(login.returnValue(TipRadnika.ADMINISTRATOR)) {
						CentralaMain window = new CentralaMain();
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
	public CentralaMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("Datumski Izvestaj");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DateFormat form = new SimpleDateFormat("dd.mm.yyyy");
				ArrayList<Transakcija> trans;
				try {
					trans = cent.izvestajDatum(form.parse(textField_2.getText()), form.parse(textField_3.getText()));
					FileWriter fw = new FileWriter(new File("Centrala\\izvestaj.txt"));
					for(Transakcija tr : trans) {
						fw.write(tr.toString() + "\n");
					}
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton button_1 = new JButton("Izvestaj po Vozilima");
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Transakcija> trans;
				try {
					trans = cent.izvestajTipaVozila(TipVozila.valueOf(textField_1.getText().toUpperCase()));
					FileWriter fw = new FileWriter(new File("Centrala\\izvestaj.txt"));
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
		
		JButton button_2 = new JButton("Izvestaj po Valuti");
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Transakcija> trans;
				try {
					trans = cent.izvestajTipValute(TipValute.valueOf(textField.getText().toUpperCase()));
					FileWriter fw = new FileWriter(new File("Centrala\\izvestaj.txt"));
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
		
		JButton button_3 = new JButton("Detaljan Izvestaj");
		button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Transakcija> trans;
				try {
					trans = cent.detaljanIzvestaj();
					FileWriter fw = new FileWriter(new File("Centrala\\izvestaj.txt"));
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
		
		textField = new JTextField();
		textField.setText("Odabrana Valuta");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("Odabrano Vozilo");
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("Poceti Datum");
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText("Krajni Datum");
		textField_3.setColumns(10);
		
		btnDodajKorisnika = new JButton("Dodaj Korisnika");
		btnDodajKorisnika.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DodavanjeKorisnika dk = new DodavanjeKorisnika();
				Radnik rad = dk.returnValue();
				if(rad!=null) {
					cent.dodajRadnika(rad);
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnDodajKorisnika, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
							.addGap(27)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnDodajKorisnika)
					.addGap(112)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(button)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_2)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(button_3)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
