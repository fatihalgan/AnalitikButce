package com.iztek.abutce.menu.raporlar;

import java.awt.Cursor;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import com.iztek.abutce.controller.GuiController;
import com.iztek.abutce.domain.ButceConstants;
import com.iztek.abutce.domain.RaporBean;
import com.iztek.abutce.util.SwingUtils;
import com.iztek.abutce.util.report.ReportManager;

public class ReportParameters extends JFrame {

	private javax.swing.JPanel jContentPane = null;
	private javax.swing.JLabel jLabel = null;
	private javax.swing.JLabel jLabel1 = null;
	private javax.swing.JLabel jLabel2 = null;
	private javax.swing.JComboBox jComboBox = null;
	private javax.swing.JCheckBox jCheckBox = null;
	private javax.swing.JCheckBox jCheckBox1 = null;
	private javax.swing.JCheckBox jCheckBox2 = null;
	private javax.swing.JButton jButton = null;
	private javax.swing.JButton jButton1 = null;
	private javax.swing.JButton jButton2 = null;
	private ButtonGroup buttonGroup = null;
	private javax.swing.DefaultComboBoxModel comboBoxModel = null;
	
	private String title = null;
	private int tip;
	private int yil;	
	
	private javax.swing.JRadioButton jRadioButton = null;
	private javax.swing.JRadioButton jRadioButton1 = null;
	public ReportParameters(String title, int tip, int yil) {
		super();
		this.title = title;
		this.tip = tip;
		this.yil = yil;
		initialize();
		editCheckBox();
	}
	
	private void initialize() {
		this.setSize(308, 295);
		this.setContentPane(getJContentPane());
		SwingUtils.centerJFrame(this);
		this.setTitle("Rapor Parametreleri");
		this.setResizable(false);
		this.addWindowListener(new java.awt.event.WindowAdapter() { 
			public void windowClosing(java.awt.event.WindowEvent e) {    
				kapatButtonClicked();
			}
		});
	}
	
