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
import java.util.MissingFormatArgumentException;

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
import com.lb.util.DBManager;

import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class UpdateAddressPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5423380881306114662L;
	public static int userID;
	private JPanel contentPane;
	private Point origin = new Point();
	private JTextField textField;
	private JTextArea textArea;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	public static int addressId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateAddressPage frame = new UpdateAddressPage();
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
	public UpdateAddressPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);//去除边框
		setLocationRelativeTo(null);
		
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
				UpdateAddressPage.this.dispose();
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
		
		JLabel label_5 = new JLabel("修改地址");
		label_5.setBounds(0, 0, 79, 30);
		panel.add(label_5);
		label_5.setForeground(new Color(255, 255, 255));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_leftline = new JPanel();
		panel_leftline.setBackground(new Color(0, 191, 255));
		panel_leftline.setBounds(0, 29, 2, 371);
		contentPane.add(panel_leftline);
		
		JPanel panel_rightline = new JPanel();
		panel_rightline.setBackground(new Color(0, 191, 255));
		panel_rightline.setBounds(498, 29, 2, 371);
		contentPane.add(panel_rightline);
		
		JPanel panel_bottomline = new JPanel();
		panel_bottomline.setBackground(new Color(0, 191, 255));
		panel_bottomline.setBounds(0, 328, 500, 2);
		contentPane.add(panel_bottomline);
		
		JLabel label_1 = new JLabel("性 别");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_1.setBounds(62, 59, 54, 15);
		contentPane.add(label_1);
		
		radioButton = new JRadioButton("男");
		radioButton.setFocusPainted(false);
		radioButton.setBounds(147, 55, 45, 23);
		contentPane.add(radioButton);
		
		radioButton_1 = new JRadioButton("女");
		radioButton_1.setFocusPainted(false);
		radioButton_1.setBounds(240, 55, 45, 23);
		contentPane.add(radioButton_1);
		if(UserService.getAddressInfoByIdService(addressId).getSex().equals("男")){
			radioButton.setSelected(true);
		}else{
			radioButton_1.setSelected(true);
		}
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioButton_1);
		bg.add(radioButton);
		
		JLabel label_2 = new JLabel("详细地址");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_2.setBounds(62, 97, 54, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("电话");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_3.setBounds(62, 206, 54, 15);
		contentPane.add(label_3);
		
		textField = new JTextField(UserService.getAddressInfoByIdService(addressId).getPhone());
		textField.setColumns(10);
		textField.setBounds(126, 199, 169, 29);
		contentPane.add(textField);
		
		JLabel label_4 = new JLabel("提  交");
		label_4.setForeground(new Color(255, 255, 255));
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_4.setBackground(new Color(0, 191, 255));
		label_4.setOpaque(true);
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_4.setBackground(new Color(18, 150, 193));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label_4.setBackground(new Color(0, 191, 255));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				label_4.setBackground(new Color(7, 50, 93));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				label_4.setBackground(new Color(18, 150, 193));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// new SellerInfoPage().setVisible(true);
				if(textArea.getText().length()!=0||textField.getText().length()!=0){
					String sex;
					if(radioButton.isSelected()){
						sex="男";
					}else{
						sex="女";
					}
					String address=textArea.getText();
					String phone=textField.getText();
					String[] objs = new String[]{sex,address,phone,String.valueOf(addressId)};
					if(DBManager.executeUpdate("update [address] set user_sex=?,address_detail=?,phone=? where address_Id=?", objs)){
						JOptionPane.showMessageDialog(UpdateAddressPage.this, "修改成功!","提示",JOptionPane.INFORMATION_MESSAGE);
						textArea.setText("");
						textField.setText("");
						UpdateAddressPage.this.dispose();
						new MainPage().setVisible(true);
					}else{
						JOptionPane.showMessageDialog(UpdateAddressPage.this, "修改失败!","提示",JOptionPane.INFORMATION_MESSAGE);
						textArea.setText("");
						textField.setText("");
					}
					
				}else{
					JOptionPane.showMessageDialog(UpdateAddressPage.this, "不能为空!","提示",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(83, 269, 128, 29);
		contentPane.add(label_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(126, 97, 181, 79);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea(UserService.getAddressInfoByIdService(addressId).getAddressdetail());
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
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
				Point p = UpdateAddressPage.this.getLocation();
				UpdateAddressPage.this.setLocation(p.x+e.getX()-origin.x, p.y+e.getY()-origin.y);
			}
			
		});
		//setSize(430, 333);
		setLocationRelativeTo(null);
	}
}
