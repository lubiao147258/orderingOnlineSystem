package com.lb.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class UserOrderPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8052016113358080909L;
	private JPanel contentPane;
	private Point origin = new Point();
	private JTable table;
	private DefaultTableModel mod;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserOrderPage frame = new UserOrderPage();
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
	public UserOrderPage() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 1074, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
				Point p = UserOrderPage.this.getLocation();
				UserOrderPage.this.setLocation(p.x+e.getX()-origin.x, p.y+e.getY()-origin.y);
			}
			
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(2, 81, 1070, 443);
		contentPane.add(scrollPane);
		String[] cols = {"编号","店铺","用户名","电话","商品名","总价格","配送地址","下单时间"};
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		mod = new DefaultTableModel(cols, 0);
		
		table = new JTable(mod);
		table.setBackground(new Color(240, 240, 240));
		table.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		table.setRowHeight(30);
		table.getTableHeader().setReorderingAllowed(false);//表头不可拖动
		table.getTableHeader().setResizingAllowed(false);//列大小不可改变
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(240);
		table.getColumnModel().getColumn(5).setPreferredWidth(65);
		table.getColumnModel().getColumn(6).setPreferredWidth(240);
		table.getColumnModel().getColumn(7).setPreferredWidth(220);
		//table.getColumnModel().getColumn(8).setPreferredWidth(140);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setDefaultRenderer(Object.class, tcr);	
		scrollPane.setViewportView(table);
		
		mod.addRow(new Object[]{"1","重启鸡公煲","张三","15126347896栋","重庆鸡公煲+米饭+王老吉","84.6","江汉大学北区一栋","2017/8/10 15:25:36"});
		mod.addRow(new Object[]{"1","重启鸡公煲","张三","15126347896栋","重庆鸡公煲+米饭+王老吉","84.6","江汉大学北区一栋","2017/8/10 15:25:36"});
		mod.addRow(new Object[]{"1","重启鸡公煲","张三","15126347896栋","重庆鸡公煲+米饭+王老吉","84.6","江汉大学北区一栋","2017/8/10 15:25:36"});
		mod.addRow(new Object[]{"1","重启鸡公煲","张三","15126347896栋","重庆鸡公煲+米饭+王老吉","84.6","江汉大学北区一栋","2017/8/10 15:25:36"});
		mod.addRow(new Object[]{"1","重启鸡公煲","张三","15126347896栋","重庆鸡公煲+米饭+王老吉","84.6","江汉大学北区一栋","2017/8/10 15:25:36"});
		mod.addRow(new Object[]{"1","重启鸡公煲","张三","15126347896栋","重庆鸡公煲+米饭+王老吉","84.6","江汉大学北区一栋","2017/8/10 15:25:36"});
		mod.addRow(new Object[]{"1","重启鸡公煲","张三","15126347896栋","重庆鸡公煲+米饭+王老吉","84.6","江汉大学北区一栋","2017/8/10 15:25:36"});
		mod.addRow(new Object[]{"1","重启鸡公煲","张三","15126347896栋","重庆鸡公煲+米饭+王老吉","84.6","江汉大学北区一栋","2017/8/10 15:25:36"});
		mod.addRow(new Object[]{"1","重启鸡公煲","张三","15126347896栋","重庆鸡公煲+米饭+王老吉","84.6","江汉大学北区一栋","2017/8/10 15:25:36"});
		mod.addRow(new Object[]{"1","重启鸡公煲","张三","15126347896栋","重庆鸡公煲+米饭+王老吉","84.6","江汉大学北区一栋","2017/8/10 15:25:36"});
		mod.addRow(new Object[]{"1","重启鸡公煲","张三","15126347896栋","重庆鸡公煲+米饭+王老吉","84.6","江汉大学北区一栋","2017/8/10 15:25:36"});
		mod.addRow(new Object[]{"1","重启鸡公煲","张三","15126347896栋","重庆鸡公煲+米饭+王老吉","84.6","江汉大学北区一栋","2017/8/10 15:25:36"});
		mod.addRow(new Object[]{"1","重启鸡公煲","张三","15126347896栋","重庆鸡公煲+米饭+王老吉","84.6","江汉大学北区一栋","2017/8/10 15:25:36"});
		mod.addRow(new Object[]{"1","重启鸡公煲","张三","15126347896栋","重庆鸡公煲+米饭+王老吉","84.6","江汉大学北区一栋","2017/8/10 15:25:36"});
		
		mod.addRow(new Object[]{"1","重启鸡公煲","张三","15126347896栋","重庆鸡公煲+米饭+王老吉","84.6","江汉大学北区一栋","2017/8/10 15:25:36"});
		mod.addRow(new Object[]{"1","重启鸡公煲","张三","15126347896栋","重庆鸡公煲+米饭+王老吉","84.6","江汉大学北区一栋","2017/8/10 15:25:36"});
		mod.addRow(new Object[]{"1","重启鸡公煲","张三","15126347896栋","重庆鸡公煲+米饭+王老吉","84.6","江汉大学北区一栋","2017/8/10 15:25:36"});
		mod.addRow(new Object[]{"1","重启鸡公煲","张三","15126347896栋","重庆鸡公煲+米饭+王老吉","84.6","江汉大学北区一栋","2017/8/10 15:25:36"});
		mod.addRow(new Object[]{"1","重启鸡公煲","张三","15126347896栋","重庆鸡公煲+米饭+王老吉","84.6","江汉大学北区一栋","2017/8/10 15:25:36"});
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 1074, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lb_close = new JLabel("");
		lb_close.setOpaque(true);
		lb_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserOrderPage.this.dispose();
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
		lb_close.setBounds(1050, 0, 25, 25);
		panel.add(lb_close);
		
		JLabel lb_min = new JLabel("");
		lb_min.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserOrderPage.this.setExtendedState(JFrame.ICONIFIED);
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
		lb_min.setBounds(1024, 0, 25, 25);
		lb_min.setOpaque(true);
		panel.add(lb_min);
		
		JLabel lblNewLabel = new JLabel("我 的 订 单");
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(79, 10, 232, 60);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setToolTipText("返回上一级");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0,191,252));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setBackground(new Color(244,164,96));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setBackground(new Color(0,191,252));
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(SellerOrderManager.class.getResource("/image/返回.png")));
		lblNewLabel_1.setBounds(0, 0, 39, 39);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textField.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				textField.setText("搜 索");
			}
		});
		textField.setText("搜 索");
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		textField.setBounds(606, 20, 211, 39);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_4 = new JLabel("查 询");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_4.setBackground(new Color(106,90,205));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_4.setBackground(new Color(30, 144, 255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				label_4.setBackground(new Color(7,50,93));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				label_4.setBackground(new Color(106,90,205));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//new SellerInfoPage().setVisible(true);
			}
		});
		label_4.setOpaque(true);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("楷体", Font.BOLD, 20));
		label_4.setBackground(new Color(30, 144, 255));
		label_4.setBounds(816, 20, 99, 38);
		panel.add(label_4);
		
		JPanel panel_leftline = new JPanel();
		panel_leftline.setBackground(new Color(0, 191, 255));
		panel_leftline.setBounds(0, 77, 2, 623);
		contentPane.add(panel_leftline);
		
		JPanel panel_rightline = new JPanel();
		panel_rightline.setBackground(new Color(0, 191, 255));
		panel_rightline.setBounds(1072, 80, 2, 620);
		contentPane.add(panel_rightline);
		
		JPanel panel_bottomline = new JPanel();
		panel_bottomline.setBackground(new Color(18,150,193));
		panel_bottomline.setBounds(-2, 620, 1202, 2);
		contentPane.add(panel_bottomline);
		
		JLabel label_3 = new JLabel("订单管理");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_3.setBackground(new Color(18,150,193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_3.setBackground(new Color(0,191,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				label_3.setBackground(new Color(7,50,93));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				label_3.setBackground(new Color(18,150,193));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//new SellerInfoPage().setVisible(true);
			}
		});
		label_3.setOpaque(true);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("楷体", Font.BOLD, 20));
		label_3.setBackground(new Color(0, 191, 255));
		label_3.setBounds(132, 549, 99, 38);
		contentPane.add(label_3);
		
		JLabel label = new JLabel("上一页");
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
			@Override
			public void mouseClicked(MouseEvent e) {
				//new SellerInfoPage().setVisible(true);
			}
		});
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("楷体", Font.BOLD, 20));
		label.setBackground(new Color(0, 191, 255));
		label.setBounds(657, 549, 99, 38);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("下一页");
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
			@Override
			public void mouseClicked(MouseEvent e) {
				//new SellerInfoPage().setVisible(true);
			}
		});
		label_1.setOpaque(true);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("楷体", Font.BOLD, 20));
		label_1.setBackground(new Color(0, 191, 255));
		label_1.setBounds(946, 549, 99, 38);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("第3页/共6页");
		label_2.setOpaque(true);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.DARK_GRAY);
		label_2.setFont(new Font("楷体", Font.BOLD, 20));
		label_2.setBackground(new Color(240,240,240));
		label_2.setBounds(766, 549, 170, 38);
		contentPane.add(label_2);
		
		
	}
}
