package Week2.Task_3;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Pavel
 */
public class SearchEmployee
{
    private int userInput()
    {
        Scanner in = new Scanner(System.in);
        while (true)
        {
            System.out.print("Введите уникальный ключ сотрудника(0-9): ");
            int num;
            num = in.nextInt();
            if (num < 0 || num > 9)
            {
                System.out.println("Сотрудник не найден! Повторите попытку!");
            }
            else
            {
                in.close();
                return num;
            }
        }
    }

    public void showEmployee(Map<Integer, Employee> m, Integer num)
    {
        while (true)
        {
            for (Map.Entry<Integer, Employee> emp: m.entrySet())
            {
                if (emp.getKey() == num)
                {
                    System.out.println(emp.getValue());
                    break;
                }
            }
            break;
        }
    }

    public static void main(String[] args)
    {
        SearchEmployee a = new SearchEmployee();
        a.showEmployee(EmployeeMap.stafMap(), a.userInput());
    }
}
