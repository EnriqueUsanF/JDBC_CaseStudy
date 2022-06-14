/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Product;
import ConnectorDB.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author luigi
 */
public class DAOProduct extends DBConnect {

    private final static String SQL_ADD = ""
            + "insert into PRODUCT"
            + "(PRODUCT_CODE,artist,title,cost,sale_price) "
            + "values"
            + "(?, ?, ?, ?, ?)";

    private final static String SQL_UPD = ""
            + "update PRODUCT set "
            + "PRODUCT_CODE = ?, artist = ?, title = ?, cost = ?, sale_price = ?"
            + "where "
            + "PRODUCT_CODE = ?";

    private final static String SQL_DEL = ""
            + "delete from PRODUCT where PRODUCT_CODE = ?";

    private final static String SQL_SAL = ""
            + "select * from PRODUCT";

    public DAOProduct() {
        super();
    }

    public void SQLadd(Product prod) throws Exception {
        @SuppressWarnings("UnusedAssignment")
        PreparedStatement ps = null;
        ps = con.prepareStatement(SQL_ADD);

        ps.setInt(1, prod.getPRODUCT_CODE());
        ps.setString(2, prod.getArtist());
        ps.setString(3, prod.getTitle());
        ps.setDouble(4, prod.getCost());
        ps.setDouble(5, prod.getSale_price());

        ps.executeUpdate();
        close(ps);
    }

    public void SQLupd(Product prod) throws Exception {
        @SuppressWarnings("UnusedAssignment")
        PreparedStatement ps = null;
        ps = con.prepareStatement(SQL_UPD);

        ps.setInt(1, prod.getPRODUCT_CODE());
        ps.setString(2, prod.getArtist());
        ps.setString(3, prod.getTitle());
        ps.setDouble(4, prod.getCost());
        ps.setDouble(5, prod.getSale_price());

        ps.setInt(6, prod.getPRODUCT_CODE());

        ps.executeUpdate();
        close(ps);
    }

    public void SQLdel(Product prod) throws Exception {
        @SuppressWarnings("UnusedAssignment")
        PreparedStatement ps = null;
        ps = con.prepareStatement(SQL_DEL);

        ps.setInt(1, prod.getPRODUCT_CODE());

        ps.executeUpdate();
        close(ps);
    }

    public ArrayList<Product> SQLsal() throws Exception {
        @SuppressWarnings("UnusedAssignment")
        PreparedStatement ps = null;
        @SuppressWarnings("UnusedAssignment")
        ResultSet rs = null;
        ArrayList<Product> lst = new ArrayList();

        Product prod;

        ps = con.prepareStatement(SQL_SAL);
        rs = ps.executeQuery();

        while (rs.next()) {
            prod = new Product();

            prod.setPRODUCT_CODE(rs.getInt("PRODUCT_CODE"));
            prod.setArtist(rs.getString("artist"));
            prod.setTitle(rs.getString("title"));
            prod.setCost(rs.getDouble("cost"));
            prod.setSale_price(rs.getDouble("sale_price"));

            lst.add(prod);
        }

        return lst;
    }
}
