/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author luigi
 */
public class Inventory {
    private int OUTLET_NUMBER;
    private int PRODUCT_CODE;
    private int quantity;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
