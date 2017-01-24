import java.util.Arrays;
import java.util.Scanner;

public class BoobleSort
{
    //����� ��� ��������� ��������� �����.
    private int randomInt(int min, int max)
    {
        return (int) (Math.random() * (++max - min)) + min;
    }

    //����� ��� �������� � ���������� ������� ���������� �������.
    private int[] randomArr(int size)
    {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = randomInt(0,99);
        }
        System.out.println("��� ������ ������ �������� " + size + " � �������� ���������� �������:\n" + Arrays.toString(arr)+ "\n");
        return arr;
    }

    //��������� ������� ������� �� ������������
    private int userInput()
    {
        Scanner in = new Scanner(System.in);
        while (true)
        {
            System.out.print("������� �������� ������ �������: ");
            int num = in.nextInt();
            if (num <= 0)
            {
                System.out.println("������������ ������ �������! �������� ������ ���� ������ ����!\n");
            }
            else
            {
                in.close();
                return num;
            }
        }
    }

    //����� ��� ���������� ��������� �������.
    public int[] bSort(int[] array)
    {
        int count = 0;

        for (int i = 0; i < array.length - 1; i++)
        {
            for (int j = i + 1; j < array.length; j++, count++)
            {
                if (array[i] < array[j])
                {
                    int buf = array[j];
                    array[j] = array[i];
                    array[i] = buf;
                }
            }
            System.out.println(Arrays.toString(array));
        }
        System.out.println("---------------------------------");
        System.out.println("����� ���� ������� " + count + " ��������.");
        return array;
    }



    public static void main(String[] args)
    {
        BoobleSort a = new BoobleSort();
        int x = a.userInput();
        a.bSort(a.randomArr(x));
    }
}
