package com.amdocs.MySpringCrudProject.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestDBController {

    @GetMapping("/testdb")
    public String testDb() {
        String connectionUrl = "jdbc:mysql://localhost:3306/test";
        String userName = "root";
        String passWord = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(connectionUrl, userName, passWord);
            return "Connected Successfully to: " + connectionUrl;
        } catch (Exception e) {
            e.printStackTrace();
            return "Can't connect to the database!!";
        }
    }
}