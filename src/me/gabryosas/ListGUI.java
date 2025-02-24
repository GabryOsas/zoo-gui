package me.gabryosas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Color;

public class ListGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbl_error;
	private JTable table;
	
	public ListGUI() {
		//Setup GUI
		super("Lista ZOO");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_title = new JLabel("Lista animali nello zoo:");
		lbl_title.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_title.setBounds(102, 12, 235, 25);
		contentPane.add(lbl_title);
		
		lbl_error = new JLabel("Animali non trovati.");
		lbl_error.setVisible(false);
		lbl_error.setForeground(new Color(255, 0, 0));
		lbl_error.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_error.setBounds(122, 150, 196, 14);
		contentPane.add(lbl_error);
		add();
	}
	public void add() {
		int y = 50;
		if (MainZoo.animaliList.isEmpty()) {
			lbl_error.setVisible(true);
		} else {
			lbl_error.setVisible(false);
		}
		for (int i = 0; i < MainZoo.animaliList.size(); i++) {
			Animali animali = MainZoo.animaliList.get(i);
			JLabel lbl_animali = new JLabel(animali.getNome());
			lbl_animali.setToolTipText(
					"Nome: " + animali.getNome() + " Specie: " + animali.getSpecie() + " Età: " + animali.getEta() + " Verso: " + animali.getVerso()
			);
			lbl_animali.setBounds(102, y, 196, 14);
			contentPane.add(lbl_animali);			
			y += 25;
		}
		revalidate();
		repaint();
	}
}
