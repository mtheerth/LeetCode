package my.test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.*;
import java.util.stream.Collectors;

import java.util.LinkedHashMap;

class Employe {
    String name;
    String department;
    double salary;
    

    public Employe(String name, String dep, double salary){
    	this.name = name;
    	this.department = dep;
    	this.salary = salary;
    }
    
    public String getName() {
    	return this.name;
    	
    }
	 public String getDepartment() {
	    	return this.department;
	    }
	 public double getSalary() {
	 return this.salary	;
	 }
}

public class Employee {
    public static void main(String[] args) {
        List<Employe> employees = List.of(
                new Employe("Alice", "HR", 10000),
                new Employe("Bob", "Engineering", 55000),
                new Employe("Charlie", "HR", 80000),
                new Employe("David", "Engineering", 70000)
        );
        //example 1
        Map<String, Optional<Employe>> highestSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                		Employe::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employe::getSalary))
                ));

        highestSalaryByDept.forEach((dept, employee) -> {
            System.out.println("Department: " + dept);
            employee.ifPresent(emp -> System.out.println("Highest Salary Employee: " + emp.getName() + " (" + emp.getSalary() + ")"));
        });
        System.out.println("----------------------------");
        // example 2
        Map<String, Set<Employe>> wellPaidEmployeesByDepartment
        = employees.stream().collect(
     		   Collectors.groupingBy(Employe::getDepartment,
         		 Collectors.filtering(e -> ((Employe) e).getSalary() < 60000, Collectors.toSet())));

        wellPaidEmployeesByDepartment.forEach((dept, employee) -> {
      System.out.println("Department: " + dept);
      employee.forEach(emp -> System.out.println(" Salary Employee less than 60000: " + emp.getName() + " (" + emp.getSalary() + ")"));
  });
    }
}
