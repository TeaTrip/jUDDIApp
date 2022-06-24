package com.wishmaster.ifmo.juddi;

import org.uddi.api_v3.BusinessList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class App {
    public static void main(String[] args) throws Exception {
        SimpleBrowse sb = new SimpleBrowse();
        SimplePublishPortable sp = new SimplePublishPortable();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String command = "";
        while (!command.equals("/exit")){
            System.out.println("Available commands");
            System.out.println("/printAllServices - Find and print all services info");
            System.out.println("/searchByName - Find and print service info by name");
            System.out.println("/registerService - Register new service in jUDDI");
            System.out.println("/exit - exit Terminate program execution");
            System.out.println("Please input command");
            command = reader.readLine();
            switch (command) {
                case  "/printAllServices":
                    sb.PrintAllServices();
                    break;
                case "/searchByName":
                    System.out.println("Please input service name");
                    String name = reader.readLine();
                    sb.FindServiceByName(name);
                    break;
                case "/registerService":
                    System.out.println("Please input business name");
                    String businessName = reader.readLine();
                    System.out.println("Please input service name");
                    String serviceName = reader.readLine();
                    System.out.println("Please input wsdl link");
                    String wsdl = reader.readLine();
                    sp.publish(businessName, serviceName, wsdl);
                    break;
                case "/exit":
                    break;
                default:
                    System.out.println("No such command");
                    System.out.println();
            }
        }
    }
}
