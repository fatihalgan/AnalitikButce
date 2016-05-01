package com.iztek.abutce.util.report;

import com.iztek.abutce.commands.butce.ReadGelirlerCommand;
import com.iztek.abutce.commands.butce.ReadGiderlerCommand;

import com.iztek.abutce.domain.ButceConstants;
import com.iztek.abutce.domain.RaporBean;

public class ReportManager {
	private String filePath = null;
	private RaporBean raporBean = null;
	
	public ReportManager(RaporBean raporBean) {
		this.raporBean = raporBean;
	}
	
	public void getReport() {
		ReportInterface reportInterface = null;
		if(raporBean.isPdf()) {
			if(raporBean.getTip() == ButceConstants.GELIR) {
				ReadGelirlerCommand command = new ReadGelirlerCommand(raporBean.getTip(), raporBean.getYil());
				command.execute();
				reportInterface = new ReportForGelirlerPdf(raporBean, command.getRoot());
			}else if(raporBean.getTip() == ButceConstants.GIDER) {
				ReadGiderlerCommand command = new ReadGiderlerCommand(raporBean.getTip(), raporBean.getYil());						
				command.execute();
				reportInterface = new ReportForGiderlerPdf(raporBean, command.getRoot());
			}
		}else {
			if(raporBean.getTip() == ButceConstants.GELIR) {
				ReadGelirlerCommand command = new ReadGelirlerCommand(raporBean.getTip(), raporBean.getYil());
				command.execute();
				reportInterface = new ReportForButceExcel(raporBean, command.getRoot());
			}else if(raporBean.getTip() == ButceConstants.GIDER) {
				ReadGiderlerCommand command = new ReadGiderlerCommand(raporBean.getTip(), raporBean.getYil());						
				command.execute();
				reportInterface = new ReportForButceExcel(raporBean, command.getRoot());
			}
		}
		reportInterface.getReport();
	}
}
