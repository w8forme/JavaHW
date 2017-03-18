package com;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;

@Component
public class WriteToFileImpl implements Writer
{
    protected File file;
    protected String name;

    public WriteToFileImpl(String name)
    {
        this.name = name;
    }

    public WriteToFileImpl()
    {
    }

    @Override
    public void write(String msg)
    {
        try
        {
            FileUtils.write(file, msg, true);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
