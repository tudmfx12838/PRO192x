/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.humanresources;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Dang Minh Tu
 */
public class HumanResources {
    
    /**
     * The method initStaffList() init the sample to staff list for testing
     */
    public static void initStaffList(ArrayList<Staff> staffs){
        // staffs.add(new Manager(staffId, name, age, salaryScale, startDate, department, annualLeave, positionManager));
        //  Business Leader = 1, Project Leader = 2, Technical Leader = 3? 
        staffs.add(new Manager("001", "Nguyen Van A", 45, 3.5, "01/01/2000", "Finance", 20, "Business Leader" ));
        staffs.add(new Employee("002", "Nguyen Van B", 30, 2.1, "01/01/2005", "Finance", 15, 20 ));
        staffs.add(new Manager("003", "Nguyen Van C", 50, 4.1, "01/01/2000", "Sale", 20, "Business Leader" ));
        staffs.add(new Employee("004", "Nguyen Van D", 20, 1.1, "01/01/2019", "Sale", 15, 21 ));
        staffs.add(new Manager("005", "Nguyen Van F", 35, 3.1, "01/01/2006", "Marketing", 20, "Project Leader" ));
        staffs.add(new Employee("006", "Nguyen Van G", 20, 2.1, "01/01/2018", "Marketing", 15, 22 ));
        staffs.add(new Employee("007", "Nguyen Van H", 27, 2.1, "01/01/2010", "IT", 15, 23 ));
        staffs.add(new Employee("009", "Nguyen Van I", 22, 2.1, "01/01/2020", "IT", 15, 18 ));
        staffs.add(new Employee("010", "Nguyen Van K", 32, 3.1, "01/01/2010", "IT", 15, 17 ));
        staffs.add(new Manager("011", "Nguyen Van L", 36, 3.1, "01/01/2009", "IT", 20, "Technical Leader" ));
        staffs.add(new Employee("012", "Nguyen Van M", 25, 2.1, "01/01/2021", "IT", 15, 16 ));
        staffs.add(new Employee("022", "Tran Trung C", 26, 2.2, "01/11/2021", "IT", 14, 15 ));
    }

    /**
     * Software is running if runApp is true and stop if it's false.
     */
    public static boolean runApp = true;
    
    public static void main(String[] args) {
        //Instance an object form class Scanner to get user's input
        Scanner input = new Scanner(System.in);
        //Declare ArrayList as staffs that's instance form abstract class Staff
        ArrayList<Staff> staffs = new ArrayList<>();
        //Instance an object form class Department
        Department departments[] = new Department[4];

        //init staff list
        initStaffList(staffs);

        //update department's number of staff
        updateDepartmentList(staffs, departments);

        while(runApp){
            //Call method begin()
            begin();

            //Call method listFeature()
            listFeature();

            //Call method chooseFeature()
            chooseFeature(input, staffs, departments);
        }

    }

    /**
     * The method begin() show software introduction
     */
    public static void begin(){
        System.out.println("Ung dung quan ly nguon nhan luc 1.0");
        System.out.println();
    }
    
    /**
     * The method listFeature() show software's list feature
     */
    public static void listFeature(){
        System.out.println("Chuc nang cua ung dung gom: ");
        System.out.println();
        System.out.println("1. Hien thi danh sach nhan vien hien co trong cong ty");
        System.out.println("2. Hien thi cac bo phan trong cong ty");
        System.out.println("3. Hien thi cac nhan vien theo tung bo phan");
        System.out.println("4. Them nhan vien moi vao cong ty ");
        System.out.println("5. Tim kiem thong tin nhan vien theo ten hoan ma nhan vien");
        System.out.println("6. Hien thi bang luong cua nhan vien toan cong ty");
        System.out.println("7. Hien thi bang luong cua nhan vien theo thu tu giam dan hoac tang dan");
        System.out.println("8. Xoa nhan vien");
        System.out.println("0. Thoat ung dung");
        System.out.println();
    }

