/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author luigi
 */
public class Sales {
    private int OUTLET_NUMBER;
    private int EMP_NUMBER;
    private int CUSTOMER_ID;
    private int PRODUCT_CODE;
    private Date SALE_DATE;
    private Time SALE_TIME;
    private int quantity;

    public int getOUTLET_NUMBER() {
        return OUTLET_NUMBER;
    }

    public void setOUTLET_NUMBER(int OUTLET_NUMBER) {
        this.OUTLET_NUMBER = OUTLET_NUMBER;
    }

    public int getEMP_NUMBER() {
        return EMP_NUMBER;
    }

    public void setEMP_NUMBER(int EMP_NUMBER) {
        this.EMP_NUMBER = EMP_NUMBER;
    }

    public int getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public void setCUSTOMER_ID(int CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public int getPRODUCT_CODE() {
        return PRODUCT_CODE;
    }

    public void setPRODUCT_CODE(int PRODUCT_CODE) {
        this.PRODUCT_CODE = PRODUCT_CODE;
    }

    public Date getSALE_DATE() {
        return SALE_DATE;
    }

    public void setSALE_DATE(Date SALE_DATE) {
        this.SALE_DATE = SALE_DATE;
    }

    public Time getSALE_TIME() {
        return SALE_TIME;
    }

    public void setSALE_TIME(Time SALE_TIME) {
        this.SALE_TIME = SALE_TIME;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
