/*
 * Created on 17.Eki.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.iztek.abutce.menu.giris;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;

import com.iztek.abutce.commands.kurumtanimlama.ReadKurumsalDuzeylerCommand;
import com.iztek.abutce.commands.kurumtanimlama.WriteKurumsalDuzeylerCommand;
import com.iztek.abutce.domain.KurumsalTanimBean;

/**
 * @author Selim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class KurumTanimlamaPanel extends JPanel {

	private javax.swing.JPanel jPanel = null;
	private javax.swing.JPanel jPanelNorth = null;
	private javax.swing.JPanel jPanelCenter = null;
	private javax.swing.JButton jButton2 = null;
	private javax.swing.JButton jButton3 = null;
	private javax.swing.JComboBox jComboBoxKurumTipi = null;
	private javax.swing.JComboBox jComboBoxIl = null;
	private javax.swing.JComboBox jComboBoxDuzey3 = null;
	private javax.swing.JList jListButunBirimler = null;
	private javax.swing.JList jListSeciliBirimler = null;
	private javax.swing.JLabel jLabel = null;
	private javax.swing.JLabel jLabelKurumTipi = null;
	private javax.swing.JLabel jLabel1 = null;
	private javax.swing.JLabel jLabel2 = null;
	private javax.swing.JLabel jLabel3 = null;
	private javax.swing.JButton jButton = null;
	private javax.swing.JButton jButton1 = null;
	private javax.swing.JLabel jLabel4 = null;
	private javax.swing.JScrollPane jScrollPaneButunBirimler = null;
	private javax.swing.JScrollPane jScrollPaneSeciliBirimler = null;
	private javax.swing.JButton jButton6 = null;
	private javax.swing.JButton jButton7 = null;


	/**
	 * This is the default constructor
	 */
	public KurumTanimlamaPanel() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setLayout(new java.awt.BorderLayout());
		this.add(getJPanel(), java.awt.BorderLayout.SOUTH);
		this.add(getJPanelNorth(), java.awt.BorderLayout.NORTH);
		this.add(getJPanelCenter(), java.awt.BorderLayout.CENTER);
		this.setSize(800, 600);
	}
	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJPanel() {
		if(jPanel == null) {
			jPanel = new javax.swing.JPanel();
			jPanel.add(getJButton2(), null);
		}
		return jPanel;
	}
	/**
	 * This method initializes jPanelNorth
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJPanelNorth() {
		if(jPanelNorth == null) {
			jPanelNorth = new javax.swing.JPanel();
			jPanelNorth.add(getJLabel(), null);
		}
		return jPanelNorth;
	}
	/**
	 * This method initializes jPanelCenter
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJPanelCenter() {
		if(jPanelCenter == null) {
			jPanelCenter = new javax.swing.JPanel();
			java.awt.GridBagConstraints consGridBagConstraints1 = new java.awt.GridBagConstraints();
			java.awt.GridBagConstraints consGridBagConstraints2 = new java.awt.GridBagConstraints();
			java.awt.GridBagConstraints consGridBagConstraints4 = new java.awt.GridBagConstraints();
			java.awt.GridBagConstraints consGridBagConstraints5 = new java.awt.GridBagConstraints();
			java.awt.GridBagConstraints consGridBagConstraints6 = new java.awt.GridBagConstraints();
			java.awt.GridBagConstraints consGridBagConstraints3 = new java.awt.GridBagConstraints();
			java.awt.GridBagConstraints consGridBagConstraints7 = new java.awt.GridBagConstraints();
			java.awt.GridBagConstraints consGridBagConstraints8 = new java.awt.GridBagConstraints();
			java.awt.GridBagConstraints consGridBagConstraints9 = new java.awt.GridBagConstraints();
			java.awt.GridBagConstraints consGridBagConstraints11 = new java.awt.GridBagConstraints();
			java.awt.GridBagConstraints consGridBagConstraints12 = new java.awt.GridBagConstraints();
			java.awt.GridBagConstraints consGridBagConstraints10 = new java.awt.GridBagConstraints();
			java.awt.GridBagConstraints consGridBagConstraints14 = new java.awt.GridBagConstraints();
			java.awt.GridBagConstraints consGridBagConstraints13 = new java.awt.GridBagConstraints();
			consGridBagConstraints4.insets = new java.awt.Insets(57,18,5,4);
			consGridBagConstraints4.ipady = 5;
			consGridBagConstraints4.ipadx = 11;
			consGridBagConstraints4.gridy = 4;
			consGridBagConstraints4.gridx = 0;
			consGridBagConstraints5.insets = new java.awt.Insets(48,40,22,6);
			consGridBagConstraints5.ipady = -6;
			consGridBagConstraints5.ipadx = 219;
			consGridBagConstraints5.fill = java.awt.GridBagConstraints.HORIZONTAL;
			consGridBagConstraints5.weightx = 1.0;
			consGridBagConstraints5.gridwidth = 2;
			consGridBagConstraints5.gridy = 0;
			consGridBagConstraints5.gridx = 1;
			consGridBagConstraints12.insets = new java.awt.Insets(13,0,7,7);
			consGridBagConstraints12.ipady = 21;
			consGridBagConstraints12.ipadx = -84;
			consGridBagConstraints12.fill = java.awt.GridBagConstraints.BOTH;
			consGridBagConstraints12.weighty = 1.0;
			consGridBagConstraints12.weightx = 1.0;
			consGridBagConstraints12.gridheight = 2;
			consGridBagConstraints12.gridy = 4;
			consGridBagConstraints12.gridx = 1;
			consGridBagConstraints11.insets = new java.awt.Insets(24,117,12,174);
			consGridBagConstraints11.ipady = 3;
			consGridBagConstraints11.ipadx = 2;
			consGridBagConstraints11.gridwidth = 4;
			consGridBagConstraints11.gridy = 3;
			consGridBagConstraints11.gridx = 0;
			consGridBagConstraints9.insets = new java.awt.Insets(12,5,4,105);
			consGridBagConstraints9.ipady = 25;
			consGridBagConstraints9.ipadx = -76;
			consGridBagConstraints9.fill = java.awt.GridBagConstraints.BOTH;
			consGridBagConstraints9.weighty = 1.0;
			consGridBagConstraints9.weightx = 1.0;
			consGridBagConstraints9.gridheight = 2;
			consGridBagConstraints9.gridy = 4;
			consGridBagConstraints9.gridx = 3;
			consGridBagConstraints1.insets = new java.awt.Insets(46,16,24,18);
			consGridBagConstraints1.ipady = 3;
			consGridBagConstraints1.ipadx = 110;
			consGridBagConstraints1.gridy = 0;
			consGridBagConstraints1.gridx = 0;
			consGridBagConstraints7.insets = new java.awt.Insets(24,40,23,6);
			consGridBagConstraints7.ipady = -7;
			consGridBagConstraints7.ipadx = 219;
			consGridBagConstraints7.fill = java.awt.GridBagConstraints.HORIZONTAL;
			consGridBagConstraints7.weightx = 1.0;
			consGridBagConstraints7.gridwidth = 2;
			consGridBagConstraints7.gridy = 2;
			consGridBagConstraints7.gridx = 1;
			consGridBagConstraints2.insets = new java.awt.Insets(23,18,23,2);
			consGridBagConstraints2.ipady = 2;
			consGridBagConstraints2.ipadx = 179;
			consGridBagConstraints2.gridy = 1;
			consGridBagConstraints2.gridx = 0;
			consGridBagConstraints6.insets = new java.awt.Insets(23,40,23,5);
			consGridBagConstraints6.ipady = -7;
			consGridBagConstraints6.ipadx = 220;
			consGridBagConstraints6.fill = java.awt.GridBagConstraints.HORIZONTAL;
			consGridBagConstraints6.weightx = 1.0;
			consGridBagConstraints6.gridwidth = 2;
			consGridBagConstraints6.gridy = 1;
			consGridBagConstraints6.gridx = 1;
			consGridBagConstraints3.insets = new java.awt.Insets(25,17,23,0);
			consGridBagConstraints3.ipady = 1;
			consGridBagConstraints3.ipadx = 24;
			consGridBagConstraints3.gridy = 2;
			consGridBagConstraints3.gridx = 0;
			consGridBagConstraints10.insets = new java.awt.Insets(5,8,67,18);
			consGridBagConstraints10.ipady = -9;
			consGridBagConstraints10.ipadx = 47;
			consGridBagConstraints10.gridy = 5;
			consGridBagConstraints10.gridx = 2;
			consGridBagConstraints14.insets = new java.awt.Insets(4,44,69,48);
			consGridBagConstraints14.ipady = -6;
			consGridBagConstraints14.ipadx = 7;
			consGridBagConstraints14.gridy = 6;
			consGridBagConstraints14.gridx = 1;
			consGridBagConstraints8.insets = new java.awt.Insets(54,9,12,19);
			consGridBagConstraints8.ipady = -9;
			consGridBagConstraints8.ipadx = 45;
			consGridBagConstraints8.gridy = 4;
			consGridBagConstraints8.gridx = 2;
			consGridBagConstraints13.insets = new java.awt.Insets(24,31,23,175);
			consGridBagConstraints13.ipady = -8;
			consGridBagConstraints13.ipadx = 4;
			consGridBagConstraints13.gridy = 2;
			consGridBagConstraints13.gridx = 3;
			jPanelCenter.setLayout(new java.awt.GridBagLayout());
			jPanelCenter.add(getJLabelKurumTipi(), consGridBagConstraints1);
			jPanelCenter.add(getJLabel1(), consGridBagConstraints2);
			jPanelCenter.add(getJLabel2(), consGridBagConstraints3);
			jPanelCenter.add(getJLabel3(), consGridBagConstraints4);
			jPanelCenter.add(getJComboBoxKurumTipi(), consGridBagConstraints5);
			jPanelCenter.add(getJComboBoxIl(), consGridBagConstraints6);
			jPanelCenter.add(getJComboBoxDuzey3(), consGridBagConstraints7);
			jPanelCenter.add(getJButton(), consGridBagConstraints8);
			jPanelCenter.add(getJScrollPaneSeciliBirimler(), consGridBagConstraints9);
			jPanelCenter.add(getJButton1(), consGridBagConstraints10);
			jPanelCenter.add(getJLabel4(), consGridBagConstraints11);
			jPanelCenter.add(getJScrollPaneButunBirimler(), consGridBagConstraints12);
			jPanelCenter.add(getJButton6(), consGridBagConstraints13);
			jPanelCenter.add(getJButton7(), consGridBagConstraints14);
		}
		return jPanelCenter;
	}
	
	/**
	 * This method initializes jButton2
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton2() {
		if(jButton2 == null) {
			jButton2 = new javax.swing.JButton();
			jButton2.setText("Ayarlarý Kaydet");
			jButton2.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					updateChanges();
				}
			});
		}
		return jButton2;
	}
	
	private void updateChanges() {
		ListModel model1 = getJComboBoxKurumTipi().getModel();
		ListModel model2 = getJComboBoxIl().getModel();
		ListModel model3 = getJComboBoxDuzey3().getModel();
		ListModel model4 = getJListButunBirimler().getModel();
		ListModel model5 = getJListSeciliBirimler().getModel();
		
		ArrayList finalList = new ArrayList();
		for(int i = 0; i < model1.getSize(); i++) {
			KurumsalTanimBean bean = (KurumsalTanimBean)model1.getElementAt(i);
			if(i == getJComboBoxKurumTipi().getSelectedIndex()) bean.setSelected(true);
			else bean.setSelected(false);
			finalList.add(bean);
		}
		
		for(int i = 0; i < model2.getSize(); i++) {
			KurumsalTanimBean bean = (KurumsalTanimBean)model2.getElementAt(i);
			if(i == getJComboBoxIl().getSelectedIndex()) bean.setSelected(true);
			else bean.setSelected(false);
			finalList.add(bean);
		}
		
		for(int i = 0; i < model3.getSize(); i++) {
			KurumsalTanimBean bean = (KurumsalTanimBean)model3.getElementAt(i);
			if(i == getJComboBoxDuzey3().getSelectedIndex()) bean.setSelected(true);
			else bean.setSelected(false);
			finalList.add(bean);
		}
		
		for(int i = 0; i < model4.getSize(); i++) {
			KurumsalTanimBean bean = (KurumsalTanimBean)model4.getElementAt(i);
			finalList.add(bean);
		}
		
		for(int i = 0; i < model5.getSize(); i++) {
			KurumsalTanimBean bean = (KurumsalTanimBean)model5.getElementAt(i);
			finalList.add(bean);
		}
		WriteKurumsalDuzeylerCommand cmd = new WriteKurumsalDuzeylerCommand(finalList);
		cmd.execute();
		if(cmd.getErrorFlag()) {
			JOptionPane.showMessageDialog(null, "Veritabanýnda bir hata oluþtu.", "HATA", JOptionPane.WARNING_MESSAGE);
		}else {
			//JOptionPane.showMessageDialog(null, getTitle()+" Baþarýyla Kaydedildi.", "BÝLGÝ", JOptionPane.INFORMATION_MESSAGE);
			//GuiController.getInstance().disposeEnableFrames(this);
		}
	}
	
	/**
	 * This method initializes jComboBoxKurumTipi
	 * 
	 * @return javax.swing.JComboBox
	 */
	private javax.swing.JComboBox getJComboBoxKurumTipi() {
		if(jComboBoxKurumTipi == null) {
			jComboBoxKurumTipi = new javax.swing.JComboBox();
			jComboBoxKurumTipi.setModel(new DefaultComboBoxModel(readKurumTipleri(1).toArray()));
			restoreLastSavedState(jComboBoxKurumTipi);
		}
		return jComboBoxKurumTipi;
	}
	
	/**
	 * This method initializes jComboBoxIl
	 * 
	 * @return javax.swing.JComboBox
	 */
	private javax.swing.JComboBox getJComboBoxIl() {
		if(jComboBoxIl == null) {
			jComboBoxIl = new javax.swing.JComboBox();
			jComboBoxIl.setModel(new DefaultComboBoxModel(readKurumTipleri(2).toArray()));
			restoreLastSavedState(jComboBoxIl);
		}
		return jComboBoxIl;
	}
	
	/**
	 * This method initializes jComboBoxDuzey3
	 * 
	 * @return javax.swing.JComboBox
	 */
	private javax.swing.JComboBox getJComboBoxDuzey3() {
		if(jComboBoxDuzey3 == null) {
			jComboBoxDuzey3 = new javax.swing.JComboBox();
			jComboBoxDuzey3.setModel(new DefaultComboBoxModel(readKurumTipleri(3).toArray()));
			restoreLastSavedState(jComboBoxDuzey3);
			jComboBoxDuzey3.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					KurumsalTanimBean tanimBean = (KurumsalTanimBean)jComboBoxDuzey3.getSelectedItem();
					editKurumsalTanim(tanimBean);
				}
			});
		}
		return jComboBoxDuzey3;
	}
	
	/**
	 * This method initializes jListButunBirimler
	 * 
	 * @return javax.swing.JList
	 */
	private javax.swing.JList getJListButunBirimler() {
		if(jListButunBirimler == null) {
			jListButunBirimler = new javax.swing.JList();
			jListButunBirimler.setModel(new DefaultComboBoxModel(readKurumTipleri(4).toArray()));
			jListButunBirimler.setValueIsAdjusting(true);
			jListButunBirimler.addMouseListener(new java.awt.event.MouseAdapter() { 
				public void mouseClicked(java.awt.event.MouseEvent e) {    
					KurumsalTanimBean tanimBean = (KurumsalTanimBean)jListButunBirimler.getSelectedValue();
					editKurumsalTanim(tanimBean);
				}
			});
		}
		return jListButunBirimler;
	}
	/**
	 * This method initializes jListSeciliBirimler
	 * 
	 * @return javax.swing.JList
	 */
	private javax.swing.JList getJListSeciliBirimler() {
		if(jListSeciliBirimler == null) {
			jListSeciliBirimler = new javax.swing.JList();
		}
		return jListSeciliBirimler;
	}
	
	private List readKurumTipleri(int level) {
		ReadKurumsalDuzeylerCommand cmd = new ReadKurumsalDuzeylerCommand(level);
		cmd.execute();
		return cmd.getResult();
	}
	
	private void restoreLastSavedState(JComboBox component) {
		ListModel model = component.getModel();
		for(int i = 0; i < model.getSize(); i++) {
			KurumsalTanimBean bean = (KurumsalTanimBean)model.getElementAt(i);
			if(bean.isSelected()) component.setSelectedIndex(i);
		}
	}
	
	private void editKurumsalTanim(KurumsalTanimBean bean) {
		if(bean.isConfigured()) return;
		int intKod = Integer.parseInt(bean.getKod());
		int level = bean.getLevel();
		if(level == 3 && intKod <= 4) return;
		else {
			KurumTanimiGirisi kurumTanimGirisi = new KurumTanimiGirisi("Kurumsal Tanýmlamalarýnýz", bean);
			kurumTanimGirisi.show();
		}
	}
	
	/**
	 * This method initializes jLabel
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel() {
		if(jLabel == null) {
			jLabel = new javax.swing.JLabel();
			jLabel.setText("Lütfen Kurumunuzla Ýlgili Bilgileri Giriniz...");
		}
		return jLabel;
	}
	
	/**
	 * This method initializes jLabelKurumTipi
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabelKurumTipi() {
		if(jLabelKurumTipi == null) {
			jLabelKurumTipi = new javax.swing.JLabel();
			jLabelKurumTipi.setText("Kurum Tipi: ");
		}
		return jLabelKurumTipi;
	}
	
	/**
	 * This method initializes jLabel1
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new javax.swing.JLabel();
			jLabel1.setText("Ýli:");
		}
		return jLabel1;
	}
	/**
	 * This method initializes jLabel2
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new javax.swing.JLabel();
			jLabel2.setText("Belediye, Baðlý Ýdare Ve Birlik: ");
		}
		return jLabel2;
	}
	/**
	 * This method initializes jLabel3
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel3() {
		if(jLabel3 == null) {
			jLabel3 = new javax.swing.JLabel();
			jLabel3.setText("Birimler Ve Belde Bel. Ve Birlik: ");
		}
		return jLabel3;
	}
	
	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton() {
		if(jButton == null) {
			jButton = new javax.swing.JButton();
			jButton.setText(">");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object[] selectedValues = getJListButunBirimler().getSelectedValues();
					for(int i = 0; i < selectedValues.length; i++) {
						KurumsalTanimBean bean = (KurumsalTanimBean)selectedValues[i];
						bean.setSelected(true);
					}
					rearrangeAllBagliBriimler();
				} 
			});
		}
		return jButton;
	}
	/**
	 * This method initializes jButton1
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton1() {
		if(jButton1 == null) {
			jButton1 = new javax.swing.JButton();
			jButton1.setText("<");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object[] selectedValues = getJListSeciliBirimler().getSelectedValues();
					for(int i = 0; i < selectedValues.length; i++) {
						KurumsalTanimBean bean = (KurumsalTanimBean)selectedValues[i];
						bean.setSelected(false);
					}
					rearrangeAllBagliBriimler();
				} 
			});
		}
		return jButton1;
	}
	
	/**
	 * This method initializes jScrollPaneSeciliBirimler
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private javax.swing.JScrollPane getJScrollPaneSeciliBirimler() {
		if(jScrollPaneSeciliBirimler == null) {
			jScrollPaneSeciliBirimler = new javax.swing.JScrollPane();
			jScrollPaneSeciliBirimler.setViewportView(getJListSeciliBirimler());
		}
		return jScrollPaneSeciliBirimler;
	}
	/**
	 * This method initializes jLabel4
	 * 
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel4() {
		if(jLabel4 == null) {
			jLabel4 = new javax.swing.JLabel();
			jLabel4.setText("Kurumunuzdaki Bulunan Baðlý Birimleri Soldaki Listeden Seçerek Saðdaki Listeye Ekleyin ");
		}
		return jLabel4;
	}
	
	/**
	 * This method initializes jButton6
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton6() {
		if(jButton6 == null) {
			jButton6 = new javax.swing.JButton();
			jButton6.setText("Güncelle");
			jButton6.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					KurumsalTanimBean bean = (KurumsalTanimBean)getJComboBoxDuzey3().getSelectedItem();
					bean.setConfigured(false);
					editKurumsalTanim(bean);
				}
			});
		}
		return jButton6;
	}
	/**
	 * This method initializes jButton7
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton7() {
		if(jButton7 == null) {
			jButton7 = new javax.swing.JButton();
			jButton7.setText("Güncelle");
			jButton7.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					KurumsalTanimBean bean = (KurumsalTanimBean)getJListButunBirimler().getSelectedValue();
					bean.setConfigured(false);
					editKurumsalTanim(bean);
				}
			});
		}
		return jButton7;
	}
	
	/**
	 * This method initializes jScrollPaneButunBirimler
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private javax.swing.JScrollPane getJScrollPaneButunBirimler() {
		if(jScrollPaneButunBirimler == null) {
			jScrollPaneButunBirimler = new javax.swing.JScrollPane();
			jScrollPaneButunBirimler.setViewportView(getJListButunBirimler());
			jScrollPaneButunBirimler.setAutoscrolls(true);
		}
		return jScrollPaneButunBirimler;
	}
	
	private void rearrangeAllBagliBriimler() {
		ListModel model1 = getJListButunBirimler().getModel();
		ListModel model2 = getJListSeciliBirimler().getModel();
		ArrayList allBirimler = new ArrayList(); 
		for(int i = 0; i < model1.getSize(); i++) {
			KurumsalTanimBean bean = (KurumsalTanimBean)model1.getElementAt(i);
			allBirimler.add(bean);
		}
		for(int i = 0; i < model2.getSize(); i++) {
			KurumsalTanimBean bean = (KurumsalTanimBean)model2.getElementAt(i);
			allBirimler.add(bean);
		}
		yerlestirBagliBirimler(allBirimler);
	}
	
	private void yerlestirBagliBirimler(List allBirimler) {
		List selectedBirimler = new ArrayList();
		List unSelectedBirimler = new ArrayList();
		for(int i = 0; i < allBirimler.size(); i++) {
			KurumsalTanimBean bean = (KurumsalTanimBean)allBirimler.get(i);
			if(bean.isSelected()) selectedBirimler.add(bean);
			else unSelectedBirimler.add(bean);
			getJListButunBirimler().setModel(new DefaultComboBoxModel(unSelectedBirimler.toArray()));
			getJListSeciliBirimler().setModel(new DefaultComboBoxModel(selectedBirimler.toArray()));
		}
	}
}
