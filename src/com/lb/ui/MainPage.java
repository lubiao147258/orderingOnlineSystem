package com.lb.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MainPage extends JFrame {

	private JPanel contentPane;
	private Point origin = new Point();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 73);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("关闭");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainPage.this.dispose();
			}
		});
		button.setBounds(743, 0, 57, 23);
		panel.add(button);
		
		this.setUndecorated(true);//去除边框
		setLocationRelativeTo(null);//初始化位置（电脑中心）
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
				Point p = MainPage.this.getLocation();
				MainPage.this.setLocation(p.x+e.getX()-origin.x, p.y+e.getY()-origin.y);
			}
			
		});
	}
}
