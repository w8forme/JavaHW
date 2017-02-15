package week1;

import java.util.Arrays;
import java.util.Scanner;

public class SelectSort
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

    //Метод для сортировки входящего массива.
    public int[] selSort(int[] array)
    {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++)
        {
            int sIndex = i;
            for (int j = i + 1; j < array.length; j++, count++)
            {
                if (array[sIndex] > array[j])
                {
                    sIndex = j;
                }
            }
            int buf = array[i];
            array[i] = array[sIndex];
            array[sIndex] = buf;
            System.out.println(Arrays.toString(array));
        }
        System.out.println("---------------------------------");
        System.out.println((char) 27 + "[31m" + "Всего было сделано " + count + " операций." + (char)27 + "[0m");
        return array;
    }

    public static void main(String[] args)
    {
        SelectSort a = new SelectSort();
        int x = a.userInput();
        a.selSort(a.randomArr(x));
    }

}