    /**
     * The method chooseFeature() implement software's feature following user's input
     * @param input       use object Scanner to get user's input
     * @param staffs      is staff list
     * @param departments      is department list
     * Description: Some of software will be called if user's input:
     * is 0 : Exit
     * is 1 : Show staff list
     * is 2 : Show department list
     * is 3 : Show staff list for each department
     * is 4 : Add new staff
     * is 5 : Find a staff in staff list
     * is 6 : Show staff's salary of list
     * is 7 : Show staff's sorting salary of list
     * is 8 : Remove staff by staff's id
     */
    public static void chooseFeature(Scanner input, ArrayList<Staff> staffs, Department departments[]){
        byte choseFeature = 0;

        //Require input a software feature form 0 to 8, if it's different form range, require input agian
        do{
            System.out.print("Nhap tinh nang de thuc hien (0 - 8)? ");
            choseFeature = input.nextByte();
        }while(choseFeature < 0 || choseFeature > 8);

        if(choseFeature == 0){
            //Set runApp to false to Exit program
            runApp = false;

            //Say goodbye
            System.out.println("Hen gap lai");

        }else if(choseFeature == 1){
            //Call method showStaffList() to show staff list
            showStaffList(input, staffs);

        }else if(choseFeature == 2){
            //Call method showDepartmentList() to show department list
            showDepartmentList(input, departments);

        }else if(choseFeature == 3){
            //Call method showDepartmentStaffList() to show staff list for each department
            showDepartmentStaffList(input, staffs);

        }else if(choseFeature == 4){
            //Call method addStaff() to add new staff to staff list
            addStaff(input, staffs, departments);

        }else if(choseFeature == 5){
            //Call method showSearchStaff() to search staff
            showSearchStaff(input, staffs);
            
        }else if(choseFeature == 6){
            //Call method showStaffSalaryList() to show staff's salary list
            showStaffSalaryList(input, staffs);

        }else if(choseFeature == 7){
            //Call method showSortStaffSalaryList() to show staff's sorting salary list
            showSortStaffSalaryList(input, staffs);

        }else if(choseFeature == 8){
            //Call method removeStaffByStaffId() to remove staff by staff'id
            removeStaffByStaffId(input, staffs, departments);

        }

        System.out.println();
    }

    /**
     * The method updateDepartmentList() implement update department's number of staff
     * @param staffs      is staff list
     * @param departments      is department list
     */
    public static void updateDepartmentList(ArrayList<Staff> staffs, Department department[]){
        int countStaffFinance = 0;
        int countStaffSale = 0;
        int countStaffMarketing = 0;
        int countStaffIT = 0;

        //Count number of staff from staff list following each department's name
        for(int i = 0; i < staffs.size(); i++){
            if(staffs.get(i).department.equals("Finance")){
                countStaffFinance++;
            }else if(staffs.get(i).department.equals("Sale")){
                countStaffSale++;
            }else if(staffs.get(i).department.equals("Marketing")){
                countStaffMarketing++;
            }else if(staffs.get(i).department.equals("IT")){
                countStaffIT++;
            }
        }

        //Update number of staff for each department
        department[0] = new Department("F001", "Finance", countStaffFinance);
        department[1] = new Department("S002", "Sale", countStaffSale);
        department[2] = new Department("M003", "Marketing", countStaffMarketing);
        department[3] = new Department("I001", "IT", countStaffIT);
    }

    /**
     * The method updateNumOfStaffDepartment() implement update department's number of staff
     * @param departments      is department list
     * @param departmemnt      is department's name
     */
    public static void updateNumOfStaffDepartment(Department departments[], String department){
        //Update number of staff in department list following department's name
        for(int i = 0; i < departments.length; i++){
            if(departments[i].getDepartmentName().equals(department)){
                departments[i].setNumOfStaff(departments[i].getNumOfStaff() + 1);
            }
        }

    }

    /**
     * The method checkExistedStaffId() implement checking  staff'id exist or not in staff list
     * @param staffs            is staff list
     * @param inputStaffId      is staff's id
     * @return return true if inputed staff's id is existing and return false if it's not exist.
     */
    public static boolean checkExistedStaffId(ArrayList<Staff> staffs, String inputStaffId){
        boolean checkResult = false;

        for(Staff staff : staffs){
            if(staff.getStaffId().equals(inputStaffId)){
                checkResult = true;
                break;
            }
        }
        return checkResult;
    }

