package com.lb.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import com.lb.service.UserService;
import com.lb.util.CheckEmail;
import com.lb.util.DBManager;

import javax.swing.JTable;

public class MainPage extends JFrame {

	public static int selectUserId;
	
	private JPanel contentPane;
	private JPanel panel_buy;
	private JPanel panel_order;
	private JPanel panel_cart;
	private JPanel panel_center;
	private JPanel panel_gerenziliao;
	private JPanel panel_dizhiguanli;
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
		System.out.println(selectUserId);
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
		label.setBounds(770, 0, 30, 30);
		panel.add(label);
		
		JLabel label_gerenzhongxin = new JLabel("个人中心");
		label_gerenzhongxin.setOpaque(true);
		label_gerenzhongxin.setBackground(new Color(0,191,255));
		label_gerenzhongxin.setFont(new Font("微软雅黑", Font.BOLD, 18));
		label_gerenzhongxin.setHorizontalAlignment(SwingConstants.CENTER);
		label_gerenzhongxin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_order.setVisible(false);
				panel_buy.setVisible(false);
				panel_cart.setVisible(false);
				panel_center.setVisible(true);
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
				panel_order.setVisible(false);
				panel_buy.setVisible(true);
				panel_cart.setVisible(false);
				panel_center.setVisible(false);
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
				panel_order.setVisible(false);
				panel_buy.setVisible(false);
				panel_cart.setVisible(true);
				panel_center.setVisible(false);
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
				panel_order.setVisible(true);
				panel_buy.setVisible(false);
				panel_cart.setVisible(false);
				panel_center.setVisible(false);
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
		
		//点餐页面
		panel_buy = new JPanel();
		panel_buy.setBounds(24, 108, 753, 463);
		contentPane.add(panel_buy);
		panel_buy.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("点餐页面");
		lblNewLabel.setBounds(352, 144, 54, 15);
		panel_buy.add(lblNewLabel);
		panel_buy.setVisible(true);
		
		
		//订单页面
		panel_order = new JPanel();
		panel_order.setBounds(24, 108, 753, 463);
		contentPane.add(panel_order);
		panel_order.setLayout(null);
		panel_order.setVisible(false);
		
		JLabel lb = new JLabel("订单页面");
		lb.setBounds(373, 5, 54, 15);
		panel_order.add(lb);
		
		
		//购物车页面
		panel_cart = new JPanel();
		panel_cart.setBounds(24, 108, 753, 463);
		contentPane.add(panel_cart);
		panel_cart.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("购物车页面");
		panel_cart.add(lblNewLabel_1);
		
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
		
		JLabel pic2 = new JLabel("");
		pic2.setIcon(new ImageIcon(MainPage.class.getResource("/image/订单.png")));
		pic2.setHorizontalAlignment(SwingConstants.CENTER);
		pic2.setBounds(10, 100, 30, 30);
		panel_center.add(pic2);
		
		JLabel lab_dingdan = new JLabel("我的订单");
		lab_dingdan.setHorizontalAlignment(SwingConstants.CENTER);
		lab_dingdan.setForeground(new Color(0, 0, 0));
		lab_dingdan.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lab_dingdan.setBounds(50, 100, 88, 30);
		panel_center.add(lab_dingdan);
		
		JLabel lab_xiangqing = new JLabel("订单详情");
		lab_xiangqing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lab_xiangqing.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lab_xiangqing.setForeground(new Color(128,128,128));
			}
		});
		lab_xiangqing.setHorizontalAlignment(SwingConstants.CENTER);
		lab_xiangqing.setForeground(new Color(128, 128, 128));
		lab_xiangqing.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lab_xiangqing.setBounds(50, 140, 88, 30);
		panel_center.add(lab_xiangqing);
		
		JLabel lab_wodezhiliao = new JLabel("我的资料");
		lab_wodezhiliao.setHorizontalAlignment(SwingConstants.CENTER);
		lab_wodezhiliao.setForeground(Color.BLACK);
		lab_wodezhiliao.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lab_wodezhiliao.setBounds(50, 199, 88, 30);
		panel_center.add(lab_wodezhiliao);
		
		JLabel pic3 = new JLabel("");
		pic3.setIcon(new ImageIcon(MainPage.class.getResource("/image/个人.png")));
		pic3.setHorizontalAlignment(SwingConstants.CENTER);
		pic3.setBounds(10, 199, 30, 30);
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
			}
		});
		label_gerenziliao.setHorizontalAlignment(SwingConstants.CENTER);
		label_gerenziliao.setForeground(Color.GRAY);
		label_gerenziliao.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_gerenziliao.setBounds(50, 239, 88, 30);
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
			}
		});
		lab_dizhiguanli.setHorizontalAlignment(SwingConstants.CENTER);
		lab_dizhiguanli.setForeground(Color.GRAY);
		lab_dizhiguanli.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lab_dizhiguanli.setBounds(50, 279, 88, 30);
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
		});
		lab_xiugaimima.setHorizontalAlignment(SwingConstants.CENTER);
		lab_xiugaimima.setForeground(Color.GRAY);
		lab_xiugaimima.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lab_xiugaimima.setBounds(50, 324, 88, 30);
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
				if(DBManager.executeUpdate("update [user] set username = ? where user_Id = ?", new String[]{inputValue,String.valueOf(selectUserId)})){
					System.out.println("修改成功");
					label_username2.setText(UserService.getUserInfoService(selectUserId).getUsername());
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
				if(DBManager.executeUpdate("update [user] set phone = ? where user_Id = ?", new String[]{inputValue,String.valueOf(selectUserId)})){
					System.out.println("修改成功");
					label_shoujihaoma2.setText(UserService.getUserInfoService(selectUserId).getPhone());
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
				if(!CheckEmail.emailCheck(inputValue)){
					JOptionPane.showMessageDialog(MainPage.this, "邮箱格式不正确!","提示",JOptionPane.INFORMATION_MESSAGE);
				}else{
					if(DBManager.executeUpdate("update [user] set email = ? where user_Id = ?", new String[]{inputValue,String.valueOf(selectUserId)})){
						System.out.println("修改成功");
						label_wodeyouxiang2.setText(UserService.getUserInfoService(selectUserId).getEmail());
					}
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
			
		});
		lb_add.setHorizontalAlignment(SwingConstants.CENTER);
		lb_add.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lb_add.setForeground(Color.GRAY);
		lb_add.setBounds(146, 16, 81, 15);
		panel_dizhiguanli.add(lb_add);
		
		
		
		
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
}
