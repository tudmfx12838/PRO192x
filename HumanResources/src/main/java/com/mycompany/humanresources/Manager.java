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
 * The Manager is manager's documentation
 * @inheritance from abstract class Staff
 * @implements  from interface ICalculator
 */
public class Manager extends Staff implements ICalculator{
    private String positionManager;
    private double salary;

    // public Manager(){}
    
    /**
    * Constructor initialize manager's data
    * @param staffId            is staff's id
    * @param name               is staff's name
    * @param age                is staff's age
    * @param salaryScale        is staff's salaryScale
    * @param startDate          is staff's start date
    * @param department         is staff's department
    * @param annualLeave        is staff's annual leave
    * @param positionManager    is staff's position
    */
    public Manager(String staffId, String name, int age,
        //Initialize staff's information
        double salaryScale, String startDate, String department,
        int annualLeave, String positionManager) {
        this.staffId = staffId;
        this.name = name;
        this.age = age;
        this.salaryScale = salaryScale;
        this.startDate = startDate;
        this.department = department;
        this.annualLeave = annualLeave;
        this.position = "manager";
        this.positionManager = positionManager;

        //Calculate salary and store to salary variable
        this.salary = calculateSalary();
    }

    /**
     * Method getPositionManager()
     * @return staff's position
     */
    public String getPositionManager(){
        return positionManager;
    }
    
    /**
     * Method setPositionManager()
     * @param positionManager   is manager's position
     * Inplement setting a posion to manager's position
     */
    public void setPositionManager(String positionManager){
        this.positionManager =  positionManager;
    }
    
    /**
	 * Method calculateSalary() will calculate manager's salary
     * @return manager's salary
	 */
    @Override
    public double calculateSalary() {
        double bonus = 0;
        if(positionManager.equals("Business Leader")){
            bonus = BUSINESSLEADER_SALARY;
        }else if(positionManager.equals("Project Leader")){
            bonus = PROJECTLEADER_SALARY;
        }else if(positionManager.equals("Technical Leader")){
            bonus = TECHNICAL_SALARY;
        }else{
            bonus = 0;
        }

        return salaryScale*MANAGER_SALARY + bonus;
    }

    /**
     * Method getSalary()
     * @return staff's salary
     */
    public double getSalary() {
        return salary;
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
        System.out.println("Chuc danh:     " + positionManager);
        System.out.println();
    }
}
