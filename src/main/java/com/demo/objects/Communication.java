package com.demo.objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Communication
{
    @Autowired
    private Starter starter;
    private Scanner scanner;
    public void input()
    {
        this.scanner = new Scanner(System.in);
        System.out.println("What you want to do\n"
                + "Insert Data in Database - write I\n"
                + "Remove Object from Database - write D\n"
                + "Take all variables from Database - write A");
        String commands = scanner.next();
        if(commands.equals("I"))
        {
            System.out.println("Write name file which need to read in resources without .json");
            System.out.println("Example -- Data");
            String path = scanner.next();
            starter.writeInDatabase(path);
        }
        if(commands.equals("D"))
        {
            System.out.println("Write email or ip_address");
            System.out.println("Example (email) -- dadad@gmail.com");
            System.out.println("Example (ip_address) -- 113.227.129.94");
            String input = scanner.next();
            if(input.contains("@"))
            {
                starter.remove(input);
            }
            else
            {
                starter.removeByIp(input);
            }
        }
        if(!commands.equals("I") && !commands.equals("D") && !commands.equals("D"))
        {
            try{
                throw new Exception();
            }catch (Exception e)
            {
                System.out.println("Input is not valid");
            }
        }
    }
}
