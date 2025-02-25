package com.tit.employeepayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.naming.Context;

@SpringBootApplication
@Slf4j
public class EmployeePayrollAppApplication {

	public static void main(String[] args) {
		ApplicationContext context=  SpringApplication.run(EmployeePayrollAppApplication.class, args);
		log.info("Employee Payroll App strated");
		context.getEnvironment().getProperty("environment");


	}

}
