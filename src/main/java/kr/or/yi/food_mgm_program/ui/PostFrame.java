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
import kr.or.yi.food_mgm_program.ui.insert.PanelMemberInfo;

import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class PostFrame extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTextField tfAddr;
	
	private PostDao dao;
	private JList<String> jlist;
	private JButton btnSearch;
	private List<Post> pList;
	private String[] arr_pLists;
	private JPanel pBtn;
	private JButton btnOK;
	
	private PanelMemberInfo parent;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JPanel panel_1;

	public PostFrame() {
		dao = new PostDaoImpl();
		pList = null;
		initComponents();
	}
	
	private void initComponents() {
		setTitle("주소찾기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 400, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(1, 5, 1, 0));
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblNewLabel = new JLabel("※ 도로명 주소를 입력하세요.");
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(Color.BLUE);
		
		JPanel pAddr = new JPanel();
		panel.add(pAddr);
		pAddr.setLayout(new BorderLayout(0, 0));
		
		tfAddr = new JTextField();
		tfAddr.setText("");
		tfAddr.registerKeyboardAction(this, "search", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);
		pAddr.add(tfAddr);
		tfAddr.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.setActionCommand("search");
		btnSearch.addActionListener(this);
		pAddr.add(btnSearch, BorderLayout.EAST);
		
		JPanel pAddrList = new JPanel();
		contentPane.add(pAddrList, BorderLayout.CENTER);
		
		jlist = new JList<>();
		pAddrList.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane(jlist);
		pAddrList.add(scrollPane);
		
		pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);
		pBtn.setLayout(new BorderLayout(0, 0));
		
		btnOK = new JButton("확인");
		btnOK.addActionListener(this);
		pBtn.add(btnOK, BorderLayout.EAST);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOK) {
			actionPerformedBtnOK(e);
		}
		if (e.getActionCommand() == "search") {
			actionPerformedBtnSearch(e);
		}
	}
	
	protected void actionPerformedBtnSearch(ActionEvent e) {
		if(tfAddr.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "검색할 주소를 입력하세요.");
		}else {
			Post post = new Post();
			post.setpDoro(tfAddr.getText().trim());
			pList = dao.selectByDoro(post);
			
			if(pList.size() == 0) {
				JOptionPane.showMessageDialog(null, "검색하신 주소가 없습니다.");
				clear();
			}else {
				arrayList(pList.size());
			}
		}
	}

	public void arrayList(int size) {
		arr_pLists = new String[size];
		for (int i = 0; i < size ; i++) {
			arr_pLists[i] = pList.get(i).toString();
		}
		jlist.setListData(arr_pLists);
	}

	public void clear() {
		tfAddr.setText("");
		arrayList(0);
	}
	
	protected void actionPerformedBtnOK(ActionEvent e) {
		setVisible(false);
		
		String addr = jlist.getSelectedValue();
		parent.setAddr(addr);
	}
	
	public void setParent(PanelMemberInfo parent) {
		this.parent = parent;
	}
}
