/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc_casestudy;

import Classes.Customer;
import Classes.Employee;
import Classes.Inventory;
import Classes.Manager;
import Classes.Outlet;
import Classes.Product;
import Classes.Returns;
import Classes.Sales;
import Delegate.StoreDelegate;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luigi
 */
public class JDBC_CaseStudy {

    static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int flag;
        String storeOption;
        
        while (true) {
            System.out.println("MAIN MENU");
            System.out.println("1.- Sale/Return processing");
            System.out.println("2.- Outlet/Employee/Customer/Product maintenance");
            System.out.println("3.- Reports");
            System.out.println("4.- Quit");
            System.out.println("Please inset one number: ");
            try {
                flag = sc.nextInt();
                if (flag == 1) {
                    while (true) {
                        System.out.println("SALES/RETURNS MENU");
                        System.out.println("1.- Process a sale");
                        System.out.println("2.- Process a return");
                        System.out.println("3.- view a sale (given date and customer id)");
                        System.out.println("4.- view a return (given date and customer id)");
                        System.out.println("5.- Quit");
                        System.out.println("Please inset one number: ");
                        try {
                            flag = sc.nextInt();
                            if (flag == 1) {
                                processSale();
                            } else if (flag == 2) {
                                processReturn();
                            } else if (flag == 3) {
                                firstQuery();
                            } else if (flag == 4) {
                                secondQuery();
                            } else if (flag == 5) {
                                break;
                            } else {
                                System.out.println("Enter valid option");
                            }
                        } catch (Exception e) {
                            System.out.println("Only can accept numeric values");
                            break;
                        }
                    }
                } else if (flag == 2) {
                    while (true) {
                        System.out.println("MAINTENANCE MENU");
                        System.out.println("1.- Add/Modify/Drop Outlet");
                        System.out.println("2.- Add/Modify/Drop Employee");
                        System.out.println("3.- Add/Modify/Drop Customer");
                        System.out.println("4.- Add/Modify/Drop Product");
                        System.out.println("5.- Process new shipment of Products for an Outlet");
                        System.out.println("6.- Process returns");
                        System.out.println("7.- Quit");
                        System.out.println("Please inset one number: ");
                        try {
                            flag = sc.nextInt();
                            if (flag == 1) {
                                while (true) {
                                    System.out.println("OUTLET MENU");
                                    System.out.println("1.- Add");
                                    System.out.println("2.- Modify");
                                    System.out.println("3.- Drop");
                                    System.out.println("4.- Quit");
                                    System.out.println("Please inset one number: ");
                                    try {
                                        flag = sc.nextInt();
                                        if (flag == 1) {
                                            addOutlet();
                                        } else if (flag == 2) {
                                            updOutlet();
                                        } else if (flag == 3) {
                                            delOutlet();
                                        } else if (flag == 4) {
                                            break;
                                        } else {
                                            System.out.println("Enter valid option");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Only can accept numeric values");
                                        break;
                                    }
                                }
                            } else if (flag == 2) {
                                while (true) {
                                    System.out.println("EMPLOYEE MENU");
                                    System.out.println("1.- Add");
                                    System.out.println("2.- Modify");
                                    System.out.println("3.- Drop");
                                    System.out.println("4.- Quit");
                                    System.out.println("Please inset one number: ");
                                    try {
                                        flag = sc.nextInt();
                                        if (flag == 1) {
                                            addEmployee();
                                        } else if (flag == 2) {
                                            updEmployee();
                                        } else if (flag == 3) {
                                            delEmployee();
                                        } else if (flag == 4) {
                                            break;
                                        } else {
                                            System.out.println("Enter valid option");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Only can accept numeric values");
                                        break;
                                    }
                                }
                            } else if (flag == 3) {
                                while (true) {
                                    System.out.println("CUSTOMER MENU");
                                    System.out.println("1.- Add");
                                    System.out.println("2.- Modify");
                                    System.out.println("3.- Drop");
                                    System.out.println("4.- Quit");
                                    System.out.println("Please inset one number: ");
                                    try {
                                        flag = sc.nextInt();
                                        if (flag == 1) {
                                            addCustomer();
                                        } else if (flag == 2) {
                                            updCustomer(); 
                                        } else if (flag == 3) {
                                            delCustomer();
                                        } else if (flag == 4) {
                                            break;
                                        } else {
                                            System.out.println("Enter valid option");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Only can accept numeric values");
                                        break;
                                    }
                                }
                            } else if (flag == 4) {
                                while (true) {
                                    System.out.println("PRODUCT MENU");
                                    System.out.println("1.- Add");
                                    System.out.println("2.- Modify");
                                    System.out.println("3.- Drop");
                                    System.out.println("4.- Quit");
                                    System.out.println("Please inset one number: ");
                                    try {
                                        flag = sc.nextInt();
                                        if (flag == 1) {
                                            addProduct();
                                        } else if (flag == 2) {
                                            updProduct();
                                        } else if (flag == 3) {
                                            delProduct();
                                        } else if (flag == 4) {
                                            break;
                                        } else {
                                            System.out.println("Enter valid option");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Only can accept numeric values");
                                        break;
                                    }
                                }
                            } else if (flag == 5) {
                                addInventory();
                            } else if (flag == 6) {
                                addReturn();
                            } else if (flag == 7) {
                                break;
                            } else {
                                System.out.println("Enter valid option");
                            }
                        } catch (Exception e) {
                            System.out.println("Only can accept numeric values");
                            break;
                        }
                    }
                } else if (flag == 3) {
                    while (true) {
                        System.out.println("REPORTS MENU");
                        System.out.println("1.- Produce yearly sales report for Oulet");
                        System.out.println("2.- Produce sales report for Employee");
                        System.out.println("3.- Produce the list of the top 10 selling items");
                        System.out.println("4.- Quit");
                        System.out.println("Please inset one number: ");
                        try {
                            flag = sc.nextInt();
                            if (flag == 1) {
                                thirdQuery();
                            } else if (flag == 2) {
                                fourthQuery();
                            } else if (flag == 3) {
                                fivethQuery();
                            } else if (flag == 4) {
                                break;
                            } else {
                                System.out.println("Enter valid option");
                            }
                        } catch (Exception e) {
                            System.out.println("Only can accept numeric values");
                            break;
                        }
                    }
                } else if (flag == 4) {
                    System.out.println("Bye...");
                    break;
                } else {
                    System.out.println("Enter valid option");
                }
            } catch (Exception e) {
                System.out.println("Only can accept numeric values");
                break;
            }
        }
        
    }

    static StoreDelegate del = new StoreDelegate();
    static Customer cusdt;
    static Employee empdt;
    static Inventory invdt;
    static Manager mandt;
    static Outlet outdt;
    static Product prodt;
    static Returns retdt;
    static Sales saldt;

    public static void processSale() {
        try {
            saldt = new Sales();
            Date date;
            Time time;

            System.out.println("Insert Outlet number:");
            saldt.setOUTLET_NUMBER(sc.nextInt());

            System.out.println("Insert Employee number:");
            saldt.setEMP_NUMBER(sc.nextInt());

            System.out.println("Insert Customer ID:");
            saldt.setCUSTOMER_ID(sc.nextInt());

            System.out.println("Insert Product Code:");
            saldt.setPRODUCT_CODE(sc.nextInt());

            System.out.println("Insert Sale date (yyyy-mm-dd):");
            date = Date.valueOf(sc.next());
            saldt.setSALE_DATE(date);

            System.out.println("Insert Sale time (hh:mm:ss):");
            time = Time.valueOf(sc.next());
            saldt.setSALE_TIME(time);

            System.out.println("Insert quantity:");
            saldt.setQuantity(sc.nextInt());

            del.createSALES(saldt);
            //OUTLET_NUMBER,EMP_NUMBER,CUSTOMER_ID,PRODUCT_CODE,SALE_DATE,SALE_TIME,quantity
        } catch (Exception ex) {
            Logger.getLogger(JDBC_CaseStudy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void processReturn() {
        try {
            retdt = new Returns();
            Date date;
            Time time;

            System.out.println("Insert Outlet number:");
            retdt.setOUTLET_NUMBER(sc.nextInt());

            System.out.println("Insert Product Code:");
            retdt.setPRODUCT_CODE(sc.nextInt());

            System.out.println("Insert Customer ID:");
            retdt.setCUSTOMER_ID(sc.nextInt());

            System.out.println("Insert Sale date (yyyy-mm-dd):");
            date = Date.valueOf(sc.next());
            retdt.setRETURN_DATE(date);

            System.out.println("Insert Sale time (hh:mm:ss):");
            time = Time.valueOf(sc.next());
            retdt.setRETURN_TIME(time);

            System.out.println("Insert quantity:");
            retdt.setQuantity(sc.nextInt());

            System.out.println("Insert reason (use\"_\"to_spaces):");
            retdt.setReason(sc.next());

            del.createRETURNS(retdt);
            //OUTLET_NUMBER,PRODUCT_CODE,CUSTOMER_ID,RETURN_DATE,RETURN_TIME,quantity,reason
        } catch (Exception ex) {
            Logger.getLogger(JDBC_CaseStudy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void firstQuery() {
        try {
            Sales salesdt = new Sales();
            System.out.println("Insert date 'yyyy-mm-dd':");
            Date date = Date.valueOf(sc.next());
            salesdt.setSALE_DATE(date);

            System.out.println("Insert Customer ID:");
            salesdt.setCUSTOMER_ID(sc.nextInt());

            del.firstQuery(salesdt).forEach((t) -> {
                System.out.println(t.getOUTLET_NUMBER()
                        + "\t" + t.getEMP_NUMBER() + "\t"
                        + t.getCUSTOMER_ID() + "\t" + t.getPRODUCT_CODE()
                        + "\t" + t.getSALE_DATE() + "\t" + t.getSALE_TIME()
                        + "\t" + t.getQuantity());
            });
            //OUTLET_NUMBER,EMP_NUMBER,CUSTOMER_ID,PRODUCT_CODE,SALE_DATE,SALE_TIME,quantity
        } catch (Exception ex) {
            Logger.getLogger(JDBC_CaseStudy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void secondQuery() {
        try {
            retdt = new Returns();

            System.out.println("Insert date 'yyyy-mm-dd':");
            Date date = Date.valueOf(sc.next());
            retdt.setRETURN_DATE(date);

            System.out.println("Insert Customer ID:");
            retdt.setCUSTOMER_ID(sc.nextInt());

            del.secondQuery(retdt).forEach((t) -> {
                System.out.println(t.getOUTLET_NUMBER()
                         + "\t" + t.getCUSTOMER_ID() + "\t" + t.getPRODUCT_CODE()
                        + "\t" + t.getRETURN_DATE()+ "\t" + t.getRETURN_DATE()
                        + "\t" + t.getQuantity() + "\t" + t.getReason());
            });
            //OUTLET_NUMBER,EMP_NUMBER,CUSTOMER_ID,PRODUCT_CODE,SALE_DATE,SALE_TIME,quantity
        } catch (Exception ex) {
            Logger.getLogger(JDBC_CaseStudy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void addOutlet(){
        try {
            outdt = new Outlet();
            System.out.println("Insert Outlet number:");
            outdt.setOUTLET_NUMBER(sc.nextInt());
            System.out.println("Insert address:");
            outdt.setAddress(sc.next());
            System.out.println("Insert city:");
            outdt.setCity(sc.next());
            System.out.println("Insert state:");
            outdt.setState(sc.next());
            System.out.println("Insert zip code:");
            outdt.setZip(sc.next());
            System.out.println("Insert phone number:");
            outdt.setPhone(sc.next());
            del.createOUTLET(outdt);
            //OUTLET_NUMBER,address,city,state,zip,phone
        } catch (Exception ex) {
            Logger.getLogger(JDBC_CaseStudy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void updOutlet(){
        try {
            outdt = new Outlet();
            System.out.println("Insert Outlet number to update:");
            outdt.setOUTLET_NUMBER(sc.nextInt());
            System.out.println("Insert new address:");
            outdt.setAddress(sc.next());
            System.out.println("Insert new city:");
            outdt.setCity(sc.next());
            System.out.println("Insert new state:");
            outdt.setState(sc.next());
            System.out.println("Insert new zip code:");
            outdt.setZip(sc.next());
            System.out.println("Insert new phone number:");
            outdt.setPhone(sc.next());
            del.updateOUTLET(outdt);
            //OUTLET_NUMBER,address,city,state,zip,phone
        } catch (Exception ex) {
            Logger.getLogger(JDBC_CaseStudy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void delOutlet(){
        try {
            outdt = new Outlet();
            System.out.println("Insert Outlet number to delete:");
            outdt.setOUTLET_NUMBER(sc.nextInt());
            del.deleteOUTLET(outdt);
            //OUTLET_NUMBER,address,city,state,zip,phone
        } catch (Exception ex) {
            Logger.getLogger(JDBC_CaseStudy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void addEmployee(){
        try {
            empdt = new Employee();
            System.out.println("Insert outlet number:");
            empdt.setOUTLET_NUMBER(sc.nextInt());
            System.out.println("Insert employee number:");
            empdt.setEMP_NUMBER(sc.nextInt());
            System.out.println("Insert employee name:");
            empdt.setEmp_name(sc.next());
            del.createEMPLOYEE(empdt);
            //OUTLET_NUMBER,EMP_NUMBER,emp_name
        } catch (Exception ex) {
            Logger.getLogger(JDBC_CaseStudy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void updEmployee(){
        try {
            empdt = new Employee();
            System.out.println("Insert employee number to modify:");
            empdt.setEMP_NUMBER(sc.nextInt());
            System.out.println("Insert new outlet number:");
            empdt.setOUTLET_NUMBER(sc.nextInt());
            
            System.out.println("Insert employee new name:");
            empdt.setEmp_name(sc.next());
            del.createEMPLOYEE(empdt);
            //Employee_NUMBER,address,city,state,zip,phone
        } catch (Exception ex) {
            Logger.getLogger(JDBC_CaseStudy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void delEmployee(){
        try {
            empdt = new Employee();
            System.out.println("Insert employee number to delete:");
            empdt.setEMP_NUMBER(sc.nextInt());
            del.deleteEMPLOYEE(empdt);
            //Employee_NUMBER,address,city,state,zip,phone
        } catch (Exception ex) {
            Logger.getLogger(JDBC_CaseStudy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void addCustomer(){
        try {
            cusdt = new Customer();
            System.out.println("Insert Customer ID:");
            cusdt.setCUSTOMER_ID(sc.nextInt());
            System.out.println("Insert Customer name:");
            cusdt.setCustomer_name(sc.next());
            System.out.println("Insert address:");
            cusdt.setAddress(sc.next());
            System.out.println("Insert city:");
            cusdt.setCity(sc.next());
            System.out.println("Insert state:");
            cusdt.setState(sc.next());
            System.out.println("Insert zip code:");
            cusdt.setZip(sc.next());
            System.out.println("Insert phone number:");
            cusdt.setPhone(sc.next());
            del.createCUSTOMER(cusdt);
            //CUSTOMER_ID,customer_name,address,city,state,zip,phone
        } catch (Exception ex) {
            Logger.getLogger(JDBC_CaseStudy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void updCustomer(){
        try {
            cusdt = new Customer();
            System.out.println("Insert Customer ID to update:");
            cusdt.setCUSTOMER_ID(sc.nextInt());
            System.out.println("Insert new Customer name:");
            cusdt.setCustomer_name(sc.next());
            System.out.println("Insert new address:");
            cusdt.setAddress(sc.next());
            System.out.println("Insert new city:");
            cusdt.setCity(sc.next());
            System.out.println("Insert new state:");
            cusdt.setState(sc.next());
            System.out.println("Insert new zip code:");
            cusdt.setZip(sc.next());
            System.out.println("Insert new phone number:");
            cusdt.setPhone(sc.next());
            del.updateCUSTOMER(cusdt);
            //Customer_NUMBER,address,city,state,zip,phone
        } catch (Exception ex) {
            Logger.getLogger(JDBC_CaseStudy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void delCustomer(){
        try {
            cusdt = new Customer();
            System.out.println("Insert Customer ID:");
            cusdt.setCUSTOMER_ID(sc.nextInt());
            del.deleteCUSTOMER(cusdt);
            //Customer_NUMBER,address,city,state,zip,phone
        } catch (Exception ex) {
            Logger.getLogger(JDBC_CaseStudy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void addProduct(){
        try {
            prodt = new Product();
            System.out.println("Insert Product code:");
            prodt.setPRODUCT_CODE(sc.nextInt());
            System.out.println("Insert artist:");
            prodt.setArtist(sc.next());
            System.out.println("Insert title:");
            prodt.setTitle(sc.next());
            System.out.println("Insert cost:");
            prodt.setCost(sc.nextDouble());
            System.out.println("Insert sale price:");
            prodt.setSale_price(sc.nextDouble());
            del.createPRODUCT(prodt);
            //PRODUCT_CODE,artist,title,cost,sale_price
        } catch (Exception ex) {
            Logger.getLogger(JDBC_CaseStudy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void updProduct(){
        try {
            prodt = new Product();
            System.out.println("Insert Product code to modify:");
            prodt.setPRODUCT_CODE(sc.nextInt());
            System.out.println("Insert new artist:");
            prodt.setArtist(sc.next());
            System.out.println("Insert new title:");
            prodt.setTitle(sc.next());
            System.out.println("Insert new cost:");
            prodt.setCost(sc.nextDouble());
            System.out.println("Insert new sale price:");
            prodt.setSale_price(sc.nextDouble());
            del.createPRODUCT(prodt);
            //Product_NUMBER,address,city,state,zip,phone
        } catch (Exception ex) {
            Logger.getLogger(JDBC_CaseStudy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void delProduct(){
        try {
            prodt = new Product();
            System.out.println("Insert Product code to modify:");
            prodt.setPRODUCT_CODE(sc.nextInt());
            del.deletePRODUCT(prodt);
            //Product_NUMBER,address,city,state,zip,phone
        } catch (Exception ex) {
            Logger.getLogger(JDBC_CaseStudy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void addInventory(){
        try {
            invdt = new Inventory();
            System.out.println("Insert Product code:");
            invdt.setPRODUCT_CODE(sc.nextInt());
            System.out.println("Insert Outlet number:");
            invdt.setOUTLET_NUMBER(sc.nextInt());
            System.out.println("Insert quantity:");
            invdt.setQuantity(sc.nextInt());
            del.createINVENTORY(invdt);
            //OUTLET_NUMBER,PRODUCT_CODE,quantity
        } catch (Exception ex) {
            Logger.getLogger(JDBC_CaseStudy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void addReturn(){
        try {
            retdt = new Returns();
            System.out.println("Insert Product code:");
            retdt.setPRODUCT_CODE(sc.nextInt());
            System.out.println("Insert Outlet number:");
            retdt.setOUTLET_NUMBER(sc.nextInt());
            System.out.println("Insert Customer ID:");
            retdt.setCUSTOMER_ID(sc.nextInt());
            System.out.println("Insert Return date (yyyy-mm-dd):");
            Date date = Date.valueOf(sc.next());
            retdt.setRETURN_DATE(date);
            System.out.println("Insert Return time (hh:mm:ss):");
            Time time = Time.valueOf(sc.next());
            retdt.setRETURN_TIME(time);
            System.out.println("Insert quantity:");
            retdt.setQuantity(sc.nextInt());
            System.out.println("Insert reason:");
            retdt.setReason(sc.next());
            del.createRETURNS(retdt);
            //OUTLET_NUMBER,PRODUCT_CODE,CUSTOMER_ID,RETURN_DATE,RETURN_TIME,quantity,reason
        } catch (Exception ex) {
            Logger.getLogger(JDBC_CaseStudy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void thirdQuery() {
        try {
            Sales salesdt = new Sales();

            del.thirdQuery(salesdt).forEach((t) -> {
                System.out.println(
                        "\t" + t.getSALE_DATE().toLocalDate().getYear()
                        + "\t" + t.getQuantity());
            });
            //OUTLET_NUMBER,EMP_NUMBER,CUSTOMER_ID,PRODUCT_CODE,SALE_DATE,SALE_TIME,quantity
        } catch (Exception ex) {
            Logger.getLogger(JDBC_CaseStudy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void fourthQuery() {
        try {
            Sales salesdt = new Sales();

            del.fourthQuery(salesdt).forEach((t) -> {
                System.out.println("Total sales: " + t.getQuantity() + "\tEmployee number:" + t.getEMP_NUMBER());
            });
            //OUTLET_NUMBER,EMP_NUMBER,CUSTOMER_ID,PRODUCT_CODE,SALE_DATE,SALE_TIME,quantity
        } catch (Exception ex) {
            Logger.getLogger(JDBC_CaseStudy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void fivethQuery() {
        try {
            Sales salesdt = new Sales();

            del.fivethQuery(salesdt).forEach((t) -> {
                System.out.println("Total sales: " + t.getQuantity() + "\tProduct Code:" + t.getPRODUCT_CODE());
            });
            //OUTLET_NUMBER,EMP_NUMBER,CUSTOMER_ID,PRODUCT_CODE,SALE_DATE,SALE_TIME,quantity
        } catch (Exception ex) {
            Logger.getLogger(JDBC_CaseStudy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}