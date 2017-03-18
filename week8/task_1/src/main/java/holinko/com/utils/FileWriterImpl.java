package holinko.com.utils;

import java.io.File;
import java.io.IOException;

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
    }

    public FileWriterImpl()
    {
        this.name = "ua_name.txt";
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

