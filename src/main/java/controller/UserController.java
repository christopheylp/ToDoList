package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController
{

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to RestTemplate Example.";
    }

    @RequestMapping(value = "/users", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<User> getUsers() {
        return userRepository.getAllUsers();
    }
}

