package StreamAPI;

import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + '\'' + 
               ", department='" + department + '\'' + ", salary=" + salary + '}';
    }

    // Equals and hashCode (useful for comparisons and collections)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && 
               Double.compare(employee.salary, salary) == 0 && 
               Objects.equals(name, employee.name) && 
               Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department, salary);
    }
}