package com.lb.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminPage extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
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
	public AdminPage() {
		setTitle("后台管理员界面");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 608, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);//去除边框
		setLocationRelativeTo(null);//初始化位置（电脑中心）
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(129, 80, 477, 350);
		contentPane.add(scrollPane);
		String[] cols = {"序号","商品名称","单价","类别","在售否"};
		DefaultTableModel mod = new DefaultTableModel(cols, 0);
		table = new JTable(mod);
		table.setBackground(new Color(240, 240, 240));
		table.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		table.setRowHeight(30);
		table.getTableHeader().setReorderingAllowed(false);//表头不可拖动
		table.getTableHeader().setResizingAllowed(false);//列大小不可改变
		mod.addRow(new Object[]{"1001","jack","10000.0"});
		mod.addRow(new Object[]{"1002","jack1","15000.0"});
		mod.addRow(new Object[]{"1003","jack2","30000.0"});
		scrollPane.setViewportView(table);
		
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
				AdminPage.this.dispose();
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
				AdminPage.this.setExtendedState(JFrame.ICONIFIED);
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
		
		JLabel lblNewLabel_1 = new JLabel("添加商品");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setBackground(new Color(18,150,193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setBackground(new Color(0,191,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblNewLabel_1.setBackground(new Color(7,50,93));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblNewLabel_1.setBackground(new Color(18,150,193));
			}
		});
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0, 191, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 20));
		lblNewLabel_1.setBounds(20, 111, 99, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("删除商品");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setBackground(new Color(18,150,193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setBackground(new Color(0,191,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				label.setBackground(new Color(7,50,93));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				label.setBackground(new Color(18,150,193));
			}
		});
		label.setForeground(new Color(255, 255, 255));
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("楷体", Font.BOLD, 20));
		label.setBackground(new Color(0, 191, 255));
		label.setBounds(20, 182, 99, 38);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("修改商品");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_1.setBackground(new Color(18,150,193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_1.setBackground(new Color(0,191,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				label_1.setBackground(new Color(7,50,93));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				label_1.setBackground(new Color(18,150,193));
			}
		});
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setOpaque(true);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("楷体", Font.BOLD, 20));
		label_1.setBackground(new Color(0, 191, 255));
		label_1.setBounds(20, 257, 99, 38);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("店家信息");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_2.setBackground(new Color(18,150,193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_2.setBackground(new Color(0,191,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				label_2.setBackground(new Color(7,50,93));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				label_2.setBackground(new Color(18,150,193));
			}
		});
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setOpaque(true);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("楷体", Font.BOLD, 20));
		label_2.setBackground(new Color(0, 191, 255));
		label_2.setBounds(20, 329, 99, 38);
		contentPane.add(label_2);
		
		
	}
}
