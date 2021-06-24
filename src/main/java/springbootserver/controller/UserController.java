package springbootserver.controller;

import springbootserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springbootserver.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController
{
    public UserRepository userRepository;

    @RequestMapping(value = "/users", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ArrayList<User> getUsers() {
        return userRepository.getAllUsers();
    }
}

