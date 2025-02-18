package my.test.pack;

import java.io.*;
import java.util.Arrays;

	class Employee implements Serializable {
	    private String name;
	    private transient int salary; // This field will not be serialized

	    public Employee(String name, int salary) {
	        this.name = name;
	        this.salary = salary;
	    }

	    @Override
	    public String toString() {
	        return "Employee{name='" + name + "', salary=" + salary + "}";
	    }
	}

	public class Transient {
	    public static void main(String[] args) {
	        // Create an Employee object
	        Employee emp = new Employee("John", 50000);

	        // Serialize the object to a file
	        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
	            out.writeObject(emp);
	            System.out.println("Serialized: " + emp);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // Deserialize the object from the file
	        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.ser"))) {
	            Employee deserializedEmp = (Employee) in.readObject();
	            System.out.println("Deserialized: " + deserializedEmp);
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	}


