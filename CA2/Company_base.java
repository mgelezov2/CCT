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
