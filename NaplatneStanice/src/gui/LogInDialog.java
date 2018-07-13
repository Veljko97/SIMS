package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enumi.TipRadnika;
import model.Radnik;
import model.Utill;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;

public class LogInDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField pwdSifra;
	boolean uspesno = false;
	int trys = 0;
	TipRadnika tipRadnika;

	public boolean returnValue(TipRadnika tipRadnika) {
		setVisible(true);
		this.tipRadnika = tipRadnika;
		return uspesno;
	}
	
	/**
	 * Create the dialog.
	 */
	public LogInDialog() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JFormattedTextField frmtdtxtfldKorisnickoIme = new JFormattedTextField();
		frmtdtxtfldKorisnickoIme.setHorizontalAlignment(SwingConstants.CENTER);
		frmtdtxtfldKorisnickoIme.setText("Korisnicko Ime");
		
		JLabel lblPogresnaSifra = new JLabel("Pogresna sifra");
		lblPogresnaSifra.setForeground(Color.RED);
		lblPogresnaSifra.setVisible(false);
		
		JLabel lblPrevisePogresnihPokusaja = new JLabel("Previse pogresnih pokusaja");
		lblPrevisePogresnihPokusaja.setForeground(Color.RED);
		lblPrevisePogresnihPokusaja.setVisible(false);
		
		pwdSifra = new JPasswordField();
		pwdSifra.setHorizontalAlignment(SwingConstants.CENTER);
		pwdSifra.setText("Sifra");
		
		JButton btnUlogujSe = new JButton("Uloguj se");
		btnUlogujSe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedReader br = new BufferedReader(new FileReader(new File("centrala\\Radnici.txt")));
					String line;
					while((line = br.readLine()) != null) {
						String[] token = line.split("\\|");
						if(token[2].equals(frmtdtxtfldKorisnickoIme.getText())) {
							if(Integer.parseInt(token[5]) == Utill.passworGenerator(pwdSifra.getText())) {
								uspesno = true;
								break;
							}else {
								lblPogresnaSifra.setVisible(true);
								break;
							}
						}
					}
					trys++;
					br.close();
					if(trys == 3 && !uspesno) {
						lblPrevisePogresnihPokusaja.setVisible(true);
						btnUlogujSe.setEnabled(false);
					}
					
					if(uspesno) {
						dispose();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(103)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(pwdSifra, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
								.addComponent(frmtdtxtfldKorisnickoIme, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPogresnaSifra)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(162)
							.addComponent(btnUlogujSe))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(139)
							.addComponent(lblPrevisePogresnihPokusaja)))
					.addContainerGap(125, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(22)
					.addComponent(frmtdtxtfldKorisnickoIme, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pwdSifra, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPogresnaSifra)
					.addGap(19)
					.addComponent(btnUlogujSe)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPrevisePogresnihPokusaja)
					.addContainerGap(77, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
