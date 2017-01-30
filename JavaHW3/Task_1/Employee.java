package JavaHW3.Task_1;

public class Employee {

    private String name;
    private double salary;

    public Employee(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", зарплата: " + salary;
    }
}
