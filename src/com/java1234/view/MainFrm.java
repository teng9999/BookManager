package com.java1234.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	JDesktopPane table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrm() {
		
		//改变系统默认字体
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
		
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 395);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		menuBar.add(menu);
		
		JMenu menu_2 = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		menu.add(menu_2);
		
		JMenuItem menuItem = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		menu_2.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		menu_2.add(menuItem_1);
		
		JMenu menu_3 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menu.add(menu_3);
		
		JMenuItem menuItem_2 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		menu_3.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		menu_3.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "是否退出系统");
				if(result==0){
					dispose();
				}
			}
		});
		menu.add(menuItem_4);
		
		JMenu menu_1 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		menuBar.add(menu_1);
		
		JMenuItem mntmjava = new JMenuItem("\u5173\u4E8Ejava1234");
		mntmjava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Java1234InterFrm java1234InterFrm=new Java1234InterFrm();
				java1234InterFrm.setVisible(true);
				table.add(java1234InterFrm);
			}
		});
		menu_1.add(mntmjava);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		table.setBackground(SystemColor.activeCaption);
		contentPane.add(table, BorderLayout.CENTER);
		
		//设置JFrame窗体最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
