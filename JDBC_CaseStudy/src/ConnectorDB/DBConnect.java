/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectorDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author luigi
 */
public class DBConnect {
    protected Connection con;

	public DBConnect(){
		String drvr = "com.mysql.jdbc.Driver";
		String user = "root";
		String pass = "123";
		String dtbs = "MusicStore";
		String srvr = "jdbc:mysql://localhost/" + dtbs;

		try{
			Class.forName(drvr);
			con = DriverManager.getConnection(srvr, user, pass);
		}catch(SQLException e){
			System.out.println(e);
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}
	}

	protected void close(PreparedStatement stat) throws Exception{
		stat.close();
	}
	protected void close(ResultSet rsst) throws Exception{
		rsst.close();
	}
}
