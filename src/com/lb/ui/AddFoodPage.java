package com.lb.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;

public class AddFoodPage extends JFrame {

	private JPanel contentPane;
	private JPanel panel_leibie;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFoodPage frame = new AddFoodPage();
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
	public AddFoodPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);//去除边框
		setLocationRelativeTo(null);//初始化位置（电脑中心）
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 608, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lb_close = new JLabel("");
		lb_close.setOpaque(true);
		lb_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddFoodPage.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lb_close.setBackground(new Color(255,0,0)); 
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lb_close.setBackground(new Color(0,191,252)); 
			}
		});
		lb_close.setBackground(new Color(0, 191, 255));
		lb_close.setIcon(new ImageIcon(AdminPage.class.getResource("/image/关闭按钮.png")));
		lb_close.setHorizontalAlignment(SwingConstants.CENTER);
		lb_close.setBounds(583, 0, 25, 25);
		panel.add(lb_close);
		
		JLabel lb_min = new JLabel("");
		lb_min.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddFoodPage.this.setExtendedState(JFrame.ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lb_min.setBackground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lb_min.setBackground(new Color(0,191,252));
			}
		});
		lb_min.setBackground(new Color(0, 191, 255));
		lb_min.setHorizontalAlignment(SwingConstants.CENTER);
		lb_min.setIcon(new ImageIcon(AdminPage.class.getResource("/image/最小化.png")));
		lb_min.setBounds(557, 0, 25, 25);
		lb_min.setOpaque(true);
		panel.add(lb_min);
		
		JLabel lblNewLabel = new JLabel("商 家 后 台 管 理 界 面 ");
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(79, 10, 468, 60);
		panel.add(lblNewLabel);
		
		JPanel panel_leftline = new JPanel();
		panel_leftline.setBackground(new Color(0, 191, 255));
		panel_leftline.setBounds(0, 77, 2, 355);
		contentPane.add(panel_leftline);
		
		JPanel panel_rightline = new JPanel();
		panel_rightline.setBackground(new Color(0, 191, 255));
		panel_rightline.setBounds(606, 77, 2, 355);
		contentPane.add(panel_rightline);
		
		JPanel panel_bottomline = new JPanel();
		panel_bottomline.setBackground(new Color(18,150,193));
		panel_bottomline.setBounds(0, 430, 608, 2);
		contentPane.add(panel_bottomline);
		
		
		/*
		panel_leibie = new JPanel();
		panel_leibie.setBounds(166, 90, 432, 332);
		contentPane.add(panel_leibie);
		panel_leibie.setLayout(null);
		
		JLabel label_2 = new JLabel("输入菜类别名称：");
		label_2.setBounds(10, 49, 149, 30);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(153, 102, 102));
		label_2.setFont(new Font("楷体", Font.PLAIN, 16));
		panel_leibie.add(label_2);
		
		textField = new JTextField();
		textField.setForeground(new Color(51, 51, 51));
		textField.setFont(new Font("楷体", Font.PLAIN, 16));
		textField.setBounds(166, 46, 182, 39);
		panel_leibie.add(textField);
		textField.setColumns(10);
		
		JLabel label_3 = new JLabel("已有菜类别名称：");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(153, 102, 102));
		label_3.setFont(new Font("楷体", Font.PLAIN, 16));
		label_3.setBounds(10, 120, 149, 30);
		panel_leibie.add(label_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(51, 51, 51));
		comboBox.setFont(new Font("楷体", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		comboBox.setBounds(166, 117, 182, 39);
		panel_leibie.add(comboBox);
		
		JLabel label_4 = new JLabel("提 交");
		label_4.setOpaque(true);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("楷体", Font.BOLD, 20));
		label_4.setBackground(new Color(0, 191, 255));
		label_4.setBounds(60, 212, 99, 38);
		panel_leibie.add(label_4);
		*/
		
		
		JLabel label = new JLabel("添加类别");
		label.setBounds(25, 137, 99, 38);
		contentPane.add(label);
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("楷体", Font.BOLD, 20));
		label.setBackground(new Color(240, 240, 240));
		
		JLabel label_1 = new JLabel("添加菜品");
		label_1.setBounds(25, 307, 99, 38);
		contentPane.add(label_1);
		label_1.setOpaque(true);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(0, 0, 128));
		label_1.setFont(new Font("楷体", Font.BOLD, 20));
		label_1.setBackground(new Color(240, 240, 240));
		
		JPanel panel_caipin = new JPanel();
		panel_caipin.setBounds(166, 90, 432, 332);
		contentPane.add(panel_caipin);
		panel_caipin.setLayout(null);
		
		JLabel label_5 = new JLabel("菜类别：");
		label_5.setBounds(10, 26, 149, 30);
		panel_caipin.add(label_5);
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setForeground(new Color(153, 102, 102));
		label_5.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("菜名称：");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(new Color(153, 102, 102));
		label_2.setFont(new Font("楷体", Font.PLAIN, 16));
		label_2.setBounds(10, 76, 149, 30);
		panel_caipin.add(label_2);
		
		JLabel label_3 = new JLabel("单价：");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(new Color(153, 102, 102));
		label_3.setFont(new Font("楷体", Font.PLAIN, 16));
		label_3.setBounds(10, 127, 149, 30);
		panel_caipin.add(label_3);
		
		JLabel label_4 = new JLabel("是否立即上架：");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setForeground(new Color(153, 102, 102));
		label_4.setFont(new Font("楷体", Font.PLAIN, 16));
		label_4.setBounds(10, 176, 112, 30);
		panel_caipin.add(label_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("楷体", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "6", "5", "4"}));
		comboBox.setBounds(106, 25, 176, 35);
		panel_caipin.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 75, 177, 35);
		panel_caipin.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(106, 122, 177, 35);
		panel_caipin.add(textField_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("是");
		rdbtnNewRadioButton.setFont(new Font("楷体", Font.PLAIN, 18));
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(133, 181, 48, 23);
		panel_caipin.add(rdbtnNewRadioButton);
		
		JRadioButton radioButton = new JRadioButton("否");
		radioButton.setFont(new Font("楷体", Font.PLAIN, 18));
		radioButton.setBounds(214, 181, 48, 23);
		panel_caipin.add(radioButton);
		
		JLabel label_6 = new JLabel("提 交");
		label_6.setOpaque(true);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("楷体", Font.BOLD, 20));
		label_6.setBackground(new Color(0, 191, 255));
		label_6.setBounds(45, 238, 99, 38);
		panel_caipin.add(label_6);
	}
}
