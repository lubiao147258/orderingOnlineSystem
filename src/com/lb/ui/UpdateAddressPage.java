package com.lb.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lb.service.UserService;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateAddressPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateAddressPage frame = new UpdateAddressPage();
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
	public UpdateAddressPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("性 别");
		lblNewLabel.setBounds(33, 46, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("详细地址");
		lblNewLabel_1.setBounds(33, 84, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("电话");
		lblNewLabel_2.setBounds(33, 193, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		radioButton = new JRadioButton("男");
		radioButton.setFocusPainted(false);
		radioButton.setSelected(true);
		radioButton.setBounds(118, 42, 45, 23);
		contentPane.add(radioButton);
		
		radioButton_1 = new JRadioButton("女");
		radioButton_1.setFocusPainted(false);
		radioButton_1.setBounds(211, 42, 45, 23);
		contentPane.add(radioButton_1);
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioButton_1);
		bg.add(radioButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(97, 84, 169, 80);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(97, 186, 169, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("提 交");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String sex;
				String AddressInfo=textArea.getText();
				String phone = textField.getText();
				if(radioButton.isSelected()){
					sex = "男";
				}else{
					sex = "女";
				}
				
				if(AddressInfo.length()==0||phone.length()==0){
					
				}else{
					/*if(UserService.addAddressService(userId, new)){
						
					}*/
				}
				
				
			}
		});
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(33, 240, 149, 29);
		contentPane.add(lblNewLabel_3);
	}
}
