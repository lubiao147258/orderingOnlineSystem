package com.lb.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.lb.entity.Cart;
import com.lb.entity.FoodVO;
import com.lb.entity.Order;
import com.lb.service.SellerService;
import com.lb.service.UserService;
import com.lb.util.DBManager;
import com.lb.util.GetCurrentDateTime;

public class CartPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8052016113358080909L;
	public static int userID;
	public static double total =0.0d;
	private JPanel contentPane;
	private Point origin = new Point();
	private JTable table;
	private DefaultTableModel mod;
	private JTextField textField;
	private int pageSize = 14;
	private int pageNum = 1;
	private int pageSum = (int) Math.ceil((UserService.getCartsInfo(userID).size() / 14.0));
	

	private JLabel label_2 = new JLabel();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CartPage frame = new CartPage();
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
	public CartPage() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setBounds(100, 100, 765, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);// 去除边框
		setLocationRelativeTo(null);// 初始化位置（电脑中心）

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
				Point p = CartPage.this.getLocation();
				CartPage.this.setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y);
			}

		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(2, 81, 760, 443);
		contentPane.add(scrollPane);
		String[] cols = { "序号", "商品名称", "数量", "总价格（元）" };
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		mod = new DefaultTableModel(cols, 0);
		// mod.setRowCount(14);
		table = new JTable(mod);
		/*table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(280);
		table.getColumnModel().getColumn(2).setPreferredWidth(180);
		table.getColumnModel().getColumn(3).setPreferredWidth(180);*/
		table.setBackground(new Color(240, 240, 240));
		table.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		table.setRowHeight(30);
		table.getTableHeader().setReorderingAllowed(false);// 表头不可拖动
		table.getTableHeader().setResizingAllowed(false);// 列大小不可改变
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setDefaultRenderer(Object.class, tcr);
		
		scrollPane.setViewportView(table);

		// mod.addRow(new Object[]{"1","重启鸡公煲","鸡肉","5"});

		initModel(pageNum, pageSize,userID);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 764, 80);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lb_close = new JLabel("");
		lb_close.setOpaque(true);
		lb_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CartPage.this.dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lb_close.setBackground(new Color(255, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lb_close.setBackground(new Color(0, 191, 252));
			}
		});
		lb_close.setBackground(new Color(0, 191, 255));
		lb_close.setIcon(new ImageIcon(AdminPage.class.getResource("/image/关闭按钮.png")));
		lb_close.setHorizontalAlignment(SwingConstants.CENTER);
		lb_close.setBounds(736, 0, 25, 25);
		panel.add(lb_close);

		JLabel lb_min = new JLabel("");
		lb_min.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CartPage.this.setExtendedState(JFrame.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lb_min.setBackground(new Color(255, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lb_min.setBackground(new Color(0, 191, 252));
			}
		});
		lb_min.setBackground(new Color(0, 191, 255));
		lb_min.setHorizontalAlignment(SwingConstants.CENTER);
		lb_min.setIcon(new ImageIcon(AdminPage.class.getResource("/image/最小化.png")));
		lb_min.setBounds(710, 0, 25, 25);
		lb_min.setOpaque(true);
		panel.add(lb_min);

		JLabel lblNewLabel = new JLabel("我的购物车");
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 163, 60);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textField.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				textField.setText("搜 索 商 品");
			}
		});
		// textField.setText("搜 索");
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		textField.setBounds(276, 20, 211, 39);
		panel.add(textField);
		textField.setColumns(10);

		JLabel label_4 = new JLabel("搜 索");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_4.setBackground(new Color(106, 90, 205));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label_4.setBackground(new Color(30, 144, 255));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				label_4.setBackground(new Color(7, 50, 93));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				label_4.setBackground(new Color(106, 90, 205));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// new SellerInfoPage().setVisible(true);
			}
		});
		label_4.setOpaque(true);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("楷体", Font.BOLD, 20));
		label_4.setBackground(new Color(30, 144, 255));
		label_4.setBounds(486, 20, 99, 38);
		panel.add(label_4);

		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 0) {//主页
					if(userID==0){
						JOptionPane.showMessageDialog(CartPage.this, "对不起，您还没有登录，无法完成此项操作!","提示",JOptionPane.INFORMATION_MESSAGE);
					}else{
						CartPage.this.dispose();
						new StartOrderPage().setVisible(true);
					}
					
				}
				if (comboBox.getSelectedIndex() == 1) {//订单
					if(userID==0){
						JOptionPane.showMessageDialog(CartPage.this, "对不起，您还没有登录，无法完成此项操作!","提示",JOptionPane.INFORMATION_MESSAGE);
					}else{
						CartPage.this.dispose();
						new UserOrderPage().setVisible(true);
					}
					
				}
				/*if (comboBox.getSelectedIndex() == 2) {//购物车
					if(userID==0){
						JOptionPane.showMessageDialog(CartPage.this, "对不起，您还没有登录，无法完成此项操作!","提示",JOptionPane.INFORMATION_MESSAGE);
					}else{
						CartPage.this.dispose();
						new CartPage().setVisible(true);
					}
					
				}*/
				if (comboBox.getSelectedIndex() == 3) {//个人中心
					if(userID==0){
						JOptionPane.showMessageDialog(CartPage.this, "对不起，您还没有登录，无法完成此项操作!","提示",JOptionPane.INFORMATION_MESSAGE);
					}else{
						CartPage.this.dispose();
						new MainPage().setVisible(true);
					}
					
				}
			}
		});
		comboBox.setFont(new Font("宋体", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "主页", "我的订单", "购物车", "个人中心" }));
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setOpaque(true);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(617, 0, 83, 25);
		panel.add(comboBox);

		JPanel panel_leftline = new JPanel();
		panel_leftline.setBackground(new Color(0, 191, 255));
		panel_leftline.setBounds(0, 77, 2, 623);
		contentPane.add(panel_leftline);

		JPanel panel_rightline = new JPanel();
		panel_rightline.setBackground(new Color(0, 191, 255));
		panel_rightline.setBounds(762, 80, 2, 620);
		contentPane.add(panel_rightline);

		JPanel panel_bottomline = new JPanel();
		panel_bottomline.setBackground(new Color(18, 150, 193));
		panel_bottomline.setBounds(-2, 610, 779, 2);
		contentPane.add(panel_bottomline);

		JLabel label_3 = new JLabel("立即下单");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_3.setBackground(new Color(18, 150, 193));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label_3.setBackground(new Color(0, 191, 255));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				label_3.setBackground(new Color(7, 50, 93));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				label_3.setBackground(new Color(18, 150, 193));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// new SellerInfoPage().setVisible(true);
				
				int[] rows = table.getSelectedRows();
				if(rows.length>0){
					if(UserService.getUserInfoService(userID).getDefaultAddressId()>0){
						for(int i=0;i<rows.length;i++){
							total+=Double.parseDouble(mod.getValueAt(rows[i], 3).toString());
						}
						System.out.println(UserService.getUserInfoService(userID).getDefaultAddressId());
						String[] objs = new String[]{String.valueOf(userID),String.valueOf(UserService.getUserInfoService(userID).getDefaultAddressId()),String.valueOf(total),"0",GetCurrentDateTime.getNowTime(),"0"};
						if(DBManager.executeUpdate("insert into [order] values(?,?,?,?,?,?)", objs)){
							List<FoodVO> lists = new ArrayList<>();
							for(int i=0;i<rows.length;i++){
								FoodVO fvo = new FoodVO();
								fvo.setFoodid(SellerService.getFoodIdByNameService(mod.getValueAt(rows[i], 1).toString().trim()));
								fvo.setFoodcount(Integer.parseInt(mod.getValueAt(rows[i], 2).toString()));
								lists.add(fvo);
							}
							for(FoodVO foodvo :lists){
								Integer[] ob = new Integer[]{UserService.getMaxIdService(),foodvo.getFoodid(),foodvo.getFoodcount()};
								DBManager.executeUpdate("insert into [order_detail] values(?,?,?)", ob);
							}
							JOptionPane.showMessageDialog(CartPage.this, "下单成功!","提示",JOptionPane.INFORMATION_MESSAGE);
							for(int i =0;i<rows.length;i++){
								DBManager.executeUpdate("delete from [cart] where cart_Id=?", new Integer[]{Integer.parseInt((mod.getValueAt(rows[i], 0).toString()))});
								
							}
							initModel(pageNum, pageSize,userID);
							
						}else{
							JOptionPane.showMessageDialog(CartPage.this, "下单失败!","提示",JOptionPane.INFORMATION_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(CartPage.this, "您还没有选择默认地址，请选择后在下单!","提示",JOptionPane.INFORMATION_MESSAGE);
					}
					
				}else{
					JOptionPane.showMessageDialog(CartPage.this, "请选择要提交的行!","提示",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		label_3.setOpaque(true);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("楷体", Font.BOLD, 20));
		label_3.setBackground(new Color(0, 191, 255));
		label_3.setBounds(25, 548, 114, 38);
		contentPane.add(label_3);

		JLabel label = new JLabel("上一页");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setBackground(new Color(18, 150, 193));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label.setBackground(new Color(0, 191, 255));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				label.setBackground(new Color(7, 50, 93));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				label.setBackground(new Color(18, 150, 193));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// new SellerInfoPage().setVisible(true);
				if (pageNum > 1) {
					pageNum--;
				}
				initModel(pageNum, pageSize,userID);
			}
		});
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("楷体", Font.BOLD, 20));
		label.setBackground(new Color(0, 191, 255));
		label.setBounds(345, 548, 99, 38);
		contentPane.add(label);

		JLabel label_1 = new JLabel("下一页");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_1.setBackground(new Color(18, 150, 193));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label_1.setBackground(new Color(0, 191, 255));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				label_1.setBackground(new Color(7, 50, 93));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				label_1.setBackground(new Color(18, 150, 193));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// new SellerInfoPage().setVisible(true);
				if (pageNum < pageSum) {
					pageNum++;
				}
				initModel(pageNum, pageSize,userID);
			}
		});
		label_1.setOpaque(true);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("楷体", Font.BOLD, 20));
		label_1.setBackground(new Color(0, 191, 255));
		label_1.setBounds(634, 548, 99, 38);
		contentPane.add(label_1);

		
		label_2.setText("第" + pageNum + "页/共" + pageSum + "页");
		label_2.setOpaque(true);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.DARK_GRAY);
		label_2.setFont(new Font("楷体", Font.BOLD, 20));
		label_2.setBackground(new Color(240, 240, 240));
		label_2.setBounds(454, 548, 170, 38);
		contentPane.add(label_2);
		
		JLabel label_5 = new JLabel("删除");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_5.setBackground(new Color(18, 150, 193));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label_5.setBackground(new Color(0, 191, 255));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				label_5.setBackground(new Color(7, 50, 93));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				label_5.setBackground(new Color(18, 150, 193));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// new SellerInfoPage().setVisible(true);
				int[] rows = table.getSelectedRows();
				if(rows.length>0){
					for(int i =0;i<rows.length;i++){
						DBManager.executeUpdate("delete from [cart] where cart_Id=?", new Integer[]{Integer.parseInt((mod.getValueAt(rows[i], 0).toString()))});
					}
					initModel(pageNum, pageSize,userID);
				}else{
					JOptionPane.showMessageDialog(CartPage.this, "请选择要删除的行!","提示",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			
		});
		label_5.setOpaque(true);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("楷体", Font.BOLD, 20));
		label_5.setBackground(new Color(0, 191, 255));
		label_5.setBounds(179, 548, 114, 38);
		contentPane.add(label_5);

	}

	private void initModel(int pageNum, int pageSize,int userId) {
		mod.setRowCount(0);
		for (Cart cart : UserService.getCartsBySize(pageNum, pageSize,userID)) {
			mod.addRow(new Object[] { cart.getId(), SellerService.getFoodInfoById(cart.getFoodid()).getFoodName(),cart.getFoodcount(),cart.getTotal()});
			//System.out.println(food.getIsOnsale());
		}
		label_2.setText("第" + pageNum + "页/共" + pageSum + "页");
	}
		
}
