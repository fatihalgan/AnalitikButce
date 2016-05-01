package com.iztek.abutce.util.report;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;

import com.iztek.abutce.controller.GuiController;
import com.iztek.abutce.domain.ButceKalemiBean;
import com.iztek.abutce.domain.RaporBean;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class ReportForGelirlerPdf implements ReportInterface {
	private RaporBean raporBean = null;
	private DefaultMutableTreeNode root = null;
	private String fileOutPath = "ButceRaporu.pdf";
	
	public ReportForGelirlerPdf(RaporBean raporBean, DefaultMutableTreeNode root) {
		this.raporBean = raporBean;
		this.root = root;
		if(raporBean.getOutputPath() != null) {
			fileOutPath = raporBean.getOutputPath()+"\\"+fileOutPath;
		}	
	}
		
	public void getReport() {
		Document document = new Document(PageSize.A4.rotate(), 30, 30, 50, 30);
		try {
			PdfWriter.getInstance(document, new FileOutputStream(fileOutPath));
			document.open();
			
			BaseFont bf = BaseFont.createFont("/com/iztek/abutce/util/report/fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font fontSmall = new Font(bf,8);
			Font fontNormal = new Font(bf,10);
			Font fontLarge = new Font(bf,18);
													
			Table table = new Table(15);

			table.setPadding(2);
			table.setSpacing(0);
			table.setDefaultHorizontalAlignment(Element.ALIGN_CENTER);
			int headerwidths[] = {3,3,3,3,3,3,3,3,5,3,3,3,3,44,15};
			table.setWidths(headerwidths);
			table.setWidth(100);

			Cell topCell = new Cell(new Phrase(raporBean.getYil()+" MALÝ YILI BÜTÇE GELÝRLERÝ", fontLarge));
			topCell.setBorder(Rectangle.NO_BORDER);
			topCell.setColspan(15);
			table.addCell(topCell);
			topCell = new Cell(new Phrase("KURUMUN ADI : .................................................... BELEDÝYESÝ", fontSmall));
			topCell.setBorder(Rectangle.NO_BORDER);
			topCell.setColspan(10);
			table.addCell(topCell);
			topCell = new Cell("");
			topCell.setBorder(Rectangle.NO_BORDER);
			topCell.setColspan(5);
			table.addCell(topCell);

			Cell cell = new Cell(new Phrase("KURUMSAL SINIFLANDIRMA", fontSmall));
			cell.setColspan(4);
			table.addCell(cell);
			cell = new Cell(new Phrase("FONKSÝYONEL SINIFLANDIRMA", fontSmall));
			cell.setColspan(4);
			table.addCell(cell);
			cell = new Cell(new Phrase("FÝNANS TÝPÝ", fontSmall));
			cell.setColspan(1);
			table.addCell(cell);
			cell = new Cell(new Phrase("EKONOMÝK SINIFLANDIRMA", fontSmall));
			cell.setColspan(4);
			table.addCell(cell);
						
			cell = new Cell(new Phrase("\nAÇIKLAMA", fontNormal));
			cell.setRowspan(2);
			table.addCell(cell);
			cell = new Cell(new Phrase(raporBean.getYil()+" YILI BÜTÇE GELÝRLERÝ", fontNormal));
			cell.setRowspan(2);
			table.addCell(cell);
						
			table.addCell(new Cell("I"));
			table.addCell(new Cell("II"));
			table.addCell(new Cell("III"));
			table.addCell(new Cell("IV"));
			table.addCell(new Cell("I"));
			table.addCell(new Cell("II"));
			table.addCell(new Cell("III"));
			table.addCell(new Cell("IV"));
			table.addCell(new Cell("I"));
			table.addCell(new Cell("I"));
			table.addCell(new Cell("II"));
			table.addCell(new Cell("III"));
			table.addCell(new Cell("IV"));
			table.endHeaders();
			
			table.setDefaultHorizontalAlignment(Element.ALIGN_CENTER);
			
			if(root != null) {
				Enumeration enum = root.preorderEnumeration();
				while(enum.hasMoreElements()) {
					ButceKalemiBean bean = (ButceKalemiBean)((DefaultMutableTreeNode)enum.nextElement()).getUserObject();
					int level = bean.getLevel();
					int j;
					for(j=1; j<level; j++) {
						cell = new Cell();
						cell.setBorder(Rectangle.RIGHT);
						table.addCell(cell);
					}
					
    	       		cell = new Cell(new Phrase(bean.getKod(), fontNormal));
	           		cell.setBorder(Rectangle.RIGHT);
                	table.addCell(cell);
				
					for(int k=j; k<13; k++) {
						cell = new Cell();
						cell.setBorder(Rectangle.RIGHT);
						table.addCell(cell);
					}
				
					table.setDefaultHorizontalAlignment(Element.ALIGN_LEFT);
					cell = new Cell(new Phrase(bean.getTanim(), fontNormal));
					cell.setBorder(Rectangle.RIGHT);
					table.addCell(cell);
					table.setDefaultHorizontalAlignment(Element.ALIGN_CENTER);
					
					if(raporBean.isSayman()) {
						cell = new Cell(new Phrase(bean.getOdenek().convertTo(GuiController.getInstance().getDefaultUnit()).toString(), fontNormal));
					}else {
						cell = new Cell(new Phrase("", fontNormal));
					}
					cell.setBorder(Rectangle.RIGHT);
					table.addCell(cell);
           		}			
			}
			document.add(table);
			document.close();
			
			if(raporBean.getOutputPath() == null) {
				Runtime.getRuntime().exec("EXPLORER.EXE "+fileOutPath);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
