package com.trax.app;

public interface EmployeeAnalyze {
    // create employee
    public void createEmployee(Employee emp);

    // show all employee
    public void showAllEmployee();
    // show employee based on the id
    public void showEmployeeBasedOnId(int id);
    //update the employee
    public void updateEmployee(int id,String name);
    // delete the employee
    public  void deleteEmployee(int id);

}
