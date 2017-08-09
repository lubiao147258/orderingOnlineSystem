package com.lb.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.lb.dao.IUser;
import com.lb.dao.impl.IUserImpl;
import com.lb.entity.User;
import com.lb.service.UserService;


public class LoginPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5491125811820657678L;
	private JPanel contentPane;
	private Point origin = new Point();
	private JTextField username;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(235,242,239));
		contentPane.setBorder(BorderFactory.createLineBorder(new Color(255,0,255)));
		contentPane.setToolTipText("");
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 255));
		panel.setBounds(0, 0, 431, 137);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_close = new JButton("");
		btn_close.setBounds(401, 0, 30, 30);
		panel.add(btn_close);
		btn_close.setBackground(new Color(51, 153, 255));
		btn_close.setToolTipText("关闭");
		btn_close.setIcon(new ImageIcon(LoginPage.class.getResource("/image/错误.png")));
		btn_close.setFocusPainted(false);
		btn_close.setBorderPainted(false);
		
		JLabel lblNewLabel = new JLabel("在 线 点 餐 系 统");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("仿宋", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(73, 37, 285, 65);
		panel.add(lblNewLabel);
		
		JButton btn_min = new JButton("");
		//最小化按钮鼠标监听事件
		btn_min.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_min.setBackground(new Color(212, 64, 39));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_min.setBackground(new Color(51, 153, 255));
			}
		});
		btn_min.setIcon(new ImageIcon(LoginPage.class.getResource("/image/最小化.png")));
		btn_min.setToolTipText("关闭");
		btn_min.setFocusPainted(false);
		btn_min.setBorderPainted(false);
		btn_min.setBackground(new Color(51, 153, 255));
		btn_min.setBounds(371, 0, 30, 30);
		panel.add(btn_min);
		
		username = new JTextField();
		username.setFont(new Font("新宋体", Font.BOLD, 15));
		username.setBounds(126, 188, 186, 32);
		contentPane.add(username);
		username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(126, 218, 186, 32);
		contentPane.add(passwordField);
		
		JRadioButton rbtn_user = new JRadioButton("用户");
		rbtn_user.setFont(new Font("宋体", Font.PLAIN, 13));
		rbtn_user.setSelected(true);
		rbtn_user.setBounds(154, 159, 57, 23);
		rbtn_user.setFocusPainted(false);
		contentPane.add(rbtn_user);
		
		JRadioButton rbtn_seller = new JRadioButton("商家");
		rbtn_seller.setFont(new Font("宋体", Font.PLAIN, 13));
		rbtn_seller.setBounds(234, 159, 78, 23);
		rbtn_seller.setFocusPainted(false);
		contentPane.add(rbtn_seller);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbtn_user);
		bg.add(rbtn_seller);
		
		JLabel register = new JLabel("注册账号");
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				register.setForeground(new Color(255, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				register.setForeground(new Color(0, 153, 255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginPage.this.dispose();
				new RegisterPage().setVisible(true);
			}
		});
		register.setFont(new Font("微软雅黑", Font.PLAIN, 11));
		register.setForeground(new Color(0, 153, 255));
		register.setBounds(334, 195, 54, 15);
		contentPane.add(register);
		
		JLabel findpsw = new JLabel("找回密码");
		findpsw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				findpsw.setForeground(new Color(255, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				findpsw.setForeground(new Color(0, 153, 255));
			}
		});
		findpsw.setFont(new Font("微软雅黑", Font.PLAIN, 11));
		findpsw.setForeground(new Color(0, 153, 255));
		findpsw.setBounds(334, 226, 54, 15);
		contentPane.add(findpsw);
		
		JButton btn_login = new JButton("登   录");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User u = new User(username.getText(),new String(passwordField.getPassword()));
				//IUser user = new IUserImpl();
				System.out.println(UserService.loginService(u));
				if(UserService.loginService(u)>=1){
					JOptionPane.showMessageDialog(LoginPage.this, "正在登陆。。。。!","提示",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_login.setBackground(new Color(60,195,245));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_login.setBackground(new Color(9,163,220));
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btn_login.setBackground(new Color(60,195,245));
			}
		});
		btn_login.setBackground(new Color(9,163,220));
		btn_login.setForeground(Color.WHITE);
		btn_login.setFont(new Font("宋体", Font.PLAIN, 12));
		btn_login.setBounds(128, 278, 184, 32);
		btn_login.setToolTipText("点击登录");
		btn_login.setFocusPainted(false);
		btn_login.setBorderPainted(false);
		contentPane.add(btn_login);
		
		JPanel panel_leftline = new JPanel();
		panel_leftline.setBackground(new Color(51,153,255));
		panel_leftline.setBounds(0, 112, 2, 221);
		contentPane.add(panel_leftline);
		
		JPanel panel_rightline = new JPanel();
		panel_rightline.setBackground(new Color(51, 153, 255));
		panel_rightline.setBounds(428, 112, 2, 221);
		contentPane.add(panel_rightline);
		
		JPanel panel_bottomline = new JPanel();
		panel_bottomline.setBackground(new Color(51, 153, 255));
		panel_bottomline.setBounds(0, 331, 431, 2);
		contentPane.add(panel_bottomline);
		
		//最小化事件
		btn_min.addActionListener(new ActionListener(){
	        @Override public void actionPerformed(ActionEvent e){
	        	LoginPage.this.setExtendedState(JFrame.ICONIFIED);
	        }
	    });
		btn_close.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				LoginPage.this.dispose();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btn_close.setBackground(new Color(51, 153, 255));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btn_close.setBackground(new Color(212, 64, 39));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				LoginPage.this.dispose();
			}
		});
		setSize(430, 333);
		setLocationRelativeTo(null);
		
		//setDefaultLookAndFeelDecorated(true);  
		
		
		this.setUndecorated(true);//去除边框
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e){
				origin.x=e.getX();
				origin.y=e.getY();
			}
			
		});
		
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e){
				Point p = LoginPage.this.getLocation();
				LoginPage.this.setLocation(p.x+e.getX()-origin.x, p.y+e.getY()-origin.y);
			}
			
		});
		
		
	}
}
