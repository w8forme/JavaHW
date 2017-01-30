package JavaHW3.Bouns_random;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Bonus {

    private List<Employee> emp = EmployeeList.addStaff();


    public Employee rndBonus(List<Employee> emp, double bonusSize)
    {
        Random rnd = new Random();
        int a = rnd.nextInt(emp.size());
        Employee e = emp.get(a);
        return e;
    }

    public static void main(String[] args)
    {
        Bonus a = new Bonus();
        List<Employee> b = EmployeeList.addStaff();
        double bonusSize = 2356.25;
        System.out.println("Победитель ежемесячной лотереии: |" + a.rndBonus(b, bonusSize).toString() + "| получает прибавку: " + bonusSize);
    }

}
