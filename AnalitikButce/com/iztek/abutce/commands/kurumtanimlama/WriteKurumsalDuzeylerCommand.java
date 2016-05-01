/*
 * Created on 12.Eki.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.iztek.abutce.commands.kurumtanimlama;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.iztek.abutce.domain.KurumsalTanimBean;
import com.iztek.abutce.util.ConnectionManager;

/**
 * @author Selim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class WriteKurumsalDuzeylerCommand {
	
	private boolean errorFlag = false;
	private KurumsalTanimBean level1Bean = null;
	private KurumsalTanimBean level2Bean = null;
	private KurumsalTanimBean level3Bean = null;
	private Collection level4Beans = new ArrayList();
	private Collection allBeans = null;	
	public WriteKurumsalDuzeylerCommand(Collection allBeans) {
		this.allBeans = allBeans;
	}
	
	public void execute() {
		Connection con = null;
		try {
			String DATA_TABLE = "KURUMSAL_SINIFLAR";
			String CONF_TABLE = "KURUMSAL_SINIF_TANIMLARI";
			con = ConnectionManager.getInstance().getConnection();
			con.setAutoCommit(false);
			arrangeBeans();
			Iterator it = allBeans.iterator();
			while(it.hasNext()) {
				KurumsalTanimBean bean = (KurumsalTanimBean)it.next();
				UpdateKurumsalTanimConfiguration(con, CONF_TABLE, bean);
			}
			
			deleteAllKurumsalSiniflar(con, DATA_TABLE);
			insertKurumsalTanimBean(con, DATA_TABLE, level1Bean);
			insertKurumsalTanimBean(con, DATA_TABLE, level2Bean);
			insertKurumsalTanimBean(con, DATA_TABLE, level3Bean);
			it = level4Beans.iterator();
			while(it.hasNext()) {
				KurumsalTanimBean bean = (KurumsalTanimBean)it.next();
				if(bean.isSelected()) insertKurumsalTanimBean(con, DATA_TABLE, bean);
			}
			con.commit();
		} catch(SQLException se) {
			errorFlag = true;
			se.printStackTrace();
		} finally {
			try {
				con.close();
			} catch(SQLException se) {
				
			}
		}
	}
	
	private void arrangeBeans() {
		Iterator it = allBeans.iterator();
		while(it.hasNext()) {
			KurumsalTanimBean bean = (KurumsalTanimBean)it.next();
			if(bean.getLevel() == 1 && bean.isSelected()) level1Bean = bean;
			else if(bean.getLevel() == 2 && bean.isSelected()) level2Bean = bean;
			else if(bean.getLevel() == 3 && bean.isSelected()) level3Bean = bean;
			else if(bean.getLevel() == 4) {
				level4Beans.add(bean);
			}
		}
	}
	
	private void insertKurumsalTanimBean(Connection con, String table, KurumsalTanimBean bean) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("INSERT INTO " + table + " (ID, LEVEL"+bean.getLevel()+", TANIM) VALUES(?, ?, ?)");
			pstmt.setBigDecimal(1, bean.getId());
			pstmt.setString(2, bean.getKod());
			pstmt.setString(3, bean.getTanim());
			int rowCount = pstmt.executeUpdate();
		} catch(SQLException se) {
			throw se;
		} finally {
			try {
				pstmt.close();
			} catch(SQLException se) {
				
			}
		}
	}
	
	private void UpdateKurumsalTanimConfiguration(Connection con, String table, KurumsalTanimBean bean) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("UPDATE " + table + " SET LEVEL"+bean.getLevel()+" = ?, TANIM = ?, SELECTED = ?, CONFIGURED = ? WHERE ID = ?");
			pstmt.setString(1, bean.getKod());
			pstmt.setString(2, bean.getTanim());
			pstmt.setBoolean(3, bean.isSelected());
			pstmt.setBoolean(4, bean.isConfigured());
			pstmt.setBigDecimal(5, bean.getId());
			int rowCount = pstmt.executeUpdate();
		} catch(SQLException se) {
			throw se;
		} finally {
			try {
				pstmt.close();
			} catch(SQLException se) {
				
			}
		}
	}
	
	private void deleteKurumsalTanimBean(Connection con, String table, KurumsalTanimBean bean) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("DELETE FROM " + table + " WHERE ID =?");
			pstmt.setBigDecimal(1, bean.getId());
			int rowCount = pstmt.executeUpdate();
		} catch(SQLException se) {
			throw se;
		} finally {
			try {
				pstmt.close();
			} catch(SQLException se) {
			
			}
		}
	}
	
	private void deleteDuzey4(Connection con, String table) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("DELETE FROM " + table + " WHERE LEVEL4 is not null");
			int rowCount = pstmt.executeUpdate();
		} catch(SQLException se) {
			throw se;
		} finally {
			try {
				pstmt.close();
			} catch(SQLException se) {
			
			}
		}
	}
	
	private boolean rowExists(Connection con, String table, KurumsalTanimBean bean) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM " + table + " WHERE ID =?");
			pstmt.setBigDecimal(1, bean.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) return true;		
		} catch(SQLException se) {
			throw se;
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch(SQLException se) {
			
			}
		}
		return false;
	}
	
	private void deleteAllKurumsalSiniflar(Connection con, String table) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("DELETE FROM " + table);
			int rowCount = pstmt.executeUpdate();
		} catch(SQLException se) {
			throw se;
		} finally {
			try {
				pstmt.close();
			} catch(SQLException se) {
			
			}
		}
	}
	
	public boolean getErrorFlag() {
		return errorFlag;
	}

}
