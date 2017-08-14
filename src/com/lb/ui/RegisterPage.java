package com.lb.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.lb.entity.User;
import com.lb.service.UserService;
import com.lb.util.CheckEmail;
import com.lb.util.CreatCode;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class RegisterPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5423380881306114662L;
	private JPanel contentPane;
	private Point origin = new Point();
	private JTextField textField_name;
	private JPasswordField passwordField_psw1;
	private JPasswordField passwordField_psw2;
	private JTextField textField_email;
	private JTextField textField_yzm;
	private JLabel yzm;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}*/

	/**
	 * Create the frame.
	 */
	public RegisterPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);//去除边框
		setLocationRelativeTo(null);//初始化位置（电脑中心）
		
		JLabel lab_name = new JLabel("用  户 名：");
		lab_name.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lab_name.setBounds(54, 58, 71, 15);
		contentPane.add(lab_name);
		
		JLabel lab_psw = new JLabel("密      码：");
		lab_psw.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lab_psw.setBounds(54, 111, 71, 15);
		contentPane.add(lab_psw);
		
		JLabel lab_psw2 = new JLabel("确认密码：");
		lab_psw2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lab_psw2.setBounds(54, 162, 71, 15);
		contentPane.add(lab_psw2);
		
		JLabel lab_email = new JLabel("邮      箱：");
		lab_email.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lab_email.setBounds(54, 218, 71, 15);
		contentPane.add(lab_email);
		
		JLabel lab_yzm = new JLabel("验  证 码：");
		lab_yzm.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lab_yzm.setBounds(54, 274, 71, 15);
		contentPane.add(lab_yzm);
		
		JButton btn_register = new JButton("立即注册");
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_name.getText().length()==0||(new String(passwordField_psw1.getPassword()).length()==0)||
						(new String(passwordField_psw2.getPassword()).length()==0)||textField_email.getText().length()==0){
					JOptionPane.showMessageDialog(RegisterPage.this, "输入框不能为空!","提示",JOptionPane.INFORMATION_MESSAGE);
				}else{
					if((new String(passwordField_psw2.getPassword()).equalsIgnoreCase((new String(passwordField_psw1.getPassword()))))){
						if(!CheckEmail.emailCheck(textField_email.getText())){
							JOptionPane.showMessageDialog(RegisterPage.this, "邮箱格式不正确!","提示",JOptionPane.INFORMATION_MESSAGE);
							textField_email.setText("");
						}else{
							if(textField_yzm.getText().length()==0){
								JOptionPane.showMessageDialog(RegisterPage.this, "验证码不能为空!","提示",JOptionPane.INFORMATION_MESSAGE);
							}else{
								if((yzm.getText().toLowerCase()).equals((textField_yzm.getText().toLowerCase()))){
									SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									User user = new User(textField_name.getText(),new String(passwordField_psw1.getPassword()),textField_email.getText(),-1,df.format(new Date()));
									if(UserService.registerService(user)){
										JOptionPane.showMessageDialog(RegisterPage.this, "注册成功!","提示",JOptionPane.INFORMATION_MESSAGE);
									}else{
										JOptionPane.showMessageDialog(RegisterPage.this, "注册失败!","提示",JOptionPane.INFORMATION_MESSAGE);
									}
								}
								else{
									JOptionPane.showMessageDialog(RegisterPage.this, "验证码不正确!","提示",JOptionPane.INFORMATION_MESSAGE);
									textField_yzm.setText("");
								}
							}
						}
					}else{
						JOptionPane.showMessageDialog(RegisterPage.this, "两次密码不一致!","提示",JOptionPane.INFORMATION_MESSAGE);
						passwordField_psw1.setText("");
						passwordField_psw2.setText("");
					}
				}
			}
		});
		btn_register.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btn_register.setFocusPainted(false);
		
		btn_register.setBounds(80, 333, 93, 23);
		contentPane.add(btn_register);
		
		JLabel lab_backToLogin = new JLabel("我已有账号，返回登录！");
		lab_backToLogin.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lab_backToLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterPage.this.dispose();
				new LoginPage().setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lab_backToLogin.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lab_backToLogin.setForeground(new Color(51,153,255));
			}
		});
		lab_backToLogin.setForeground(new Color(51, 153, 255));
		lab_backToLogin.setBounds(319, 337, 132, 15);
		contentPane.add(lab_backToLogin);
		
		textField_name = new JTextField();
		textField_name.setBounds(135, 54, 199, 23);
		contentPane.add(textField_name);
		textField_name.setColumns(10);
		
		passwordField_psw1 = new JPasswordField();
		passwordField_psw1.setBounds(135, 107, 199, 23);
		contentPane.add(passwordField_psw1);
		
		passwordField_psw2 = new JPasswordField();
		passwordField_psw2.setBounds(135, 158, 199, 23);
		contentPane.add(passwordField_psw2);
		
		textField_email = new JTextField();
		textField_email.setBounds(135, 214, 199, 23);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		
		textField_yzm = new JTextField();
		textField_yzm.setBounds(135, 263, 132, 38);
		contentPane.add(textField_yzm);
		textField_yzm.setColumns(10);
		
		yzm = new JLabel(CreatCode.getCode());
		yzm.setForeground(new Color(102, 51, 153));
		yzm.setToolTipText("看不清，换一个");
		yzm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				yzm.setText(CreatCode.getCode());
			}
		});
		//System.out.println("验证码："+yzm.getText());
		yzm.setFont(new Font("Segoe Print", Font.BOLD, 30));
		yzm.setBounds(316, 263, 119, 38);
		contentPane.add(yzm);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 500, 30);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RegisterPage.this.dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				label.setBackground(new Color(255, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label.setBackground(new Color(0, 191, 252));
			}
		});
		label.setBounds(478, 0, 22, 22);
		panel.add(label);
		label.setIcon(new ImageIcon(RegisterPage.class.getResource("/image/关闭按钮.png")));
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(new Color(0, 191, 255));
		
		JPanel panel_leftline = new JPanel();
		panel_leftline.setBackground(new Color(0, 191, 255));
		panel_leftline.setBounds(0, 29, 2, 371);
		contentPane.add(panel_leftline);
		
		JPanel panel_rightline = new JPanel();
		panel_rightline.setBackground(new Color(0, 191, 255));
		panel_rightline.setBounds(498, 29, 2, 371);
		contentPane.add(panel_rightline);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(0, 398, 500, 2);
		contentPane.add(panel_1);
		//this.setUndecorated(true);//去除边框
		this.setResizable(false);
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
				Point p = RegisterPage.this.getLocation();
				RegisterPage.this.setLocation(p.x+e.getX()-origin.x, p.y+e.getY()-origin.y);
			}
			
		});
		//setSize(430, 333);
		setLocationRelativeTo(null);
	}
}
