package JavaHW3.Bouns_random;

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
