package com.lb.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.lb.entity.Food;
import com.lb.entity.FoodType;
import com.lb.service.SellerService;

public class AddFoodPage extends JFrame {

	private JPanel contentPane;
	private JPanel panel_leibie;
	private JPanel panel_caipin;
	private JTextField textField;
	private JTextField textField_name;
	private JTextField textFielddanjia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFoodPage frame = new AddFoodPage();
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
	public AddFoodPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);//去除边框
		setLocationRelativeTo(null);//初始化位置（电脑中心）
		contentPane.setLayout(null);
		
		
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
				AddFoodPage.this.dispose();
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
				AddFoodPage.this.setExtendedState(JFrame.ICONIFIED);
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
		
		//添加菜
		
		panel_leibie = new JPanel();
		panel_leibie.setBounds(166, 90, 432, 332);
		contentPane.add(panel_leibie);
		panel_leibie.setLayout(null);
		panel_leibie.setVisible(false);
		
		JLabel label_2 = new JLabel("输入菜类别名称：");
		label_2.setBounds(10, 49, 149, 30);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(153, 102, 102));
		label_2.setFont(new Font("楷体", Font.PLAIN, 16));
		panel_leibie.add(label_2);
		
		textField = new JTextField();
		textField.setForeground(new Color(51, 51, 51));
		textField.setFont(new Font("楷体", Font.PLAIN, 16));
		textField.setBounds(166, 46, 182, 39);
		panel_leibie.add(textField);
		textField.setColumns(10);
		
		JLabel label_3 = new JLabel("已有菜类别名称：");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(153, 102, 102));
		label_3.setFont(new Font("楷体", Font.PLAIN, 16));
		label_3.setBounds(10, 120, 149, 30);
		panel_leibie.add(label_3);
		
		JComboBox comboBox = new JComboBox();
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"1"}));
		for (FoodType foodtype : SellerService.getFoodTyleService()) {
			comboBox.addItem(foodtype.getTypeName());
		}
		//comboBox.addItem("武汉");

		comboBox.setForeground(new Color(51, 51, 51));
		comboBox.setFont(new Font("楷体", Font.PLAIN, 16));
		comboBox.setBounds(166, 117, 182, 39);
		panel_leibie.add(comboBox);
		
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
				if(textField.getText().trim().length()==0){
					JOptionPane.showMessageDialog(AddFoodPage.this, "请输入添加的类别!","提示",JOptionPane.INFORMATION_MESSAGE);
				}else{
					if(SellerService.checkFoodTypeNameIsExistsService(textField.getText())==0){
						if(SellerService.addFoodTypeService(textField.getText())){
							JOptionPane.showMessageDialog(AddFoodPage.this, "添加成功!","提示",JOptionPane.INFORMATION_MESSAGE);			
								comboBox.removeAllItems();					
							for (FoodType foodtype : SellerService.getFoodTyleService()) {
								comboBox.addItem(foodtype.getTypeName());
							}
							textField.setText("");						
							
						}else{
							JOptionPane.showMessageDialog(AddFoodPage.this, "添加失败!","提示",JOptionPane.INFORMATION_MESSAGE);
							textField.setText("");
						}
					}else{
						JOptionPane.showMessageDialog(AddFoodPage.this, "已存在该类商品，请勿重复添加!","提示",JOptionPane.INFORMATION_MESSAGE);
						textField.setText("");
					}
				}
				
			}
		});
		label_4.setOpaque(true);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("楷体", Font.BOLD, 20));
		label_4.setBackground(new Color(0, 191, 255));
		label_4.setBounds(60, 212, 99, 38);
		panel_leibie.add(label_4);
		
		
		
		JLabel label = new JLabel("添加类别");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_caipin.setVisible(false);
				panel_leibie.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setForeground(new Color(0, 0, 128));
			}
		});
		label.setBounds(25, 288, 99, 38);
		contentPane.add(label);
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("楷体", Font.BOLD, 20));
		label.setBackground(new Color(240, 240, 240));
		
		JLabel label_1 = new JLabel("添加菜品");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_caipin.setVisible(true);
				panel_leibie.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label_1.setForeground(new Color(255,0,0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_1.setForeground(new Color(0, 0, 128));
			}
		});
		label_1.setBounds(25, 136, 99, 38);
		contentPane.add(label_1);
		label_1.setOpaque(true);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(0, 0, 128));
		label_1.setFont(new Font("楷体", Font.BOLD, 20));
		label_1.setBackground(new Color(240, 240, 240));
		
		
		
		panel_caipin = new JPanel();
		panel_caipin.setBounds(166, 90, 432, 332);
		contentPane.add(panel_caipin);
		panel_caipin.setLayout(null);
		
		
		
		
		//****************************
		
		JLabel label_5 = new JLabel("菜类别：");
		label_5.setBounds(10, 26, 149, 30);
		panel_caipin.add(label_5);
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setForeground(new Color(153, 102, 102));
		label_5.setFont(new Font("楷体", Font.PLAIN, 16));
		
		JLabel label_caiing = new JLabel("菜名称：");
		label_caiing.setHorizontalAlignment(SwingConstants.LEFT);
		label_caiing.setForeground(new Color(153, 102, 102));
		label_caiing.setFont(new Font("楷体", Font.PLAIN, 16));
		label_caiing.setBounds(10, 76, 149, 30);
		panel_caipin.add(label_caiing);
		
		JLabel label_33 = new JLabel("单价：");
		label_33.setHorizontalAlignment(SwingConstants.LEFT);
		label_33.setForeground(new Color(153, 102, 102));
		label_33.setFont(new Font("楷体", Font.PLAIN, 16));
		label_33.setBounds(10, 127, 149, 30);
		panel_caipin.add(label_33);
		
		JLabel label_44 = new JLabel("是否立即上架：");
		label_44.setHorizontalAlignment(SwingConstants.LEFT);
		label_44.setForeground(new Color(153, 102, 102));
		label_44.setFont(new Font("楷体", Font.PLAIN, 16));
		label_44.setBounds(10, 176, 112, 30);
		panel_caipin.add(label_44);
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setFont(new Font("楷体", Font.PLAIN, 18));
		
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "6", "5", "4"}));
		
		for (FoodType foodtype : SellerService.getFoodTyleService()) {
			comboBox1.addItem(foodtype.getTypeName());
		}
		
		comboBox1.setBounds(106, 25, 176, 35);
		panel_caipin.add(comboBox1);
		
		textField_name = new JTextField();
		textField_name.setBounds(106, 75, 177, 35);
		panel_caipin.add(textField_name);
		textField_name.setColumns(10);
		
		textFielddanjia = new JTextField();
		textFielddanjia.setColumns(10);
		textFielddanjia.setBounds(106, 122, 177, 35);
		panel_caipin.add(textFielddanjia);
		
		JRadioButton shi = new JRadioButton("是");
		shi.setFont(new Font("楷体", Font.PLAIN, 18));
		shi.setSelected(true);
		shi.setBounds(133, 181, 48, 23);
		panel_caipin.add(shi);
		
		JRadioButton fou = new JRadioButton("否");
		fou.setFont(new Font("楷体", Font.PLAIN, 18));
		fou.setBounds(214, 181, 48, 23);
		panel_caipin.add(fou);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(shi);
		bg.add(fou);
		JLabel label_6 = new JLabel("提 交");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_6.setBackground(new Color(18,150,193));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_6.setBackground(new Color(0,191,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				label_6.setBackground(new Color(7,50,93));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				label_6.setBackground(new Color(18,150,193));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField_name.getText().trim().length()==0||textFielddanjia.getText().trim().length()==0){
					//comboBox1
					//textField_name
					//textFielddanjia
					//shi/fou
					JOptionPane.showMessageDialog(AddFoodPage.this, "输入框不能为空!","提示",JOptionPane.INFORMATION_MESSAGE);
					textField_name.setText("");
					textFielddanjia.setText("");
				}
				else{					
					int typeid =SellerService.getFoodTypeIdByName((comboBox1.getSelectedItem().toString().trim()));
					int isOnsale;
					if(shi.isSelected()){
						isOnsale=1;
					}else{
						isOnsale=0;						
					}
					if(SellerService.checkFoodNameIsExistsService(textField_name.getText().trim())>=1){
						JOptionPane.showMessageDialog(AddFoodPage.this, "已存在给商品,请勿重复添加!","提示",JOptionPane.INFORMATION_MESSAGE);
						textField_name.setText("");
						textFielddanjia.setText("");
					}else{
						if(SellerService.addFoodService(new Food(typeid,textField_name.getText().trim(),Double.parseDouble(textFielddanjia.getText().trim()),isOnsale))){
							JOptionPane.showMessageDialog(AddFoodPage.this, "添加成功!","提示",JOptionPane.INFORMATION_MESSAGE);
							textField_name.setText("");
							textFielddanjia.setText("");
						}else{
							JOptionPane.showMessageDialog(AddFoodPage.this, "添加失败!","提示",JOptionPane.INFORMATION_MESSAGE);
							textField_name.setText("");
							textFielddanjia.setText("");
						}
					}
				}
			}
		});
		label_6.setOpaque(true);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("楷体", Font.BOLD, 20));
		label_6.setBackground(new Color(0, 191, 255));
		label_6.setBounds(45, 238, 99, 38);
		panel_caipin.add(label_6);
		
	}
}
