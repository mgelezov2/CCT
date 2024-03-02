package ca2_ooa;



/**
 *
 * @author michael
 */

//EMPLOYEE CLASS

public class Employee {
       public String name;
       public String email;
       public int empNum;
       public static int nextEmpNum = 1;

//EMPLOYEE CONSTRUCTOR
    public Employee(){
        name = "";
        email = "";
    }
    
//EMPLOYEE INITILIAZED CONSTRUCTOR
    public Employee(String empName, String empEmail, int empIDNum){
        name = empName;
        email = empEmail;
        empNum = empIDNum;
        nextEmpNum++;
        
    }

//EMPLOYEE METHOD THAT RETURNS THE NAME OF THE EMPLOYEE
    public String getName(String name) {
	return name;
    }
    
//EMPLOYEE METHOD THAT RETURNS THE EMAIL OF THE EMPLOYEE
    public String getEmail(String email) {
	return email;
    }
