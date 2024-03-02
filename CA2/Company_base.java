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
