/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Customer;
import ConnectorDB.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author luigi
 */
public class DAOCustomer extends DBConnect{
    private final static String SQL_ADD = ""
	+ "insert into CUSTOMER"
	+ "(CUSTOMER_ID,customer_name,address,city,state,zip,phone) "
	+ "values"
	+ "(?, ?, ?, ?, ?, ?, ?)";

	private final static String SQL_UPD = ""
	+ "update CUSTOMER set "
	+ "CUSTOMER_ID = ?, customer_name = ?, address = ?, city = ?, state = ?, zip = ?, phone = ?"
	+ "where "
	+ "CUSTOMER_ID = ?";

	private final static String SQL_DEL = ""
	+ "delete from CUSTOMER where CUSTOMER_ID = ?";

	private final static String SQL_SAL = ""
	+ "select * from CUSTOMER";

	public DAOCustomer(){
		super();
	}

	public void SQLadd(Customer cust) throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQL_ADD);

		ps.setInt(1, cust.getCUSTOMER_ID());
                ps.setString(2, cust.getCustomer_name());
		ps.setString(3, cust.getAddress());
		ps.setString(4, cust.getCity());
		ps.setString(5, cust.getState());
		ps.setString(6, cust.getZip());
		ps.setString(7, cust.getPhone());

		ps.executeUpdate();
		close(ps);
	}

	public void SQLupd(Customer cust) throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQL_UPD);

		ps.setInt(1, cust.getCUSTOMER_ID());
                ps.setString(2, cust.getCustomer_name());
		ps.setString(3, cust.getAddress());
		ps.setString(4, cust.getCity());
		ps.setString(5, cust.getState());
		ps.setString(6, cust.getZip());
		ps.setString(7, cust.getPhone());

		ps.setInt(8, cust.getCUSTOMER_ID());

		ps.executeUpdate();
		close(ps);
	}

	public void SQLdel(Customer cust) throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQL_DEL);

                ps.setInt(1, cust.getCUSTOMER_ID());

		ps.executeUpdate();
		close(ps);
	}

	public ArrayList<Customer> SQLsal() throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		@SuppressWarnings("UnusedAssignment")
		ResultSet rs = null;
		ArrayList<Customer> lst = new ArrayList();

		Customer cust;

		ps = con.prepareStatement(SQL_SAL);
		rs = ps.executeQuery();

		while(rs.next()){
			cust = new Customer();

                        cust.setCUSTOMER_ID(rs.getInt("CUSTOMER_ID"));
                        cust.setCustomer_name(rs.getString("customer_name"));
			cust.setAddress(rs.getString("address"));
			cust.setCity(rs.getString("city"));
			cust.setState(rs.getString("state"));
			cust.setZip(rs.getString("zip"));
			cust.setPhone(rs.getString("phone"));
                        
			lst.add(cust);
		}

		return lst;
	}
}
