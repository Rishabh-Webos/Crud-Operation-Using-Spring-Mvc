package com.validate;
import javax.servlet.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = {"/insertData", "/updateData"})
public class Filters implements Filter {
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    response.setContentType("text/html");
    if (request instanceof HttpServletRequest) {
      String url = ((HttpServletRequest) request).getRequestURL().toString();
      if (url.contains("insertData")) {
        System.out.println("Present");
      } else {
        // System.out.println("Not Present");
        try {
          int id = Integer.valueOf(request.getParameter("employeeId"));
        } catch (NumberFormatException ex) {
          request.setAttribute("id", "Please Enter Number");
          request.getRequestDispatcher("index.jsp").forward(request, response);
        }
      }
    }

    String name = request.getParameter("employeeName");
    Pattern pattern = Pattern.compile("[a-zA-Z]+\\.?");
    Matcher matcher = pattern.matcher(name);
    if (!matcher.matches()) {
      request.setAttribute("name", "Please Enter Proper Name");
      request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    String email = request.getParameter("employeeEmail");
    String password = request.getParameter("employeePassword");
    pattern = Pattern.compile("^(.+)@(.+)$");
    matcher = pattern.matcher(email);
    if (!matcher.matches()) {
      request.setAttribute("mail", "Please Enter valid mail");
      request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
    pattern = Pattern.compile(regex);
    matcher = pattern.matcher(password);
    if (!matcher.matches()) {
      request.setAttribute("password", "Please Enter Proper password");
      request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    chain.doFilter(request, response);
  }
}

