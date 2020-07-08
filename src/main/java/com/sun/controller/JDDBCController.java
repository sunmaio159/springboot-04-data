package com.sun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/user")
    public List<Map<String,Object>> userList(){
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println(maps);
        return maps;
    }
    @RequestMapping("/addUser")
    public String addUser(){
        String sql = "insert into user(name,pwd) values('赵六','123')";
        jdbcTemplate.update(sql);
        return "add-Ok";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(){
        String sql = "delete from user where id='4' ";
        jdbcTemplate.execute(sql);
        return "delete-Ok";
    }
    @RequestMapping("/updateUser")
    public String updateUser(){
        String sql = "update user set name='赵六六' , pwd='长沙市水水水水' where id='4' ";
        jdbcTemplate.execute(sql);
        return "update-Ok";
    }
}
