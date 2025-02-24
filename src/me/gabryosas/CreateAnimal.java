package me.gabryosas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JRadioButton;

public class CreateAnimal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_specie;
	private JTextField txt_eta;
	private JButton btn_aggiungi;
	private JTextField txt_verso;
	
	public CreateAnimal() {
		//Setup GUI
		super("Creazione animale");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ListGUI frame_list = new ListGUI();
		frame_list.setVisible(true);
		
		//Creazione JLabel
		JLabel lbl_title = new JLabel("Registra animale");
		lbl_title.setBounds(133, 11, 180, 33);
		lbl_title.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lbl_title);
		
		JLabel lbl_specie = new JLabel("Specie");
		lbl_specie.setBounds(133, 90, 65, 14);
		contentPane.add(lbl_specie);
		
		JLabel lbl_name = new JLabel("Nome");
		lbl_name.setBounds(133, 55, 65, 14);
		contentPane.add(lbl_name);
		
		JLabel lbl_eta = new JLabel("Et\u00E0");
		lbl_eta.setBounds(133, 125, 65, 14);
		contentPane.add(lbl_eta);
		
		JLabel lbl_verso = new JLabel("Verso");
		lbl_verso.setBounds(133, 160, 65, 14);
		contentPane.add(lbl_verso);
		
		JLabel lbl_zampe = new JLabel("Numero zampe:");
		lbl_zampe.setBounds(133, 186, 130, 16);
		contentPane.add(lbl_zampe);
		
		//Creazione JTextField
		txt_name = new JTextField();
		txt_name.setBounds(177, 55, 86, 20);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		txt_specie = new JTextField();
		txt_specie.setBounds(177, 90, 86, 20);
		txt_specie.setColumns(10);
		contentPane.add(txt_specie);
		
		txt_eta = new JTextField();
		txt_eta.setBounds(177, 125, 86, 20);
		txt_eta.setColumns(10);
		contentPane.add(txt_eta);
		
		txt_verso = new JTextField();
		txt_verso.setColumns(10);
		txt_verso.setBounds(177, 160, 86, 20);
		contentPane.add(txt_verso);
		
		//Creazione JRadioButton
		JRadioButton rdb_button_1 = new JRadioButton("2");
		rdb_button_1.setBounds(133, 210, 121, 24);
		contentPane.add(rdb_button_1);
		
		JRadioButton rdb_button_2 = new JRadioButton("4");
		rdb_button_2.setBounds(133, 238, 121, 24);
		contentPane.add(rdb_button_2);
		
		
		//Gestione errori nella selezione (JRadioButton)
		rdb_button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdb_button_2.isSelected()) {
					rdb_button_2.setSelected(false);
				}
			}
		});
		
		rdb_button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdb_button_1.isSelected()) {
					rdb_button_1.setSelected(false);
				}
			}
		});
		
		//Creazione JButton
		btn_aggiungi = new JButton("Aggiungi animale");
		btn_aggiungi.setBounds(133, 270, 180, 23);
		btn_aggiungi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_aggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txt_name.getText().equalsIgnoreCase("") 
						|| txt_specie.getText().equalsIgnoreCase("")
						|| txt_eta.getText().equalsIgnoreCase("")
						|| txt_verso.getText().equalsIgnoreCase("")
						|| (!rdb_button_1.isSelected() && !rdb_button_2.isSelected())) {
			        message("Per favore inserisci le informazioni richieste", "Errore", JOptionPane.ERROR_MESSAGE);
			        return;
			        //dispose(); //REMIND chiudo la GUI con questo metodo
				} 	
				
				int zampe = rdb_button_1.isSelected() ? Integer.valueOf(rdb_button_1.getText()) : Integer.valueOf(rdb_button_2.getText());
				
				if (!isInt(txt_eta.getText())) {
					message("Numero non valido", "Errore", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				Animali animale = new Animali(
						txt_name.getText(), 
						txt_specie.getText(),
						txt_verso.getText(),
						Integer.valueOf(txt_eta.getText()),
						zampe
						);	
				
				MainZoo.animaliList.add(animale);
				message(
						"Animale aggiunto con successo!\n Nome: " + animale.getNome() + "\nSpecie: " + animale.getSpecie() + "\nEtà: " + animale.getEta() + "\nVerso: " + animale.getVerso(),
						"Animale aggiunto", 
						JOptionPane.INFORMATION_MESSAGE
						);
				
				frame_list.add();
			}
		});
		
		contentPane.add(btn_aggiungi);
	}
	private boolean isInt(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	private void message(String message, String title, int pane) {
        JOptionPane.showMessageDialog(
        		null,
        		message, 
                title, 
                pane
                );
	}
}
