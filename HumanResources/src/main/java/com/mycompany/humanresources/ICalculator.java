/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.humanresources;

/**
 *
 * @author Dang Minh Tu
 */
public interface ICalculator {
    public static final int EMPLOYEE_SALARY = 3000000;
    public static final int OVERTIME_SALARY = 200000;
    public static final int MANAGER_SALARY = 5000000;
    public static final int BUSINESSLEADER_SALARY = 8000000;
    public static final int PROJECTLEADER_SALARY = 5000000;
    public static final int TECHNICAL_SALARY = 6000000;
    
    public abstract double calculateSalary();
}
