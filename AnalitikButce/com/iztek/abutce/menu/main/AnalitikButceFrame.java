package com.iztek.abutce.menu.main;

import java.awt.CardLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.iztek.abutce.controller.GuiController;
import com.iztek.abutce.domain.ButceConstants;
import com.iztek.abutce.event.ButceTipiChangedEvent;
import com.iztek.abutce.event.TreeEventDispatcher;
import com.iztek.abutce.menu.giris.ButceGirisiPanel;
import com.iztek.abutce.menu.giris.KurumTanimlamaPanel;
import com.iztek.abutce.menu.hakkinda.Help;
import com.iztek.abutce.menu.tanimlamalar.ButceHesaplariPanel;
import com.iztek.abutce.util.SwingUtils;
import com.iztek.abutce.util.money.Unit;
public class AnalitikButceFrame extends JFrame {

	private javax.swing.JPanel jContentPane = null;
	private javax.swing.JMenuBar jJMenuBar = null;
	private javax.swing.JMenu jMenu = null;
	private javax.swing.JMenu jMenu1 = null;
	private javax.swing.JMenu jMenu2 = null;
	private javax.swing.JMenu jMenu3 = null;
	private javax.swing.JMenu jMenu5 = null;
	private javax.swing.JMenuItem jMenuItem = null;
	private javax.swing.JMenuItem jMenuItem1 = null;
	private javax.swing.JMenuItem jMenuItem4 = null;
	private javax.swing.JMenuItem jMenuItem5 = null;
	private javax.swing.JMenuItem jMenuItem6 = null;
	private JMenuItem jMenuItem7 = null;  //  @jve:visual-info  decl-index=0 visual-constraint="-402,596"
	private javax.swing.JMenuItem jMenuItem20 = null;
	private javax.swing.JMenuItem jMenuItem181 = null;
	private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem = null;
	private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1 = null;
	private javax.swing.JPanel jPanel = null;
	private javax.swing.JLabel jLabel = null;
	private javax.swing.ButtonGroup buttonGroup = null;
	private int butceYili;
	private EmptyPanel emptyPanel = null;
	private KurumTanimlamaPanel kurumTanimlamaPanel = null;
	private ButceGirisiPanel gelirButcesiGirisiPanel = null;
	private ButceGirisiPanel giderButcesiGirisiPanel = null;
	private ButceHesaplariPanel gelirButcesiHesaplariPanel = null;
	private ButceHesaplariPanel giderButcesiHesaplariPanel = null;
	private javax.swing.JMenu jMenu4 = null;
	private javax.swing.JMenuItem jMenuItem2 = null;
	private javax.swing.JMenuItem jMenuItem3 = null;
	
	private JMenuItem jMenuItem8 = null;
	public AnalitikButceFrame() {
		super();
		butceYili = 2005;
		initialize();
		String defaultUnit = ResourceBundle.getBundle("moneyUnit").getString("defaultMoneyUnit");
		if(defaultUnit.equals(Unit.TL)) {
			jRadioButtonMenuItem.setSelected(true);
		}else if(defaultUnit.equals(Unit.YTL)) {
			jRadioButtonMenuItem1.setSelected(true);
		}
	}

