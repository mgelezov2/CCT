package ca2_ooa;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author michael
 */

//COMPANY CLASS THAT EXTENDS TO EMPLOYEE FOR USAGE OF EMPLOYEE METHODS
public class Company_base extends Employee{
    Employee employee_comp = new Employee();
    String company_Name;
    ArrayList<String> staff = new ArrayList<>();

//COMPANY CLASS CONSTRUCTOR
     public Company_base(){
        company_Name = "Business Gnómes Ltd";
        
    }
     
//INITALIZED COMPANY CONSTRUCTOR
    public Company_base(String companyName){
        company_Name = companyName;
    }

//ADDS NEW STAFF TO THE COMPANY ARRAY CALLED STAFF
    public ArrayList<String> addNewStaff(String name, String email, int empNum){
        staff.add(employee_comp.getName(name));
        staff.add(employee_comp.getEmail(email));
        staff.add(String.valueOf(employee_comp.getNextEmpNum(empNum)));
        return staff;
     }
    
//REMOVES AN EMPLOYEE BY EMPLOYEE NUMBER
//BUG: UNABLE TO REMOVE EMPLOYEE DESPITE ENTERING STAFF NUMBER    
    public ArrayList<String> removeStaff(int empNum){
        staff.remove(employee_comp.getName(name));
        staff.remove(employee_comp.getEmail(email));
     
        return staff;
    }

//CALCULATES AMOUNT OF STAFF MEMBERS IN THE ARRAY
    public int getStaffNumber(){
        int size = staff.size();
        return size;
    }
    
//RETURNS LIST OF EMPLOYEES AND CHECKS IF THEY ARE ON THE LIST
//BUG: UNABLE TO RETURN A NAME OF THE TARGETTED EMPLOYEE BY EMPLOYEE NUMBER AS IT RETURNS NOTHING WHEN PROMPTED TO DO SO
    public String listEmployees(int empNum){
        Iterator<String> employeeList = staff.iterator();
        while(employeeList.hasNext()){
            if(employeeList.next().equals(String.valueOf(employee_comp.getNextEmpNum(empNum)))){
            System.out.println("Current staff list: " + staff);
            }
        }
        return null;
    }

//MANAGER CLASS CONSOLE THAT EXTENDS TO COMPANY CLASS FOR USAGE OF ITS METHODS  
    public static class Manager extends Company_base{
    Company_base manager_system = new Company_base();
    Scanner userInput = new Scanner(System.in);
    int choice = 0;
    String userName,password;
    String userInp,userPassInp;
    String nameInp, emailInp;
    int empNumInp;
    
//RETURNS USERNAME THAT THE MANAGER HAS TYPED IN
    public String getuserName(){
        return userName;
    }
    
//ALLOWS FOR MANUAL INPUT FOR THE MANAGER TO ENTER THEIR USERNAME
    public String setuserName(String managerUsername){
        return this.userName = managerUsername;
    }
    
//RETURNS PASSWORD TYPED BY THE MANAGER
    public String getPassword(){
        return password;
    }
    
//ALLOWS FOR MANUAL INPUT OF THE PASSWORD FOR THE MANAGER TO ENTER THEIR USERNAME
    public String setPassword(String managerPassword){
        return this.password = managerPassword;
    }
