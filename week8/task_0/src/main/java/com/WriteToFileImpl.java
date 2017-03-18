package com;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class WriteToFileImpl implements Writer
{
    protected File file;
    protected String name;

    public WriteToFileImpl(String name)
    {
        this.name = name;
        System.out.println("In constr WriteToFileImpl...");
    }

//    public void init() throws IOException{
//        System.out.println("In constr init()...");
//        file = new File(name);
//        if (!file.canWrite()){
//            System.out.println("Cannot write file");
//        }
//    }

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
