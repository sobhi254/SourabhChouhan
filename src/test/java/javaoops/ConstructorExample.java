package javaoops;

public class ConstructorExample {

    public static void main(String[] args) {
        Employee employee = new Employee("Rahul", 50000);
        employee.printSalary();
    }
}

class Employee {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    void printSalary() {
        System.out.println(name + " salary is " + salary);
    }
}
