package com.demo.objects;


import com.demo.entity.User;
import com.demo.service.ActionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
//если например нету такого класса то научиться создавать
//И возможно через дерево научиться самому читать json file
//JPA

@Component
public class Starter
{

    @Autowired
    ActionService actionService;
    private User[] users;

    public void writeInDatabase(String path)
    {
        //JSON from file to Object
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            users = mapper.readValue(new File("src/main/resources/" + path + ".json"), User[].class);
            insert();
        } catch (IOException e) {
            System.out.println("No exist file");
            e.printStackTrace();
        }
    }
    public void remove(String email)
    {
        actionService.removeByEmail(email);
        System.out.println("email - " + email);
    }
    public void removeByIp(String ip_address)
    {
        actionService.removeByIp_address(ip_address);
        System.out.println("ip_address - " + ip_address);
    }
    public void insert() {
        for (int i = 0; i < users.length; i++) {
            actionService.save(users[i]);
        }
    }

}
