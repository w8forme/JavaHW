package Week2.Task_3;
import java.util.HashMap;
import java.util.Map;

public class EmployeeMap
{

    public static Map<Integer, Employee> stafMap()
    {
        Map<Integer, Employee> empMap = new HashMap<Integer, Employee>();
        Integer x = 0;
        empMap.put(x++, new Employee("Васильчук Джессика Юрьевна"));
        empMap.put(x++, new Employee("Гаврилова Валентина Игоревна"));
        empMap.put(x++, new Employee("Безбердая Лилия Александровна"));
        empMap.put(x++, new Employee("Капустина Ирина Сергеевна"));
        empMap.put(x++, new Employee("Козачук Мария Никитична"));
        empMap.put(x++, new Employee("Мальцева Полина Игоревна"));
        empMap.put(x++, new Employee("Папкина Алена Эдуардовна"));
        empMap.put(x++, new Employee("Корляков Илья Дмитриевич"));
        empMap.put(x++, new Employee("Костин Александр Сергеевич"));
        empMap.put(x++, new Employee("Волобаев Артем Александрович"));


        return empMap;
    }
}
