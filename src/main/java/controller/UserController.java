package controller;

import model.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

public class UserController {
    @GetMapping("/user")
    public User user( @RequestParam(value = "email") String email,
                      @RequestParam(value = "lastname") String lastname,
                      @RequestParam(value = "firstname") String firstname,
                      @RequestParam(value = "password") String password,
                      @RequestParam(value = "birthdate")
                      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthdate)


    //@RequestParam("localDate") LocalDate birthdate)
    {
        return new User(String.format(email, email),
                String.format(lastname, lastname),
                String.format(firstname,firstname),
                String.format(password,password),
                birthdate


        );
    }
}

