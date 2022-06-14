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
public class Returns {
    private int OUTLET_NUMBER;
    private int PRODUCT_CODE;
    private int CUSTOMER_ID;
    private Date RETURN_DATE;
    private Time RETURN_TIME;
    private int quantity;
    private String reason;

    public int getOUTLET_NUMBER() {
        return OUTLET_NUMBER;
    }

    public void setOUTLET_NUMBER(int OUTLET_NUMBER) {
        this.OUTLET_NUMBER = OUTLET_NUMBER;
    }

    public int getPRODUCT_CODE() {
        return PRODUCT_CODE;
    }

    public void setPRODUCT_CODE(int PRODUCT_CODE) {
        this.PRODUCT_CODE = PRODUCT_CODE;
    }

    public int getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public void setCUSTOMER_ID(int CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public Date getRETURN_DATE() {
        return RETURN_DATE;
    }

    public void setRETURN_DATE(Date RETURN_DATE) {
        this.RETURN_DATE = RETURN_DATE;
    }

    public Time getRETURN_TIME() {
        return RETURN_TIME;
    }

    public void setRETURN_TIME(Time RETURN_TIME) {
        this.RETURN_TIME = RETURN_TIME;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
