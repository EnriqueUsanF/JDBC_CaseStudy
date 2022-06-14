/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Classes.Customer;
import Classes.Employee;
import Classes.Inventory;
import Classes.Manager;
import Classes.Outlet;
import Classes.Product;
import Classes.Returns;
import Classes.Sales;
import DAO.DAOCustomer;
import DAO.DAOEmployee;
import DAO.DAOInventory;
import DAO.DAOManager;
import DAO.DAOOtherQueries;
import DAO.DAOOutlet;
import DAO.DAOProduct;
import DAO.DAOReturns;
import DAO.DAOSales;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luigi
 */
public class StoreFacade {
    //-----------------------------------------------------OUTLET
    public void newOUTLET(Outlet dt) throws Exception {
        DAOOutlet dao = new DAOOutlet();
        dao.SQLadd(dt);
    }

    public List listOUTLET() throws Exception {
        DAOOutlet dao = new DAOOutlet();
        return dao.SQLsal();
    }

    public void updateOUTLET(Outlet dt) throws Exception {
        DAOOutlet dao = new DAOOutlet();
        dao.SQLupd(dt);
    }

    public void deleteOUTLET(Outlet dt) throws Exception {
        DAOOutlet dao = new DAOOutlet();
        dao.SQLdel(dt);
    }
    //-----------------------------------------------------EMPLOYEE
    public void newEMPLOYEE(Employee dt) throws Exception {
        DAOEmployee dao = new DAOEmployee();
        dao.SQLadd(dt);
    }

    public List listEMPLOYEE() throws Exception {
        DAOEmployee dao = new DAOEmployee();
        return dao.SQLsal();
    }

    public void updateEMPLOYEE(Employee dt) throws Exception {
        DAOEmployee dao = new DAOEmployee();
        dao.SQLupd(dt);
    }

    public void deleteEMPLOYEE(Employee dt) throws Exception {
        DAOEmployee dao = new DAOEmployee();
        dao.SQLdel(dt);
    }
    //-----------------------------------------------------PRODUCT
    public void newPRODUCT(Product dt) throws Exception {
        DAOProduct dao = new DAOProduct();
        dao.SQLadd(dt);
    }

    public List listPRODUCT() throws Exception {
        DAOProduct dao = new DAOProduct();
        return dao.SQLsal();
    }

    public void updatePRODUCT(Product dt) throws Exception {
        DAOProduct dao = new DAOProduct();
        dao.SQLupd(dt);
    }

    public void deletePRODUCT(Product dt) throws Exception {
        DAOProduct dao = new DAOProduct();
        dao.SQLdel(dt);
    }
    //-----------------------------------------------------CUSTOMER
    public void newCUSTOMER(Customer dt) throws Exception {
        DAOCustomer dao = new DAOCustomer();
        dao.SQLadd(dt);
    }

    public List listCUSTOMER() throws Exception {
        DAOCustomer dao = new DAOCustomer();
        return dao.SQLsal();
    }

    public void updateCUSTOMER(Customer dt) throws Exception {
        DAOCustomer dao = new DAOCustomer();
        dao.SQLupd(dt);
    }

    public void deleteCUSTOMER(Customer dt) throws Exception {
        DAOCustomer dao = new DAOCustomer();
        dao.SQLdel(dt);
    }
    //-----------------------------------------------------MANAGER
    public void newMANAGER(Manager dt) throws Exception {
        DAOManager dao = new DAOManager();
        dao.SQLadd(dt);
    }

    public List listMANAGER() throws Exception {
        DAOManager dao = new DAOManager();
        return dao.SQLsal();
    }

    public void updateMANAGER(Manager dt) throws Exception {
        DAOManager dao = new DAOManager();
        dao.SQLupd(dt);
    }

    public void deleteMANAGER(Manager dt) throws Exception {
        DAOManager dao = new DAOManager();
        dao.SQLdel(dt);
    }
    //-----------------------------------------------------INVENTORY
    public void newINVENTORY(Inventory dt) throws Exception {
        DAOInventory dao = new DAOInventory();
        dao.SQLadd(dt);
    }

    public List listINVENTORY() throws Exception {
        DAOInventory dao = new DAOInventory();
        return dao.SQLsal();
    }

    public void updateINVENTORY(Inventory dt) throws Exception {
        DAOInventory dao = new DAOInventory();
        dao.SQLupd(dt);
    }

    public void deleteINVENTORY(Inventory dt) throws Exception {
        DAOInventory dao = new DAOInventory();
        dao.SQLdel(dt);
    }
    //-----------------------------------------------------SALES
    public void newSALES(Sales dt) throws Exception {
        DAOSales dao = new DAOSales();
        dao.SQLadd(dt);
    }

    public List listSALES() throws Exception {
        DAOSales dao = new DAOSales();
        return dao.SQLsal();
    }

    public void updateSALES(Sales dt) throws Exception {
        DAOSales dao = new DAOSales();
        dao.SQLupd(dt);
    }

    public void deleteSALES(Sales dt) throws Exception {
        DAOSales dao = new DAOSales();
        dao.SQLdel(dt);
    }
    //-----------------------------------------------------RETURNS
    public void newRETURNS(Returns dt) throws Exception {
        DAOReturns dao = new DAOReturns();
        dao.SQLadd(dt);
    }

    public List listRETURNS() throws Exception {
        DAOReturns dao = new DAOReturns();
        return dao.SQLsal();
    }

    public void updateRETURNS(Returns dt) throws Exception {
        DAOReturns dao = new DAOReturns();
        dao.SQLupd(dt);
    }

    public void deleteRETURNS(Returns dt) throws Exception {
        DAOReturns dao = new DAOReturns();
        dao.SQLdel(dt);
    }
    //-----------------------------------------------------SOME QUERIES
    public ArrayList<Sales> firstQuery(Sales dt) throws Exception {
        DAOOtherQueries dao = new DAOOtherQueries();
        return dao.SQLsal1(dt);
    }
    public ArrayList<Returns> secondQuery(Returns dt) throws Exception {
        DAOOtherQueries dao = new DAOOtherQueries();
        return dao.SQLsal2(dt);
    }
    public ArrayList<Sales> thirdQuery(Sales dt) throws Exception {
        DAOOtherQueries dao = new DAOOtherQueries();
        return dao.SQLsal3(dt);
    }
    public ArrayList<Sales> fourthQuery(Sales dt) throws Exception {
        DAOOtherQueries dao = new DAOOtherQueries();
        return dao.SQLsal4(dt);
    }
    public ArrayList<Sales> fivethQuery(Sales dt) throws Exception {
        DAOOtherQueries dao = new DAOOtherQueries();
        return dao.SQLsal5(dt);
    }
}