	private void initialize() {
		this.setContentPane(getJContentPane());
		this.setSize(800, 600);
		SwingUtils.centerJFrame(this);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle(butceYili + " YILI ANALÝTÝK BÜTÇESÝ");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				GuiController.getInstance().cikisItemSelected();
			}
		});
	}

	private javax.swing.JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(getJJMenuBar(), java.awt.BorderLayout.NORTH);
			jContentPane.add(getJPanel(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}

	private javax.swing.JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new javax.swing.JMenuBar();
			jJMenuBar.add(getJMenu());
			jJMenuBar.add(getJMenu2());
			jJMenuBar.add(getJMenu1());
			jJMenuBar.add(getJMenu3());
			jJMenuBar.add(getJMenu42());
			jJMenuBar.add(getJMenu5());
		}
		return jJMenuBar;
	}

	private javax.swing.JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new javax.swing.JMenu();
			jMenu.add(getJMenuItem7());
			jMenu.add(getJMenuItem());
			jMenu.add(getJMenuItem1());
			jMenu.setText("Giriþ");
		}
		return jMenu;
	}

	private javax.swing.JMenu getJMenu1() {
		if (jMenu1 == null) {
			jMenu1 = new javax.swing.JMenu();
			jMenu1.add(getJMenuItem4());
			jMenu1.add(getJMenuItem181());
			jMenu1.setText("Tanýmlamalar");
		}
		return jMenu1;
	}

	private javax.swing.JMenu getJMenu2() {
		if (jMenu2 == null) {
			jMenu2 = new javax.swing.JMenu();
			jMenu2.add(getJMenuItem5());
			jMenu2.add(getJMenuItem6());
			jMenu2.setText("Raporlar");
		}
		return jMenu2;
	}

	private javax.swing.JMenu getJMenu3() {
		if (jMenu3 == null) {
			jMenu3 = new javax.swing.JMenu();
			jMenu3.add(getJRadioButtonMenuItem());
			jMenu3.add(getJRadioButtonMenuItem1());
			buttonGroup = new javax.swing.ButtonGroup();
			buttonGroup.add(jRadioButtonMenuItem);
			buttonGroup.add(jRadioButtonMenuItem1);
			jMenu3.setText("Ayarlar");
		}
		return jMenu3;
	}

	private javax.swing.JMenu getJMenu5() {
		if (jMenu5 == null) {
			jMenu5 = new javax.swing.JMenu();
			jMenu5.add(getJMenuItem20());
			jMenu5.setText("Çýkýþ");
		}
		return jMenu5;
	}

	private javax.swing.JMenuItem getJMenuItem() {
		if (jMenuItem == null) {
			jMenuItem = new javax.swing.JMenuItem();
			jMenuItem.setText("Gelir Bütçesi Hesaplarý Giriþi");
			jMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {					
					handleCardPanel("gelirButcesiGirisiPanel","Gelir Bütçesi Hesaplarý Giriþi");
					TreeEventDispatcher.getDispatcher().fireButceTipiChangedEvent(new ButceTipiChangedEvent(this, ButceConstants.GELIR));
				}
			});
		}
		return jMenuItem;
	}

	private javax.swing.JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new javax.swing.JMenuItem();
			jMenuItem1.setText("Gider Bütçesi Hesaplarý Giriþi");
			jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					handleCardPanel("giderButcesiGirisiPanel","Gider Bütçesi Hesaplarý Giriþi");
					TreeEventDispatcher.getDispatcher().fireButceTipiChangedEvent(new ButceTipiChangedEvent(this, ButceConstants.GIDER));
				}
			});
		}
		return jMenuItem1;
	}

	private javax.swing.JMenuItem getJMenuItem4() {
		if (jMenuItem4 == null) {
			jMenuItem4 = new javax.swing.JMenuItem();
			jMenuItem4.setText("Gelir Bütçesi Hesaplarý");
			jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					handleCardPanel("gelirButcesiHesaplariPanel", "Gelir Bütçesi Tanýmlamalarý");
					TreeEventDispatcher.getDispatcher().fireButceTipiChangedEvent(new ButceTipiChangedEvent(this, ButceConstants.GELIR));
				}
			});
		}
		return jMenuItem4;
	}

	private javax.swing.JMenuItem getJMenuItem181() {
		if (jMenuItem181 == null) {
			jMenuItem181 = new javax.swing.JMenuItem();
			jMenuItem181.setText("Gider Bütçesi Hesaplarý");
			jMenuItem181
				.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					handleCardPanel("giderButcesiHesaplariPanel", "Gider Bütçesi Tanýmlamalarý");	
					TreeEventDispatcher.getDispatcher().fireButceTipiChangedEvent(new ButceTipiChangedEvent(this, ButceConstants.GIDER));
				}
			});
		}
		return jMenuItem181;
	}

	private javax.swing.JMenuItem getJMenuItem5() {
		if (jMenuItem5 == null) {
			jMenuItem5 = new javax.swing.JMenuItem();
			jMenuItem5.setText("Gelir Bütçesi (B Cetveli) Raporu");
			jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					GuiController.getInstance().raporlarItemSelected(
						jMenuItem5.getText(),
						ButceConstants.GELIR);
				}
			});
		}
		return jMenuItem5;
	}

	private javax.swing.JMenuItem getJMenuItem6() {
		if (jMenuItem6 == null) {
			jMenuItem6 = new javax.swing.JMenuItem();
			jMenuItem6.setText("Birleþik Ödenek Cetveli Raporu");
			jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					GuiController.getInstance().raporlarItemSelected(
						jMenuItem6.getText(),
						ButceConstants.GIDER);
				}
			});
		}
		return jMenuItem6;
	}

	private javax.swing.JRadioButtonMenuItem getJRadioButtonMenuItem() {
		if (jRadioButtonMenuItem == null) {
			jRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
			jRadioButtonMenuItem.setText("Ödenek Giriþi ve Raporlar TL Üzerinden Olsun");
			jRadioButtonMenuItem.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					moneyUnitSelected();
				}
			});
		}
		return jRadioButtonMenuItem;
	}

	private javax.swing.JMenu getJMenu42() {
		if(jMenu4 == null) {
			jMenu4 = new javax.swing.JMenu();
			jMenu4.add(getJMenuItem2());
			jMenu4.add(getJMenuItem3());
			jMenu4.setText("Hakkýnda");
			jMenu4.add(getJMenuItem8());
		}
		return jMenu4;
	}
	
	private javax.swing.JMenuItem getJMenuItem2() {
		if(jMenuItem2 == null) {
			jMenuItem2 = new javax.swing.JMenuItem();
			jMenuItem2.setText("Son Kullanýcý Lisans Anlaþmasý");
			jMenuItem2.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					GuiController.getInstance().eulaItemSelected();
				}
			});
		}
		return jMenuItem2;
	}
	
	private javax.swing.JMenuItem getJMenuItem3() {
		if(jMenuItem3 == null) {
			jMenuItem3 = new javax.swing.JMenuItem();
			jMenuItem3.setText("Hakkýnda");
			jMenuItem3.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					GuiController.getInstance().hakkindaItemSelected();
				}
			});
		}
		return jMenuItem3;
	}
		
	private javax.swing.JMenuItem getJMenuItem7() {
		if (jMenuItem7 == null) {
			jMenuItem7 = new javax.swing.JMenuItem();
			jMenuItem7.setText("Kurumunuzla Ýlgili Bilgiler");
			jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					handleCardPanel("kurumTanimlamaPanel","Kurumunuzla Ýlgili Bilgiler");						
				}
			});
		}
		return jMenuItem7;
	}

	private javax.swing.JRadioButtonMenuItem getJRadioButtonMenuItem1() {
		if (jRadioButtonMenuItem1 == null) {
			jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
			jRadioButtonMenuItem1.setText("Ödenek Giriþi ve Raporlar YTL Üzerinden Olsun");
			jRadioButtonMenuItem1
				.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					moneyUnitSelected();
				}
			});
		}
		return jRadioButtonMenuItem1;
	}

	private javax.swing.JMenuItem getJMenuItem20() {
		if (jMenuItem20 == null) {
			jMenuItem20 = new javax.swing.JMenuItem();
			jMenuItem20.setText("Çýkýþ");
			jMenuItem20.setIcon(
				new javax.swing.ImageIcon(
					getClass().getResource(
						"/com/iztek/abutce/images/exit.gif")));
			jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					GuiController.getInstance().cikisItemSelected();
				}
			});
		}
		return jMenuItem20;
	}

	private javax.swing.JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new javax.swing.JPanel();
			jPanel.setLayout(new java.awt.CardLayout());
			emptyPanel = new EmptyPanel();
			kurumTanimlamaPanel = new KurumTanimlamaPanel();
			gelirButcesiGirisiPanel = new ButceGirisiPanel();
			giderButcesiGirisiPanel = new ButceGirisiPanel();
			jPanel.add(emptyPanel,"emptyPanel");
			jPanel.add(kurumTanimlamaPanel,"kurumTanimlamaPanel");
			jPanel.add(gelirButcesiGirisiPanel,"gelirButcesiGirisiPanel");
			jPanel.add(giderButcesiGirisiPanel, "giderButcesiGirisiPanel");
			jPanel.add(getGelirButcesiHesaplariPanel(), getGelirButcesiHesaplariPanel().getName());
			jPanel.add(getGiderButcesiHesaplariPanel(), getGiderButcesiHesaplariPanel().getName());
		}
		return jPanel;
	}

	private javax.swing.JLabel getJLabel() {
		if (jLabel == null) {
			jLabel = new javax.swing.JLabel();
			jLabel.setText(butceYili + " YILI ANALÝTÝK BÜTÇESÝ");
			jLabel.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 40));
			jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			jLabel.setForeground(new java.awt.Color(0, 0, 177));
		}
		return jLabel;
	}

	private void moneyUnitSelected() {
		if (jRadioButtonMenuItem.isSelected()) {
			GuiController.getInstance().setDefaultUnit(Unit.TL);
		} else if (jRadioButtonMenuItem1.isSelected()) {
			GuiController.getInstance().setDefaultUnit(Unit.YTL);
		}
		File file = new File("moneyUnit.properties");
		try	{
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("defaultMoneyUnit="+GuiController.getInstance().getDefaultUnit());
			fileWriter.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	private void handleCardPanel(String panelName,String frameTitle){
		this.setTitle(frameTitle);
		JPanel cardPanel = getJPanel();
		CardLayout cl = (CardLayout)(cardPanel.getLayout());	
		cl.show(cardPanel, panelName);
	}
	/**
	 * This method initializes butceHesaplariPanel	
	 * 	
	 * @return com.iztek.abutce.menu.tanimlamalar.ButceHesaplariPanel	
	 */    
	private ButceHesaplariPanel getGelirButcesiHesaplariPanel() {
		if (gelirButcesiHesaplariPanel == null) {
			gelirButcesiHesaplariPanel = new ButceHesaplariPanel(this);
			gelirButcesiHesaplariPanel.setName("gelirButcesiHesaplariPanel");
		}
		return gelirButcesiHesaplariPanel;
	}
	
	private ButceHesaplariPanel getGiderButcesiHesaplariPanel() {
		if (giderButcesiHesaplariPanel == null) {
			giderButcesiHesaplariPanel = new ButceHesaplariPanel(this);
			giderButcesiHesaplariPanel.setName("giderButcesiHesaplariPanel");
		}
		return giderButcesiHesaplariPanel;
	}
	/**
	 * This method initializes jMenuItem8	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */    
	private JMenuItem getJMenuItem8() {
		if (jMenuItem8 == null) {
			jMenuItem8 = new JMenuItem();
			jMenuItem8.setText("Yardým");
			jMenuItem8.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					Help help = new Help();
					help.show();
 				}
			});
		}
		return jMenuItem8;
	}
  }