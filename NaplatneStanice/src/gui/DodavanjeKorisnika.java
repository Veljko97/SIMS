package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enumi.TipRadnika;
import model.Radnik;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

public class DodavanjeKorisnika extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3594750698249800812L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtImeRadnika;
	private JTextField txtPrezimeRadnika;
	private JTextField txtKorisnickoIme;
	private JTextField txtSifra;
	private JTextField txtJmbg;
	private JTextField txtTipRadnika;
	private JTextField txtIdRadnogMesta;
	private Radnik radnik = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DodavanjeKorisnika dialog = new DodavanjeKorisnika();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Radnik returnValue() {
		setVisible(true);
		return radnik;
	}

	/**
	 * Create the dialog.
	 */
	public DodavanjeKorisnika() {
		setModal(true);
		setBounds(100, 100, 431, 244);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		txtImeRadnika = new JTextField();
		txtImeRadnika.setText("Ime Radnika");
		txtImeRadnika.setColumns(10);
		txtPrezimeRadnika = new JTextField();
		txtPrezimeRadnika.setText("Prezime Radnika");
		txtPrezimeRadnika.setColumns(10);
		txtKorisnickoIme = new JTextField();
		txtKorisnickoIme.setText("Korisnicko ime");
		txtKorisnickoIme.setColumns(10);
		txtSifra = new JTextField();
		txtSifra.setText("Sifra");
		txtSifra.setColumns(10);
		txtJmbg = new JTextField();
		txtJmbg.setText("JMBG");
		txtJmbg.setColumns(10);
		txtTipRadnika = new JTextField();
		txtTipRadnika.setText("Tip Radnika");
		txtTipRadnika.setColumns(10);
		txtIdRadnogMesta = new JTextField();
		txtIdRadnogMesta.setText("Id Radnog Mesta");
		txtIdRadnogMesta.setColumns(10);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				radnik = new Radnik(txtImeRadnika.getText(),txtPrezimeRadnika.getText(),txtKorisnickoIme.getText(),txtSifra.getText(),Double.parseDouble(txtJmbg.getText()),TipRadnika.valueOf(txtTipRadnika.getText().toUpperCase()),Integer.parseInt(txtIdRadnogMesta.getText()));
				dispose();
			}
		});
		
		JButton btnOtkazi = new JButton("Otkazi");
		btnOtkazi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txtIdRadnogMesta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(56)
							.addComponent(btnPotvrdi)
							.addGap(18)
							.addComponent(btnOtkazi))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txtKorisnickoIme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtSifra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtTipRadnika, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txtImeRadnika, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtPrezimeRadnika, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtJmbg, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtImeRadnika, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPrezimeRadnika, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtJmbg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtKorisnickoIme, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSifra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTipRadnika, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtIdRadnogMesta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOtkazi)
						.addComponent(btnPotvrdi))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
	}

}
