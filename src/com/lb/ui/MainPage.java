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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.lb.entity.Address;
import com.lb.service.UserService;
import com.lb.util.CheckEmail;
import com.lb.util.DBManager;

public class MainPage extends JFrame {

	public static int selectUserId;
	
	private JPanel contentPane;
	private JPanel panel_center;
	private JPanel panel_gerenziliao;
	private JPanel panel_dizhiguanli;
	private JPanel panel_xiugaimima;
	private Point origin = new Point();
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	private JTable table;
	private DefaultTableModel mod;

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
		//System.out.println(selectUserId);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 800, 98);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(MainPage.class.getResource("/image/关闭按钮.png")));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainPage.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setBackground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setBackground(new Color(0,191,252));
			}
		});
		label.setOpaque(true);
		label.setBackground(new Color(0, 191, 255));
		label.setBounds(775, 0, 25, 25);
		panel.add(label);
		
		JLabel label_gerenzhongxin = new JLabel("个人中心");
		label_gerenzhongxin.setOpaque(true);
		label_gerenzhongxin.setBackground(new Color(0,191,255));
		label_gerenzhongxin.setFont(new Font("微软雅黑", Font.BOLD, 18));
		label_gerenzhongxin.setHorizontalAlignment(SwingConstants.CENTER);
		label_gerenzhongxin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//panel_center.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label_gerenzhongxin.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_gerenzhongxin.setForeground(new Color(255,255,255));
			}
		});
		label_gerenzhongxin.setForeground(new Color(255, 255, 255));
		label_gerenzhongxin.setBounds(600, 22, 87, 49);
		panel.add(label_gerenzhongxin);
		
		JLabel label_kaishidiancan = new JLabel("开始点餐");
		label_kaishidiancan.setFont(new Font("微软雅黑", Font.BOLD, 18));
		label_kaishidiancan.setHorizontalAlignment(SwingConstants.CENTER);
		label_kaishidiancan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//panel_center.setVisible(false);
				MainPage.this.dispose();
				new StartOrderPage().setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label_kaishidiancan.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_kaishidiancan.setForeground(new Color(255,255,255));
			}
		});
		label_kaishidiancan.setForeground(new Color(255, 255, 255));
		label_kaishidiancan.setBounds(80, 22, 87, 49);
		panel.add(label_kaishidiancan);
		
		JLabel label_gouwuche = new JLabel("购物车");
		label_gouwuche.setFont(new Font("微软雅黑", Font.BOLD, 18));
		label_gouwuche.setHorizontalAlignment(SwingConstants.CENTER);
		label_gouwuche.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//panel_center.setVisible(false);
				MainPage.this.dispose();
				new CartPage().setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label_gouwuche.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_gouwuche.setForeground(new Color(255,255,255));
			}
		});
		label_gouwuche.setForeground(new Color(255, 255, 255));
		label_gouwuche.setBounds(424, 22, 87, 49);
		panel.add(label_gouwuche);
		
		JLabel label_wodedingdan = new JLabel("我的订单");
		label_wodedingdan.setFont(new Font("微软雅黑", Font.BOLD, 18));
		label_wodedingdan.setHorizontalAlignment(SwingConstants.CENTER);
		label_wodedingdan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label_wodedingdan.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_wodedingdan.setForeground(new Color(255,255,255));
			}
		});
		label_wodedingdan.setForeground(new Color(255, 255, 255));
		label_wodedingdan.setBounds(246, 22, 87, 49);
		panel.add(label_wodedingdan);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainPage.this.setExtendedState(JFrame.ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label_1.setBackground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_1.setBackground(new Color(0,191,252));
			}
		});
		label_1.setIcon(new ImageIcon(MainPage.class.getResource("/image/最小化.png")));
		label_1.setOpaque(true);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBackground(new Color(0, 191, 255));
		label_1.setBounds(750, 0, 25, 25);
		panel.add(label_1);
			
		
		//个人中心页面
		panel_center = new JPanel();
		panel_center.setBounds(24, 108, 753, 463);
		contentPane.add(panel_center);
		panel_center.setVisible(true);
		panel_center.setLayout(null);
		
		JLabel lab_geren = new JLabel("个人中心");
		lab_geren.setForeground(new Color(30, 144, 255));
		lab_geren.setHorizontalAlignment(SwingConstants.CENTER);
		lab_geren.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lab_geren.setBounds(50, 25, 88, 30);
		panel_center.add(lab_geren);
		
		JLabel pic1 = new JLabel("");
		pic1.setIcon(new ImageIcon(MainPage.class.getResource("/image/主页.png")));
		pic1.setBounds(10, 25, 30, 30);
		panel_center.add(pic1);
		
		JLabel lab_wodezhiliao = new JLabel("我的资料");
		lab_wodezhiliao.setHorizontalAlignment(SwingConstants.CENTER);
		lab_wodezhiliao.setForeground(Color.BLACK);
		lab_wodezhiliao.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lab_wodezhiliao.setBounds(50, 96, 88, 30);
		panel_center.add(lab_wodezhiliao);
		
		JLabel pic3 = new JLabel("");
		pic3.setIcon(new ImageIcon(MainPage.class.getResource("/image/个人.png")));
		pic3.setHorizontalAlignment(SwingConstants.CENTER);
		pic3.setBounds(10, 96, 30, 30);
		panel_center.add(pic3);
		
		JLabel label_gerenziliao = new JLabel("个人资料");
		label_gerenziliao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_gerenziliao.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_gerenziliao.setForeground(new Color(128,128,128));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_gerenziliao.setVisible(true);
				panel_dizhiguanli.setVisible(false);
				panel_xiugaimima.setVisible(false);
			}
		});
		label_gerenziliao.setHorizontalAlignment(SwingConstants.CENTER);
		label_gerenziliao.setForeground(Color.GRAY);
		label_gerenziliao.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_gerenziliao.setBounds(50, 136, 88, 30);
		panel_center.add(label_gerenziliao);
		
		JLabel lab_dizhiguanli = new JLabel("地址管理");
		lab_dizhiguanli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lab_dizhiguanli.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lab_dizhiguanli.setForeground(new Color(128,128,128));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_gerenziliao.setVisible(false);
				panel_dizhiguanli.setVisible(true);
				panel_xiugaimima.setVisible(false);
			}
		});
		lab_dizhiguanli.setHorizontalAlignment(SwingConstants.CENTER);
		lab_dizhiguanli.setForeground(Color.GRAY);
		lab_dizhiguanli.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lab_dizhiguanli.setBounds(50, 176, 88, 30);
		panel_center.add(lab_dizhiguanli);
		
		JLabel lab_xiugaimima = new JLabel("修改密码");
		lab_xiugaimima.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lab_xiugaimima.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lab_xiugaimima.setForeground(new Color(128,128,128));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_gerenziliao.setVisible(false);
				panel_dizhiguanli.setVisible(false);
				panel_xiugaimima.setVisible(true);
			}
		});
		lab_xiugaimima.setHorizontalAlignment(SwingConstants.CENTER);
		lab_xiugaimima.setForeground(Color.GRAY);
		lab_xiugaimima.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lab_xiugaimima.setBounds(50, 221, 88, 30);
		panel_center.add(lab_xiugaimima);
		
		JLabel lab_line = new JLabel("");
		lab_line.setBackground(new Color(192, 192, 192));
		lab_line.setBounds(175, 15, 1, 430);
		panel_center.add(lab_line);
		lab_line.setOpaque(true);
		
		//个人资料panel
		
		panel_gerenziliao = new JPanel();
		panel_gerenziliao.setBounds(186, 10, 557, 435);
		panel_center.add(panel_gerenziliao);
		panel_gerenziliao.setLayout(null);
		
		JLabel lab_gerenziliao = new JLabel("个人资料");
		lab_gerenziliao.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lab_gerenziliao.setHorizontalAlignment(SwingConstants.CENTER);
		lab_gerenziliao.setBounds(10, 10, 102, 22);
		panel_gerenziliao.add(lab_gerenziliao);
		
		JLabel label_touxiang = new JLabel("头像");
		label_touxiang.setForeground(new Color(0, 0, 0));
		label_touxiang.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_touxiang.setBounds(42, 69, 36, 15);
		panel_gerenziliao.add(label_touxiang);
		
		JLabel pictouxiang = new JLabel("");
		pictouxiang.setIcon(new ImageIcon(MainPage.class.getResource("/image/头像.png")));
		pictouxiang.setHorizontalAlignment(SwingConstants.CENTER);
		pictouxiang.setBounds(138, 60, 90, 90);
		panel_gerenziliao.add(pictouxiang);
		
		JLabel label_youhuming1 = new JLabel("用户名");
		label_youhuming1.setForeground(new Color(0, 0, 0));
		label_youhuming1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_youhuming1.setBounds(42, 207, 54, 15);
		panel_gerenziliao.add(label_youhuming1);
		
		JLabel label_username2 = new JLabel(UserService.getUserInfoService(selectUserId).getUsername());
		label_username2.setToolTipText(label_username2.getText());
		label_username2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_username2.setForeground(new Color(128, 128, 128));
		label_username2.setHorizontalAlignment(SwingConstants.LEFT);
		label_username2.setBounds(150, 203, 129, 22);
		panel_gerenziliao.add(label_username2);
		
		JLabel label_shoujihaoma = new JLabel("手机号码");
		label_shoujihaoma.setForeground(new Color(0, 0, 0));
		label_shoujihaoma.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_shoujihaoma.setHorizontalAlignment(SwingConstants.CENTER);
		label_shoujihaoma.setBounds(20, 270, 75, 15);
		panel_gerenziliao.add(label_shoujihaoma);
		
		JLabel label_shoujihaoma2 = new JLabel(UserService.getUserInfoService(selectUserId).getPhone());
		label_shoujihaoma2.setToolTipText(label_shoujihaoma2.getText());
		label_shoujihaoma2.setHorizontalAlignment(SwingConstants.LEFT);
		label_shoujihaoma2.setForeground(Color.GRAY);
		label_shoujihaoma2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_shoujihaoma2.setBounds(150, 266, 129, 22);
		panel_gerenziliao.add(label_shoujihaoma2);
		
		JLabel label_wodeyouxiang = new JLabel("我的邮箱");
		label_wodeyouxiang.setHorizontalAlignment(SwingConstants.CENTER);
		label_wodeyouxiang.setForeground(Color.BLACK);
		label_wodeyouxiang.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_wodeyouxiang.setBounds(20, 319, 75, 15);
		panel_gerenziliao.add(label_wodeyouxiang);
		
		JLabel label_wodeyouxiang2 = new JLabel(UserService.getUserInfoService(selectUserId).getEmail());
		label_wodeyouxiang2.setToolTipText(label_wodeyouxiang2.getText());
		label_wodeyouxiang2.setHorizontalAlignment(SwingConstants.LEFT);
		label_wodeyouxiang2.setForeground(Color.GRAY);
		label_wodeyouxiang2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_wodeyouxiang2.setBounds(150, 315, 129, 22);		
		panel_gerenziliao.add(label_wodeyouxiang2);
		
		JLabel label_username3 = new JLabel("[修改]");
		label_username3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String inputValue = JOptionPane.showInputDialog("请输入用户名："); 
				if(inputValue!=null){
					if(DBManager.executeUpdate("update [user] set username = ? where user_Id = ?", new String[]{inputValue,String.valueOf(selectUserId)})){
						System.out.println("修改成功");
						label_username2.setText(UserService.getUserInfoService(selectUserId).getUsername());
					}
				}else{
					JOptionPane.showMessageDialog(MainPage.this, "不能为空!","提示",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		label_username3.setForeground(new Color(30, 144, 255));
		label_username3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_username3.setBounds(315, 207, 54, 15);
		panel_gerenziliao.add(label_username3);
		
		JLabel label_shoujihaoma3 = new JLabel("[修改/绑定]");
		label_shoujihaoma3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String inputValue = JOptionPane.showInputDialog("请输入手机号："); 
				if(inputValue!=null){
					if(DBManager.executeUpdate("update [user] set phone = ? where user_Id = ?", new String[]{inputValue,String.valueOf(selectUserId)})){
						System.out.println("修改成功");
						label_shoujihaoma2.setText(UserService.getUserInfoService(selectUserId).getPhone());
					}
				}else{
					JOptionPane.showMessageDialog(MainPage.this, "不能为空!","提示",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		label_shoujihaoma3.setForeground(new Color(30, 144, 255));
		if(label_shoujihaoma2.getText().trim()==null){
			label_shoujihaoma2.setText("未绑定");
		}
		
		label_shoujihaoma3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_shoujihaoma3.setBounds(315, 270, 81, 15);
		panel_gerenziliao.add(label_shoujihaoma3);
		
		JLabel label_wodeyouxiang3 = new JLabel("[修改/绑定]");
		label_wodeyouxiang3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String inputValue = JOptionPane.showInputDialog("请输入邮箱："); 
				if(inputValue!=null){
					if(!CheckEmail.emailCheck(inputValue)){
						JOptionPane.showMessageDialog(MainPage.this, "邮箱格式不正确!","提示",JOptionPane.INFORMATION_MESSAGE);
					}else{
						if(DBManager.executeUpdate("update [user] set email = ? where user_Id = ?", new String[]{inputValue,String.valueOf(selectUserId)})){
							System.out.println("修改成功");
							label_wodeyouxiang2.setText(UserService.getUserInfoService(selectUserId).getEmail());
						}
					}
				}else{
					JOptionPane.showMessageDialog(MainPage.this, "不能为空!","提示",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		label_wodeyouxiang3.setForeground(new Color(30, 144, 255));
		if(label_wodeyouxiang2.getText().trim()==null){
			label_wodeyouxiang2.setText("未绑定");
			
		}
		label_wodeyouxiang3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_wodeyouxiang3.setBounds(315, 319, 81, 15);
		panel_gerenziliao.add(label_wodeyouxiang3);
		
		
		
		//地址管理panel
		
		panel_dizhiguanli = new JPanel();
		panel_dizhiguanli.setBounds(186, 10, 557, 435);
		panel_center.add(panel_dizhiguanli);
		panel_dizhiguanli.setLayout(null);
		panel_dizhiguanli.setVisible(false);
		
		JLabel label_dizhiguanli = new JLabel("地址管理");
		label_dizhiguanli.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		label_dizhiguanli.setHorizontalAlignment(SwingConstants.CENTER);
		label_dizhiguanli.setBounds(10, 10, 102, 22);
		panel_dizhiguanli.add(label_dizhiguanli);
		JLabel lb_add = new JLabel("添加新地址");
		lb_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lb_add.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lb_add.setForeground(Color.GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				MainPage.this.dispose();
				new AddAddressInfo().setVisible(true);
			}
			
		});
		lb_add.setHorizontalAlignment(SwingConstants.CENTER);
		lb_add.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lb_add.setForeground(Color.GRAY);
		lb_add.setBounds(146, 16, 81, 15);
		panel_dizhiguanli.add(lb_add);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 42, 537, 383);
		panel_dizhiguanli.add(scrollPane);
		String[] cols = {"序号","用户名","性别","地址信息","电话"};
		//String[] cols = {"","","","",""};
		mod = new DefaultTableModel(cols, 0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		table = new JTable(mod);
		table.setSurrendersFocusOnKeystroke(true);
		table.setBorder(new LineBorder(new Color(192, 192, 192)));
		table.setBackground(new Color(240,240,240));
		table.setForeground(Color.GRAY);
		table.setRowHeight(40);
		table.getTableHeader().setReorderingAllowed(false);//表头不可拖动
		table.getTableHeader().setResizingAllowed(false);//列大小不可改变
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(269);
		table.getColumnModel().getColumn(4).setPreferredWidth(95);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		table.setDefaultRenderer(Object.class, tcr);
		
		//mod.addRow(new Object[]{"1","jack232","男","经济技术开发区江汉大学北区1栋","15926315478"});
		
		initModal();
		
		
		
		scrollPane.setViewportView(table);
		
		JLabel lb_del = new JLabel("删除地址");
		lb_del.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lb_del.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lb_del.setForeground(Color.GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int rows = table.getSelectedRow();
				if(rows>0){
					//System.out.println(UserService.getUserInfoService(selectUserId).getDefaultAddressId());
					//System.out.println((int)mod.getValueAt(rows, 0));					
					if(UserService.getUserInfoService(selectUserId).getDefaultAddressId()==(int)mod.getValueAt(rows, 0)){
						JOptionPane.showMessageDialog(MainPage.this, "该地址是默认地址，无法删除!","提示",JOptionPane.INFORMATION_MESSAGE);
					}else{
						if(DBManager.executeUpdate("delete from [address] where address_Id=? ", new String[]{String.valueOf(selectUserId)})){
							JOptionPane.showMessageDialog(MainPage.this, "删除成功!","提示",JOptionPane.INFORMATION_MESSAGE);
							initModal();
						}else{
							JOptionPane.showMessageDialog(MainPage.this, "删除失败!","提示",JOptionPane.INFORMATION_MESSAGE);
						}
					}
					
				}
				else{
					JOptionPane.showMessageDialog(MainPage.this, "请选择删除的行!","提示",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		lb_del.setHorizontalAlignment(SwingConstants.CENTER);
		lb_del.setForeground(Color.GRAY);
		lb_del.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lb_del.setBounds(257, 16, 81, 15);
		panel_dizhiguanli.add(lb_del);
		
		JLabel lb_update = new JLabel("修改地址");
		lb_update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lb_update.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lb_update.setForeground(Color.GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				UpdateAddressPage.addressId=(int) mod.getValueAt(row, 0);
				new UpdateAddressPage().setVisible(true);
			}
		});
		lb_update.setHorizontalAlignment(SwingConstants.CENTER);
		lb_update.setForeground(Color.GRAY);
		lb_update.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lb_update.setBounds(360, 16, 81, 15);
		panel_dizhiguanli.add(lb_update);
		
		JLabel lb_default = new JLabel("选择默认地址");
		lb_default.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lb_default.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lb_default.setForeground(Color.GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if(row>=0){
					if(UserService.setDefaultAddressService(selectUserId, Integer.parseInt((mod.getValueAt(row, 0).toString())))){
						JOptionPane.showMessageDialog(MainPage.this, "修改成功!","提示",JOptionPane.INFORMATION_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(MainPage.this, "修改失败!","提示",JOptionPane.INFORMATION_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(MainPage.this, "请选择你要设置为默认地址的行!","提示",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		lb_default.setHorizontalAlignment(SwingConstants.CENTER);
		lb_default.setForeground(Color.GRAY);
		lb_default.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lb_default.setBounds(466, 16, 81, 15);
		panel_dizhiguanli.add(lb_default);
		
		
		
		panel_xiugaimima = new JPanel();
		panel_xiugaimima.setBounds(186, 10, 557, 435);
		panel_center.add(panel_xiugaimima);
		panel_xiugaimima.setLayout(null);
		panel_xiugaimima.setVisible(false);
		
		JLabel label_xiugaimima = new JLabel("修改密码");
		label_xiugaimima.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		label_xiugaimima.setHorizontalAlignment(SwingConstants.CENTER);
		label_xiugaimima.setBounds(10, 10, 102, 22);
		panel_xiugaimima.add(label_xiugaimima);
		
		JLabel lab_yuanshimima = new JLabel("请输入原始密码：");
		lab_yuanshimima.setHorizontalAlignment(SwingConstants.LEFT);
		lab_yuanshimima.setForeground(Color.GRAY);
		lab_yuanshimima.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lab_yuanshimima.setBounds(35, 77, 119, 29);
		panel_xiugaimima.add(lab_yuanshimima);
		
		JLabel lab_xinmima = new JLabel("请输入新密码：");
		lab_xinmima.setHorizontalAlignment(SwingConstants.LEFT);
		lab_xinmima.setForeground(Color.GRAY);
		lab_xinmima.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lab_xinmima.setBounds(35, 183, 119, 29);
		panel_xiugaimima.add(lab_xinmima);
		
		passwordField1 = new JPasswordField();
		passwordField1.setEchoChar('★');
		passwordField1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		passwordField1.setBounds(160, 73, 238, 39);
		panel_xiugaimima.add(passwordField1);
		
		passwordField2 = new JPasswordField();
		passwordField2.setEchoChar('★');
		passwordField2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		passwordField2.setBounds(160, 179, 238, 39);
		panel_xiugaimima.add(passwordField2);
		
		JLabel label_submit = new JLabel("提    交");
		label_submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_submit.setBackground(new Color(18,150,193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_submit.setBackground(new Color(0,191,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				label_submit.setBackground(new Color(7,50,93));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				label_submit.setBackground(new Color(18,150,193));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if((new String(passwordField1.getPassword())).trim().length()==0||(new String(passwordField2.getPassword())).trim().length()==0){
					JOptionPane.showMessageDialog(MainPage.this, "不能为空!","提示",JOptionPane.INFORMATION_MESSAGE);
					System.out.println(UserService.getUserInfoService(selectUserId).getPassword());
				}else{
					if((new String(UserService.getUserInfoService(selectUserId).getPassword())).equals(new String(passwordField1.getPassword()))){
						if(DBManager.executeUpdate("update [user] set password=? where user_Id=?", new String[]{(new String(passwordField2.getPassword())),String.valueOf(selectUserId)})){
							JOptionPane.showMessageDialog(MainPage.this, "修改成功!","提示",JOptionPane.INFORMATION_MESSAGE);
							passwordField1.setText("");
							passwordField2.setText("");
						}else{
							JOptionPane.showMessageDialog(MainPage.this, "修改失败!","提示",JOptionPane.INFORMATION_MESSAGE);
							passwordField1.setText("");
							passwordField2.setText("");
						}
					}else{
						JOptionPane.showMessageDialog(MainPage.this, "输入的原始密码不正确!","提示",JOptionPane.INFORMATION_MESSAGE);
						passwordField1.setText("");
						passwordField2.setText("");
					}
				}
			}
		});
		label_submit.setOpaque(true);
		label_submit.setBackground(new Color(0, 191, 255));
		label_submit.setHorizontalAlignment(SwingConstants.CENTER);
		label_submit.setForeground(Color.WHITE);
		label_submit.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label_submit.setBounds(164, 301, 119, 39);
		panel_xiugaimima.add(label_submit);
		
		
		
		
		JPanel panel_leftline = new JPanel();
		panel_leftline.setBackground(new Color(0, 191, 255));
		panel_leftline.setBounds(0, 94, 4, 506);
		contentPane.add(panel_leftline);
		
		JPanel panel_rightline = new JPanel();
		panel_rightline.setBackground(new Color(0, 191, 255));
		panel_rightline.setBounds(796, 94, 4, 506);
		contentPane.add(panel_rightline);
		
		JPanel panel_bottomline = new JPanel();
		panel_bottomline.setBackground(new Color(0, 191, 255));
		panel_bottomline.setBounds(0, 596, 800, 4);
		contentPane.add(panel_bottomline);
		
		
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

	public void initModal() {
		mod.setRowCount(0);
		for (Address address : UserService.getAddressInfoService(selectUserId)) {
			mod.addRow(new Object[]{address.getId(),UserService.getUserInfoService(selectUserId).getUsername(),address.getSex(),address.getAddressdetail(),address.getPhone()});
		}
	}
}
