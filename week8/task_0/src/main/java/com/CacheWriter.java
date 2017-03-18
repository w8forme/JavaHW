package com;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CacheWriter extends WriteToFileImpl
{
    private int cacheSize;
    private List<String> cache;

    public CacheWriter(int cacheSize, String fileName)
    {
        super(fileName);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<>(cacheSize);
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
            //write();
            cache.clear();
            cache = null;
        }
    }

    @Override
    public void write(String msg)
    {
        try
        {
            StringBuilder sb = new StringBuilder();
            cache.add(msg + "\n");
            if (cache.size() == cacheSize)
            {
                System.out.println(cache.toString());
                FileUtils.write(file, cache.toString(), true);
                for (String s : cache)
                {
                    sb.append(s + "\n");
                }
                cache.clear();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

