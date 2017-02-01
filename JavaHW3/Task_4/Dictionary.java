package JavaHW3.Task_4;
import java.util.Scanner;

public class Dictionary
{
    //User input
    private String userInput()
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


    public static void main(String[] args)
    {
        Dictionary a = new Dictionary();
        Search.showWord(FileInput.fileRead(), a.userInput());
    }
}
