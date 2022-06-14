/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Sales;
import ConnectorDB.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author luigi
 */
public class DAOSales extends DBConnect{
    private final static String SQL_ADD = ""
	+ "insert into SALES"
	+ "(OUTLET_NUMBER,EMP_NUMBER,CUSTOMER_ID,PRODUCT_CODE,SALE_DATE,SALE_TIME,quantity) "
	+ "values"
	+ "(?, ?, ?, ?, ?, ?, ?)";

	private final static String SQL_UPD = ""
	+ "update SALES set "
	+ "OUTLET_NUMBER = ?, EMP_NUMBER = ?, CUSTOMER_ID = ?, PRODUCT_CODE = ?, SALE_DATE = ?, SALE_TIME = ?, quantity = ?"
	+ "where "
	+ "OUTLET_NUMBER = ? and EMP_NUMBER = ? and CUSTOMER_ID = ? and PRODUCT_CODE = ?";

	private final static String SQL_DEL = ""
	+ "delete from SALES where OUTLET_NUMBER = ? and EMP_NUMBER = ? and CUSTOMER_ID = ? and PRODUCT_CODE = ?";

	private final static String SQL_SAL = ""
	+ "select * from SALES";

	public DAOSales(){
		super();
	}

	public void SQLadd(Sales sal) throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQL_ADD);

		ps.setInt(1, sal.getOUTLET_NUMBER());
                ps.setInt(2, sal.getEMP_NUMBER());
		ps.setInt(3, sal.getCUSTOMER_ID());
		ps.setInt(4, sal.getPRODUCT_CODE());
		ps.setDate(5, sal.getSALE_DATE());
		ps.setTime(6, sal.getSALE_TIME());
		ps.setInt(7, sal.getQuantity());
                
		ps.executeUpdate();
		close(ps);
	}

	public void SQLupd(Sales sal) throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQL_UPD);

		ps.setInt(1, sal.getOUTLET_NUMBER());
                ps.setInt(2, sal.getEMP_NUMBER());
		ps.setInt(3, sal.getCUSTOMER_ID());
		ps.setInt(4, sal.getPRODUCT_CODE());
		ps.setDate(5, sal.getSALE_DATE());
		ps.setTime(6, sal.getSALE_TIME());
		ps.setInt(7, sal.getQuantity());

                ps.setInt(8, sal.getOUTLET_NUMBER());
                ps.setInt(9, sal.getEMP_NUMBER());
		ps.setInt(10, sal.getCUSTOMER_ID());
		ps.setInt(11, sal.getPRODUCT_CODE());

		ps.executeUpdate();
		close(ps);
	}

	public void SQLdel(Sales sal) throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQL_DEL);

		ps.setInt(1, sal.getOUTLET_NUMBER());
                ps.setInt(2, sal.getEMP_NUMBER());
		ps.setInt(3, sal.getCUSTOMER_ID());
		ps.setInt(4, sal.getPRODUCT_CODE());

		ps.executeUpdate();
		close(ps);
	}

	public ArrayList<Sales> SQLsal() throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		@SuppressWarnings("UnusedAssignment")
		ResultSet rs = null;
		ArrayList<Sales> lst = new ArrayList();

		Sales sal;

		ps = con.prepareStatement(SQL_SAL);
		rs = ps.executeQuery();

		while(rs.next()){
			sal = new Sales();

                        sal.setOUTLET_NUMBER(rs.getInt("OUTLET_NUMBER"));
                        sal.setEMP_NUMBER(rs.getInt("EMP_NUMBER"));
			sal.setCUSTOMER_ID(rs.getInt("CUSTOMER_ID"));
			sal.setPRODUCT_CODE(rs.getInt("PRODUCT_CODE"));
			sal.setSALE_DATE(rs.getDate("SALE_DATE"));
			sal.setSALE_TIME(rs.getTime("SALE_TIME"));
			sal.setQuantity(rs.getInt("quantity"));
                        
			lst.add(sal);
		}

		return lst;
	}
}
