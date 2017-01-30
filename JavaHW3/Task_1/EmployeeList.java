package JavaHW3.Task_1;
import java.util.ArrayList;
import java.util.List;


public class EmployeeList {



    public static List<Employee> addStaff()
    {
        List<Employee> staff = new ArrayList<Employee>();
        staff.add(new Employee("Сергей Иванов", 7000.0));
        staff.add(new Employee("Варвара Полтавская", 15000.0));
        staff.add(new Employee("Алексей Петров", 4000.0));
        staff.add(new Employee("Василий Пупкин", 7000.0));
        staff.add(new Employee("Антон Антонов", 5000.0));
        staff.add(new Employee("Лилия Цветочная", 10000.0));
        staff.add(new Employee("Василиса Прекрасная", 2000.0));

        return staff;
    }





}
