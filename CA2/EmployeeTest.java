package ca2_ooa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author michael
 */

//EMPLOYEE TEST THAT EXTENDS TO THE EMPLOYEE CLASS ALLOWING USAGE OF METHODS FROM THE EMPLOYEE CLASS
public class EmployeeTest extends Employee{

    public static void mainCall() {
      
//PROJECTGROUP ARRAY FOR STORING EMPLOYEE OBJECTS; NAME, EMAIL AND EMPLOYEE NUMBER
        ArrayList<String> projectGroup = new ArrayList<String>();
        ArrayList<Integer> empNums = new ArrayList<Integer>();
      
// M ARRAY FOR STORING A SPECIFIC EMPLOYEE THAT IS SELECTED BY AN EMPLOYEE NUMBER
        List<String> m = new ArrayList<String>();
      
