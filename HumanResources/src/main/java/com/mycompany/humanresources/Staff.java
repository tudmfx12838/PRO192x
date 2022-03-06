/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.humanresources;

/**
 *
 * @author Dang Minh Tu
 */
public abstract class Staff {
    protected String staffId;
    protected String name;
    protected int age;
    protected double salaryScale;
    protected String startDate;
    protected String department;
    protected int annualLeave;
    protected String position;
    
    public abstract void displayInformation();

    public String getStaffId(){
        return staffId;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public double getSalaryScale(){
        return salaryScale;
    }

    public String getStartDate(){
        return startDate;
    }

    public String getDepartment(){
        return department;
    }

    public int getAnnualLeave(){
        return annualLeave;
    }

    public String getPosition(){
        return position;
    }    
}
