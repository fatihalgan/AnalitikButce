/*
 * Created on 11.Eki.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.iztek.abutce.commands.kurumtanimlama;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iztek.abutce.domain.KurumsalTanimBean;
import com.iztek.abutce.util.ConnectionManager;

/**
 * @author Selim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ReadKurumsalDuzeylerCommand {
	
	private ArrayList result = new ArrayList();
	private boolean errorFlag = false;
	private int level = 1;
	
	public ReadKurumsalDuzeylerCommand(int level) {
		super();
		this.level = level; 
	}
	
	public void execute() {
		Connection con = null;
		try {
			String table = "KURUMSAL_SINIF_TANIMLARI";
			con = ConnectionManager.getInstance().getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("SELECT ID, LEVEL"+level+", TANIM, CONFIGURED, SELECTED from " + table + 
				" WHERE LEVEL"+level+" is not null");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BigDecimal id = rs.getBigDecimal("ID");
				String kod = rs.getString("LEVEL"+level);
				String tanim = rs.getString("TANIM");
				boolean configured = rs.getBoolean("CONFIGURED");
				boolean selected = rs.getBoolean("SELECTED");
				KurumsalTanimBean bean = new KurumsalTanimBean(id, tanim, kod, level, configured, selected);
				result.add(bean);
			}
			pstmt.close();
		} catch(SQLException se) {
			errorFlag = true;
			se.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				errorFlag = true;
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @return
	 */
	public boolean isErrorFlag() {
		return errorFlag;
	}

	/**
	 * @return
	 */
	public ArrayList getResult() {
		return result;
	}

}
