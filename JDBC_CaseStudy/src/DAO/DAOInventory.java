/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Inventory;
import ConnectorDB.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author luigi
 */
public class DAOInventory extends DBConnect{
    private final static String SQL_ADD = ""
	+ "insert into INVENTORY"
	+ "(OUTLET_NUMBER,PRODUCT_CODE,quantity) "
	+ "values"
	+ "(?, ?, ?)";

	private final static String SQL_UPD = ""
	+ "update INVENTORY set "
	+ "OUTLET_NUMBER = ?, PRODUCT_CODE = ?, quantity = ?"
	+ "where "
	+ "OUTLET_NUMBER = ? and PRODUCT_CODE = ?";

	private final static String SQL_DEL = ""
	+ "delete from INVENTORY where OUTLET_NUMBER = ? and PRODUCT_CODE = ?";

	private final static String SQL_SAL = ""
	+ "select * from INVENTORY";

	public DAOInventory(){
		super();
	}

	public void SQLadd(Inventory inv) throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQL_ADD);

		ps.setInt(1, inv.getOUTLET_NUMBER());
		ps.setInt(2, inv.getPRODUCT_CODE());
                ps.setInt(3, inv.getQuantity());

		ps.executeUpdate();
		close(ps);
	}

	public void SQLupd(Inventory inv) throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQL_UPD);

		ps.setInt(1, inv.getOUTLET_NUMBER());
		ps.setInt(2, inv.getPRODUCT_CODE());
                ps.setInt(3, inv.getQuantity());

		ps.setInt(4, inv.getOUTLET_NUMBER());
		ps.setInt(5, inv.getPRODUCT_CODE());

		ps.executeUpdate();
		close(ps);
	}

	public void SQLdel(Inventory inv) throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQL_DEL);

                ps.setInt(1, inv.getOUTLET_NUMBER());
		ps.setInt(2, inv.getPRODUCT_CODE());

		ps.executeUpdate();
		close(ps);
	}

	public ArrayList<Inventory> SQLsal() throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		@SuppressWarnings("UnusedAssignment")
		ResultSet rs = null;
		ArrayList<Inventory> lst = new ArrayList();

		Inventory inv;

		ps = con.prepareStatement(SQL_SAL);
		rs = ps.executeQuery();

		while(rs.next()){
			inv = new Inventory();

                        inv.setOUTLET_NUMBER(rs.getInt("OUTLET_NUMBER"));
			inv.setPRODUCT_CODE(rs.getInt("PRODUCT_CODE"));
                        inv.setQuantity(rs.getInt("quantity"));
                        
			lst.add(inv);
		}

		return lst;
	}
}
