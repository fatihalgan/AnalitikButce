import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ActivatorGui extends JFrame {

	private javax.swing.JPanel jContentPane = null;

	private javax.swing.JLabel jLabel = null;
	private javax.swing.JTextField jTextField = null;
	private javax.swing.JButton browseButton = null;
	private javax.swing.JButton activateButton = null;
	private javax.swing.JButton clearButton = null;	
	private javax.swing.JPanel jPanel = null;
	
	public ActivatorGui() {
		super();
		initialize();
	}
	
	private void initialize() {
		this.setSize(355, 168);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((screenSize.width-355)/2, (screenSize.height-168)/2, 355, 168);
		this.setContentPane(getJContentPane());
		this.setTitle("QuestionBank Activator");
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	private javax.swing.JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(getJPanel(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}
	
	private javax.swing.JPanel getJPanel() {
		if(jPanel == null) {
			jPanel = new javax.swing.JPanel();
			jPanel.setLayout(null);
			jPanel.add(getJLabel(), null);
			jPanel.add(getJTextField(), null);
			jPanel.add(getActivateButton(), null);
			jPanel.add(getClearButton(), null);
			jPanel.add(getBrowseButton(), null);
			jPanel.setBackground(new java.awt.Color(216,228,248));
		}
		return jPanel;
	}
		
	private javax.swing.JLabel getJLabel() {
		if(jLabel == null) {
			jLabel = new javax.swing.JLabel();
			jLabel.setBounds(56, 14, 235, 21);
			jLabel.setText("QuestionBank Installation Path");
			jLabel.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 16));
			jLabel.setForeground(new java.awt.Color(48,106,197));
		}
		return jLabel;
	}
	
	private javax.swing.JTextField getJTextField() {
		if(jTextField == null) {
			jTextField = new javax.swing.JTextField();
			jTextField.setBounds(16, 50, 234, 21);
			jTextField.setPreferredSize(new java.awt.Dimension(250,20));
		}
		return jTextField;
	}
	
	private javax.swing.JButton getBrowseButton() {
		if(browseButton == null) {
			browseButton = new javax.swing.JButton();
			browseButton.setBounds(251, 49, 88, 23);
			browseButton.setText("Browse...");
			browseButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.SoftBevelBorder.RAISED));
			browseButton.setBackground(new java.awt.Color(236,233,216));
			browseButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					browseButtonClicked();
				}
			});
		}
		return browseButton;
	}
	
	private javax.swing.JButton getActivateButton() {
		if(activateButton == null) {
			activateButton = new javax.swing.JButton();
			activateButton.setBounds(85, 95, 80, 26);
			activateButton.setText("Activate");
			activateButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.SoftBevelBorder.RAISED));
			activateButton.setBackground(new java.awt.Color(236,233,216));
			activateButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					activateButtonClicked();
				}
			});
		}
		return activateButton;
	}
	
	private javax.swing.JButton getClearButton() {
		if(clearButton == null) {
			clearButton = new javax.swing.JButton();
			clearButton.setBounds(170, 95, 80, 26);
			clearButton.setText("Clear");
			clearButton.setPreferredSize(new java.awt.Dimension(80,26));
			clearButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.SoftBevelBorder.RAISED));
			clearButton.setBackground(new java.awt.Color(236,233,216));
			clearButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					clearButtonClicked();
				}
			});
		}
		return clearButton;
	}
	
	private void clearButtonClicked() {
		jTextField.setText("");
	}
	
	private void browseButtonClicked() {
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fileChooser.showOpenDialog(this);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File directoy = fileChooser.getSelectedFile();
			jTextField.setText(directoy.getPath());
		}
	}
	
	private void activateButtonClicked() {
		String text = jTextField.getText().trim();
		if(text.length() != 0) {
			setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			File directory = new File(jTextField.getText());
			if(directory.exists() && directory.isDirectory()) {
				boolean flag = Hasher.activate(directory);
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				if(flag) {
					JOptionPane.showMessageDialog(this, "QuestionBank has been successfully activated!", "Success", 0);
					System.exit(0);
				}else{
					JOptionPane.showMessageDialog(this, "An error has occured while activating QuestionBank!", "Error", 0);
				}
			}else {
				JOptionPane.showMessageDialog(this, "Invalid path!\nPlease enter or browse QuestionBank installation path.", "Warning", 0);
				jTextField.setText("");
			}
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}else {
			JOptionPane.showMessageDialog(this, "Please enter or browse QuestionBank installation path!", "Warning", 0);
			jTextField.setText("");
		}
	}
}
