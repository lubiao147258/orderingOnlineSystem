package com.lb.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.lb.entity.FoodVO;
import com.lb.service.SellerService;
import com.lb.service.UserService;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class UserOrderDetailPage extends JFrame {

	public static double money=(double) 0.0;
	public static int orderID;
	private Point origin = new Point();
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel mod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserOrderDetailPage frame = new UserOrderDetailPage();
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
	public UserOrderDetailPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				origin.x = e.getX();
				origin.y = e.getY();
			}

		});

		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point p = UserOrderDetailPage.this.getLocation();
				UserOrderDetailPage.this.setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y);
			}

		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 600, 25);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("订单详情");
		label.setBounds(10, 6, 54, 15);
		panel.add(label);
		label.setForeground(new Color(255, 255, 255));
		
		JLabel label_4 = new JLabel("");
		label_4.setOpaque(true);
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserOrderDetailPage.this.dispose();
				money=0.0;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label_4.setBackground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_4.setBackground(new Color(0,191,252));
			}
		});
		label_4.setBounds(575, 0, 25, 25);
		panel.add(label_4);
		label_4.setIcon(new ImageIcon(UserOrderDetailPage.class.getResource("/image/关闭按钮.png")));
		label_4.setOpaque(true);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBackground(new Color(0, 191, 255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(0, 22, 2, 378);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 191, 255));
		panel_2.setBounds(598, 22, 2, 378);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 191, 255));
		panel_3.setBounds(0, 398, 600, 2);
		contentPane.add(panel_3);
		this.setUndecorated(true);// 去除边框
		setLocationRelativeTo(null);// 初始化位置（电脑中心）
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(0, 22, 600, 296);
		contentPane.add(scrollPane);
		String[] cols = {"商品名称", "数量（份）", "价格（元）"};
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		mod = new DefaultTableModel(cols, 0);
		// mod.setRowCount(14);
		table = new JTable(mod);
		table.setBackground(new Color(240, 240, 240));
		table.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		table.setRowHeight(30);
		table.getTableHeader().setReorderingAllowed(false);// 表头不可拖动
		table.getTableHeader().setResizingAllowed(false);// 列大小不可改变
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setDefaultRenderer(Object.class, tcr);
		scrollPane.setViewportView(table);
		
		//mod.addRow(new Object[]{"重启鸡公煲","3","56"});
		for(FoodVO foodvo :UserService.getOrderDetailInfoByOrderIdService(orderID)){
			mod.addRow(new Object[]{SellerService.getFoodInfoById(foodvo.getFoodid()).getFoodName(),foodvo.getFoodcount(),foodvo.getFoodcount()*UserService.getFoodPriceById(foodvo.getFoodid())});
		}
		
		
		JLabel label_1 = new JLabel("总价格：");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label_1.setForeground(Color.DARK_GRAY);
		label_1.setBounds(359, 344, 103, 28);
		contentPane.add(label_1);
		
		
		for(int i =0;i<mod.getRowCount();i++){
			money+=Double.parseDouble( mod.getValueAt(i, 2).toString());
		}
		JLabel label_2 = new JLabel(money+"￥");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label_2.setBounds(465, 344, 123, 28);
		contentPane.add(label_2);
		
	}
}
