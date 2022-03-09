/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.humanresources;

/**
 *
 * @author Dang Minh Tu
 */
public class Employee extends Staff implements ICalculator {

    private int overTime;
    private double salary;

    public Employee(){}

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
    
    public void setOverTime(int overTime){
        this.overTime = overTime;
    }
    
    public int getOverTime(){
        return overTime;
    }

    
    public double getSalary() {
        return salary;
    }

    /**
	 * {@interface}
	 * This inserts the docs from the ICalculator Interface.
	 * Implement staff's salary calculation.
	 */
    @Override
    public double calculateSalary() {
        return salaryScale*EMPLOYEE_SALARY + overTime*OVERTIME_SALARY;
    }

    /**
	 * {@inheritDoc}
	 * This inserts the docs from the overridden method above.
	 * Implementation-specific docuementation can then be added here.
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
