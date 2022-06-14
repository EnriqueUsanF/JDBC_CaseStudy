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
public class Employee {
    private int OUTLET_NUMBER;
    private int EMP_NUMBER;
    private String emp_name;

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

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }
}
