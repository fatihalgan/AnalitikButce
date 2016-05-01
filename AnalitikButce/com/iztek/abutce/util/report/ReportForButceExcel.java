package com.iztek.abutce.util.report;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.iztek.abutce.controller.GuiController;
import com.iztek.abutce.domain.ButceConstants;
import com.iztek.abutce.domain.ButceKalemiBean;
import com.iztek.abutce.domain.RaporBean;

public class ReportForButceExcel implements ReportInterface {
	private String filePath = null;
	private String fileOutPath = "ButceRaporu.xls";
	private DefaultMutableTreeNode root = null;
	private RaporBean raporBean = null;
	private int cellCount;
	
	public ReportForButceExcel(RaporBean raporBean, DefaultMutableTreeNode root) {
		this.raporBean = raporBean;
		this.root = root;
		if(raporBean.getTip() == ButceConstants.GELIR) {
			cellCount = 15;
			filePath = "SablonForGelir.xls";
		}else if(raporBean.getTip() == ButceConstants.GIDER) {
			cellCount = 17;
			filePath = "SablonForGider.xls";
		}
		if(raporBean.getOutputPath() != null) {
			fileOutPath = raporBean.getOutputPath()+"\\"+fileOutPath;
		}
	}
	
	private void writeToCell(HSSFRow row, short cellNum, String value) {
		HSSFCell cell = row.getCell((short)cellNum);
		if(cell == null) {
			cell = row.createCell((short)cellNum);
		}
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue(value);
	}
	
	private void editCell(HSSFSheet sayfa) {
		HSSFRow row = sayfa.getRow(1);
		if(row != null) {
			HSSFCell cell = row.getCell((short)8);
			if(cell != null) {
				cell.setEncoding(HSSFCell.ENCODING_UTF_16);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(raporBean.getYil()+cell.getStringCellValue());
			}
		}
		
		row = sayfa.getRow(3);
		if(row != null) {
			HSSFCell cell = row.getCell((short)14);
			if(cell != null) {
				cell.setEncoding(HSSFCell.ENCODING_UTF_16);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(raporBean.getYil()+cell.getStringCellValue());
			}
		}
	}
	
	private void addBorder(HSSFWorkbook wb, HSSFRow row) {
		HSSFCellStyle style = wb.createCellStyle();
		for(Iterator iter = row.cellIterator(); iter.hasNext();) {
			HSSFCell cell = (HSSFCell)iter.next();
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cell.setCellStyle(style);
		}		
	}
		
	public void getReport() {
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(filePath));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sayfa = wb.getSheetAt(0);
			
			editCell(sayfa);
			
			if(root != null) {
				Enumeration enum = root.preorderEnumeration();	
				int index = 0;		
				while(enum.hasMoreElements()) {
					ButceKalemiBean bean = (ButceKalemiBean)((DefaultMutableTreeNode)enum.nextElement()).getUserObject();
					int cellNum = bean.getLevel()-1;
					HSSFRow row = sayfa.createRow(index+6);
					for(int j=0; j<cellCount; j++) {
						row.createCell((short)j);	
					}
				
					addBorder(wb, row);
				
					writeToCell(row, (short)cellNum, bean.getKod());
					writeToCell(row, (short)13, bean.getTanim());
					if(raporBean.getTip() == ButceConstants.GELIR) {
						if(raporBean.isSayman() && bean.getOdenek() != null) {
							writeToCell(row, (short)14, bean.getOdenek().convertTo(GuiController.getInstance().getDefaultUnit()).toString());
						}
					}else if(raporBean.getTip() == ButceConstants.GIDER) {
						if(raporBean.isSayman() && bean.getOdenekSayman() != null) {
							writeToCell(row, (short)14, bean.getOdenekSayman().convertTo(GuiController.getInstance().getDefaultUnit()).toString());
						}
						if(raporBean.isBaskan() && bean.getOdenekBaskan() != null) {							
							writeToCell(row, (short)15, bean.getOdenekBaskan().convertTo(GuiController.getInstance().getDefaultUnit()).toString());
						}
						if(raporBean.isEncumen() && bean.getOdenekEncumen() != null) {
							writeToCell(row, (short)16, bean.getOdenekEncumen().convertTo(GuiController.getInstance().getDefaultUnit()).toString());
						}
					}
					index++;
				}
			}
			
			try {
				FileOutputStream fileOut = new FileOutputStream(fileOutPath);
				wb.write(fileOut);
				fileOut.close();
			}catch(FileNotFoundException e) {
				System.out.println("Dosya Bulunamadý: "+e.getMessage());							
			}
			if(raporBean.getOutputPath() == null) {
				Runtime.getRuntime().exec("EXPLORER.EXE "+fileOutPath);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
