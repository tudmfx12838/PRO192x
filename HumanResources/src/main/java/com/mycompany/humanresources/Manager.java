/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.humanresources;

/**
 *
 * @author Dang Minh Tu
 */
public class Manager extends Staff implements ICalculator{
    private String positionManager;
    private double salary;
    
    public Manager(String staffId, String name, int age,
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
        this.salary = calculateSalary();
    }

    public String getPositionManager(){
        return positionManager;
    }
    
    public void setPositionManager(String positionManager){
        this.positionManager =  positionManager;
    }
    
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

    public double getSalary() {
        return salary;
    }
    
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
