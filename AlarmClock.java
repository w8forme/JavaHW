import java.util.Scanner;

public class AlarmClock
{
    public void alarmMsg()
    {
        Scanner in = new Scanner(System.in);
        int num;
        do
        {
            System.out.print("������� ����� �� 0 �� 24: ");
            num = in.nextInt();
        }
        while (num < 0 | num > 24);
        {
            if (num >= 8 && num <= 21)
            {
                System.out.println("������!");
                in.close();
            }
            else
            {
                System.out.println("������� �����!");
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
