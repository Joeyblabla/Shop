package test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import test.entity.User;
import test.service.UserService;

@Controller
public class FirstController {
    
    @Autowired
    private UserService service;
    
    @RequestMapping("/hello.do")
    public String sayHello(String username) {
        List<User> list = service.getUsers();
        System.out.println("username is: " + username);
        System.out.println(list.size());
        System.out.println(list.get(0).getName());
        return "success";
    }
}
