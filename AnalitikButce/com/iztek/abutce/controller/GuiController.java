package com.iztek.abutce.controller;

import javax.swing.JFrame;
import com.iztek.abutce.menu.giris.KurumTanimlamaPanel;
import com.iztek.abutce.menu.hakkinda.Eula;
import com.iztek.abutce.menu.hakkinda.Hakkinda;
import com.iztek.abutce.menu.main.AnalitikButceFrame;
import com.iztek.abutce.menu.raporlar.ReportParameters;
import com.iztek.abutce.util.SwingUtils;
import com.iztek.abutce.util.money.Unit;

public class GuiController {
	private static GuiController instance = null;
	private AnalitikButceFrame mainFrame = null;
	private KurumTanimlamaPanel kurumTanimlama = null;
	private ReportParameters reportParameters = null;
	private Hakkinda hakkinda = null;
	private Eula eula = null;
		
	private final int butceYili = 2005;
	private String defaultUnit = Unit.TL;

	private GuiController() {
	}

	public static synchronized GuiController getInstance() {
		if (instance == null) { // Lazy initalization. Singleton pattern.
			instance = new GuiController();
		}
		return instance;
	}

	public int getButceYili() {
		return butceYili;
	}

	public String getDefaultUnit() {
		return defaultUnit;
	}

	public void setDefaultUnit(String string) {
		defaultUnit = string;
	}

	public void cikisItemSelected() {
		SwingUtils.exitConfirmation(mainFrame);
	}

	public void disableEnableFrames(
		JFrame frameForDisable,
		JFrame frameForEnable) {
		frameForDisable.setEnabled(false);
		frameForEnable.setEnabled(true);
	}

	public void disposeEnableFrames(JFrame frameForDispose) {
		frameForDispose.dispose();
		mainFrame.setEnabled(true);
		mainFrame.setVisible(true);
	}

	public void showAButceFrame() {
		mainFrame = new AnalitikButceFrame();
		mainFrame.show();
	}

	public void raporlarItemSelected(String title, int tip) {
		reportParameters = new ReportParameters(title, tip, butceYili);
		disableEnableFrames(mainFrame, reportParameters);
		reportParameters.show();
	}

	public void kurumTanimlamaItemSelected(String title) {
		kurumTanimlama = new KurumTanimlamaPanel();
	}
	
	public void eulaItemSelected() {
		eula = new Eula();
		disableEnableFrames(mainFrame, eula);
		eula.show();
	}
	
	public void hakkindaItemSelected() {
		hakkinda = new Hakkinda();
		disableEnableFrames(mainFrame, hakkinda);
		hakkinda.show();
	}
	
}