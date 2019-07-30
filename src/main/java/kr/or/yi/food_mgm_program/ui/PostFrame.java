package kr.or.yi.food_mgm_program.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import kr.or.yi.food_mgm_program.dao.PostDao;
import kr.or.yi.food_mgm_program.daoImpl.PostDaoImpl;
import kr.or.yi.food_mgm_program.dto.Post;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PostFrame extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTextField tfAddr;
	
	private PostDao dao;
	private JList<String> list;
	private JButton btnSearch;
	private List<Post> pList;
	
	public PostFrame() {
		dao = new PostDaoImpl();
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pAddr = new JPanel();
		contentPane.add(pAddr, BorderLayout.NORTH);
		pAddr.setLayout(new BorderLayout(0, 0));
		
		tfAddr = new JTextField();
		pAddr.add(tfAddr);
		tfAddr.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		pAddr.add(btnSearch, BorderLayout.EAST);
		
		JPanel pAddrList = new JPanel();
		contentPane.add(pAddrList, BorderLayout.CENTER);
		
		list = new JList<>();
		pAddrList.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane(list);
		pAddrList.add(scrollPane);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
	}
	
	protected void actionPerformedBtnSearch(ActionEvent e) {
		Post post = new Post();
		post.setpDoro(tfAddr.getText().trim());
		List<Post> list = dao.selectByDoro(post);
		System.out.println(list);
	}
}