    /**
     * The method addStaff() implement adding new staff to staff list and update number of staff in department
     * @param input             use object Scanner to get user's input
     * @param staffs            is staff list
     * @param departments       is department list
     */
    public static void addStaff(Scanner input, ArrayList<Staff> staffs, Department departments[]){
        byte staffPosition = 0;
        String staffId = "";
        String name = "";
        int age = 0;
        double salaryScale = 0.0;
        String startDate = "";
        byte choseDepartment = 0;
        String department = "";
        int annualLeave = 0;
        int overTime = 0;
        byte chosePosition = 0;
        String positionManager = "";

        boolean runAddStaff = true;
        byte nextAddStaff = 0;

        Employee employee;
        Manager manager;

        //if runAddStaff is true, add staff feature always run. if it's false, it will be stopped and back to main menu.
        while(runAddStaff){
        
            staffPosition = 0;
            staffId = "";
            name = "";
            age = 0;
            salaryScale = 0.0;
            startDate = "";
            department = "";
            annualLeave = 0;
            overTime = 0;
            chosePosition = 0;
            positionManager = "";

            System.out.println("Them nhan vien moi vao cong ty ");
            /** 
             * Require input staff position with 2 options, if it different from, require input again
             *staffPosition is 1 that's mean, manager's data is being inputted
             *staffPosition is 2 that's mean, employee's data is being inputted
            */
            do{
                System.out.print("Nhap vi tri nhan vien: Quan ly = 1, Nhan vien = 2? ");
                staffPosition = input.nextByte();
            }while(staffPosition < 1 ||  staffPosition > 2);
            
            
            //if input's data for employee, require input manager position with 3 options, if it different from, require input again
            if(staffPosition == 1){
                do{
                    System.out.print("Nhap vi tri Quan ly: Business Leader = 1, Project Leader = 2, Technical Leader = 3? ");
                    chosePosition = input.nextByte();
                }while(chosePosition < 1 ||  chosePosition > 3);
    
                if(chosePosition == 1){
                    positionManager = "Business Leader";
                }else if(chosePosition == 2){
                    positionManager = "Project Leader";
                }else if(chosePosition == 3){
                    positionManager = "Technical Leader";
                }
            }
            
            //Require input staff id, if it is existing in staff list, require input again
            do{
                System.out.print("Nhap ma so nhan vien?                ");
                staffId = input.next();
                input.nextLine();
                
                //Call method checkExistedStaffId() to check staff's id is exist or not in staff list
                //If it's existing, inform user and require input again
                if(checkExistedStaffId(staffs,staffId)){
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("!!! Ma so nhan vien da ton tai !!!");
                    System.out.println("!!! Xin nhap ma nhan vien moi  !!!");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                }
            }while(checkExistedStaffId(staffs,staffId));

            //Require input staff's name
            System.out.print("Nhap ten nhan vien?                  ");
            name = input.nextLine();
            
            //Require input staff's age, if age less than 18, inform user and require input again
            do{
                System.out.print("Nhap tuoi nhan vien(tuoi >= 18)?      ");
                age = input.nextInt();
                if(age < 18){
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("!!! Nhan vien chua du toi di lam !!!");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                }
            }while(age < 18);

            //Require input staff's age, if age less than 18, inform user and require input again
            do{
                System.out.print("Nhap he so luong(hsl >= 1)?          ");
                salaryScale = input.nextDouble();
                if(salaryScale < 1.0){
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("!!! He so luong phai >= 1 !!!");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                }
            }while(salaryScale < 1.0);
            
            //Require input staff's started date.
            System.out.print("Nhap ngay vao cong ty(dd/mm/yyyy)?   ");
            startDate = input.next();

            //Require input staff's deparment with with 4 options, if it different from range, require input again
            do{
                System.out.print("Nhap phong ban: \nFinance=1, Sale=2, Marketing=3, IT=4? ");
                choseDepartment = input.nextByte();
                if(choseDepartment == 1){
                    department = "Finance";
                }else if(choseDepartment == 2){
                    department = "Sale";
                }else if(choseDepartment == 3){
                    department = "Marketing";
                }else if(choseDepartment == 4){
                    department = "IT";
                }
            }while(choseDepartment < 1 || choseDepartment > 4);

            //Require input staff's annual leave date
            System.out.print("Nhap ngay phep?                      ");
            annualLeave = input.nextInt();
            
            //if input's data for employee, more require input employee over working time
            if(staffPosition == 2){
                do{
                    System.out.print("Nhap so gio da lam them?             ");
                    overTime = input.nextInt();
                }while(overTime < 0);
            }
            
            //Call method updateNumOfStaffDepartment() to update number of staff following inputed department name
            updateNumOfStaffDepartment(departments, department);
            System.out.println();
            
            /** 
             *staffPosition is 1 that's mean, manager's data is being inputted. Update manager's data to staff list
             *staffPosition is 2 that's mean, employee's data is being inputted. Update employee's data to staff list
            */
            if(staffPosition == 1){
                // System.out.format("%s  %s  %d  %f  %s  %s  %d  %s", staffId, name, age, salaryScale, startDate, department, annualLeave, positionManager);
                staffs.add(new Manager(staffId, name, age, salaryScale, startDate, department, annualLeave, positionManager));
                System.out.println("Them nhan vien thanh cong");
                manager = (Manager)staffs.get(staffs.size() - 1);
                manager.displayInformation();
            }else if(staffPosition == 2){
                // System.out.format("%s  %s  %d  %f  %s  %s  %d  %d", staffId, name, age, salaryScale, startDate, department, annualLeave, overTime);
                staffs.add(new Employee(staffId, name, age, salaryScale, startDate, department, annualLeave, overTime));
                System.out.println("Them nhan vien thanh cong");
                employee = (Employee)staffs.get(staffs.size() - 1);
                employee.displayInformation();
            }

            //Ask user for continue inputing or back to main menu
            do{
                System.out.print("Nhap: Tiep tuc them = 1, Quay ve Menu chinh = 0? ");
                nextAddStaff = input.nextByte();
                if(nextAddStaff == 0){
                    runAddStaff = false;
                }else if(nextAddStaff == 1){
                    runAddStaff = true;
                }
            }while(nextAddStaff < 0 ||  nextAddStaff > 1);
            
            System.out.println();
        }
    }

