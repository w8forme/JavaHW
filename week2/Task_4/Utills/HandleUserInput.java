package week2.Task_4.Utills;

import java.util.Scanner;

/**
 * Created by Pavel
 */
public class HandleUserInput
{


    public static String handle()
    {
        String word = "";
        try (Scanner in = new Scanner(System.in))
        {
            System.out.print("Введите слово на английском: ");
            word = in.nextLine();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return word;
        }
    }
}
