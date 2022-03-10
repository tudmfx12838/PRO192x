/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.humanresources;

/**
 *
 * @author Dang Minh Tu
 */

/**
 * The Staff is a abstract example to staff documentation
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
    
    /**
     * An abstract method as displayInformation() sepcify showing staff's information
     */
    public abstract void displayInformation();

    /**
     * Method getStaffId()
     * @return staff's id
     */
    public String getStaffId(){
        return staffId;
    }

    /**
     * Method getName()
     * @return staff's name
     */
    public String getName(){
        return name;
    }

    /**
     * Method getAge()
     * @return staff's age
     */
    public int getAge(){
        return age;
    }

    /**
     * Method salaryScale()
     * @return staff's salary scale
     */
    public double getSalaryScale(){
        return salaryScale;
    }

    /**
     * Method getStartDate()
     * @return staff's start date
     */
    public String getStartDate(){
        return startDate;
    }

    /**
     * Method getDepartment()
     * @return staff's department
     */
    public String getDepartment(){
        return department;
    }

    /**
     * Method getAnnualLeave()
     * @return staff's annual leave
     */
    public int getAnnualLeave(){
        return annualLeave;
    }

    /**
     * Method getPosition()
     * @return staff's position
     */
    public String getPosition(){
        return position;
    }    
}
