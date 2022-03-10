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
 * The Department is department's documentation
 */
public class Department {
    private String departmentId;
    private String departmentName;
    private int NumOfStaff;
    
    /**
    * Constructor initialize manager's data
    * @param departmentId            is department's id
    * @param departmentName          is department's name
    * @param NumOfStaff              is department's number of staff
    */
    public Department(String departmentId, String departmentName, int NumOfStaff){
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.NumOfStaff = NumOfStaff;
    }
    
    /**
     * Method setDepartmentId()
     * @param departmentId   is department's id
     * Inplement setting a id to department's id
     */
    public void setDepartmentId(String departmentId){
        this.departmentId = departmentId;
    }
    
    /**
     * Method getDepartmentId()
     * @return department's id
     */
    public String getDepartmentId(){
        return departmentId;
    }
    
    /**
     * Method setDepartmentName()
     * @param departmentName   is department's name
     * Inplement setting a name to department's name
     */
    public void setDepartmentName(String departmentName){
        this.departmentName = departmentName;
    }
    
    /**
     * Method getDepartmentName()
     * @return department's name
     */
    public String getDepartmentName(){
        return departmentName;
    }
    
    /**
     * Method setDepartmentName()
     * @param NumOfStaff   is department's number of staff
     * Inplement setting a number of staff to department's number of staff
     */
    public void setNumOfStaff(int NumOfStaff){
        this.NumOfStaff = NumOfStaff;
    }
    
    /**
     * Method getNumOfStaff()
     * @return department's number of staff
     */
    public int getNumOfStaff(){
        return NumOfStaff;
    }
    
    /**
     * Method toString()
     * @return department's information consist of id, name and number of staff
     */
    public String toString(){
        String departmentInfo = "|" + fillSpace(2) + this.getDepartmentId() + fillSpace(8) + "|" +
                    fillSpace(2) + this.getDepartmentName() + fillSpace(20 - 1 - this.getDepartmentName().length()) + "|"+
                    fillSpace(2) + this.getNumOfStaff() + fillSpace(19 - Integer.toString(this.getNumOfStaff()).length()) + "|";
        return departmentInfo;
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
