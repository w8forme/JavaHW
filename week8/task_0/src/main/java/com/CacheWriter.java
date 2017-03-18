package com;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
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

    public CacheWriter()
    {
    }

    public void init() throws IOException
    {
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
                String textMsg = doText(cache);
                FileUtils.write(file, textMsg, true);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            cache.clear();
            cache = null;
        }
    }

    @Override
    public void write(String msg)
    {
        try
        {
            cache.add(msg);
            if (cache.size() == cacheSize)
            {
                String textMsg = doText(cache);
                FileUtils.write(file, textMsg, true);
                cache.clear();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private String doText(List<String> cache)
    {
        StringBuilder sb = new StringBuilder();
        for (String text : cache)
        {
            sb.append(text);
        }
        return sb.toString();
    }
}

