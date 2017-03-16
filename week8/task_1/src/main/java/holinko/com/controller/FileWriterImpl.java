package holinko.com.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

/**
 * Created by Pavel
 */
public class FileWriterImpl implements FileWriter
{

    protected File file;
    protected String name;

    public FileWriterImpl(String name)
    {
        this.name = name;
        System.out.println("In constr FileWriterImpl...");
    }

    @Override
    public void writeToFile(String msg)
    {
        try
        {
            file = new File(name);
            FileUtils.write(file, msg, true);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

