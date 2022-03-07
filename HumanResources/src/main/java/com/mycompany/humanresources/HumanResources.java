/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.humanresources;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dang Minh Tu
 */
public class HumanResources {
    
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
    }

    public static void initDepartmentList(ArrayList<Staff> staffs, Department department[]){
        // Employee employee;
        // Manager manager;
        int countStaffFinance = 0;
        int countStaffSale = 0;
        int countStaffMarketing = 0;
        int countStaffIT = 0;

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
                
            // if(staffs.get(i).position.equals("manager")){
            //     manager = (Manager)staffs.get(i); 
            // }else{
            //     employee = (Employee)staffs.get(i);    
            // }
        }

        department[0] = new Department("F001", "Finance", countStaffFinance);
        department[1] = new Department("S002", "Sale", countStaffSale);
        department[2] = new Department("M003", "Marketing", countStaffMarketing);
        department[3] = new Department("I001", "IT", countStaffIT);
    }

    public static boolean runApp = true;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Staff> staffs = new ArrayList<>();
        Department departments[] = new Department[4];

        initStaffList(staffs);
        initDepartmentList(staffs, departments);
        
        while(runApp){
            begin();
            listFeature();
            chooseFeature(input, staffs, departments);
            System.out.println();
        }

    }

    public static void begin(){
        System.out.println("Ung dung quan ly nguon nhan luc 1.0");
        System.out.println();
    }
    
    public static void listFeature(){
        System.out.println("Chuc nang cua ung dung gom: ");
        System.out.println();
        System.out.println("1. Hien thi danh sach nhan vien hien co trong cong ty");
        System.out.println("2. Hien thi cac bo phan trong cong ty");
        System.out.println("3. Hien thi cac nhan vien theo tung bo phan");
        System.out.println("4. Them nhan vien moi vao cong ty ");
        System.out.println("5. Tim kiem thong tin nhan vien theo ten hoan ma nhan vien");
        System.out.println("6. Hien thi bang luong cua nhan vien toan cong ty");
        System.out.println("7. Hien thi bang luong cua nhan vien theo thu tu tang dan");
        System.out.println("8. Hien thi bang luong cua nhan vien theo thu tu giam dan");
        System.out.println("0. Thoat ung dung");
        System.out.println();
    }
    
    public static void chooseFeature(Scanner input, ArrayList<Staff> staffs, Department departments[]){
        byte choseFeature = 0;
        do{
            System.out.print("Nhap tinh nang de thuc hien (0 - 8)? ");
            choseFeature = input.nextByte();
        }while(choseFeature < 0 || choseFeature > 8);

        if(choseFeature == 0){
            runApp = false;
            System.out.println("Hen gap lai");
        }else if(choseFeature == 1){

            showStaffList(input, staffs);

        }else if(choseFeature == 2){

            showDepartmentList(input, departments);

        }else if(choseFeature == 3){

            showDepartmentStaffList(input, staffs);

        }else if(choseFeature == 4){

            addStaff(input, staffs);

        }else if(choseFeature == 5){

        }else if(choseFeature == 6){

            showStaffSalaryList(input, staffs);

        }else if(choseFeature == 7){

        }else if(choseFeature == 8){

        }

    }

    public static void addStaff(Scanner input, ArrayList<Staff> staffs){
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

            do{
                System.out.print("Nhap vi tri nhan vien: Quan ly = 1, Nhan vien = 2? ");
                staffPosition = input.nextByte();
            }while(staffPosition < 1 ||  staffPosition > 2);
    
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
            
            System.out.print("Nhap ma so nhan vien?                ");
            staffId = input.next();
            input.nextLine();
            
            System.out.print("Nhap ten nhan vien?                  ");
            name = input.nextLine();
    
            System.out.print("Nhap tuoi nhan vien?                 ");
            age = input.nextInt();
    
            System.out.print("Nhap he so luong?                    ");
            salaryScale = input.nextDouble();
    
            System.out.print("Nhap ngay vao cong ty(dd/mm/yyyy)?   ");
            startDate = input.next();

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
            }while(choseDepartment < 1 || choseDepartment > 3);

    
            System.out.print("Nhap ngay phep?                      ");
            annualLeave = input.nextInt();
    
            if(staffPosition == 2){
                do{
                    System.out.print("Nhap so gio da lam them?             ");
                    overTime = input.nextInt();
                }while(overTime < 0);
            }
            
            if(staffPosition == 1){
                System.out.format("%s  %s  %d  %f  %s  %s  %d  %s", staffId, name, age, salaryScale, startDate, department, annualLeave, positionManager);
                staffs.add(new Manager(staffId, name, age, salaryScale, startDate, department, annualLeave, positionManager));
            }else if(staffPosition == 2){
                System.out.format("%s  %s  %d  %f  %s  %s  %d  %d", staffId, name, age, salaryScale, startDate, department, annualLeave, overTime);
                staffs.add(new Employee(staffId, name, age, salaryScale, startDate, department, annualLeave, overTime));
            }

            System.out.println();

            do{
                System.out.print("Nhap: Tiep tuc them = 1, Quay ve Menu chinh = 0? ");
                nextAddStaff = input.nextByte();
            }while(nextAddStaff < 0 ||  nextAddStaff > 1);
            
            if(nextAddStaff == 0){
                runAddStaff = false;
            }else if(nextAddStaff == 1){
                runAddStaff = true;
            }

            System.out.println();
        }
    }

    public static void showStaffList(Scanner input, ArrayList<Staff> staffs){
        Employee employee;
        Manager manager;
        boolean runShow = true;
        byte backMenu = 0;

        while(runShow){
            System.out.println("=================================================================================================================");
            System.out.println("|  Ma NV  |           Ten NV           |    Phong ban    |    Chuc vu    |       Chuc danh       |    Ngay vao  |");
            System.out.println("=================================================================================================================");

            for(int i = 0; i < staffs.size(); i++){
                
                if(staffs.get(i).position.equals("manager")){
                    manager = (Manager)staffs.get(i);
                        
                    System.out.print("|" + fillSpace(3) + manager.getStaffId() + fillSpace(3) + "|");
                    System.out.print(fillSpace(1) + manager.getName() + fillSpace(28 - 1 - manager.getName().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getDepartment() + fillSpace(17 -1 - manager.getDepartment().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getPosition() + fillSpace(15 - 1 - manager.getPosition().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getPositionManager() + fillSpace(23 - 1 - manager.getPositionManager().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getStartDate() + fillSpace(13 - manager.getStartDate().length()) + "|\n"); 

                }else{
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
        
            do{
                System.out.print("Nhap: Quay ve Menu chinh = 0? ");
                backMenu = input.nextByte();
                if(backMenu == 0){
                    runShow = false;
                }
            }while(backMenu != 0);
        }
    }

    public static String fillSpace(int sizeSpace){
        String space = "";
        for(int i = 0; i < sizeSpace; i++){
            space += " ";
        }
        return space;
    }

    public static void showDepartmentList(Scanner input, Department departments[]){
        boolean runShow = true;
        byte backMenu = 0;

        while(runShow){
            System.out.println("============================================================");
            System.out.println("|  Ma bo phan  |     Ten bo phan     |  So luong nhan vien |");
            System.out.println("============================================================");

            for(int i = 0; i < departments.length; i++){
                

                System.out.print("|" + fillSpace(2) + departments[i].getDepartmentId() + fillSpace(8) + "|");
                System.out.print(fillSpace(2) + departments[i].getDepartmentName() + fillSpace(20 - 1 - departments[i].getDepartmentName().length()) + "|");
                System.out.print(fillSpace(2) + departments[i].getNumOfStaff() + fillSpace(19 - Integer.toString(departments[i].getNumOfStaff()).length()) + "|\n");
            }

            System.out.println("============================================================");
        
            do{
                System.out.print("Nhap: Quay ve Menu chinh = 0? ");
                backMenu = input.nextByte();
                if(backMenu == 0){
                    runShow = false;
                }
            }while(backMenu != 0);
        }
    }

    public static void showDepartmentStaffList(Scanner input, ArrayList<Staff> staffs){
        Employee employee;
        Manager manager;
        boolean runShow = true;
        byte backMenu = 0;

        byte choose = 0;
        String choseDepartment = "";

        do{
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


            System.out.println("=================================================================================================================");
            System.out.println("|  Ma NV  |           Ten NV           |    Phong ban    |    Chuc vu    |       Chuc danh       |    Ngay vao  |");
            System.out.println("=================================================================================================================");

            for(int i = 0; i < staffs.size(); i++){
                
                if(staffs.get(i).position.equals("manager")&&staffs.get(i).department.equals(choseDepartment)){
                    manager = (Manager)staffs.get(i);
                        
                    System.out.print("|" + fillSpace(3) + manager.getStaffId() + fillSpace(3) + "|");
                    System.out.print(fillSpace(1) + manager.getName() + fillSpace(28 - 1 - manager.getName().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getDepartment() + fillSpace(17 -1 - manager.getDepartment().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getPosition() + fillSpace(15 - 1 - manager.getPosition().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getPositionManager() + fillSpace(23 - 1 - manager.getPositionManager().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getStartDate() + fillSpace(13 - manager.getStartDate().length()) + "|\n"); 

                }
            }

            for(int i = 0; i < staffs.size(); i++){

                if(staffs.get(i).position.equals("staff")&&staffs.get(i).department.equals(choseDepartment)){
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

    public static void showStaffSalaryList(Scanner input, ArrayList<Staff> staffs){
        Employee employee;
        Manager manager;
        boolean runShow = true;
        byte backMenu = 0;

        do{

            System.out.println("==================================================================================================");
            System.out.println("|  Ma NV  |           Ten NV           |    Phong ban    |    Chuc vu    |         Luong         |");
            System.out.println("==================================================================================================");

            for(int i = 0; i < staffs.size(); i++){
                
                if(staffs.get(i).position.equals("manager")){
                    manager = (Manager)staffs.get(i);
                        
                    System.out.print("|" + fillSpace(3) + manager.getStaffId() + fillSpace(3) + "|");
                    System.out.print(fillSpace(1) + manager.getName() + fillSpace(28 - 1 - manager.getName().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getDepartment() + fillSpace(17 -1 - manager.getDepartment().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getPosition() + fillSpace(15 - 1 - manager.getPosition().length()) + "|");
                    System.out.print(fillSpace(1) + (int)manager.getSalary() + fillSpace(16 - Integer.toString((int)manager.getSalary()).length()) + "vnd   |\n"); 

                }else{
                    employee = (Employee)staffs.get(i);
                        
                    System.out.print("|" + fillSpace(3) + employee.getStaffId() + fillSpace(3) + "|");
                    System.out.print(fillSpace(1) + employee.getName() + fillSpace(28 - 1 - employee.getName().length()) + "|");
                    System.out.print(fillSpace(1) + employee.getDepartment() + fillSpace(17 -1 - employee.getDepartment().length()) + "|");
                    System.out.print(fillSpace(1) + employee.getPosition() + fillSpace(15 - 1 - employee.getPosition().length()) + "|");
                    System.out.print(fillSpace(1) + (int)employee.getSalary() + fillSpace(16 - Integer.toString((int)employee.getSalary()).length()) + "vnd   |\n"); 
                }
            }

            System.out.println("==================================================================================================");
        
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

    public static void showStaffSalaryListSortAsc(Scanner input, ArrayList<Staff> staffs){
        Employee employee;
        Manager manager;
        boolean runShow = true;
        byte backMenu = 0;

        Staff Staff_arr[] = new Staff[staffs.size()];

        for(int i = 0; i < staffs.size(); i++){
            Staff_arr[i] = staffs.get(i);
        }

        do{

            System.out.println("==================================================================================================");
            System.out.println("|  Ma NV  |           Ten NV           |    Phong ban    |    Chuc vu    |         Luong         |");
            System.out.println("==================================================================================================");

            for(int i = 0; i < staffs.size(); i++){
                
                if(staffs.get(i).position.equals("manager")){
                    manager = (Manager)staffs.get(i);
                        
                    System.out.print("|" + fillSpace(3) + manager.getStaffId() + fillSpace(3) + "|");
                    System.out.print(fillSpace(1) + manager.getName() + fillSpace(28 - 1 - manager.getName().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getDepartment() + fillSpace(17 -1 - manager.getDepartment().length()) + "|");
                    System.out.print(fillSpace(1) + manager.getPosition() + fillSpace(15 - 1 - manager.getPosition().length()) + "|");
                    System.out.print(fillSpace(1) + (int)manager.getSalary() + fillSpace(16 - Integer.toString((int)manager.getSalary()).length()) + "vnd   |\n"); 

                }else{
                    employee = (Employee)staffs.get(i);
                        
                    System.out.print("|" + fillSpace(3) + employee.getStaffId() + fillSpace(3) + "|");
                    System.out.print(fillSpace(1) + employee.getName() + fillSpace(28 - 1 - employee.getName().length()) + "|");
                    System.out.print(fillSpace(1) + employee.getDepartment() + fillSpace(17 -1 - employee.getDepartment().length()) + "|");
                    System.out.print(fillSpace(1) + employee.getPosition() + fillSpace(15 - 1 - employee.getPosition().length()) + "|");
                    System.out.print(fillSpace(1) + (int)employee.getSalary() + fillSpace(16 - Integer.toString((int)employee.getSalary()).length()) + "vnd   |\n"); 
                }
            }

            System.out.println("==================================================================================================");
        
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

    public static void showStaffSalaryListSortDesc(Scanner input, ArrayList<Staff> staffs){
    }
}


