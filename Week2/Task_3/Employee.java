package Week2.Task_3;

/**
 * Created by Pavel
 */
public class Employee
{
    private String name;

    public Employee(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ФИО сотрудника: " + name;
    }
}
