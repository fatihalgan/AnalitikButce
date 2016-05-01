/*
 * Created on 13.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.abutce.persister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

import com.iztek.abutce.domain.ButceConstants;
import com.iztek.abutce.domain.ButceKalemiBean;
import com.iztek.abutce.util.ConnectionManager;
import com.iztek.abutce.util.money.Money;




/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ButceKalemiBeanPersister {
	
	Connection con = null;
	
	protected String getInsertTanimStatement(int level, int butceTipi) {
		String tableName = ButceConstants.getTableName(level, ButceConstants.LEFT, butceTipi);
			String insertString = "INSERT INTO " + tableName + " (";
			String columns = "";
			String injectParams = "";
			if(level >= 5 && level <=8) {
			for(int i = 5; i <= level; i++) {
				columns = columns + "LEVEL" + i +", ";
				injectParams = injectParams + "?,";
			}
			} else if(level > 9) {
			for(int i = 9; i <= 13; i++) {
				columns = columns + "LEVEL" + i +", ";
				injectParams = injectParams + "?,";
			}
			} else if(level <= 4 || level == 9) {
				columns = "LEVEL" + level + ", ";
				injectParams = injectParams + "?,";
			} 
			insertString = insertString + columns + " TANIM) VALUES (";
			injectParams = injectParams + "?";
			insertString = insertString + injectParams + ")";
			return insertString;
	}
	
	protected String getUpdateTanimStatement(int level, int butceTipi) {
		String tableName = ButceConstants.getTableName(level, ButceConstants.LEFT, butceTipi);	
		return "UPDATE " + tableName + " SET LEVEL" + level + " = ?, TANIM = ? WHERE ID = ?";
	}
	
	protected String getDeleteTanimStatement(int level, int butceTipi) {
		String tableName = ButceConstants.getTableName(level, ButceConstants.LEFT, butceTipi);
		return "DELETE FROM " + tableName + " WHERE ID = ?";
	}
	
	protected String getSelectTanimByIdStatement(int level, int butceTipi) {
		String tableName = ButceConstants.getTableName(level, ButceConstants.LEFT, butceTipi);
		String selectString = "SELECT ID, LEVEL" + level + ", TANIM FROM " + tableName + " WHERE ID = ?";
		return selectString;
	}
	
	protected String getSelectTanimStatement(int level, int butceTipi) {
		String tableName = ButceConstants.getTableName(level, ButceConstants.LEFT, butceTipi);
		String selectString = "SELECT ID, LEVEL" + level +
		", TANIM FROM " + tableName + " WHERE ";
		String columnString = "";
		if(level <= 4 || level == 9) {
			columnString = "LEVEL"+ level + " IS NOT NULL";
		} else if(level >= 5 && level <= 8) {
			if(level == 5) columnString = "LEVEL5 IS NOT NULL AND LEVEL6 IS NULL AND LEVEL7 IS NULL AND LEVEL8 IS NULL";
			else if(level == 6) columnString = "LEVEL5 = ? AND LEVEL6 IS NOT NULL AND LEVEL7 IS NULL AND LEVEL8 IS NULL";
			else if(level == 7) columnString = "LEVEL5 = ? AND LEVEL6 = ? AND LEVEL7 IS NOT NULL AND LEVEL8 IS NULL";
			else if(level == 8) columnString = "LEVEL5 = ? AND LEVEL6 = ? AND LEVEL7 = ? AND LEVEL8 IS NOT NULL";
		} else if(level > 9) {
			if(level == 10) columnString = "LEVEL10 IS NOT NULL AND LEVEL11 IS NULL AND LEVEL12 IS NULL AND LEVEL13 IS NULL";
			else if(level == 11) columnString = "LEVEL10 = ? AND LEVEL11 IS NOT NULL AND LEVEL12 IS NULL AND LEVEL13 IS NULL";
			else if(level == 12) columnString = "LEVEL10 = ? AND LEVEL11 = ? AND LEVEL12 IS NOT NULL AND LEVEL13 IS NULL";
			else if(level == 13) columnString = "LEVEL10 = ? AND LEVEL11 = ? AND LEVEL12 = ? AND LEVEL13 IS NOT NULL";
		}
		return selectString + columnString;
	}
	
	protected String getSelectTanimFromRootPathStatement(String rootPath, int butceTipi) {
		String[] pathArray = parseRootPath(rootPath);
		int level = pathArray.length;
		String tableName = ButceConstants.getTableName(level, ButceConstants.LEFT, butceTipi);
		String selectString = "SELECT ID, LEVEL" + level +
		", TANIM FROM " + tableName + " WHERE ";
		String columnString = "";
		if(level <= 4 || level == 9) {
			columnString = "LEVEL"+ level + " = ?";
		} else if(level >= 5 && level <= 8) {
			if(level == 5) columnString = "LEVEL5 = ? AND LEVEL6 IS NULL AND LEVEL7 IS NULL AND LEVEL8 IS NULL";
			else if(level == 6) columnString = "LEVEL5 = ? AND LEVEL6 = ? AND LEVEL7 IS NULL AND LEVEL8 IS NULL";
			else if(level == 7) columnString = "LEVEL5 = ? AND LEVEL6 = ? AND LEVEL7 = ? AND LEVEL8 IS NULL";
			else if(level == 8) columnString = "LEVEL5 = ? AND LEVEL6 = ? AND LEVEL7 = ? AND LEVEL8 = ?";
		} else if(level > 9) {
			if(level == 10) columnString = "LEVEL10 = ? AND LEVEL11 IS NULL AND LEVEL12 IS NULL AND LEVEL13 IS NULL";
			else if(level == 11) columnString = "LEVEL10 = ? AND LEVEL11 = ? AND LEVEL12 IS NULL AND LEVEL13 IS NULL";
			else if(level == 12) columnString = "LEVEL10 = ? AND LEVEL11 = ? AND LEVEL12 = ? AND LEVEL13 IS NULL";
			else if(level == 13) columnString = "LEVEL10 = ? AND LEVEL11 = ? AND LEVEL12 = ? AND LEVEL13 = ?";
		}
		return selectString + columnString;
	}
	
	public void loadTanimBilgileriFromRootPath(Connection con, String rootPath, int butceTipi, ButceKalemiBean bean) throws Exception {
		String[] pathArray = parseRootPath(rootPath);
		int level = pathArray.length;
		String selectString = getSelectTanimFromRootPathStatement(rootPath, butceTipi);
		String[] paramArray = null;
		if(level <= 4 || level == 9) {
			paramArray = new String[1];
			paramArray[0] = pathArray[level -1];
		} else if(level >=5 && level <= 8) {
			if(level == 5) {
				paramArray = new String[1];
				paramArray[0] = pathArray[level - 1];
			} else if(level == 6) {
				paramArray = new String[2];
				paramArray[0] = pathArray[level - 2];
				paramArray[1] = pathArray[level - 1];
			} else if(level == 7) {
				paramArray = new String[3];
				paramArray[0] = pathArray[level - 3];
				paramArray[1] = pathArray[level - 2];
				paramArray[2] = pathArray[level - 1];
			} else if(level == 8) {
				paramArray = new String[4];
				paramArray[0] = pathArray[level - 4];
				paramArray[1] = pathArray[level - 3];
				paramArray[2] = pathArray[level - 2];
				paramArray[3] = pathArray[level - 1];
			}
		} else if(level > 9) {
			if(level == 10) {
				paramArray = new String[1];
				paramArray[0] = pathArray[level - 1];
			} else if(level == 11) {
				paramArray = new String[2];
				paramArray[0] = pathArray[level - 2];
				paramArray[1] = pathArray[level - 1];
			} else if(level == 12) {
				paramArray = new String[3];
				paramArray[0] = pathArray[level - 3];
				paramArray[1] = pathArray[level - 2];
				paramArray[2] = pathArray[level - 1];
			} else if(level == 13) {
				paramArray = new String[4];
				paramArray[0] = pathArray[level - 4];
				paramArray[1] = pathArray[level - 3];
				paramArray[2] = pathArray[level - 2];
				paramArray[3] = pathArray[level - 1];
			}
		}
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(selectString);
			for(int i = 1; i <= paramArray.length; i++) {
				pstmt.setString(i, paramArray[i - 1]);
			}
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt(1);
				String kod = rs.getString(2);
				String tanim = rs.getString(3);
				bean.setId(id);
				bean.setKod(kod);
				bean.setTanim(tanim);
				bean.setLevel(level);
			}
		} catch(SQLException se) {
			throw new Exception(se.getMessage());
		} finally {
			rs.close();
			pstmt.close();
		}
	}
	
	private String getSelectButceKalemiStatement(int butceTipi) {
		String tableName = ButceConstants.getTableName(0, ButceConstants.RIGHT, butceTipi);
		String selectString = null;
		if(butceTipi == ButceConstants.GELIR)
			selectString = "SELECT PATH_TO_ROOT, BUTCE_YILI, ODENEK, IS_LEAF FROM " + tableName + " WHERE PATH_TO_ROOT = ? AND BUTCE_YILI = ?";
		else if(butceTipi == ButceConstants.GIDER)
			selectString = "SELECT PATH_TO_ROOT, BUTCE_YILI, ODENEK_SAYMAN, ODENEK_BASKAN, ODENEK_ENCUMEN, IS_LEAF FROM " + tableName + " WHERE PATH_TO_ROOT = ? AND BUTCE_YILI = ?";
		return selectString;
	}
	
	private String getInsertButceKalemiStatement(int islemTipi, int butceTipi) {
		String tableName = ButceConstants.getTableName(0, ButceConstants.RIGHT, butceTipi);
		String insertString = "INSERT INTO " + tableName + " (PATH_TO_ROOT, BUTCE_YILI, IS_LEAF) VALUES(?, ?, ?)";
		return insertString;
	}
	
	private String getDeleteButceKalemiStatement(int islemTipi, int butceTipi) {
		String tableName = ButceConstants.getTableName(0, ButceConstants.RIGHT, butceTipi);
		String deleteString = "DELETE FROM " + tableName + " WHERE PATH_TO_ROOT = ? AND BUTCE_YILI = ?";
		return deleteString;
	}
	
	private String getUpdateButceKalemiStatement(int islemTipi, int butceTipi) {
		String tableName = ButceConstants.getTableName(0, ButceConstants.RIGHT, butceTipi);
		String updateString = null;
		if(butceTipi == ButceConstants.GELIR)
			updateString = "UPDATE " + tableName + " SET ODENEK = ? WHERE PATH_TO_ROOT = ? AND BUTCE_YILI = ?";
		else if(butceTipi == ButceConstants.GIDER) 
			updateString = "UPDATE " + tableName + " SET ODENEK_SAYMAN = ?, ODENEK_BASKAN = ?, ODENEK_ENCUMEN = ? WHERE PATH_TO_ROOT = ? AND BUTCE_YILI = ?";
		return updateString;
	}
	
	public void insertButceKalemi(int islemTipi, int butceTipi, ButceKalemiBean bean, String pathToRoot) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getInstance().getConnection();
			pstmt = con.prepareStatement(getInsertButceKalemiStatement(islemTipi, butceTipi));
			int butceYili = ButceConstants.BUTCE_YILI;
			pstmt.setString(1, pathToRoot);
			pstmt.setInt(2, butceYili);
			pstmt.setBoolean(3, bean.isLeaf());
			int rowCount = pstmt.executeUpdate();
			if(rowCount > 0) {
				if(bean.isLeaf()) bean.setLeft(false);
				bean.setRight(true);
			}
		} catch(SQLException se) {
			throw new Exception(se);
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch(SQLException se) {
				
			}
		}
	}
	
	public void deleteButceKalemi(int islemTipi, int butceTipi, ButceKalemiBean bean, String pathToRoot) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getInstance().getConnection();
			pstmt = con.prepareStatement(getDeleteButceKalemiStatement(islemTipi, butceTipi));
			int butceYili = ButceConstants.BUTCE_YILI;
			pstmt.setString(1, pathToRoot);
			pstmt.setInt(2, butceYili);
			int rowCount = pstmt.executeUpdate();
			if(rowCount > 0) {
				bean.setLeft(true);
				bean.setRight(false);
			}
		} catch(SQLException se) {
			throw new Exception(se);
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch(SQLException se) {
				
			}
		}
	}
	
	public void updateButceKalemi(int islemTipi, int butceTipi, ButceKalemiBean bean, String pathToRoot) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getInstance().getConnection();
			pstmt = con.prepareStatement(getUpdateButceKalemiStatement(islemTipi, butceTipi));
			int butceYili = ButceConstants.BUTCE_YILI;
			if(butceTipi == ButceConstants.GELIR) {
				if(bean.getOdenek() != null) {
					Money odenekMoney = bean.getOdenek();
					double odenek = odenekMoney.convertTo("TL").getAmount();
					pstmt.setDouble(1, odenek);
				} else pstmt.setNull(1, Types.DOUBLE);
				pstmt.setString(2, pathToRoot);
				pstmt.setInt(3, butceYili);
			} else {
				if(bean.getOdenekSayman() != null) {
					Money odenekSaymanMoney = bean.getOdenekSayman();
					double odenekSayman = odenekSaymanMoney.convertTo("TL").getAmount();
					pstmt.setDouble(1, odenekSayman);
				} else pstmt.setNull(1, Types.DOUBLE);
				
				if(bean.getOdenekBaskan() != null) {
					Money odenekBaskanMoney = bean.getOdenekBaskan();
					double odenekBaskan = odenekBaskanMoney.convertTo("TL").getAmount();
					pstmt.setDouble(2, odenekBaskan);
				} else pstmt.setNull(2, Types.DOUBLE);
				
				if(bean.getOdenekEncumen() != null) {
					Money odenekEncumenMoney = bean.getOdenekEncumen();
					double odenekEncumen = odenekEncumenMoney.convertTo("TL").getAmount();
					pstmt.setDouble(3, odenekEncumen);
				} else pstmt.setNull(3, Types.DOUBLE);
				
				pstmt.setString(4, pathToRoot);
				pstmt.setInt(5, butceYili);
			}
			
			int rowCount = pstmt.executeUpdate();
		} catch(SQLException se) {
			throw new Exception(se);
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch(SQLException se) {
				
			}
		}
	}
	
	public void loadButceKalemiBilgileri(int butceTipi, String pathToRoot, ButceKalemiBean bean) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getInstance().getConnection();
			pstmt = con.prepareStatement(getSelectButceKalemiStatement(butceTipi));
			int butceYili = ButceConstants.BUTCE_YILI;
			pstmt.setString(1, pathToRoot);
			pstmt.setInt(2, ButceConstants.BUTCE_YILI);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(butceTipi == ButceConstants.GELIR) {
					double odenek = rs.getDouble("ODENEK");
					bean.setOdenek(new Money(odenek, "TL"));
					bean.setLeaf(rs.getBoolean("IS_LEAF"));
				} else if(butceTipi == ButceConstants.GIDER) {
					double odenekSayman = rs.getDouble("ODENEK_SAYMAN");
					double odenekBaskan = rs.getDouble("ODENEK_BASKAN");
					double odenekEncumen = rs.getDouble("ODENEK_ENCUMEN");
					bean.setOdenekSayman(new Money(odenekSayman, "TL"));
					bean.setOdenekBaskan(new Money(odenekBaskan, "TL"));
					bean.setOdenekEncumen(new Money(odenekEncumen, "TL"));
					bean.setLeaf(rs.getBoolean("IS_LEAF"));
				}
				bean.setRight(true);
			} else {
				bean.setRight(false);
			}
			return;
		} catch(SQLException se) {
			throw new Exception(se);
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch(SQLException se) {
				
			}
		}
	}
	
	public static String[] parseRootPath(String path) {
		StringTokenizer tok = new StringTokenizer(path, "_");
		String[] pathArray = new String[tok.countTokens()];
		int i = 0;
		while(tok.hasMoreTokens()) {
			pathArray[i] = tok.nextToken();
			i++;
		}
		return pathArray;
	}
	
	public Collection findTanimlarByRootPathAndLevel(int butceTipi, String rootPath, int level) throws Exception {
		Collection result = new ArrayList();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			String[] pathArray = parseRootPath(rootPath);
			con = ConnectionManager.getInstance().getConnection();
			pstmt = con.prepareStatement(getSelectTanimStatement(level, butceTipi));
			if(level >= 6 && level <= 8) {
				if(level == 6) pstmt.setString(1, pathArray[level - 2]);
				else if(level == 7) {
					pstmt.setString(1, pathArray[level - 3]);
					pstmt.setString(2, pathArray[level - 2]);
				} else if(level == 8) {
					pstmt.setString(1, pathArray[level - 4]);
					pstmt.setString(2, pathArray[level - 3]);
					pstmt.setString(3, pathArray[level - 2]);
				} 
			} else if(level >= 11) {
				if(level == 11) pstmt.setString(1, pathArray[level - 2]);
				else if(level == 12) {
					pstmt.setString(1, pathArray[level - 3]);
					pstmt.setString(2, pathArray[level - 2]);
				} else if(level == 13) {
					pstmt.setString(1, pathArray[level - 4]);
					pstmt.setString(2, pathArray[level - 3]);
					pstmt.setString(3, pathArray[level - 2]);
				}
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String kod = rs.getString("LEVEL"+level);
				String tanim = rs.getString("TANIM");
				ButceKalemiBean bean = new ButceKalemiBean(id, kod, tanim, level);
				if(bean.getLevel() == 1) {
					bean.setLeft(true);
					bean.setRight(true);
				}
				result.add(bean);
			}
			return result;
		} catch(SQLException se) {
			throw new Exception(se);
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch(SQLException se) {
				
			}
		}
	}
	
	public ButceKalemiBean findButceTanimiById(int id, int level, int islemTipi) throws Exception {
		ButceKalemiBean result = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionManager.getInstance().getConnection();
			pstmt = con.prepareStatement(getSelectTanimByIdStatement(level, islemTipi));
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
				String kod = rs.getString("LEVEL"+level);
				String tanim = rs.getString("TANIM");
				result = new ButceKalemiBean(id, kod, tanim, level);
			}
			return result;
		} catch(SQLException se) {
			throw new Exception(se);
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch(SQLException se) {
				
			}
		}
	}
	
	public void updateButceTanimi(ButceKalemiBean bean, int butceTipi) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getInstance().getConnection();
			pstmt = con.prepareStatement(getUpdateTanimStatement(bean.getLevel(), butceTipi));
			pstmt.setString(1, bean.getKod());
			pstmt.setString(2, bean.getTanim());
			pstmt.setInt(3, bean.getId());
			int rowCount = pstmt.executeUpdate();
		} catch(SQLException se) {
			throw new Exception(se);
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch(SQLException se) {
				
			}
		}
	}
	
	public void deleteButceTanimi(ButceKalemiBean bean, int butceTipi) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getInstance().getConnection();
			pstmt = con.prepareStatement(getDeleteTanimStatement(bean.getLevel(), butceTipi));
			pstmt.setInt(1, bean.getId());
			int rowCount = pstmt.executeUpdate();
		} catch(SQLException se) {
			throw new Exception(se);
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch(SQLException se) {
				
			}
		}
	}

}
