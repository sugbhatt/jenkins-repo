package com.example.myapp;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyappController {

    @RequestMapping("/")
    public String greeting() throws UnknownHostException{
        return "Hello again Jenkins! Date: " + new SimpleDateFormat("yyyy-MM-dd:HH.mm.ss").format(new Date()) + " from Host: " + InetAddress.getLocalHost().getHostName(); 
    }
  
}
