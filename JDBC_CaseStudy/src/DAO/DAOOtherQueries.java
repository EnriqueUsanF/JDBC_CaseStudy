/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Employee;
import Classes.Returns;
import Classes.Sales;
import ConnectorDB.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author luigi
 */
public class DAOOtherQueries extends DBConnect {

    private final static String SQL_SAL1 = ""
            + "SELECT * FROM SALES WHERE SALE_DATE like ? AND CUSTOMER_ID = ?";

    private final static String SQL_SAL2 = ""
            + "SELECT * FROM RETURNS WHERE RETURN_DATE = ? AND CUSTOMER_ID = ?";

    private final static String SQL_SAL3 = ""
            + "SELECT SALE_DATE,SUM(quantity) FROM SALES GROUP BY SALE_DATE";

    private final static String SQL_SAL4 = ""
            + "SELECT SUM(quantity), EMP_NUMBER FROM SALES GROUP BY EMP_NUMBER";

    private final static String SQL_SAL5 = ""
            + "SELECT SUM(quantity) as Q, PRODUCT_CODE \n"
            + "FROM SALES \n"
            + "GROUP BY PRODUCT_CODE ORDER BY Q DESC LIMIT 10;";

    public DAOOtherQueries() {
        super();
    }

    public ArrayList<Sales> SQLsal1(Sales sal) throws Exception {
        @SuppressWarnings("UnusedAssignment")
        PreparedStatement ps = null;
        @SuppressWarnings("UnusedAssignment")
        ResultSet rs = null;
        ArrayList<Sales> lst = new ArrayList();

        ps = con.prepareStatement(SQL_SAL1);

        ps.setDate(1, sal.getSALE_DATE());
        ps.setInt(2, sal.getCUSTOMER_ID());

        rs = ps.executeQuery();

        while (rs.next()) {
            sal = new Sales();
            sal.setOUTLET_NUMBER(rs.getInt("OUTLET_NUMBER"));
            sal.setEMP_NUMBER(rs.getInt("EMP_NUMBER"));
            sal.setCUSTOMER_ID(rs.getInt("CUSTOMER_ID"));
            sal.setPRODUCT_CODE(rs.getInt("PRODUCT_CODE"));
            sal.setSALE_DATE(rs.getDate("SALE_DATE"));
            sal.setSALE_TIME(rs.getTime("SALE_TIME"));
            sal.setQuantity(rs.getInt("quantity"));
            //OUTLET_NUMBER,EMP_NUMBER,CUSTOMER_ID,PRODUCT_CODE,SALE_DATE,SALE_TIME,quantity
            lst.add(sal);
        }

        return lst;
    }

    public ArrayList<Returns> SQLsal2(Returns sal) throws Exception {
        @SuppressWarnings("UnusedAssignment")
        PreparedStatement ps = null;
        @SuppressWarnings("UnusedAssignment")
        ResultSet rs = null;
        ArrayList<Returns> lst = new ArrayList();

        ps = con.prepareStatement(SQL_SAL2);

        ps.setDate(1, sal.getRETURN_DATE());
        ps.setInt(2, sal.getCUSTOMER_ID());
        rs = ps.executeQuery();

        while (rs.next()) {
            sal = new Returns();

            sal.setOUTLET_NUMBER(rs.getInt("OUTLET_NUMBER"));
            sal.setCUSTOMER_ID(rs.getInt("CUSTOMER_ID"));
            sal.setPRODUCT_CODE(rs.getInt("PRODUCT_CODE"));
            sal.setRETURN_DATE(rs.getDate("RETURN_DATE"));
            sal.setRETURN_TIME(rs.getTime("RETURN_TIME"));
            sal.setQuantity(rs.getInt("quantity"));
            sal.setReason(rs.getString("reason"));
            //OUTLET_NUMBER,PRODUCT_CODE,CUSTOMER_ID,RETURN_DATE,RETURN_TIME,quantity,reason
            lst.add(sal);
        }

        return lst;
    }

    public ArrayList<Sales> SQLsal3(Sales sal) throws Exception {
        @SuppressWarnings("UnusedAssignment")
        PreparedStatement ps = null;
        @SuppressWarnings("UnusedAssignment")
        ResultSet rs = null;
        ArrayList<Sales> lst = new ArrayList();

        ps = con.prepareStatement(SQL_SAL3);
        rs = ps.executeQuery();

        while (rs.next()) {
            sal = new Sales();
            sal.setSALE_DATE(rs.getDate("SALE_DATE"));
            sal.setQuantity(rs.getInt("SUM(quantity)"));
            //OUTLET_NUMBER,EMP_NUMBER,CUSTOMER_ID,PRODUCT_CODE,SALE_DATE,SALE_TIME,quantity
            lst.add(sal);
        }
        return lst;
    }

    public ArrayList<Sales> SQLsal4(Sales sal) throws Exception {
        @SuppressWarnings("UnusedAssignment")
        PreparedStatement ps = null;
        @SuppressWarnings("UnusedAssignment")
        ResultSet rs = null;
        ArrayList<Sales> lst = new ArrayList();

        ps = con.prepareStatement(SQL_SAL4);

        rs = ps.executeQuery();

        while (rs.next()) {
            sal = new Sales();

            sal.setQuantity(rs.getInt("SUM(quantity)"));
            sal.setEMP_NUMBER(rs.getInt("EMP_NUMBER"));
            //OUTLET_NUMBER,EMP_NUMBER,CUSTOMER_ID,PRODUCT_CODE,SALE_DATE,SALE_TIME,quantity
            lst.add(sal);
        }
        return lst;
    }
    
    public ArrayList<Sales> SQLsal5(Sales sal) throws Exception {
        @SuppressWarnings("UnusedAssignment")
        PreparedStatement ps = null;
        @SuppressWarnings("UnusedAssignment")
        ResultSet rs = null;
        ArrayList<Sales> lst = new ArrayList();

        ps = con.prepareStatement(SQL_SAL5);

        rs = ps.executeQuery();

        while (rs.next()) {
            sal = new Sales();

            sal.setQuantity(rs.getInt("Q"));
            sal.setPRODUCT_CODE(rs.getInt("PRODUCT_CODE"));
            //OUTLET_NUMBER,EMP_NUMBER,CUSTOMER_ID,PRODUCT_CODE,SALE_DATE,SALE_TIME,quantity
            lst.add(sal);
        }
        return lst;
    }
}
