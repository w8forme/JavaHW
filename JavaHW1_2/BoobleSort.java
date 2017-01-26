package JavaHW1_2;

import java.util.Arrays;
import java.util.Scanner;

public class BoobleSort
{
    //Метод для генерации случайных чисел.
    private int randomInt(int min, int max)
    {
        return (int) (Math.random() * (++max - min)) + min;
    }

    //Метод для создания и заполнения массива случайными числами.
    private int[] randomArr(int size)
    {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = randomInt(-99,99);
        }
        System.out.println("Был создан массив размером " + size + " и заполнен случайными числами:\n" + Arrays.toString(arr)+ "\n");
        return arr;
    }

    //Получение размера массива от пользователя
    private int userInput()
    {
        Scanner in = new Scanner(System.in);
        while (true)
        {
            System.out.print("Введите желаемый размер массива: ");
            int num = in.nextInt();
            if (num <= 0)
            {
                System.out.println("Недопустимый размер массива! Значение должно быть больше нуля!\n");
            }
            else
            {
                in.close();
                return num;
            }
        }
    }

    //Метод для сортировки входящего массива в обратном порядке.
    public int[] bSort(int[] array)
    {
        int count = 0;

        for (int i = array.length; i > 0; i--)
        {

            for (int j = 0; j < i - 1; j++, count++)
            {
                if (array[j] < array[j + 1])
                {
                    int buf = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = buf;
                }
            }
            System.out.println(Arrays.toString(array));
        }
        System.out.println("---------------------------------");
        System.out.println((char) 27 + "[31m" + "Всего было сделано " + count + " операций." + (char)27 + "[0m");
        return array;
    }

    public static void main(String[] args)
    {
        BoobleSort a = new BoobleSort();
        int x = a.userInput();
        a.bSort(a.randomArr(x));
    }
}
