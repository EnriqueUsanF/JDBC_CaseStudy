/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delegate;

import Classes.Customer;
import Classes.Employee;
import Classes.Inventory;
import Classes.Manager;
import Classes.Outlet;
import Classes.Product;
import Classes.Returns;
import Classes.Sales;
import Facade.StoreFacade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luigi
 */
public class StoreDelegate {
    //-----------------------------------------------------OUTLET
    public void createOUTLET(Outlet dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.newOUTLET(dt);
    }

    public void deleteOUTLET(Outlet dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.deleteOUTLET(dt);
    }

    public void updateOUTLET(Outlet dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.updateOUTLET(dt);
    }
    
    public List listOUTLET() throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        return store.listOUTLET();
    }
    //-----------------------------------------------------EMPLOYEE
    public void createEMPLOYEE(Employee dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.newEMPLOYEE(dt);
    }

    public void deleteEMPLOYEE(Employee dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.deleteEMPLOYEE(dt);
    }

    public void updateEMPLOYEE(Employee dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.updateEMPLOYEE(dt);
    }
    
    public List listEMPLOYEE() throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        return store.listEMPLOYEE();
    }
    //-----------------------------------------------------PRODUCT
    public void createPRODUCT(Product dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.newPRODUCT(dt);
    }

    public void deletePRODUCT(Product dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.deletePRODUCT(dt);
    }

    public void updatePRODUCT(Product dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.updatePRODUCT(dt);
    }
    
    public List listPRODUCT() throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        return store.listPRODUCT();
    }
    //-----------------------------------------------------CUSTOMER
    public void createCUSTOMER(Customer dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.newCUSTOMER(dt);
    }

    public void deleteCUSTOMER(Customer dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.deleteCUSTOMER(dt);
    }

    public void updateCUSTOMER(Customer dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.updateCUSTOMER(dt);
    }
    
    public List listCUSTOMER() throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        return store.listCUSTOMER();
    }
    //-----------------------------------------------------MANAGER
    public void createMANAGER(Manager dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.newMANAGER(dt);
    }

    public void deleteMANAGER(Manager dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.deleteMANAGER(dt);
    }

    public void updateMANAGER(Manager dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.updateMANAGER(dt);
    }
    
    public List listMANAGER() throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        return store.listMANAGER();
    }
    //-----------------------------------------------------INVENTORY
    public void createINVENTORY(Inventory dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.newINVENTORY(dt);
    }

    public void deleteINVENTORY(Inventory dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.deleteINVENTORY(dt);
    }

    public void updateINVENTORY(Inventory dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.updateINVENTORY(dt);
    }
    
    public List listINVENTORY() throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        return store.listINVENTORY();
    }
    //-----------------------------------------------------SALES
    public void createSALES(Sales dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.newSALES(dt);
    }

    public void deleteSALES(Sales dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.deleteSALES(dt);
    }

    public void updateSALES(Sales dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.updateSALES(dt);
    }
    
    public List listSALES() throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        return store.listSALES();
    }
    //-----------------------------------------------------RETURNS
    public void createRETURNS(Returns dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.newRETURNS(dt);
    }

    public void deleteRETURNS(Returns dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.deleteRETURNS(dt);
    }

    public void updateRETURNS(Returns dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        store.updateRETURNS(dt);
    }
    
    public List listRETURNS() throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        return store.listRETURNS();
    }
    //---------------------------------------------------------------Queries
    public ArrayList<Sales> firstQuery(Sales dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        return store.firstQuery(dt);
    }
    public ArrayList<Returns> secondQuery(Returns dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        return store.secondQuery(dt);
    }
    public ArrayList<Sales> thirdQuery(Sales dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        return store.thirdQuery(dt);
    }
    public ArrayList<Sales> fourthQuery(Sales dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        return store.fourthQuery(dt);
    }
    public ArrayList<Sales> fivethQuery(Sales dt) throws SQLException, Exception {
        StoreFacade store = new StoreFacade();
        return store.fivethQuery(dt);
    }
}
