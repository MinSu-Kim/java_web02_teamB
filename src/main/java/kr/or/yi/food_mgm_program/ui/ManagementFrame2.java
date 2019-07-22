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
import java.awt.Component;
import javax.swing.border.BevelBorder;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class ManagementFrame2 extends JFrame {

	private JPanel contentPane;

	
	public ManagementFrame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1105, 716);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(300, 60000));
		contentPane.setBorder(new LineBorder(Color.ORANGE));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setAutoscrolls(true);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.YELLOW));
		panel.setBounds(new Rectangle(0, 0, 1, 1));
		panel.setMaximumSize(new Dimension(800, 60000));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 20, 20));
		
		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		JButton button_3 = new JButton("New button");
		panel.add(button_3);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.add(btnNewButton);
		
		JButton button = new JButton("New button");
		panel.add(button);
		
		JButton button_2 = new JButton("New button");
		panel.add(button_2);
		
		JButton button_1 = new JButton("New button");
		button_1.setAlignmentY(20.0f);
		button_1.setAlignmentX(20.0f);
		panel.add(button_1);
		
		JLabel label_1 = new JLabel("");
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		panel.add(label_2);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
	}
}
