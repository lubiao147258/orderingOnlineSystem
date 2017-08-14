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

import com.lb.entity.Food;
import com.lb.service.SellerService;
import com.lb.service.UserService;
import com.lb.util.DBManager;

public class StartOrderPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8052016113358080909L;
	public 	static int userid;
	private JPanel contentPane;
	private Point origin = new Point();
	private JTable table;
	private DefaultTableModel mod;
	private JTextField textField;
	private int pageSize = 14;
	private int pageNum = 1;
	private int pageSum = (int) Math.ceil((UserService.getFoodInfo().size() / 14.0));

	private JLabel label_2 = new JLabel();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartOrderPage frame = new StartOrderPage();
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
	public StartOrderPage() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//System.out.println(userid);
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
				Point p = StartOrderPage.this.getLocation();
				StartOrderPage.this.setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y);
			}

		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(2, 81, 760, 443);
		contentPane.add(scrollPane);
		String[] cols = { "菜编 号", "菜 名", "类别", "价 格（元）" };
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
		table.setDefaultRenderer(Object.class, tcr);
		scrollPane.setViewportView(table);

		// mod.addRow(new Object[]{"1","重启鸡公煲","鸡肉","5"});

		initModel(pageNum, pageSize);

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
				StartOrderPage.this.dispose();
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
				StartOrderPage.this.setExtendedState(JFrame.ICONIFIED);
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

		JLabel lblNewLabel = new JLabel("点餐系统 ");
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
		textField.setBounds(211, 20, 211, 39);
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
				mod.setRowCount(0);
				for (Food food : SellerService.getFoodsBySize(pageNum, pageSize)) {
					if(food.getFoodName().equals(textField.getText())||SellerService.getFoodTypeById(food.getType_id()).equals(textField.getText())){
						mod.addRow(new Object[] { food.getId(), food.getFoodName(),SellerService.getFoodTypeById(food.getType_id()), food.getPrice() });
					}else if(textField.getText().trim().length()==0){
						initModel(pageNum, pageSize);
					}
					//System.out.println(food.getIsOnsale());
				}
				label_2.setText("第" + pageNum + "页/共" + pageSum + "页");
				
			}
		});
		label_4.setOpaque(true);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("楷体", Font.BOLD, 20));
		label_4.setBackground(new Color(30, 144, 255));
		label_4.setBounds(421, 20, 99, 38);
		panel.add(label_4);

		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 0) {
					initModel(pageNum, pageSize);
					//new MainPage().setVisible(true);
				}
				if (comboBox.getSelectedIndex() == 1) {
					//new MainPage().setVisible(true);
					if(userid==0){
						JOptionPane.showMessageDialog(StartOrderPage.this, "对不起，您还没有登录，无法完成此项操作!","提示",JOptionPane.INFORMATION_MESSAGE);
					}else{
						StartOrderPage.this.dispose();
						new UserOrderPage().setVisible(true);
					}
				}
				if (comboBox.getSelectedIndex() == 2) {
					if(userid==0){
						JOptionPane.showMessageDialog(StartOrderPage.this, "对不起，您还没有登录，无法完成此项操作!","提示",JOptionPane.INFORMATION_MESSAGE);
					}else{
						StartOrderPage.this.dispose();
						new CartPage().setVisible(true);
					}
				}
				if (comboBox.getSelectedIndex() == 3) {
					if(userid==0){
						JOptionPane.showMessageDialog(StartOrderPage.this, "对不起，您还没有登录，无法完成此项操作!","提示",JOptionPane.INFORMATION_MESSAGE);
					}else{
						StartOrderPage.this.dispose();
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

		JLabel label_3 = new JLabel("加入购物车");
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
				//new SellerInfoPage().setVisible(true);
				int row = table.getSelectedRow();
				
					if(row>=0){
						if(userid==0){
							JOptionPane.showMessageDialog(StartOrderPage.this, "对不起，您还没有登录，无法完成此项操作!","提示",JOptionPane.INFORMATION_MESSAGE);
						}else{
							//System.out.println(userid);
							int count  = UserService.getFoodCountById(Integer.parseInt(mod.getValueAt(row,0).toString()),userid);
							if(count>=1){
								String[]  objs = new String[]{String.valueOf((count+1)),String.valueOf(((count+1)*(UserService.getFoodPriceById((int) mod.getValueAt(row,0))))),mod.getValueAt(row,0).toString()};
								if(DBManager.executeUpdate("update cart set food_count=?,total=? where food_Id=?", objs)){
									JOptionPane.showMessageDialog(StartOrderPage.this, "添加成功!","提示",JOptionPane.INFORMATION_MESSAGE);
								}else{
									JOptionPane.showMessageDialog(StartOrderPage.this, "添加失败!","提示",JOptionPane.INFORMATION_MESSAGE);
								}
							}else{
								int foodId = Integer.parseInt(mod.getValueAt(row,0).toString());
								String[] objs = new String[]{String.valueOf(userid),mod.getValueAt(row,0).toString(),String.valueOf(1),String.valueOf(UserService.getFoodPriceById(foodId))};
								if(DBManager.executeUpdate("insert into cart values(?,?,?,?)", objs)){
									JOptionPane.showMessageDialog(StartOrderPage.this, "添加成功!","提示",JOptionPane.INFORMATION_MESSAGE);
								}
								else{
									JOptionPane.showMessageDialog(StartOrderPage.this, "添加失败!","提示",JOptionPane.INFORMATION_MESSAGE);
								}
							}
						}					
						
					}else{
						JOptionPane.showMessageDialog(StartOrderPage.this, "请选择一行加入购车!","提示",JOptionPane.INFORMATION_MESSAGE);
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
				initModel(pageNum, pageSize);
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
				initModel(pageNum, pageSize);
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

	}

	private void initModel(int pageNum, int pageSize) {
		mod.setRowCount(0);
		for (Food food : SellerService.getFoodsBySize(pageNum, pageSize)) {
			mod.addRow(new Object[] { food.getId(), food.getFoodName(),SellerService.getFoodTypeById(food.getType_id()), food.getPrice() });
			//System.out.println(food.getIsOnsale());
		}
		label_2.setText("第" + pageNum + "页/共" + pageSum + "页");
	}
}
