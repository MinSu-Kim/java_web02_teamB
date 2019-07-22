package kr.or.yi.food_mgm_program.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ManagementFrame extends JFrame {

	private JPanel contentPane;

	
	public ManagementFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1105, 716);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(10000, 32767));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(10000, 32767));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(31, 119, 182, 52);
		panel.add(btnNewButton);
		
		JButton button = new JButton("New button");
		button.setBounds(31, 192, 182, 52);
		panel.add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(31, 272, 182, 52);
		panel.add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(31, 343, 182, 52);
		panel.add(button_2);
		
		JButton button_3 = new JButton("New button");
		button_3.setBounds(31, 417, 182, 52);
		panel.add(button_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 10, 10);
		panel.add(panel_2);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
	}
}
