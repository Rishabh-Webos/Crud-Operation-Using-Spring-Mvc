package com.employee.enginee;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.employee.dao.OperationOnEmployee;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@Controller
public class EmployeeController {
  private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

  @RequestMapping(value = "/pushData", method = RequestMethod.POST)
  public ModelAndView insertEmployeeData(
      @RequestParam String employeeName,
      @RequestParam String employeeEmail,
      @RequestParam String employeePassword) {
    ModelAndView mv = new ModelAndView();
    OperationOnEmployee operation = new OperationOnEmployee();
    Employee employee = new Employee();
    EmployeeService service = new EmployeeService();
    employee = service.setDetails("0", employeeName, employeeEmail, employeePassword);
    int rowAffected = operation.insertData(employee);
    System.out.println("EmployeeController::insertEmployeeData -> Data inserted Successfully");
    log.info("EmployeeController::insertEmployeeData -> Data inserted Successfully");
    log.debug("EmployeeController::insertEmployeeData -> Data inserted Successfully");
    log.error("insertEmployeeData Method :: Data inserted Successfully");
    if (rowAffected > 0) {
      log.info("EmployeeController::insertEmployeeData -> Data inserted Successfully");
      mv = viewData();
    } else {
      mv.setViewName("display.jsp");
      mv.addObject("msg", "something went wrong");
    }
    return mv;
  }

  @RequestMapping(value = "/viewData")
  public ModelAndView viewData() {
    ModelAndView mv = new ModelAndView();
    OperationOnEmployee operation = new OperationOnEmployee();
    ArrayList<Employee> listOfEmployee = new ArrayList<Employee>();
    listOfEmployee = operation.getAllDataOfEmployee();
    mv.setViewName("display.jsp");
    mv.addObject("listOfEmployee", listOfEmployee);
    return mv;
  }

  @RequestMapping(value = "/update")
  public ModelAndView getData(@RequestParam String id) {
    ModelAndView mv = new ModelAndView();
    OperationOnEmployee operation = new OperationOnEmployee();
    ArrayList<Employee> listOfEmployee = new ArrayList<Employee>();
    listOfEmployee = operation.getDataOfEmployee(Integer.parseInt(id));
    mv.setViewName("update.jsp");
    mv.addObject("listOfEmployee", listOfEmployee);
    return mv;
  }

  @RequestMapping(value = "/updateData", method = RequestMethod.POST)
  public ModelAndView putData(
      @RequestParam String employeeId,
      @RequestParam String employeeName,
      @RequestParam String employeeEmail,
      @RequestParam String employeePassword) {
    ModelAndView mv = new ModelAndView();
    OperationOnEmployee operation = new OperationOnEmployee();
    Employee employee = new Employee();
    employee =
        EmployeeService.setDetails(employeeId, employeeName, employeeEmail, employeePassword);
    int rowAffected = operation.updateData(employee);
    if (rowAffected > 0) {
      mv = viewData();
    } else {
      mv.setViewName("update.jsp");
      mv.addObject("msg", "SomeThing went Wrong");
    }
    return mv;
  }

  @RequestMapping(value = "/delete")
  public ModelAndView popData(@RequestParam String id) {
    ModelAndView mv = new ModelAndView();
    OperationOnEmployee operation = new OperationOnEmployee();
    int rowAffected = operation.deleteDataOfEmployee(Integer.parseInt(id));
    if (rowAffected > 0) {
      mv = viewData();
    }
    return mv;
  }
}
