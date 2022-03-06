/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.humanresources;

/**
 *
 * @author Dang Minh Tu
 */
public class Department {
    private String departmentId;
    private String departmentName;
    private int NumOfStaff;
    
    public Department(String departmentId, String departmentName, int NumOfStaff){
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.NumOfStaff = NumOfStaff;
    }
    
    public void setDepartmentId(String departmentId){
        this.departmentId = departmentId;
    }
    
    public String getDepartmentId(){
        return departmentId;
    }
    
    public void setDepartmentName(String departmentName){
        this.departmentName = departmentName;
    }
    
    public String getDepartmentName(){
        return departmentName;
    }
    
    public void setNumOfStaff(int NumOfStaff){
        this.NumOfStaff = NumOfStaff;
    }
    
    public int getNumOfStaff(){
        return NumOfStaff;
    }
    
    public String toString(){
        return "Department Id: " + departmentId + ", Department name: "
                + departmentName + ", Number of staff: " + NumOfStaff;
    }
}
