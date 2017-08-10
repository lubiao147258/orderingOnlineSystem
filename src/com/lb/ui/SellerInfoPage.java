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

import com.lb.service.SellerService;

import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class SellerInfoPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellerInfoPage frame = new SellerInfoPage();
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
	public SellerInfoPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);//去除边框
		setLocationRelativeTo(null);//初始化位置（电脑中心）
		
		
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
				SellerInfoPage.this.dispose();
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
				SellerInfoPage.this.setExtendedState(JFrame.ICONIFIED);
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
		
		JLabel lblNewLabel_1 = new JLabel("商家简介");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 25));
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 90, 115, 49);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("店铺名称：");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(SystemColor.textHighlight);
		label.setFont(new Font("楷体", Font.PLAIN, 25));
		label.setBounds(60, 134, 125, 30);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("店铺简介：");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(SystemColor.textHighlight);
		label_1.setFont(new Font("楷体", Font.PLAIN, 25));
		label_1.setBounds(60, 214, 125, 30);
		contentPane.add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(195, 214, 197, 101);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea(SellerService.getSellerInfo().getShopinfo());
		textArea.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		JLabel label_2 = new JLabel("店铺位置：");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(SystemColor.textHighlight);
		label_2.setFont(new Font("楷体", Font.PLAIN, 25));
		label_2.setBounds(60, 336, 125, 30);
		contentPane.add(label_2);
		
		JLabel lblNewLabel_2 = new JLabel(SellerService.getSellerInfo().getShopname());
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(195, 130, 197, 42);
		contentPane.add(lblNewLabel_2);
		
		JLabel label_3 = new JLabel(SellerService.getSellerInfo().getLocation());
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("楷体", Font.PLAIN, 20));
		label_3.setBounds(195, 336, 197, 42);
		contentPane.add(label_3);
		
		JLabel lblNewLabel_3 = new JLabel("[修改]");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(452, 134, 54, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel label_4 = new JLabel("[修改]");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_4.setBounds(452, 214, 54, 25);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("[修改]");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_5.setBounds(452, 342, 54, 25);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("电话号码：");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(SystemColor.textHighlight);
		label_6.setFont(new Font("楷体", Font.PLAIN, 25));
		label_6.setBounds(60, 384, 125, 30);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel(SellerService.getSellerInfo().getPhone());
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setFont(new Font("楷体", Font.PLAIN, 20));
		label_7.setBounds(195, 380, 197, 42);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("[修改]");
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_8.setBounds(452, 390, 54, 25);
		contentPane.add(label_8);
	}
}
