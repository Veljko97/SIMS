package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import enumi.TipRadnika;
import enumi.TipValute;
import enumi.TipVozila;
import model.Cena;
import model.Cenovnik;
import model.Centrala;
import model.Deonica;
import model.Grad;
import model.NaplatnaStanica;
import model.Transakcija;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class NaplatnoMestoMain {

	private JFrame frame;
	private Centrala cent = Centrala.getInstance();
	private final String osnovaLabele = "Cena Putarine: ";
	NaplatnaStanica naplatna = null;
	private double cena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NaplatnoMestoMain window = new NaplatnoMestoMain();
					LogInDialog login = new LogInDialog();
					login.returnValue(TipRadnika.administrator);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NaplatnoMestoMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblCenaPutarine = new JLabel(osnovaLabele);
		lblCenaPutarine.setFont(new Font("Arial", Font.BOLD, 16));
		
		JComboBox comboBox_1 = new JComboBox();
		JComboBox comboBox = new JComboBox();
		JComboBox comboBox_2 = new JComboBox();
		for(TipVozila tv : TipVozila.values()) {
			comboBox.addItem(tv);
		}
		for(TipValute tv : TipValute.values()) {
			comboBox_2.addItem(tv);
		}
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBox_1.removeAllItems();
				for(NaplatnaStanica na : cent.getNaplatneStanice()) {
					if(na.getIdStanice() == cent.getUlogovani().getIdRadnogMesta()) {
						naplatna = na;
						break;
					}
				}
				for(Deonica deo : naplatna.getDeonice()) {
					if(!deo.getOdredisniGrad().equals(naplatna.getGrad())) {
						comboBox_1.addItem(deo.getOdredisniGrad());
					}else {
						comboBox_1.addItem(deo.getPolazniGrad());
					}
				}
				
			}
		});
		
		comboBox_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag = false;
				for(Deonica deo : naplatna.getDeonice()) {
					if(deo.getOdredisniGrad().equals(comboBox_1.getSelectedItem()) || deo.getPolazniGrad().equals(comboBox_1.getSelectedItem())){
						for(Cenovnik cen : deo.getCenovnik()) {
							if(cen.isAktivnost()) {
								TipVozila tp = (TipVozila) comboBox.getSelectedItem();
								TipValute tv = (TipValute) comboBox_2.getSelectedItem();
								for(Cena ce : cen.getCena()) {
									if (ce.getTipVozila() == tp) {
										if(tv.equals(TipValute.DINAR)) {
											lblCenaPutarine.setText(osnovaLabele + ce.getDinarCena());
											cena = ce.getDinarCena();
										}else {
											lblCenaPutarine.setText(osnovaLabele + ce.getEvroCena());
											cena = ce.getEvroCena();
										}
										flag = true;
										break;
									}
								}
							}
							if(flag) {
								break;
							}
						}
					}
					if(flag) {
						break;
					}
				}
			}
		});
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				naplatna.getMesta().get(0).izvrsiTransakciju((TipVozila) comboBox.getSelectedItem(), (TipValute) comboBox_2.getSelectedItem(), cena, new Date());
				comboBox.setSelectedIndex(0);
				comboBox_1.removeAllItems();
			}
		});
		
		lblCenaPutarine.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(322, Short.MAX_VALUE)
					.addComponent(btnPotvrdi, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(comboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(comboBox_1, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(comboBox_2, Alignment.LEADING, 0, 153, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addComponent(lblCenaPutarine, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(36))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCenaPutarine, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addComponent(btnPotvrdi, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblCenaPutarine, comboBox, comboBox_1, comboBox_2, btnPotvrdi}));
	}
}
