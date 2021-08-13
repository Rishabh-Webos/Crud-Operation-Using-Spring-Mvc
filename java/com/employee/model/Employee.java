package com.employee.model;

public class Employee {
  int id;
  String employeeName;
  String employeeEmail;
  String employeePassword;

  public Employee() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public String getEmployeeEmail() {
    return employeeEmail;
  }

  public void setEmployeeEmail(String employeeEmail) {
    this.employeeEmail = employeeEmail;
  }

  public String getEmployeePassword() {
    return employeePassword;
  }

  public void setEmployeePassword(String employeePassword) {
    this.employeePassword = employeePassword;
  }

  public Employee(int id, String employeeName, String employeeEmail, String employeePassword) {
    super();
    this.id = id;
    this.employeeName = employeeName;
    this.employeeEmail = employeeEmail;
    this.employeePassword = employeePassword;
  }

  @Override
  public String toString() {
    return "Employee [id="
        + id
        + ", employeeName="
        + employeeName
        + ", employeeEmail="
        + employeeEmail
        + ", employeePassword="
        + employeePassword
        + "]";
  }
}
