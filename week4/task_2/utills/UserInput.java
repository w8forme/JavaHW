package week4.task_2.src.main.java.utills;

import java.util.Scanner;

/**
 * Created by Pavel
 */
public class UserInput
{

    public String userInput()
    {
        String choice;
        try (Scanner in = new Scanner(System.in))
        {
            System.out.println("Доступные валюты:");
            System.out.println(" 1. USD");
            System.out.println(" 2. EUR");
            System.out.println(" З. RUR\n");
            System.out.print("Введите название валюты: ");
            choice = in.nextLine();
            return choice.toUpperCase();
        }
    }
}
