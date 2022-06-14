/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Returns;
import ConnectorDB.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author luigi
 */
public class DAOReturns extends DBConnect{
    private final static String SQL_ADD = ""
	+ "insert into RETURNS"
	+ "(OUTLET_NUMBER,PRODUCT_CODE,CUSTOMER_ID,RETURN_DATE,RETURN_TIME,quantity,reason) "
	+ "values"
	+ "(?, ?, ?, ?, ?, ?, ?)";

	private final static String SQL_UPD = ""
	+ "update RETURNS set "
	+ "OUTLET_NUMBER = ?, PRODUCT_CODE = ?, CUSTOMER_ID = ?, RETURN_DATE = ?, RETURN_TIME = ?, quantity = ?, reason = ?"
	+ "where "
	+ "OUTLET_NUMBER = ? and PRODUCT_CODE = ? and CUSTOMER_ID = ?";

	private final static String SQL_DEL = ""
	+ "delete from RETURNS where OUTLET_NUMBER = ? and PRODUCT_CODE = ? and CUSTOMER_ID = ?";

	private final static String SQL_SAL = ""
	+ "select * from RETURNS";

	public DAOReturns(){
		super();
	}

	public void SQLadd(Returns ret) throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQL_ADD);

		ps.setInt(1, ret.getOUTLET_NUMBER());
                ps.setInt(2, ret.getPRODUCT_CODE());
		ps.setInt(3, ret.getCUSTOMER_ID());
		ps.setDate(4, ret.getRETURN_DATE());
		ps.setTime(5, ret.getRETURN_TIME());
		ps.setInt(6, ret.getQuantity());
		ps.setString(7, ret.getReason());
                
		ps.executeUpdate();
		close(ps);
	}

	public void SQLupd(Returns ret) throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQL_UPD);

		ps.setInt(1, ret.getOUTLET_NUMBER());
                ps.setInt(2, ret.getPRODUCT_CODE());
		ps.setInt(3, ret.getCUSTOMER_ID());
		ps.setDate(4, ret.getRETURN_DATE());
		ps.setTime(5, ret.getRETURN_TIME());
		ps.setInt(6, ret.getQuantity());
		ps.setString(7, ret.getReason());

                ps.setInt(8, ret.getOUTLET_NUMBER());
                ps.setInt(9, ret.getPRODUCT_CODE());
		ps.setInt(10, ret.getCUSTOMER_ID());

		ps.executeUpdate();
		close(ps);
	}

	public void SQLdel(Returns ret) throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQL_DEL);

		ps.setInt(1, ret.getOUTLET_NUMBER());
                ps.setInt(2, ret.getPRODUCT_CODE());
		ps.setInt(3, ret.getCUSTOMER_ID());

		ps.executeUpdate();
		close(ps);
	}

	public ArrayList<Returns> SQLsal() throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		@SuppressWarnings("UnusedAssignment")
		ResultSet rs = null;
		ArrayList<Returns> lst = new ArrayList();

		Returns ret;

		ps = con.prepareStatement(SQL_SAL);
		rs = ps.executeQuery();

		while(rs.next()){
			ret = new Returns();

                        ret.setOUTLET_NUMBER(rs.getInt("OUTLET_NUMBER"));
                        ret.setPRODUCT_CODE(rs.getInt("PRODUCT_CODE"));
			ret.setCUSTOMER_ID(rs.getInt("CUSTOMER_ID"));
			ret.setRETURN_DATE(rs.getDate("RETURN_DATE"));
			ret.setRETURN_TIME(rs.getTime("RETURN_TIME"));
			ret.setQuantity(rs.getInt("quantity"));
			ret.setReason(rs.getString("reason"));
                        
			lst.add(ret);
		}

		return lst;
	}
}
