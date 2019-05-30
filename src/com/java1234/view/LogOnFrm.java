package com.java1234.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument.LeafElement;

import com.java1234.model.User;
import com.java1234.model.UserDao;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

public class LogOnFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao=new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrm frame = new LogOnFrm();
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
	public LogOnFrm() {
		
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
				
		setResizable(false);
		setTitle(" \u7BA1\u7406\u5458\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("宋体", Font.BOLD, 19));
		label.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/logo.png")));
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6    \u7801\uFF1A");
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		
		JButton btnNewButton = new JButton("\u767B  \u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginValueActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD  \u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(113)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(86)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(passwordTxt))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNewButton_1)))))
					.addContainerGap(120, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(label)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(41))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);//为null,启动程序时窗口将置于屏幕的中央
	}

	/**
	 * 登录事件处理
	 * @param e
	 */
	private void loginValueActionPerformed(ActionEvent evt) {
		String userName=this.userNameTxt.getText();
		String password=new String(this.passwordTxt.getPassword());
		
		if(StringUtil.isEmpty(userName)){
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(StringUtil.isEmpty(password)){
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		
		User user=new User(userName, password);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			User currentUser=userDao.login(con, user);
			if(currentUser!=null){
				dispose();   //销毁当前窗体
				new MainFrm().setVisible(true);  //调出主窗体可见
				System.out.println("登录成功");
				//JOptionPane.showMessageDialog(null, "登录成功");
			}else{
				JOptionPane.showMessageDialog(null, "用户名或密码错误");
			}
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		
		
		
		
	}
	
	/**
	 * 重置事件处理
	 * @param evt
	 */
	protected void resetValueActionPerformed(ActionEvent evt) {
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
		
		
	}
}
