package week4.task_1.src.main.java;

import java.util.Scanner;

/**
 * Created by Pavel
 */
public class Calculator
{

    public double add(double a, double b)
    {
        return a + b;
    }

    public double minus(double a, double b)
    {
        return a - b;
    }

    public double divide(double a, double b)
    {

        if (0 == b)
        {
            throw new IllegalArgumentException();
        } else
        {
            return a / b;

        }
    }

    public double multiply(double a, double b)
    {
        return a * b;
    }

    public static void main(String[] args)
    {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input first parameter: ");
        double a = scanner.nextDouble();
        System.out.print("Input first parameter: ");
        double b = scanner.nextDouble();

        double res1 = calculator.add(a, b);
        double res2 = calculator.minus(a, b);
        double res3 = calculator.divide(a, b);
        double res4 = calculator.multiply(a, b);

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
        scanner.close();
    }
}
