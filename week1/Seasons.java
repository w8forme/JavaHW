package week1;

import java.util.Scanner;

public class Seasons
{

    public void seasonMsg()
    {
        int num;

        do
        {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите число от 1 до 12: ");
            num = in.nextInt();
            in.close();
        }
        while (num < 0 && num > 12);
        {
            switch (num)
            {
                case 1:
                case 2:
                case 12:
                    System.out.println("Зима!");
                    break;
                case 3:
                case 4:
                case 5:
                    System.out.println("Весна!");
                    break;
                case 6:
                case 7:
                case 8:
                    System.out.println("Лето!");
                    break;
                case 9:
                case 10:
                case 11:
                    System.out.println("Осень!");
                    break;
                default:
                    System.out.println("Неверный параметр!");
                    break;
            }
        }
    }


    public static void main(String[] args)
    {
        Seasons a = new Seasons();
        a.seasonMsg();
    }
}
