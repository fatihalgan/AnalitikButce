/*
 * Created on 18.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.iztek.abutce.commands.butce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import com.iztek.abutce.domain.ButceKalemiBean;
import com.iztek.abutce.util.ConnectionManager;
import com.iztek.abutce.util.TreeUtil;
import com.iztek.abutce.util.money.Money;
import com.iztek.abutce.util.money.MoneyException;

/**
 * @author db2admin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ReadGiderlerCommand {

	private DefaultMutableTreeNode root = null;
	private boolean errorFlag = false;
	private int butceTipi;
	private int yil;
		
	public ReadGiderlerCommand(int butceTipi, int yil) {
		this.butceTipi = butceTipi;
		this.yil = yil;		
	}
	
	private DefaultMutableTreeNode readGelirlerRecursively(java.sql.Connection con) {
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT PATH_TO_ROOT, ODENEK_SAYMAN, ODENEK_BASKAN, ODENEK_ENCUMEN FROM GIDERLER WHERE BUTCE_YILI=? ORDER BY PATH_TO_ROOT");
			pstmt.setInt(1, yil);
			ResultSet rs = pstmt.executeQuery();
			ArrayList arrayList = new ArrayList();
			while(rs.next()) {
				String rootToPath = rs.getString(1);
				double odenekSayman = rs.getDouble(2);
				double odenekBaskan = rs.getDouble(3);
				double odenekEncumen = rs.getDouble(4);
				ButceKalemiBean bean = new ButceKalemiBean(0, null, null, 0);
				ButceKalemiBean.getPersister().loadTanimBilgileriFromRootPath(con, rootToPath, butceTipi, bean);
				bean.setRootToPath(rootToPath);
				bean.setOdenekSayman(new Money(odenekSayman, "TL"));
				bean.setOdenekBaskan(new Money(odenekBaskan, "TL"));
				bean.setOdenekEncumen(new Money(odenekEncumen, "TL"));
				arrayList.add(bean);
			}
			rs.close();
			pstmt.close();
			root = TreeUtil.convertPreOrderListToTree(arrayList);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (MoneyException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return root;
	}
		
	public void execute() {
		Connection con = null;
		try {
			con = ConnectionManager.getInstance().getConnection();
			
			root = readGelirlerRecursively(con);
			if(root != null) {
				root = (DefaultMutableTreeNode)root.getRoot();
			}		
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				errorFlag = true;
				e.printStackTrace();
			}
		}
	}
			
	public boolean getErrorFlag() {
		return errorFlag;
	}
	
	public DefaultMutableTreeNode getRoot() {
		return root;
	}
}
