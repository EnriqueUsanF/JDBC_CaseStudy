/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Employee;
import ConnectorDB.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author luigi
 */
public class DAOEmployee extends DBConnect{
    private final static String SQL_ADD = ""
	+ "insert into EMPLOYEE"
	+ "(OUTLET_NUMBER,EMP_NUMBER,emp_name) "
	+ "values"
	+ "(?, ?, ?)";

	private final static String SQL_UPD = ""
	+ "update EMPLOYEE set "
	+ "OUTLET_NUMBER = ?, EMP_NUMBER = ?, emp_name = ?"
	+ "where "
	+ "EMP_NUMBER = ?";

	private final static String SQL_DEL = ""
	+ "delete from EMPLOYEE where EMP_NUMBER = ?";

	private final static String SQL_SAL = ""
	+ "select * from EMPLOYEE";

	public DAOEmployee(){
		super();
	}

	public void SQLadd(Employee emp) throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQL_ADD);

		ps.setInt(1, emp.getOUTLET_NUMBER());
		ps.setInt(2, emp.getEMP_NUMBER());
		ps.setString(3, emp.getEmp_name());

		ps.executeUpdate();
		close(ps);
	}

	public void SQLupd(Employee emp) throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQL_UPD);

		ps.setInt(1, emp.getOUTLET_NUMBER());
		ps.setInt(2, emp.getEMP_NUMBER());
		ps.setString(3, emp.getEmp_name());

		ps.setInt(4, emp.getEMP_NUMBER());

		ps.executeUpdate();
		close(ps);
	}

	public void SQLdel(Employee emp) throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQL_DEL);

                ps.setInt(1, emp.getEMP_NUMBER());

		ps.executeUpdate();
		close(ps);
	}

	public ArrayList<Employee> SQLsal() throws Exception{
		@SuppressWarnings("UnusedAssignment")
		PreparedStatement ps = null;
		@SuppressWarnings("UnusedAssignment")
		ResultSet rs = null;
		ArrayList<Employee> lst = new ArrayList();

		Employee emp;

		ps = con.prepareStatement(SQL_SAL);
		rs = ps.executeQuery();

		while(rs.next()){
			emp = new Employee();

                        emp.setOUTLET_NUMBER(rs.getInt("OUTLET_NUMBER"));
			emp.setEMP_NUMBER(rs.getInt("EMP_NUMBER"));
			emp.setEmp_name(rs.getString("emp_name"));
                        
			lst.add(emp);
		}

		return lst;
	}
}
