package com.Projectmaven.Maven_Demo.client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.Projectmaven.Maven_Demo.myException.ServiceException;
//import com.Projectmaven.Maven_Demo.service.serviceImpl.EmplyoeeServiceImpl;
import com.Projectmaven.Maven_Demo.service.serviceImpl.*;


public class EmployeeApp 
{
	static Scanner sc=new Scanner(System.in);
	public static void main(String args[]) throws SQLException
	{
		EmployeeServiceImpl ob=new EmployeeServiceImpl();
		try {
			ob.showAll();
		} catch (ServiceException e) {
			System.out.println(e);
		} 
		try {
			ResultSet rs=ob.display();
			System.out.println("\n====Displaying Employee Details whose salary is more than 20000====\n");
			System.out.println("E_ID"+ "\t" + "E_name" + "\t" + "E_age" + "\t" + "E_salary");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t  "+rs.getInt(3)+"\t"+rs.getInt(4));
			}
		} catch (ServiceException e) {
			System.out.println(e);
		}
		try {
			System.out.println("\n====Searching employee id in the database====");
			System.out.print("\nEnter employee id :");
			int empId=sc.nextInt();
			ob.invalidId(empId);
		} catch (ServiceException e) {
			System.out.println(e);
		}
		try {
			System.out.println("\n====Updating Employee Salary by ID====");
			System.out.print("\nEnter employee id :");
			int empId=sc.nextInt();
			System.out.print("Enter salary: ");
			int empSal=sc.nextInt();
			ob.updateSalary(empId, empSal);
		} catch (ServiceException e) {
			System.out.println(e);
		}
	}
}


