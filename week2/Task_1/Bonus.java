package week2.Task_1;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Pavel
 */
public class Bonus {

    private double userInput()
    {
        Scanner in = new Scanner(System.in);
        while (true)
        {
            System.out.print("Введите размер премии: ");
            double num;
            num = in.nextDouble();
            if (num <= 0)
            {
                System.out.println("Размер премии должен быть больше 0!");
            }
            else
            {
                in.close();
                return num;
            }
        }
    }

    private Employee rndBonus(List<Employee> emp, double bonusSize)
    {
        Random rnd = new Random();
        int a = rnd.nextInt(emp.size());
        Employee e = emp.get(a);
        return e;
    }

    public void showBonus()
    {
        List<Employee> b = EmployeeList.addStaff();
        double bonusSize = userInput();
        System.out.println("Победитель ежемесячной лотереии: |" + rndBonus(b, bonusSize).toString() + "| получает прибавку: " + bonusSize);
    }

    public static void main(String[] args)
    {
        Bonus a = new Bonus();
        a.showBonus();
    }
}
