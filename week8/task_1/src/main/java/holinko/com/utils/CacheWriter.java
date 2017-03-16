package holinko.com.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel
 */
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
        System.out.println("In constr init()...");
        super.file = new File(super.name);
        if (!file.canWrite())
        {
            System.out.println("Cannot write file");
        }
    }

    public void destroy()
    {
        if (!cache.isEmpty())
        {
            try
            {
                FileUtils.write(file, cache.toString(), true);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            cache.clear();
            cache = null;
        }
    }

    @Override
    public void writeToFile(String msg)
    {
        try
        {
            cache.add(msg);
            if (cache.size() == cacheSize)
            {
                FileUtils.write(file, cache.toString(), true);
                cache.clear();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
