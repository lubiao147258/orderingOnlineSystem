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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(253, 10, 329, 215);
		contentPane.add(scrollPane);
		String[] cols = {"序号","商品名称","单价","类别","在售否"};
		DefaultTableModel mod = new DefaultTableModel(cols, 0);
		table = new JTable(mod);
		table.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		mod.addRow(new Object[]{"1001","jack","10000.0",});
		mod.addRow(new Object[]{"1002","jack1","15000.0"});
		mod.addRow(new Object[]{"1003","jack2","30000.0"});
		scrollPane.setViewportView(table);
		
		
	}
}