	private javax.swing.JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJLabel(), null);
			jContentPane.add(getJLabel1(), null);
			jContentPane.add(getJComboBox(), null);
			jContentPane.add(getJCheckBox(), null);
			jContentPane.add(getJCheckBox1(), null);
			jContentPane.add(getJCheckBox2(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJLabel2(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJRadioButton(), null);
			jContentPane.add(getJRadioButton1(), null);
			buttonGroup = new ButtonGroup();
			buttonGroup.add(jRadioButton);
			buttonGroup.add(jRadioButton1);
		}
		return jContentPane;
	}
		
	private javax.swing.JLabel getJLabel() {
		if(jLabel == null) {
			jLabel = new javax.swing.JLabel();
			jLabel.setBounds(18, 10, 266, 24);
			jLabel.setText(title);
			jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jLabel.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));
		}
		return jLabel;
	}

	private javax.swing.JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new javax.swing.JLabel();
			jLabel2.setBounds(18, 34, 266, 24);
			jLabel2.setText("Rapor Parametrelerini Seçiniz");
			jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jLabel2.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 14));
		}
		return jLabel2;
	}
	
	private javax.swing.JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new javax.swing.JLabel();
			jLabel1.setBounds(59, 74, 59, 20);
			jLabel1.setText("Bütçe Yýlý");
		}
		return jLabel1;
	}
	
	private javax.swing.JComboBox getJComboBox() {
		if(jComboBox == null) {
			jComboBox = new javax.swing.JComboBox();
			jComboBox.setBounds(119, 74, 102, 20);
			comboBoxModel = new javax.swing.DefaultComboBoxModel();
			
			for (int i = 2010; i > 1999; i--) {
				comboBoxModel.addElement(new Integer(i));
			}
			comboBoxModel.setSelectedItem(new Integer(yil));
			jComboBox.setModel(comboBoxModel);
		}
		return jComboBox;
	}
	
	private javax.swing.JCheckBox getJCheckBox() {
		if(jCheckBox == null) {
			jCheckBox = new javax.swing.JCheckBox();
			jCheckBox.setBounds(37, 105, 228, 20);
			jCheckBox.setText("Saymanýn Teklifi");
			jCheckBox.setSelected(true);
		}
		return jCheckBox;
	}
	
	private javax.swing.JCheckBox getJCheckBox1() {
		if(jCheckBox1 == null) {
			jCheckBox1 = new javax.swing.JCheckBox();
			jCheckBox1.setBounds(37, 125, 228, 20);
			jCheckBox1.setText("Belediye Baþkanýnca Uygun Görülen");
			jCheckBox1.setSelected(true);
		}
		return jCheckBox1;
	}
	
	private javax.swing.JCheckBox getJCheckBox2() {
		if(jCheckBox2 == null) {
			jCheckBox2 = new javax.swing.JCheckBox();
			jCheckBox2.setBounds(37, 145, 228, 20);
			jCheckBox2.setText("Encümence Onaylanan");
			jCheckBox2.setSelected(true);
		}
		return jCheckBox2;
	}
	
	private javax.swing.JButton getJButton() {
		if(jButton == null) {
			jButton = new javax.swing.JButton();
			jButton.setBounds(6, 228, 91, 26);
			jButton.setText("Yazdýr");
			jButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iztek/abutce/images/printer.gif")));
			jButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					yazdirButtonClicked();
				}
			});
		}
		return jButton;
	}

	private javax.swing.JRadioButton getJRadioButton() {
		if(jRadioButton == null) {
			jRadioButton = new javax.swing.JRadioButton();
			jRadioButton.setBounds(37, 175, 154, 16);
			jRadioButton.setText("Pdf Olarak Rapor Al");
			jRadioButton.setSelected(true);
		}
		return jRadioButton;
	}
	
	private javax.swing.JRadioButton getJRadioButton1() {
		if(jRadioButton1 == null) {
			jRadioButton1 = new javax.swing.JRadioButton();
			jRadioButton1.setBounds(37, 194, 154, 16);
			jRadioButton1.setText("Excel Olarak Rapor Al");
		}
		return jRadioButton1;
	}
	
	private javax.swing.JButton getJButton2() {
		if(jButton2 == null) {
			jButton2 = new javax.swing.JButton();
			jButton2.setBounds(103, 228, 96, 26);
			jButton2.setText("Kaydet");
			jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iztek/abutce/images/save.gif")));
			jButton2.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					kaydetButtonClicked();
				}
			});
		}
		return jButton2;
	}
	
	private javax.swing.JButton getJButton1() {
		if(jButton1 == null) {
			jButton1 = new javax.swing.JButton();
			jButton1.setBounds(205, 228, 91, 26);
			jButton1.setText("Kapat");
			jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/iztek/abutce/images/close.gif")));
			jButton1.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					kapatButtonClicked();
				}
			});
		}
		return jButton1;
	}
	
	private void kapatButtonClicked() {
		GuiController.getInstance().disposeEnableFrames(this);
	}
	
	private void editCheckBox() {
		if(tip == ButceConstants.GELIR) {
			jCheckBox.setText("Bütçe Geliri");
			jCheckBox.setBounds(29, 115, 228, 20);
			jCheckBox1.setVisible(false);
			jCheckBox2.setVisible(false);
		}
	}
	
	private RaporBean getRaporBean() {
		RaporBean raporBean = null;
		int secilenYil = Integer.parseInt(jComboBox.getSelectedItem().toString());
		boolean isSayman = jCheckBox.isSelected();
		boolean isBaskan = jCheckBox1.isSelected();
		boolean isEncumen = jCheckBox2.isSelected();
		if(tip == ButceConstants.GELIR) {
			raporBean = new RaporBean(tip, secilenYil, jRadioButton.isSelected(), isSayman);
		}else if(tip == ButceConstants.GIDER) {
			raporBean = new RaporBean(tip, secilenYil, jRadioButton.isSelected(), isSayman, isBaskan, isEncumen);
		}
		return raporBean;	
	}
	
	private void yazdirButtonClicked() {
		RaporBean raporBean = getRaporBean();
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		ReportManager reportManager = new ReportManager(raporBean);
		reportManager.getReport();
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));		
		kapatButtonClicked();
	}
	
	private void kaydetButtonClicked() {
		RaporBean raporBean = getRaporBean();
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setFileHidingEnabled(false);
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File outputPath = chooser.getSelectedFile();
			if(outputPath != null) {
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				raporBean.setOutputPath(outputPath.getPath());
				ReportManager reportManager = new ReportManager(raporBean);
				reportManager.getReport();
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				kapatButtonClicked();
			}
		} 
	}
} 
