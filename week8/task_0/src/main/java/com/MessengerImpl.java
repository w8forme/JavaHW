package com;

import java.util.Scanner;

public class MessengerImpl implements Messenger {
    public MessengerImpl() {
        System.out.println("In constr MessengerImpl...");
    }

    @Override
    public String getMessage() {
        System.out.println("Input your message");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
