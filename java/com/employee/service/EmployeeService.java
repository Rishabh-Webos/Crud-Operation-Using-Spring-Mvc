package com.employee.service;

import com.employee.model.Employee;

public class EmployeeService {
  public static Employee setDetails(
      String employeeId, String employeeName, String employeeEmail, String employeePassword) {
    Employee employee = new Employee();
    employee.setEmployeeEmail(employeeEmail);
    employee.setEmployeeName(employeeName);
    employee.setEmployeePassword(employeePassword);
    employee.setId(Integer.parseInt(employeeId));
    return employee;
  }
}
