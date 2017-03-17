package holinko.com.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel
 */
@Component
public class CacheWriter extends FileWriterImpl
{
    private int cacheSize;
    private List<String> cache;

    public CacheWriter(int cacheSize, String fileName)
    {
        super(fileName);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<String>(cacheSize);
    }

    public void init() throws IOException
    {
        System.out.println("In method init");
        super.file = new File(super.name);
        if (!file.canWrite())
        {
            System.out.println("Cannot write file");
        }
    }

    public void destroy()
    {
        System.out.println("In destroy method");
        if (!cache.isEmpty())
        {
            try
            {
                String textMsg = doTextNews(cache);
                FileUtils.write(file, textMsg, true);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            cache.clear();
            cache = null;
        }
    }

    //This method create text from list for writing into file
    private String doTextNews(List<String> cache)
    {
        StringBuilder sb = new StringBuilder();
        String result;
        for (String text : cache)
        {
            sb.append(text);
        }
        result = sb.toString();
        return result;
    }

    @Override
    public void writeToFile(String msg)
    {
        try
        {
            cache.add(msg);
            if (cache.size() == cacheSize)
            {
                String textMsg = doTextNews(cache);
                FileUtils.write(file, textMsg, true);
                cache.clear();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
