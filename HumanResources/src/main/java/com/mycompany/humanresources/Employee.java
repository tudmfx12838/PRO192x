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
 * The Employee is employee's documentation
 * @inheritance from abstract class Staff
 * @implements  from interface ICalculator
 */
public class Employee extends Staff implements ICalculator {

    private int overTime;
    private double salary;

    // public Employee(){}

    /**
    * Constructor initialize manager's data
    * @param staffId            is staff's id
    * @param name               is staff's name
    * @param age                is staff's age
    * @param salaryScale        is staff's salaryScale
    * @param startDate          is staff's start date
    * @param department         is staff's department
    * @param annualLeave        is staff's annual leave
    * @param overTime           is staff's over working time
    */
    public Employee(String staffId, String name, int age,
            double salaryScale, String startDate, String department,
            int annualLeave, int overTime) {
        this.staffId = staffId;
        this.name = name;
        this.age = age;
        this.salaryScale = salaryScale;
        this.startDate = startDate;
        this.department = department;
        this.annualLeave = annualLeave;
        this.position = "staff";
        this.overTime = overTime;

        this.salary = calculateSalary();
    }
    
    /**
     * Method setOverTime()
     * @param overTime   is staff's over working time
     * Inplement setting a over working time to staff's over working time
     */
    public void setOverTime(int overTime){
        this.overTime = overTime;
    }
    
    /**
     * Method getOverTime()
     * @return staff's over working time
     */
    public int getOverTime(){
        return overTime;
    }

    /**
     * Method getSalary()
     * @return staff's salary
     */
    public double getSalary() {
        return salary;
    }

    /**
	 * Method calculateSalary() will calculate employee's salary
     * @return employee's salary
	 */
    @Override
    public double calculateSalary() {
        return salaryScale*EMPLOYEE_SALARY + overTime*OVERTIME_SALARY;
    }

    /**
	 * Method displayInformation() will show manager's information
	 */
    @Override
    public void displayInformation() {
        System.out.println("Ma so NV:      " + staffId);
        System.out.println("Ten:           " + name);
        System.out.println("Tuoi:          " + age);
        System.out.println("He so luong:   " + salaryScale);
        System.out.println("Ngay bat dau:  " + startDate);
        System.out.println("Bo phan:       " + department);
        System.out.println("Ngay phep:     " + annualLeave);
        System.out.println("Chuc vu:       " + position);
        System.out.println("Gio lam them:  " + overTime);
        System.out.println();
    }
}
