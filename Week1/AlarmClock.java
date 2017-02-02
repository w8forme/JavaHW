package Week1;

import java.util.Scanner;

public class AlarmClock
{
    public void alarmMsg()
    {
        Scanner in = new Scanner(System.in);
        int num;
        do
        {
            System.out.print("Введите число от 1 до 24: ");
            num = in.nextInt();
        }
        while (num < 1 | num > 24);
        {
            if (num >= 8 && num <= 21)
            {
                System.out.println("Привет!");
                in.close();
            }
            else
            {
                System.out.println("Абонент занят!");
                in.close();
            }
        }
    }

    public static void main(String[] args)
    {
        AlarmClock a = new AlarmClock();
        a.alarmMsg();
    }
}
