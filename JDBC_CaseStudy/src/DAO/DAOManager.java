/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Manager;
import ConnectorDB.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author luigi
 */
public class DAOManager extends DBConnect{
    private final static String SQL_ADD = ""
	+ "insert into MANAGER"
	+ "(OUTLET_NUMBER,EMP_NUMBER) "
	+ "values"
	+ "(?, ?)";

	private final static String SQL_UPD = ""
	+ "update MANAGER set "
	+ "OUTLET_NUMBER = ?, EMP_NUMBER = ?"
	+ "where "
	+ "OUTLET_NUMBER = ? and EMP_NUMBER = ?";

	private final static String SQL_DEL = ""
	+ "delete from MANAGER where OUTLET_NUMBER = ? and EMP_NUMBER = ?";

	private final static String SQL_SAL = ""
	+ "select * from MANAGER";

	public DAOManager(){
		super();
	}

	public void SQLadd(Manager mana) throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQL_ADD);

		ps.setInt(1, mana.getOUTLET_NUMBER());
		ps.setInt(2, mana.getEMP_NUMBER());

		ps.executeUpdate();
		close(ps);
	}

	public void SQLupd(Manager mana) throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQL_UPD);

		ps.setInt(1, mana.getOUTLET_NUMBER());
		ps.setInt(2, mana.getEMP_NUMBER());

		ps.setInt(3, mana.getOUTLET_NUMBER());
		ps.setInt(4, mana.getEMP_NUMBER());

		ps.executeUpdate();
		close(ps);
	}

	public void SQLdel(Manager mana) throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQL_DEL);

                ps.setInt(1, mana.getOUTLET_NUMBER());
                ps.setInt(2, mana.getEMP_NUMBER());

		ps.executeUpdate();
		close(ps);
	}

	public ArrayList<Manager> SQLsal() throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		@SuppressWarnings("UnusedAssignment")
		ResultSet rs = null;
		ArrayList<Manager> lst = new ArrayList();

		Manager mana;

		ps = con.prepareStatement(SQL_SAL);
		rs = ps.executeQuery();

		while(rs.next()){
			mana = new Manager();

                        mana.setOUTLET_NUMBER(rs.getInt("OUTLET_NUMBER"));
			mana.setEMP_NUMBER(rs.getInt("EMP_NUMBER"));
                        
			lst.add(mana);
		}

		return lst;
	}
}
