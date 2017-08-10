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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.lb.entity.FoodType;
import com.lb.service.SellerService;
import com.lb.util.DBManager;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

public class ChangeFoodPage extends JFrame {

	public static int selectid;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeFoodPage frame = new ChangeFoodPage();
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
	public ChangeFoodPage() {
		//System.out.println("Change页面的值："+selectid);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setUndecorated(true);//去除边框
		setLocationRelativeTo(null);//初始化位置（电脑中心）
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 608, 80);
		panel.setBackground(new Color(0, 191, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lb_close = new JLabel("");
		lb_close.setOpaque(true);
		lb_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ChangeFoodPage.this.dispose();
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
				ChangeFoodPage.this.setExtendedState(JFrame.ICONIFIED);
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
		panel_leftline.setBounds(0, 77, 2, 355);
		panel_leftline.setBackground(new Color(0, 191, 255));
		contentPane.add(panel_leftline);
		
		JPanel panel_rightline = new JPanel();
		panel_rightline.setBounds(606, 77, 2, 355);
		panel_rightline.setBackground(new Color(0, 191, 255));
		contentPane.add(panel_rightline);
		
		JPanel panel_bottomline = new JPanel();
		panel_bottomline.setBounds(0, 430, 608, 2);
		panel_bottomline.setBackground(new Color(18,150,193));
		contentPane.add(panel_bottomline);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(98, 88, 432, 332);
		contentPane.add(panel_1);
		
		JLabel label = new JLabel("菜类别：");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(new Color(153, 102, 102));
		label.setFont(new Font("楷体", Font.PLAIN, 16));
		label.setBounds(10, 26, 78, 30);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("菜名称：");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(new Color(153, 102, 102));
		label_1.setFont(new Font("楷体", Font.PLAIN, 16));
		label_1.setBounds(10, 76, 91, 30);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("单价：");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(new Color(153, 102, 102));
		label_2.setFont(new Font("楷体", Font.PLAIN, 16));
		label_2.setBounds(10, 127, 86, 30);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("状态：");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(new Color(153, 102, 102));
		label_3.setFont(new Font("楷体", Font.PLAIN, 16));
		label_3.setBounds(10, 176, 99, 30);
		panel_1.add(label_3);
		
		JComboBox comboBox = new JComboBox();
		
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "4", "7", "8", "9", "6", "5", "2", "3"}));
		for (FoodType foodtype : SellerService.getFoodTyleService()) {
			comboBox.addItem(foodtype.getTypeName());
		}
		comboBox.setFont(new Font("楷体", Font.PLAIN, 18));
		comboBox.setBounds(106, 25, 176, 35);
		panel_1.add(comboBox);
		//System.out.println("Change页面的值："+selectid);
		textField = new JTextField(SellerService.getFoodInfoById(selectid).getFoodName());
		textField.setFont(new Font("楷体", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(106, 75, 177, 35);
		panel_1.add(textField);
		
		textField_1 = new JTextField(String.valueOf(SellerService.getFoodInfoById(selectid).getPrice()));
		textField_1.setFont(new Font("楷体", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(106, 122, 177, 35);
		panel_1.add(textField_1);
		
		JRadioButton radioButton = new JRadioButton("在售");
		//radioButton.setSelected(true);
		
		radioButton.setFont(new Font("楷体", Font.PLAIN, 18));
		radioButton.setBounds(115, 179, 61, 23);
		panel_1.add(radioButton);
		
		//System.out.println("状态："+SellerService.getFoodInfoById(selectid).getIsOnsale());
		JRadioButton radioButton_1 = new JRadioButton("已下架");
		radioButton_1.setFont(new Font("楷体", Font.PLAIN, 18));
		radioButton_1.setBounds(201, 179, 91, 23);
		panel_1.add(radioButton_1);
		if(SellerService.getFoodInfoById(selectid).getIsOnsale()==1){
			radioButton.setSelected(true);
			radioButton_1.setSelected(false);
		}else{
			radioButton.setSelected(false);
			radioButton_1.setSelected(true);
		}
		ButtonGroup  bg = new ButtonGroup();
		bg.add(radioButton_1);
		bg.add(radioButton);
		JLabel label_4 = new JLabel("提 交");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_4.setBackground(new Color(18,150,193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_4.setBackground(new Color(0,191,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				label_4.setBackground(new Color(7,50,93));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				label_4.setBackground(new Color(18,150,193));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField.getText().trim().length()==0||textField_1.getText().trim().length()==0){//comboBox\textField\textField_1
					JOptionPane.showMessageDialog(ChangeFoodPage.this, "修改失败，不允许输入框为空!","提示",JOptionPane.INFORMATION_MESSAGE);
				}else{
					String com = (String) comboBox.getSelectedItem();
					int onsale;
					if(radioButton.isSelected()){
						onsale=1;
					}else{
						onsale=0;
					}
					String[] objs = new String[]{textField.getText().trim(),textField_1.getText().trim(),String.valueOf(SellerService.getFoodTypeIdByName(com)),String.valueOf(onsale),String.valueOf(selectid)};
					if(DBManager.executeUpdate("update food set food_name=?,food_price=?,type_id=?,onsale=? where food_Id=?", objs)){
						JOptionPane.showMessageDialog(ChangeFoodPage.this, "修改成功!","提示",JOptionPane.INFORMATION_MESSAGE);
						new AdminPage().setVisible(true);
					}else{
						JOptionPane.showMessageDialog(ChangeFoodPage.this, "修改失败!","提示",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
			}
		});
		label_4.setOpaque(true);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("楷体", Font.BOLD, 20));
		label_4.setBackground(new Color(0, 191, 255));
		label_4.setBounds(45, 238, 99, 38);
		panel_1.add(label_4);
	}

}
