package com.chatservice.springboot;

import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

   @SpringBootApplication(exclude={DataSourceAutoConfiguration.class}) // Remove the exclude when adding a database
   public class SpringBootChatApplication {

       public static void main(String[] args) {
           SpringApplication.run(SpringBootChatApplication.class, args);
       }
   }