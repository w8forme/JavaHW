package week2.Task_4.Utills;

import java.io.*;


public class FileInput
{
    //This method reads the file and saves the data to the LinkedHashMap, the english word is a key, the russian one is a value.
    public static BufferedReader getFileReader() throws FileNotFoundException
    {
        String filePath = "CoursesHomeTasks\\src\\week2\\Task_4\\rsen.txt"; //This path needs to be changed
        return new BufferedReader(new FileReader(filePath));
    }
}
