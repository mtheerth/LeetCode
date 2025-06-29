class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getDetails() {
        return "Employee: " + name + ", ID: " + id;
    }
}

class EmployeeRepository {
    public void save(Employee emp) {
        System.out.println("Saving employee: " + emp.getDetails());
    }
}

public class SRPDemo {
    public static void main(String[] args) {
        Employee emp = new Employee("Alice", 101);
        EmployeeRepository repo = new EmployeeRepository();
        repo.save(emp);
    }
}

