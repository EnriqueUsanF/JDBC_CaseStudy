/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Outlet;
import ConnectorDB.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author luigi
 */
public class DAOOutlet extends DBConnect{
        private final static String SQL_ADD = ""
	+ "insert into OUTLET"
	+ "(OUTLET_NUMBER,address,city,state,zip,phone) "
	+ "values"
	+ "(?, ?, ?, ?, ?, ?)";

	private final static String SQL_UPD = ""
	+ "update OUTLET set "
	+ "OUTLET_NUMBER = ?, address = ?, city = ?, state = ?, zip = ?, phone = ?"
	+ "where "
	+ "OUTLET_NUMBER = ?";

	private final static String SQL_DEL = ""
	+ "delete from OUTLET where OUTLET_NUMBER = ?";

	private final static String SQL_SAL = ""
	+ "select * from OUTLET";

	public DAOOutlet(){
		super();
	}

	public void SQLadd(Outlet out) throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQL_ADD);

		ps.setInt(1, out.getOUTLET_NUMBER());
		ps.setString(2, out.getAddress());
		ps.setString(3, out.getCity());
		ps.setString(4, out.getState());
		ps.setString(5, out.getZip());
		ps.setString(6, out.getPhone());

		ps.executeUpdate();
		close(ps);
	}

	public void SQLupd(Outlet out) throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQL_UPD);

		ps.setInt(1, out.getOUTLET_NUMBER());
		ps.setString(2, out.getAddress());
		ps.setString(3, out.getCity());
		ps.setString(4, out.getState());
		ps.setString(5, out.getZip());
		ps.setString(6, out.getPhone());

		ps.setInt(7, out.getOUTLET_NUMBER());

		ps.executeUpdate();
		close(ps);
	}

	public void SQLdel(Outlet out) throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQL_DEL);

                ps.setInt(1, out.getOUTLET_NUMBER());

		ps.executeUpdate();
		close(ps);
	}

	public ArrayList<Outlet> SQLsal() throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		@SuppressWarnings("UnusedAssignment")
		ResultSet rs = null;
		ArrayList<Outlet> lst = new ArrayList();

		Outlet out;

		ps = con.prepareStatement(SQL_SAL);
		rs = ps.executeQuery();

		while(rs.next()){
			out = new Outlet();

                        out.setOUTLET_NUMBER(rs.getInt("OUTLET_NUMBER"));
			out.setAddress(rs.getString("address"));
			out.setCity(rs.getString("city"));
			out.setState(rs.getString("state"));
			out.setZip(rs.getString("zip"));
			out.setPhone(rs.getString("phone"));
                        
			lst.add(out);
		}

		return lst;
	}
}
