package Week2.Task_4;
import Week2.Task_4.Utills.FillMap;
import Week2.Task_4.Utills.HandleUserInput;
import jdk.internal.org.objectweb.asm.Handle;

import java.util.Scanner;

/**
 * Change default path to file "english-russian.txt" in class "FileInput".
 */
public class Dictionary
{
    //User input
    private String userInput()
    {
        return HandleUserInput.handle();
    }


    public static void main(String[] args)
    {
        Dictionary a = new Dictionary();
        Search.showWord(FillMap.parsAndCreate(), a.userInput());
    }
}
