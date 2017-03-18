package com;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MessengerImpl implements Messenger
{
    public MessengerImpl()
    {
    }

    @Override
    public String getMessage()
    {
        System.out.println("Input your message");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
