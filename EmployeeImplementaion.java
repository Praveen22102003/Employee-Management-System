package com.trax.app;

import java.sql.*;

public class EmployeeImplementaion implements EmployeeAnalyze {
    Connection con;

    public void createEmployee(Employee emp) {
        con=DBConnection.createDBConnection();
        String query="insert into employee values(?,?,?,?)"; 
        try {

            PreparedStatement value = con.prepareStatement(query);
            value.setInt(1,emp.getId());
            value.setString(2,emp.getName());
            value.setDouble(3,emp.getSalary());
            value.setInt(4,emp.getAge());
            int cnt=value.executeUpdate();
            if(cnt!=0)
            {
                System.out.println("Employee inserted Sucessfully!!!");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }


    public void showAllEmployee() {
        con=DBConnection.createDBConnection();
        String query="select * from employee";
        try
        {
            Statement EmpDetails=con.createStatement();
            ResultSet result=EmpDetails.executeQuery(query);
            System.out.println("Employee Details");
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.format("%s\t%s\t%s\t%s\n","ID","NAME","SALARY","AGE");
            System.out.println("----------------------------------------------------------------------------------------");
            while(result.next())
            {
                System.out.format("%d\t%s\t%f\t%d\n",result.getInt(1),result.getString(2),result.getDouble(3),result.getInt(4));
            }
            System.out.println("----------------------------------------------------------------------------------------");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void showEmployeeBasedOnId(int id) {
        con=DBConnection.createDBConnection();
        String query="select * from employee where id="+id;
        try{
            Statement EmployeeID=con.createStatement();
            ResultSet result= EmployeeID.executeQuery(query);
            System.out.println("------------------------------------------------------------------");
            while (result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("------------------------------------------------------------------");

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void updateEmployee(int id,String name) {
        con=DBConnection.createDBConnection();
        String query="update employee set name=? where id=?";
        try{
            PreparedStatement EmpUpdate=con.prepareStatement(query);
            EmpUpdate.setString(1,name);
            EmpUpdate.setInt(2,id);
            int count=EmpUpdate.executeUpdate();
            if(count!=0)
                System.out.println("Employee Details updated successfully !!");
            System.out.println("-------------------------------------------------------------------------");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void deleteEmployee(int id) {
        con=DBConnection.createDBConnection();
        String query="delete from employee where id=?";
        try{
            PreparedStatement EmpDelete=con.prepareStatement(query);
            EmpDelete.setInt(1,id);
            int cnt= EmpDelete.executeUpdate();
            if(cnt!=0)
                System.out.println("Employee Deleted Successfully!!! "+id);
            System.out.println("-----------------------------------------------------------------------------");

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
}
