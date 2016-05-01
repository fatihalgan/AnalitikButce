package com.iztek.abutce.util;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingUtils {

	public static void centerJFrame(Component jFrame) {
		Dimension dim = jFrame.getToolkit().getScreenSize();
		jFrame.setLocation(
			dim.width / 2 - jFrame.getWidth() / 2,
			dim.height / 2 - jFrame.getHeight() / 2);
	}

	public static void exitConfirmation(JFrame jFrame) {
		Object[] options = new Object[] {"Evet", "Hayýr"};
		int confirm =
			JOptionPane.showOptionDialog(
				jFrame,
				"Programdan Çýkmak Ýstediðinizden Emin misiniz ?",
				"Çýkýþ Onayý",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[0]);
		if(confirm == 0) {
			jFrame.dispose();
			System.exit(0);
		}
	}
	
	public static int errorMessage(Component jFrame, String message) {
		Object[] options = new Object[] {"Tamam"};
		int confirm = JOptionPane.showOptionDialog(
				jFrame,
				message,
				"Hata!!",
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.ERROR_MESSAGE,
				null,
				options,
				options[0]);
		return confirm; 
	}
	
	public static int deleteConfirmation(JFrame jFrame) {
		int confirm = JOptionPane.showOptionDialog(
				jFrame,
				"Bu Kaydý Silmek Ýstediðinizden Emin misiniz?",
				"Silme Onayý",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				null,
				null);
		return confirm;
	}
}