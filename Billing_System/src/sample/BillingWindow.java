package sample;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import com.sun.glass.events.*;

import java.awt.Color;
import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;
import java.lang.NullPointerException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BillingWindow {
	//Variables
	String tax;
	String subtotal;
	String total;
	double[] costOfItem = new double[21];

	//JFrame
	private JFrame frmBillingInformation;
	private JFrame frame;
	
	//TextField
	private JTextField textEggs;
	private JTextField textWine;
	private JTextField textMilk;
	private JTextField textRum;
	private JTextField textBread;
	private JTextField textCoriander;
	private JTextField textMeat;
	private JTextField textRice;
	private JTextField textGrapes;
	private JTextField textOrange;
	private JTextField textGinger;
	private JTextField textTomatoes;
	private JTextField textLettuce;
	private JTextField textBacon;
	private JTextField textBeans;
	private JTextField textCheese;
	private JTextField textApple;
	private JTextField textPineapple;
	private JTextField textCarrots;
	private JTextField textBroccoli;
	private JTextField textTax;
	private JTextField textSubtotal;
	private JTextField textTotal;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillingWindow window = new BillingWindow();
					window.frmBillingInformation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BillingWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBillingInformation = new JFrame();
		frmBillingInformation.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				//Enabling the text
				textWine.setEnabled(false);
				textMilk.setEnabled(false);
				textMeat.setEnabled(false);
				textRice.setEnabled(false);
				textEggs.setEnabled(false);
				textOrange.setEnabled(false);
				textGrapes.setEnabled(false);
				textGinger.setEnabled(false); 
				textTomatoes.setEnabled(false);
				textLettuce.setEnabled(false);
				
				textRum.setEnabled(false);
				textBread.setEnabled(false);
				textBacon.setEnabled(false);
				textBeans.setEnabled(false);
				textCheese.setEnabled(false);
				textApple.setEnabled(false);
				textPineapple.setEnabled(false);
				textCoriander.setEnabled(false);
				textCarrots.setEnabled(false);
				textBroccoli.setEnabled(false);
				
			}
		});
		frmBillingInformation.setTitle("Billing Information");
		frmBillingInformation.setBounds(0, 0, 925, 700);
		frmBillingInformation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBillingInformation.getContentPane().setLayout(new GridLayout(1, 3, 3, 3));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		frmBillingInformation.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(4, 3, 109, 647);
		panel_1.add(panel_3);
		
		JCheckBox chckbxWine = new JCheckBox("Wine");
		chckbxWine.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxWine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxWine.isSelected())
				{
					textWine.setEnabled(true);
					textWine.setText("");
					textWine.requestFocus();
				}
				else
				{
					textWine.setEnabled(false);
					textWine.setText("0");
				}
			}
		});
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 28));
		chckbxWine.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_3.add(chckbxWine);
		
		JCheckBox chckbxMilk = new JCheckBox("Milk");
		chckbxMilk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxMilk.isSelected())
				{
					textMilk.setEnabled(true);
					textMilk.setText("");
					textMilk.requestFocus();
				}
				else
				{
					textMilk.setEnabled(false);
					textMilk.setText("0");
				}
			}
		});
		chckbxMilk.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxMilk.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_3.add(chckbxMilk);
		
		JCheckBox chckbxMeat = new JCheckBox("Meat");
		chckbxMeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxMeat.isSelected())
				{
					textMeat.setEnabled(true);
					textMeat.setText("");
					textMeat.requestFocus();
				}
				else
				{
					textMeat.setEnabled(false);
					textMeat.setText("0");
				}
			}
		});
		chckbxMeat.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxMeat.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_3.add(chckbxMeat);
		
		JCheckBox chckbxRice = new JCheckBox("Rice");
		chckbxRice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxRice.isSelected())
				{
					textRice.setEnabled(true);
					textRice.setText("");
					textRice.requestFocus();
				}
				else
				{
					textRice.setEnabled(false);
					textRice.setText("0");
				}
			}
		});
		chckbxRice.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxRice.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_3.add(chckbxRice);
		
		JCheckBox chckbxEggs = new JCheckBox("Eggs");
		chckbxEggs.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxEggs.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_3.add(chckbxEggs);
		
		JCheckBox chckbxOrange = new JCheckBox("Orange");
		chckbxOrange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxOrange.isSelected())
				{
					textOrange.setEnabled(true);
					textOrange.setText("");
					textOrange.requestFocus();
				}
				else
				{
					textOrange.setEnabled(false);
					textOrange.setText("0");
				}
			}
		});
		chckbxOrange.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxOrange.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_3.add(chckbxOrange);
		
		JCheckBox chckbxGrapes = new JCheckBox("Grapes");
		chckbxGrapes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxGrapes.isSelected())
				{
					textGrapes.setEnabled(true);
					textGrapes.setText("");
					textGrapes.requestFocus();
				}
				else
				{
					textGrapes.setEnabled(false);
					textGrapes.setText("0");
				}
			}
		});
		chckbxGrapes.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxGrapes.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_3.add(chckbxGrapes);
		
		JCheckBox chckbxGinger = new JCheckBox("Ginger");
		chckbxGinger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxGinger.isSelected())
				{
					textGinger.setEnabled(true);
					textGinger.setText("");
					textGinger.requestFocus();
				}
				else
				{
					textGinger.setEnabled(false);
					textGinger.setText("0");
				}
			}
		});
		chckbxGinger.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxGinger.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_3.add(chckbxGinger);
		
		JCheckBox chckbxTomatoes = new JCheckBox("Tomatoes");
		chckbxTomatoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxTomatoes.isSelected())
				{
					textTomatoes.setEnabled(true);
					textTomatoes.setText("");
					textTomatoes.requestFocus();
				}
				else
				{
					textTomatoes.setEnabled(false);
					textTomatoes.setText("0");
				}
			}
		});
		chckbxTomatoes.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxTomatoes.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_3.add(chckbxTomatoes);
		
		JCheckBox chckbxLettuce = new JCheckBox("Lettuce");
		chckbxLettuce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxLettuce.isSelected())
				{
					textLettuce.setEnabled(true);
					textLettuce.setText("");
					textLettuce.requestFocus();
				}
				else
				{
					textLettuce.setEnabled(false);
					textLettuce.setText("0");
				}
			}
		});
		chckbxLettuce.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxLettuce.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_3.add(chckbxLettuce);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(114, 3, 109, 647);
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setVgap(30);
		panel_1.add(panel_4);
		
		textWine = new JTextField();
		textWine.setHorizontalAlignment(SwingConstants.CENTER);
		textWine.setText("0");
		textWine.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_4.add(textWine);
		textWine.setColumns(10);
		
		textMilk = new JTextField();
		textMilk.setHorizontalAlignment(SwingConstants.CENTER);
		textMilk.setText("0");
		textMilk.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_4.add(textMilk);
		textMilk.setColumns(10);
		
		textMeat = new JTextField();
		textMeat.setHorizontalAlignment(SwingConstants.CENTER);
		textMeat.setText("0");
		textMeat.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_4.add(textMeat);
		textMeat.setColumns(10);
		
		textRice = new JTextField();
		textRice.setHorizontalAlignment(SwingConstants.CENTER);
		textRice.setText("0");
		textRice.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_4.add(textRice);
		textRice.setColumns(10);
		
		textEggs = new JTextField();
		textEggs.setHorizontalAlignment(SwingConstants.CENTER);
		textEggs.setText("0");
		textEggs.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_4.add(textEggs);
		textEggs.setColumns(10);
		
		textOrange = new JTextField();
		textOrange.setHorizontalAlignment(SwingConstants.CENTER);
		textOrange.setText("0");
		textOrange.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_4.add(textOrange);
		textOrange.setColumns(10);
		
		textGrapes = new JTextField();
		textGrapes.setHorizontalAlignment(SwingConstants.CENTER);
		textGrapes.setText("0");
		textGrapes.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_4.add(textGrapes);
		textGrapes.setColumns(10);
		
		textGinger = new JTextField();
		textGinger.setHorizontalAlignment(SwingConstants.CENTER);
		textGinger.setText("0");
		textGinger.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_4.add(textGinger);
		textGinger.setColumns(10);
		
		textTomatoes = new JTextField();
		textTomatoes.setHorizontalAlignment(SwingConstants.CENTER);
		textTomatoes.setText("0");
		textTomatoes.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_4.add(textTomatoes);
		textTomatoes.setColumns(10);
		
		textLettuce = new JTextField();
		textLettuce.setText("0");
		textLettuce.setHorizontalAlignment(SwingConstants.CENTER);
		textLettuce.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_4.add(textLettuce);
		textLettuce.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(224, 3, 109, 647);
		FlowLayout flowLayout_3 = (FlowLayout) panel_5.getLayout();
		flowLayout_3.setVgap(28);
		panel_1.add(panel_5);
		
		JCheckBox chckbxRum = new JCheckBox("Rum");
		chckbxRum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxRum.isSelected())
				{
					textRum.setEnabled(true);
					textRum.setText("");
					textRum.requestFocus();
				}
				else
				{
					textRum.setEnabled(false);
					textRum.setText("0");
				}
			}
		});
		chckbxRum.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxRum.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_5.add(chckbxRum);
		
		JCheckBox chckbxBread = new JCheckBox("Bread");
		chckbxBread.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxBread.isSelected())
				{
					textBread.setEnabled(true);
					textBread.setText("");
					textBread.requestFocus();
				}
				else
				{
					textBread.setEnabled(false);
					textBread.setText("0");
				}
			}
		});
		chckbxBread.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxBread.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_5.add(chckbxBread);
		
		JCheckBox chckbxBacon = new JCheckBox("Bacon");
		chckbxBacon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxBacon.isSelected())
				{
					textBacon.setEnabled(true);
					textBacon.setText("");
					textBacon.requestFocus();
				}
				else
				{
					textBacon.setEnabled(false);
					textBacon.setText("0");
				}
			}
		});
		chckbxBacon.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxBacon.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_5.add(chckbxBacon);
		
		JCheckBox chckbxBeans = new JCheckBox("Beans");
		chckbxBeans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxBeans.isSelected())
				{
					textBeans.setEnabled(true);
					textBeans.setText("");
					textBeans.requestFocus();
				}
				else
				{
					textBeans.setEnabled(false);
					textBeans.setText("0");
				}
			}
		});
		chckbxBeans.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxBeans.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_5.add(chckbxBeans);
		
		JCheckBox chckbxCheese = new JCheckBox("Cheese");
		chckbxCheese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxCheese.isSelected())
				{
					textCheese.setEnabled(true);
					textCheese.setText("");
					textCheese.requestFocus();
				}
				else
				{
					textCheese.setEnabled(false);
					textCheese.setText("0");
				}
			}
		});
		chckbxCheese.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxCheese.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_5.add(chckbxCheese);
		
		JCheckBox chckbxApple = new JCheckBox("Apple");
		chckbxApple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxApple.isSelected())
				{
					textApple.setEnabled(true);
					textApple.setText("");
					textApple.requestFocus();
				}
				else
				{
					textApple.setEnabled(false);
					textApple.setText("0");
				}
			}
		});
		chckbxApple.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxApple.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_5.add(chckbxApple);
		
		JCheckBox chckbxPineapple = new JCheckBox("Pineapple");
		chckbxPineapple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxPineapple.isSelected())
				{
					textPineapple.setEnabled(true);
					textPineapple.setText("");
					textPineapple.requestFocus();
				}
				else
				{
					textPineapple.setEnabled(false);
					textPineapple.setText("0");
				}
			}
		});
		chckbxPineapple.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxPineapple.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_5.add(chckbxPineapple);
		
		JCheckBox chckbxCoriander = new JCheckBox("Coriander");
		chckbxCoriander.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxCoriander.isSelected())
				{
					textCoriander.setEnabled(true);
					textCoriander.setText("");
					textCoriander.requestFocus();
				}
				else
				{
					textCoriander.setEnabled(false);
					textCoriander.setText("0");
				}
			}
		});
		chckbxCoriander.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxCoriander.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_5.add(chckbxCoriander);
		
		JCheckBox chckbxCarrots = new JCheckBox("Carrots");
		chckbxCarrots.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxCarrots.isSelected())
				{
					textCarrots.setEnabled(true);
					textCarrots.setText("");
					textCarrots.requestFocus();
				}
				else
				{
					textCarrots.setEnabled(false);
					textCarrots.setText("0");
				}
			}
		});
		chckbxCarrots.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxCarrots.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_5.add(chckbxCarrots);
		
		JCheckBox chckbxBroccoli = new JCheckBox("Broccoli");
		chckbxBroccoli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxBroccoli.isSelected())
				{
					textBroccoli.setEnabled(true);
					textBroccoli.setText("");
					textBroccoli.requestFocus();
				}
				else
				{
					textBroccoli.setEnabled(false);
					textBroccoli.setText("0");
				}
			}
		});
		chckbxBroccoli.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxBroccoli.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_5.add(chckbxBroccoli);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(334, 3, 109, 647);
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setVgap(30);
		panel_1.add(panel_6);
		
		textRum = new JTextField();
		textRum.setHorizontalAlignment(SwingConstants.CENTER);
		textRum.setText("0");
		textRum.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_6.add(textRum);
		textRum.setColumns(10);
		
		textBread = new JTextField();
		textBread.setHorizontalAlignment(SwingConstants.CENTER);
		textBread.setText("0");
		textBread.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_6.add(textBread);
		textBread.setColumns(10);
		
		textBacon = new JTextField();
		textBacon.setHorizontalAlignment(SwingConstants.CENTER);
		textBacon.setText("0");
		textBacon.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_6.add(textBacon);
		textBacon.setColumns(10);
		
		textBeans = new JTextField();
		textBeans.setHorizontalAlignment(SwingConstants.CENTER);
		textBeans.setText("0");
		textBeans.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_6.add(textBeans);
		textBeans.setColumns(10);
		
		textCheese = new JTextField();
		textCheese.setHorizontalAlignment(SwingConstants.CENTER);
		textCheese.setText("0");
		textCheese.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_6.add(textCheese);
		textCheese.setColumns(10);
		
		textApple = new JTextField();
		textApple.setHorizontalAlignment(SwingConstants.CENTER);
		textApple.setText("0");
		textApple.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_6.add(textApple);
		textApple.setColumns(10);
		
		textPineapple = new JTextField();
		textPineapple.setHorizontalAlignment(SwingConstants.CENTER);
		textPineapple.setText("0");
		textPineapple.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_6.add(textPineapple);
		textPineapple.setColumns(10);
		
		textCoriander = new JTextField();
		textCoriander.setHorizontalAlignment(SwingConstants.CENTER);
		textCoriander.setText("0");
		textCoriander.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_6.add(textCoriander);
		textCoriander.setColumns(10);
		
		textCarrots = new JTextField();
		textCarrots.setHorizontalAlignment(SwingConstants.CENTER);
		textCarrots.setText("0");
		textCarrots.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_6.add(textCarrots);
		textCarrots.setColumns(10);
		
		textBroccoli = new JTextField();
		textBroccoli.setHorizontalAlignment(SwingConstants.CENTER);
		textBroccoli.setText("0");
		textBroccoli.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel_6.add(textBroccoli);
		textBroccoli.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		frmBillingInformation.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTax.setBounds(38, 37, 56, 16);
		panel_2.add(lblTax);
		
		textTax = new JTextField();
		textTax.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textTax.setHorizontalAlignment(SwingConstants.CENTER);
		textTax.setText("0");
		textTax.setBounds(204, 34, 116, 22);
		panel_2.add(textTax);
		textTax.setColumns(10);
		
		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSubtotal.setBounds(38, 84, 86, 16);
		panel_2.add(lblSubtotal);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTotal.setBounds(38, 133, 56, 16);
		panel_2.add(lblTotal);
		
		textSubtotal = new JTextField();
		textSubtotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textSubtotal.setHorizontalAlignment(SwingConstants.CENTER);
		textSubtotal.setText("0");
		textSubtotal.setColumns(10);
		textSubtotal.setBounds(204, 81, 116, 22);
		panel_2.add(textSubtotal);
		
		textTotal = new JTextField();
		textTotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textTotal.setText("0");
		textTotal.setColumns(10);
		textTotal.setBounds(204, 130, 116, 22);
		panel_2.add(textTotal);
		
		JTextArea textReceipt = new JTextArea();
		textReceipt.setBounds(12, 194, 424, 375);
		panel_2.add(textReceipt);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				costOfItem[0] = Double.parseDouble(textWine.getText())*7.50;
				costOfItem[1] = Double.parseDouble(textMilk.getText())*3.99;
				costOfItem[2] = Double.parseDouble(textMeat.getText())*2.89;
				costOfItem[3] = Double.parseDouble(textRice.getText())*12.99;
				costOfItem[4] = Double.parseDouble(textEggs.getText())*3.99;
				costOfItem[5] = Double.parseDouble(textOrange.getText())*1.99;
				costOfItem[6] = Double.parseDouble(textGrapes.getText())*1.99;
				costOfItem[7] = Double.parseDouble(textGinger.getText())*0.99;
				costOfItem[8] = Double.parseDouble(textTomatoes.getText())*2.99;
				costOfItem[9] = Double.parseDouble(textLettuce.getText())*1.99;
				costOfItem[10] = Double.parseDouble(textRum.getText())*11.20;
				costOfItem[11] = Double.parseDouble(textBread.getText())*3.50;
				costOfItem[12] = Double.parseDouble(textBacon.getText())*1.15;
				costOfItem[13] = Double.parseDouble(textBeans.getText())*2.20;
				costOfItem[14] = Double.parseDouble(textCheese.getText())*4.50;
				costOfItem[15] = Double.parseDouble(textApple.getText())*1.50;
				costOfItem[16] = Double.parseDouble(textPineapple.getText())*5.20;
				costOfItem[17] = Double.parseDouble(textCoriander.getText())*1.99;
				costOfItem[18] = Double.parseDouble(textCarrots.getText())*3.89;
				costOfItem[19] = Double.parseDouble(textBroccoli.getText())*1.59;
				
				
				costOfItem[20] = costOfItem[0] + costOfItem[1] + costOfItem[2]+ costOfItem[3] + costOfItem[4]
						         + costOfItem[5] + costOfItem[6] + costOfItem[7]+ costOfItem[8] + costOfItem[9]
				                 + costOfItem[10] + costOfItem[11] + costOfItem[12]+ costOfItem[13] + costOfItem[14]
				                 + costOfItem[15] + costOfItem[16] + costOfItem[17]+ costOfItem[18] + costOfItem[19];
				
				tax = String.format("$ %.2f", ((costOfItem[20]*13)/100));
				subtotal = String.format("$ %.2f", costOfItem[20]);
				total = String.format("$ %.2f", (costOfItem[20] + ((costOfItem[20]*13)/100)));
				
				textTax.setText(tax);
				textSubtotal.setText(subtotal);
				textTotal.setText(total);	
				
				textReceipt.setEnabled(true);
				int refs = 1352 + (int) (Math.random()*4238);
				Calendar timer = Calendar.getInstance();
				timer.getTime();
				SimpleDateFormat tTime = new SimpleDateFormat ("HH:mm:ss");
				tTime.format(timer.getTime());
				SimpleDateFormat tDate = new SimpleDateFormat ("dd:MMM:yyyy");
				tDate.format(timer.getTime());
				
				textReceipt.append("\t\tBilling Information\n" +
				"Reference: \t\t\t\t             " + refs +
				"\n============================================================\t" +
				"\n============================================================\t" +
				"\nTax:\t\t\t\t          " + tax +
				"\nSub-Total:\t\t\t\t          " + subtotal +
				"\n----------------------------------------------------------------------------------------------------------\t" +
				"\nTotal:\t\t\t\t          " + total +
				"\n============================================================\t" +
				"\n============================================================\t" +
				"\nDate: " + tDate.format(timer.getTime()) +
				"\t\t                         Time:" + tTime.format(timer.getTime()) +
				"\n\n\t         Thank you for shopping at Skyblue\n");	
			}
		});
		btnTotal.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnTotal.setBounds(46, 602, 97, 25);
		panel_2.add(btnTotal);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Setting text
				textReceipt.setText("");
				textReceipt.setEnabled(false);
				textWine.setText(null);
				textMilk.setText(null);
				textMeat.setText(null);
				textRice.setText(null);
				textEggs.setText(null);
				textOrange.setText(null);
				textGrapes.setText(null);
				textGinger.setText(null); 
				textTomatoes.setText(null);
				textLettuce.setText(null);
				textRum.setText(null);
				textBread.setText(null);
				textBacon.setText(null);
				textBeans.setText(null);
				textCheese.setText(null);
				textApple.setText(null);
				textPineapple.setText(null);
				textCoriander.setText(null);
				textCarrots.setText(null);
				textBroccoli.setText(null);
				
				textTax.setText(null);
				textSubtotal.setText(null);
				textTotal.setText(null);
				
				chckbxWine.setSelected(false);
				chckbxMilk.setSelected(false);
				chckbxMeat.setSelected(false);
				chckbxRice.setSelected(false);
				chckbxEggs.setSelected(false);
				chckbxOrange.setSelected(false);
				chckbxGrapes.setSelected(false);
				chckbxGinger.setSelected(false);
				chckbxTomatoes.setSelected(false);
				chckbxLettuce.setSelected(false);
				chckbxRum.setSelected(false);
				chckbxBread.setSelected(false);
				chckbxBacon.setSelected(false);
				chckbxBeans.setSelected(false);
				chckbxCheese.setSelected(false);
				chckbxApple.setSelected(false);
				chckbxPineapple.setSelected(false);
				chckbxCoriander.setSelected(false);
				chckbxCarrots.setSelected(false);
				chckbxBroccoli.setSelected(false);
				
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnClear.setBounds(186, 602, 97, 25);
		panel_2.add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "       Do you want to exit", "Billing Information",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION){
					System.exit(0);
			}
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnExit.setBounds(318, 602, 97, 25);
		panel_2.add(btnExit);
	}
}
