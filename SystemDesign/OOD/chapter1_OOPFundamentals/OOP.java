// Encapsulation Example
class Person {
    private String name; // private variable

    public Person(String name) {
        this.name = name;
    }

    public String getName() { // public method
        return name;
    }
}

// Inheritance Example
class Employee extends Person {
    private int employeeId;

    public Employee(String name, int employeeId) {
        super(name);
        this.employeeId = employeeId;
    }
}

// Polymorphism Example
Person p = new Employee("Alice", 101); // Employee IS-A Person
System.out.println(p.getName()); // Calls Person's method

