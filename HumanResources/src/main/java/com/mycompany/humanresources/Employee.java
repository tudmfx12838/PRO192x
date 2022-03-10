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
    public void displayInformation(int option) {

        //Option as 1 to show all of staff's informantion
        if(option == 1){

            System.out.print("|" + fillSpace(3) + this.getStaffId() + fillSpace(3) + "|");
            System.out.print(fillSpace(1) + this.getName() + fillSpace(24 - 1 - this.getName().length()) + "|");
            System.out.print(fillSpace(1) + this.getAge() + fillSpace(6 - 1 - Integer.toString(this.getAge()).length()) + "|");
            System.out.print(fillSpace(1) + this.getSalaryScale() + fillSpace(13 - 1 - Double.toString(this.getSalaryScale()).length()) + "|");
            System.out.print(fillSpace(1) + this.getAnnualLeave() + fillSpace(11 - 1 - Integer.toString(this.getAnnualLeave()).length()) + "|");
            System.out.print(fillSpace(1) + this.getDepartment() + fillSpace(13 -1 - this.getDepartment().length()) + "|");
            System.out.print(fillSpace(1) + this.getPosition() + fillSpace(11 - 1 - this.getPosition().length()) + "|");
            System.out.print(fillSpace(19) + "|");
            System.out.print(fillSpace(1) + this.getOverTime() + fillSpace(16 - 1 - Integer.toString(this.getOverTime()).length()) + "|");
            System.out.print(fillSpace(1) + this.getStartDate() + fillSpace(11 - this.getStartDate().length()) + "|\n"); 
        }
        //Option as 2 to show sort staff's informantion
        else if(option == 2){

            System.out.print("|" + fillSpace(3) + this.getStaffId() + fillSpace(3) + "|");
            System.out.print(fillSpace(1) + this.getName() + fillSpace(28 - 1 - this.getName().length()) + "|");
            System.out.print(fillSpace(1) + this.getDepartment() + fillSpace(17 -1 - this.getDepartment().length()) + "|");
            System.out.print(fillSpace(1) + this.getPosition() + fillSpace(15 - 1 - this.getPosition().length()) + "|");
            System.out.print(fillSpace(23) + "|"); 
            System.out.print(fillSpace(1) + this.getStartDate() + fillSpace(13 - this.getStartDate().length()) + "|\n"); 
        }
        //Option as 3 to show sort staff's informantion and staff's salary
        else if(option == 3){

            System.out.print("|" + fillSpace(3) + this.getStaffId() + fillSpace(3) + "|");
            System.out.print(fillSpace(1) + this.getName() + fillSpace(28 - 1 - this.getName().length()) + "|");
            System.out.print(fillSpace(1) + this.getDepartment() + fillSpace(17 -1 - this.getDepartment().length()) + "|");
            System.out.print(fillSpace(1) + this.getPosition() + fillSpace(15 - 1 - this.getPosition().length()) + "|");
            System.out.print(fillSpace(1) + (int)this.getSalary() + fillSpace(16 - Integer.toString((int)this.getSalary()).length()) + "vnd   |\n");
        }
    }

    /**
     * The method fillSpace() implement fill space into a string
     * @param sizeSpace       is number of space that want to fill
     */
    public String fillSpace(int sizeSpace){
        String space = "";
        for(int i = 0; i < sizeSpace; i++){
            space += " ";
        }
        return space;
    }
}
