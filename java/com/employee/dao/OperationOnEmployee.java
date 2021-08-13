package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.config.SqlConfigFile;
import com.employee.model.Employee;

public class OperationOnEmployee {
  public int insertData(Employee employee) {
    int rowAffected = 0;
    Connection connection = SqlConfigFile.getConnection();
    try {
      PreparedStatement statement =
          connection.prepareStatement(
              "insert into employee (employee_name,emp_email,employee_password) values(?,?,?)");
      statement.setString(1, employee.getEmployeeName());
      statement.setString(2, employee.getEmployeeEmail());
      statement.setString(3, employee.getEmployeePassword());
      rowAffected = statement.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return rowAffected;
  }

  public ArrayList<Employee> getAllDataOfEmployee() {
    ArrayList<Employee> listOfEmployee = new ArrayList<Employee>();
    Connection connection = SqlConfigFile.getConnection();
    try {
      Statement statement = connection.createStatement();
      ResultSet Data = statement.executeQuery("select * from employee");
      while (Data.next()) {
        listOfEmployee.add(
            new Employee(Data.getInt(1), Data.getString(2), Data.getString(3), Data.getString(4)));
      }
    } catch (SQLException e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return listOfEmployee;
  }

  public ArrayList<Employee> getDataOfEmployee(int employeeId) {
    ArrayList<Employee> listOfEmployee = new ArrayList<Employee>();
    Connection connection = SqlConfigFile.getConnection();
    try {
      Statement statement = connection.createStatement();
      ResultSet Data =
          statement.executeQuery("select * from employee where employee_id=" + employeeId + "");
      if (Data.next()) {
        listOfEmployee.add(
            new Employee(Data.getInt(1), Data.getString(2), Data.getString(3), Data.getString(4)));
      }
    } catch (SQLException e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return listOfEmployee;
  }

  public int updateData(Employee employee) {
    int rowAffected = 0;
    Connection connection = SqlConfigFile.getConnection();
    try {
      PreparedStatement statement =
          connection.prepareStatement(
              "update employee set employee_name=?,emp_email=?,employee_password=? where employee_id=?");
      statement.setString(1, employee.getEmployeeName());
      statement.setString(2, employee.getEmployeeEmail());
      statement.setString(3, employee.getEmployeePassword());
      statement.setInt(4, employee.getId());
      rowAffected = statement.executeUpdate();
    } catch (SQLException e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return rowAffected;
  }

  public int deleteDataOfEmployee(int parseInt) { // TODO Auto-generated method stub
    int rowAffected = 0;
    Connection connection = SqlConfigFile.getConnection();
    try {
      PreparedStatement statement =
          connection.prepareStatement("delete from employee where employee_id=?");
      statement.setInt(1, parseInt);
      rowAffected = statement.executeUpdate();
    } catch (SQLException e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return rowAffected;
  }
}