    /**
     * The method showStaffList() implement showing staff list
     * @param input       use object Scanner to get user's input
     * @param staffs      is staff list
     */
    public static void showStaffList(Scanner input, ArrayList<Staff> staffs){
        Employee employee;
        Manager manager;
        boolean runShow = true;
        byte backMenu = 0;

        while(runShow){

            //Show sheet structure
            System.out.println("=================================================================================================================");
            System.out.println("|  Ma NV  |           Ten NV           |    Phong ban    |    Chuc vu    |       Chuc danh       |    Ngay vao  |");
            System.out.println("=================================================================================================================");

            for(int i = 0; i < staffs.size(); i++){
                //if it's data of manager, show manager's data from staff list
                if(staffs.get(i) instanceof Manager){
                    manager = (Manager)staffs.get(i);
                        
                    System.out.print("|" + fillSpace(3) + manager.getStaffId() + fillSpace(3) + "|");
                    System.out.print(fillSpace(1) + manager.getName() + fillSpace(28 - 1 - manager.getName().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getDepartment() + fillSpace(17 -1 - manager.getDepartment().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getPosition() + fillSpace(15 - 1 - manager.getPosition().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getPositionManager() + fillSpace(23 - 1 - manager.getPositionManager().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getStartDate() + fillSpace(13 - manager.getStartDate().length()) + "|\n"); 

                }
                //if it's data of employee, show employee's data from staff list
                else if(staffs.get(i) instanceof Employee){
                    employee = (Employee)staffs.get(i);
                        
                    System.out.print("|" + fillSpace(3) + employee.getStaffId() + fillSpace(3) + "|");
                    System.out.print(fillSpace(1) + employee.getName() + fillSpace(28 - 1 - employee.getName().length()) + "|");
                    System.out.print(fillSpace(1) + employee.getDepartment() + fillSpace(17 -1 - employee.getDepartment().length()) + "|");
                    System.out.print(fillSpace(1) + employee.getPosition() + fillSpace(15 - 1 - employee.getPosition().length()) + "|");
                    System.out.print(fillSpace(23) + "|"); 
                    System.out.print(fillSpace(1) + employee.getStartDate() + fillSpace(13 - employee.getStartDate().length()) + "|\n"); 
                }
            }
            System.out.println("=================================================================================================================");
            
            //Ask user for backing to main menu
            do{
                System.out.print("Nhap: Quay ve Menu chinh = 0? ");
                backMenu = input.nextByte();
                if(backMenu == 0){
                    runShow = false;
                }
            }while(backMenu != 0);
        }
    }

    /**
     * The method fillSpace() implement fill space into a string
     * @param sizeSpace       is number of space that want to fill
     */
    public static String fillSpace(int sizeSpace){
        String space = "";
        for(int i = 0; i < sizeSpace; i++){
            space += " ";
        }
        return space;
    }

    /**
     * The method showDepartmentList() implement showing department list
     * @param input             use object Scanner to get user's input
     * @param departments       is deparment list
     */
    public static void showDepartmentList(Scanner input, Department departments[]){
        boolean runShow = true;
        byte backMenu = 0;

        while(runShow){
            //Show sheet structure
            System.out.println("============================================================");
            System.out.println("|  Ma bo phan  |     Ten bo phan     |  So luong nhan vien |");
            System.out.println("============================================================");

            //Show each department's infomation from deparment's list
            for(int i = 0; i < departments.length; i++){
                
                System.out.print("|" + fillSpace(2) + departments[i].getDepartmentId() + fillSpace(8) + "|");
                System.out.print(fillSpace(2) + departments[i].getDepartmentName() + fillSpace(20 - 1 - departments[i].getDepartmentName().length()) + "|");
                System.out.print(fillSpace(2) + departments[i].getNumOfStaff() + fillSpace(19 - Integer.toString(departments[i].getNumOfStaff()).length()) + "|\n");
            }

            System.out.println("============================================================");
            
            //Ask user for backing to main menu
            do{
                System.out.print("Nhap: Quay ve Menu chinh = 0? ");
                backMenu = input.nextByte();
                if(backMenu == 0){
                    runShow = false;
                }
            }while(backMenu != 0);
        }
    }

    /**
     * The method showDepartmentStaffList() implement showing staff of department from staffs list by inputing department's name
     * @param input             use object Scanner to get user's input
     * @param staffs            is staff list
     */
    public static void showDepartmentStaffList(Scanner input, ArrayList<Staff> staffs){
        Employee employee;
        Manager manager;
        boolean runShow = true;
        byte backMenu = 0;

        byte choose = 0;
        String choseDepartment = "";

        do{
            //Require input choosing deparment's name with with 4 options, if it different from range, require input again
            do{
                System.out.print("Nhap phong ban muon xem: Finance = 1, Sale = 2, Marketing = 3, IT = 4?  ");
                choose = input.nextByte();

                if(choose == 1){
                    choseDepartment = "Finance";
                }else if(choose == 2){
                    choseDepartment = "Sale";
                }else if(choose == 3){
                    choseDepartment = "Marketing";
                }else if(choose == 4){
                    choseDepartment = "IT";
                }
            }while(choose < 1 || choose > 4);

            //Show sheet structure
            System.out.println("=================================================================================================================");
            System.out.println("|  Ma NV  |           Ten NV           |    Phong ban    |    Chuc vu    |       Chuc danh       |    Ngay vao  |");
            System.out.println("=================================================================================================================");

            //Show manager's data following inputed department's name
            for(int i = 0; i < staffs.size(); i++){
                
                if((staffs.get(i) instanceof Manager)&&staffs.get(i).department.equals(choseDepartment)){
                    manager = (Manager)staffs.get(i);
                        
                    System.out.print("|" + fillSpace(3) + manager.getStaffId() + fillSpace(3) + "|");
                    System.out.print(fillSpace(1) + manager.getName() + fillSpace(28 - 1 - manager.getName().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getDepartment() + fillSpace(17 -1 - manager.getDepartment().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getPosition() + fillSpace(15 - 1 - manager.getPosition().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getPositionManager() + fillSpace(23 - 1 - manager.getPositionManager().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getStartDate() + fillSpace(13 - manager.getStartDate().length()) + "|\n"); 

                }
            }

            //Show employee's data following inputed department's name
            for(int i = 0; i < staffs.size(); i++){

                if((staffs.get(i) instanceof Employee)&&staffs.get(i).department.equals(choseDepartment)){
                    employee = (Employee)staffs.get(i);
                        
                    System.out.print("|" + fillSpace(3) + employee.getStaffId() + fillSpace(3) + "|");
                    System.out.print(fillSpace(1) + employee.getName() + fillSpace(28 - 1 - employee.getName().length()) + "|");
                    System.out.print(fillSpace(1) + employee.getDepartment() + fillSpace(17 -1 - employee.getDepartment().length()) + "|");
                    System.out.print(fillSpace(1) + employee.getPosition() + fillSpace(15 - 1 - employee.getPosition().length()) + "|");
                    System.out.print(fillSpace(23) + "|"); 
                    System.out.print(fillSpace(1) + employee.getStartDate() + fillSpace(13 - employee.getStartDate().length()) + "|\n"); 
                }
            }

            System.out.println("=================================================================================================================");
            
            //Ask user for continue or backing to main menu
            do{
                System.out.print("Nhap: Tiep tuc xem = 1, Quay ve Menu chinh = 0? ");
                backMenu = input.nextByte();
                if(backMenu == 0){
                    runShow = false;
                }else if(backMenu == 1){
                    runShow = true;
                }
            }while(backMenu < 0 || backMenu > 1);
            
        }while(runShow);
    }

    
    /**
     * The method showStaffSalaryList() implement showing staff's salary list
     * @param input             use object Scanner to get user's input
     * @param staffs            is staff list
     */
    public static void showStaffSalaryList(Scanner input, ArrayList<Staff> staffs){
        Employee employee;
        Manager manager;
        boolean runShow = true;
        byte backMenu = 0;

        do{
            //Show sheet structure
            System.out.println("==================================================================================================");
            System.out.println("|  Ma NV  |           Ten NV           |    Phong ban    |    Chuc vu    |         Luong         |");
            System.out.println("==================================================================================================");

            for(int i = 0; i < staffs.size(); i++){
                //if it's data of manager, show manager's data from staff list
                if(staffs.get(i) instanceof Manager){
                    manager = (Manager)staffs.get(i);
                        
                    System.out.print("|" + fillSpace(3) + manager.getStaffId() + fillSpace(3) + "|");
                    System.out.print(fillSpace(1) + manager.getName() + fillSpace(28 - 1 - manager.getName().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getDepartment() + fillSpace(17 -1 - manager.getDepartment().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getPosition() + fillSpace(15 - 1 - manager.getPosition().length()) + "|");
                    System.out.print(fillSpace(1) + (int)manager.getSalary() + fillSpace(16 - Integer.toString((int)manager.getSalary()).length()) + "vnd   |\n"); 

                }
                //if it's data of employee, show employee's data from staff list
                else if(staffs.get(i) instanceof Employee){
                    employee = (Employee)staffs.get(i);
                        
                    System.out.print("|" + fillSpace(3) + employee.getStaffId() + fillSpace(3) + "|");
                    System.out.print(fillSpace(1) + employee.getName() + fillSpace(28 - 1 - employee.getName().length()) + "|");
                    System.out.print(fillSpace(1) + employee.getDepartment() + fillSpace(17 -1 - employee.getDepartment().length()) + "|");
                    System.out.print(fillSpace(1) + employee.getPosition() + fillSpace(15 - 1 - employee.getPosition().length()) + "|");
                    System.out.print(fillSpace(1) + (int)employee.getSalary() + fillSpace(16 - Integer.toString((int)employee.getSalary()).length()) + "vnd   |\n"); 
                }
            }

            System.out.println("==================================================================================================");
            
            //Ask user for continue or backing to main menu
            do{
                System.out.print("Nhap: Tiep tuc xem = 1, Quay ve Menu chinh = 0? ");
                backMenu = input.nextByte();
                if(backMenu == 0){
                    runShow = false;
                }else if(backMenu == 1){
                    runShow = true;
                }
            }while(backMenu < 0 || backMenu > 1);
            
        }while(runShow);
    }

    /**
     * The method showSortStaffSalaryList() implement showing sorting staff's salary list
     * @param input             use object Scanner to get user's input
     * @param staffs            is staff list
     */
    public static void showSortStaffSalaryList(Scanner input, ArrayList<Staff> staffs){
        Employee employee;
        Manager manager;
        boolean runShow = true;
        byte choseNum = 1;

        //Coppy to a temp of staff list
        ArrayList<Staff> staffs_2 = new ArrayList<>();
        staffs_2.addAll(staffs);
        
        do{ 
            /**
             * Sorting staff list number with 3 options: 
             * if choseNum is 1, staff's salary list will be sorted Ascending
             * if choseNum is 2, staff's salary list will be sorted Descending
             * if choseNum is 3, staff's salary list will be kept original staff list
             * if choseNum is 4, will exit feature and back to main menu    
             */
            if(choseNum == 1){
                sortStaffSalary(staffs_2,"Asc");
            }else if(choseNum == 2){
                sortStaffSalary(staffs_2,"Desc");
            }else if(choseNum == 3){
                staffs_2.clear();
                staffs_2.addAll(staffs);
            }

            //Show sheet structure
            System.out.println("==================================================================================================");
            System.out.println("|  Ma NV  |           Ten NV           |    Phong ban    |    Chuc vu    |         Luong         |");
            System.out.println("==================================================================================================");

            for(int i = 0; i < staffs_2.size(); i++){
                //if it's data of manager, show manager's data from staff list
                if(staffs_2.get(i) instanceof Manager){
                    manager = (Manager)staffs_2.get(i);

                    System.out.print("|" + fillSpace(3) + manager.getStaffId() + fillSpace(3) + "|");
                    System.out.print(fillSpace(1) + manager.getName() + fillSpace(28 - 1 - manager.getName().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getDepartment() + fillSpace(17 -1 - manager.getDepartment().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getPosition() + fillSpace(15 - 1 - manager.getPosition().length()) + "|");
                    System.out.print(fillSpace(1) + (int)manager.getSalary() + fillSpace(16 - Integer.toString((int)manager.getSalary()).length()) + "vnd   |\n");
                }
                //if it's data of employee, show employee's data from staff list
                else if(staffs_2.get(i) instanceof Employee){
                    employee = (Employee)staffs_2.get(i);

                    System.out.print("|" + fillSpace(3) + employee.getStaffId() + fillSpace(3) + "|");
                    System.out.print(fillSpace(1) + employee.getName() + fillSpace(28 - 1 - employee.getName().length()) + "|");
                    System.out.print(fillSpace(1) + employee.getDepartment() + fillSpace(17 -1 - employee.getDepartment().length()) + "|");
                    System.out.print(fillSpace(1) + employee.getPosition() + fillSpace(15 - 1 - employee.getPosition().length()) + "|");
                    System.out.print(fillSpace(1) + (int)employee.getSalary() + fillSpace(16 - Integer.toString((int)employee.getSalary()).length()) + "vnd   |\n"); 
                } 
            }

            System.out.println("==================================================================================================");
            
            //Require input choosing number with with 4 options, if it different from range, require input again
            do{
                System.out.print("Nhap: Luong tang dan = 1, Luong giam dan = 2, Bang luong goc = 3, Quay ve Menu chinh = 0? ");
                choseNum = input.nextByte();
                if(choseNum == 0){
                    runShow = false;
                }else{
                    runShow = true;
                }
            }while(choseNum < 0 || choseNum > 3);
            
        }while(runShow);
    }

    /**
     * The method sortStaffSalary() implement showing sorting staff's salary list
     * @param input             use object Scanner to get user's input
     * @param sortRule          if it is "Asc", sort staff's salary by ascending, if it is "Desc" sort staff's salary by descending
     */
    public static void sortStaffSalary(ArrayList<Staff> staffs, String sortRule){
        Staff staff_temp = null;
        double staffSalary_1 = 0.0, staffSalary_2 = 0.0;

        for(int i = 0; i < staffs.size() - 1; i++){

            for(int j = i + 1; j < staffs.size(); j++){
                //if it's data of manager, get manager's salary from staff list
                //if it's data of employee, get employee's salary from staff list
                if(staffs.get(i) instanceof Manager){
                    staffSalary_1 = ((Manager)staffs.get(i)).getSalary();
                }else if(staffs.get(i) instanceof Employee){
                    staffSalary_1 = ((Employee)staffs.get(i)).getSalary();
                }

                if(staffs.get(j) instanceof Manager){
                    staffSalary_2 = ((Manager)staffs.get(j)).getSalary();
                }else if(staffs.get(j) instanceof Employee){
                    staffSalary_2 = ((Employee)staffs.get(j)).getSalary();
                }

                //sort staff's salary by ascending
                if(sortRule.equals("Desc")){
                    if(staffSalary_1 < staffSalary_2){
                        staff_temp = staffs.get(i);
                        staffs.set(i, null);
                        staffs.set(i, staffs.get(j));
                        staffs.set(j, null);
                        staffs.set(j, staff_temp);
                    }
                }
                //sort staff's salary by descending
                else if(sortRule.equals("Asc")){
                    if(staffSalary_1 > staffSalary_2){
                        staff_temp = staffs.get(i);
                        staffs.set(i, null);
                        staffs.set(i, staffs.get(j));
                        staffs.set(j, null);
                        staffs.set(j, staff_temp);
                    }
                }

            }
        }
    }

    /**
     * The method showSearchStaff() implement showing searching a staff in staff list by name or staff id
     * @param input             use object Scanner to get user's input
     * @param staffs            is staffs list
     */
    public static void showSearchStaff(Scanner input, ArrayList<Staff> staffs){
        Employee employee;
        Manager manager;
        boolean runShow = true;
        byte choseNum = 1;
        String keyword = "";

        //Declare a searchedStaff to store search result
        ArrayList<Staff> searchedStaff = new ArrayList<>();
 
        do{
            //Clear searchedStaff
            searchedStaff.clear();

            //Require input search keyword (staff id or name) and store search result to searchedStaff
            System.out.print("Nhap ma nhan vien hoac ten nhan vien can tim? ");
            keyword = input.next();
            for(Staff staff : staffs){
                if(staff.getStaffId().equals(keyword)){
                    searchedStaff.add(staff);
                }else if(staff.getName().endsWith(keyword)){
                    searchedStaff.add(staff);
                }
            }
            
            //if searchedStaff is not empty, show result. 
            if(!searchedStaff.isEmpty()){
                //Show sheet structure
                System.out.println("=================================================================================================================");
                System.out.println("|  Ma NV  |           Ten NV           |    Phong ban    |    Chuc vu    |       Chuc danh       |    Ngay vao  |");
                System.out.println("=================================================================================================================");

                for(int i = 0; i < searchedStaff.size(); i++){
                    //if it's data of manager, show manager's data from searchedStaff
                    if(searchedStaff.get(i) instanceof Manager){
                        manager = (Manager)searchedStaff.get(i);
                            
                        System.out.print("|" + fillSpace(3) + manager.getStaffId() + fillSpace(3) + "|");
                        System.out.print(fillSpace(1) + manager.getName() + fillSpace(28 - 1 - manager.getName().length()) + "|");
                        System.out.print(fillSpace(1) + manager.getDepartment() + fillSpace(17 -1 - manager.getDepartment().length()) + "|");
                        System.out.print(fillSpace(1) + manager.getPosition() + fillSpace(15 - 1 - manager.getPosition().length()) + "|");
                        System.out.print(fillSpace(1) + manager.getPositionManager() + fillSpace(23 - 1 - manager.getPositionManager().length()) + "|");
                        System.out.print(fillSpace(1) + manager.getStartDate() + fillSpace(13 - manager.getStartDate().length()) + "|\n"); 

                    }
                    //if it's data of employee, show employee's data from searchedStaff
                    else if(searchedStaff.get(i) instanceof Employee){
                        employee = (Employee)searchedStaff.get(i);
                            
                        System.out.print("|" + fillSpace(3) + employee.getStaffId() + fillSpace(3) + "|");
                        System.out.print(fillSpace(1) + employee.getName() + fillSpace(28 - 1 - employee.getName().length()) + "|");
                        System.out.print(fillSpace(1) + employee.getDepartment() + fillSpace(17 -1 - employee.getDepartment().length()) + "|");
                        System.out.print(fillSpace(1) + employee.getPosition() + fillSpace(15 - 1 - employee.getPosition().length()) + "|");
                        System.out.print(fillSpace(23) + "|"); 
                        System.out.print(fillSpace(1) + employee.getStartDate() + fillSpace(13 - employee.getStartDate().length()) + "|\n"); 
                    }
                }

                System.out.println("=================================================================================================================");
                
            }else{
                //if searchedStaff is empty, inform "not found". 
                System.out.println("??????????????????????????????");
                System.out.println("??? Khong tim thay ket qua ???");
                System.out.println("??????????????????????????????");
            }
            
            //Ask user for continue finding or backing to main menu
            do{
                System.out.print("Nhap: Tiep tuc tim = 1, Quay ve Menu chinh = 0? ");
                choseNum = input.nextByte();
                if(choseNum == 0){
                    runShow = false;
                }else{
                    runShow = true;
                }
            }while(choseNum < 0 || choseNum > 1);
            
        }while(runShow);

    }

    /**
     * The method removeStaffByStaffId() implement removing a staff by inputing staff's id
     * @param input             use object Scanner to get user's input
     * @param staffs            is staffs list
     * @param departments       is department list
     */
    public static void removeStaffByStaffId(Scanner input, ArrayList<Staff> staffs, Department departments[]){

        Employee employee;
        Manager manager;
        boolean runShow = true;
        byte choseNum = 1;
        String keyword = "";
        Staff searchedStaff = null;

        byte isDelete = 0;
        int deleteIndex = 0;
 
        do{
            //clear searchedStaff
            searchedStaff = null;

            //Require input staff's id want to remove
            System.out.print("Nhap ma nhan vien muon xoa? ");
            keyword = input.next();

            //Search inputted staff's id in staff list
            for(int i = 0; i < staffs.size(); i++){
                if(staffs.get(i).getStaffId().equals(keyword)){
                    //Store searched result in searchedStaff
                    searchedStaff = staffs.get(i);

                    //get index where want to remove in staff list
                    deleteIndex = i;
                    break;
                }
            }
            
            //if searchedStaff is not empty, show result
            if(searchedStaff != null){

                System.out.println("=================================================================================================================");
                System.out.println("|  Ma NV  |           Ten NV           |    Phong ban    |    Chuc vu    |       Chuc danh       |    Ngay vao  |");
                System.out.println("=================================================================================================================");

                if(searchedStaff instanceof Manager){
                    manager = (Manager)searchedStaff;
                        
                    System.out.print("|" + fillSpace(3) + manager.getStaffId() + fillSpace(3) + "|");
                    System.out.print(fillSpace(1) + manager.getName() + fillSpace(28 - 1 - manager.getName().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getDepartment() + fillSpace(17 -1 - manager.getDepartment().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getPosition() + fillSpace(15 - 1 - manager.getPosition().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getPositionManager() + fillSpace(23 - 1 - manager.getPositionManager().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getStartDate() + fillSpace(13 - manager.getStartDate().length()) + "|\n"); 

                }else if(searchedStaff instanceof Employee){
                    employee = (Employee)searchedStaff;
                        
                    System.out.print("|" + fillSpace(3) + employee.getStaffId() + fillSpace(3) + "|");
                    System.out.print(fillSpace(1) + employee.getName() + fillSpace(28 - 1 - employee.getName().length()) + "|");
                    System.out.print(fillSpace(1) + employee.getDepartment() + fillSpace(17 -1 - employee.getDepartment().length()) + "|");
                    System.out.print(fillSpace(1) + employee.getPosition() + fillSpace(15 - 1 - employee.getPosition().length()) + "|");
                    System.out.print(fillSpace(23) + "|"); 
                    System.out.print(fillSpace(1) + employee.getStartDate() + fillSpace(13 - employee.getStartDate().length()) + "|\n"); 
                }
                
                System.out.println("=================================================================================================================");
                
                //More one time, confirm removing or not
                do{
                    System.out.print("Ban chac chan muon xoa, nhap: Xoa = 1, Khong Xoa = 0? ");
                    isDelete = input.nextByte();
                    if(isDelete == 1){
                        //remove staff by
                        staffs.remove(deleteIndex);

                        //update department's number of staff after remove a staff
                        updateDepartmentList(staffs, departments);
                        System.out.println("Xoa thanh cong!\n");
                    }else if(isDelete == 0){
                        //don't remove
                    }
                }while(isDelete < 0 || isDelete > 1);

            }else{
                //if searchedStaff is empty, inform "not found"
                System.out.println("??????????????????????????????");
                System.out.println("??? Khong tim thay ket qua ???");
                System.out.println("??????????????????????????????");
            }

            //Ask user for continue removing or backing to main menu
            do{
                System.out.print("Nhap: Tiep tuc tim = 1, Quay ve Menu chinh = 0? ");
                choseNum = input.nextByte();
                if(choseNum == 0){
                    runShow = false;
                }else{
                    runShow = true;
                }
            }while(choseNum < 0 || choseNum > 1);
            
        }while(runShow);
    }
  
}


