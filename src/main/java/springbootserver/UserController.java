package springbootserver;


import model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;


@SpringBootApplication
@RestController
public class UserController {

   public static void main(String[] args){
       SpringApplication.run(UserController.class,args);
   }
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
