package com.trax.app;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        EmployeeAnalyze main=new EmployeeImplementaion();
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to the employee management system!");
        System.out.println("--------------------------------------------------------------------------------------------");
        do{
            System.out.println("1. Create Employee \n"+"2. Show All Employee \n "+"3. Show Employee based on id \n"+"4. Update the Employee \n"+"5. Delete the Employee\n");
            System.out.println("Enter choice:");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                    Employee emp=new Employee();
                    System.out.println("Enter Employee ID:");
                    int id=sc.nextInt();
                    System.out.println("Enter Name of the Employee:");
                    String name=sc.next();
                    System.out.println("Enter Salary of the Employee::");
                    double salary=sc.nextDouble();
                    System.out.println("Enter Age of the Employee::");
                    int age=sc.nextInt();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);
                    main.createEmployee(emp);
                    break;
                case 2:
                    main.showAllEmployee();
                    break;
                case 3:
                    System.out.println("Enter id to show the details");
                    int empid=sc.nextInt();
                    main.showEmployeeBasedOnId(empid);
                case 4:
                    System.out.println("Enter id to update the details");
                    int empid1=sc.nextInt();
                    System.out.println("Enter the new name");
                    name=sc.next();
                    main.updateEmployee(empid1,name);
                    break;
                case 5:
                    System.out.println("Enter the id to delete");
                    id=sc.nextInt();
                    main.deleteEmployee(id);
                    break;
                case 6:
                    System.out.println("Thank You for Visiting Us!");
                    System.exit(0);
                default:
                    System.out.println("Please Enter Valid Choice!");
                    break;

            }
        }while(true);


    }
}
