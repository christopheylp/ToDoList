package springbootserver.controller;

import springbootserver.model.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springbootserver.repository.TodoListRepository;

import java.util.ArrayList;

@RestController
public class TodoListController
{

    @Autowired
    private TodoListRepository todoListRepository;


    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to TodoList Controller.";
    }

    // GET routes qui permet de retourner toutes les todolists
    @RequestMapping(value = "/todos", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ArrayList<TodoList> getTodoLists() {
        return todoListRepository.getAllTodoLists();
    }

    // GET routes qui permet de retourner une todolist grace a sa position
    @RequestMapping(value = "/todos/{No}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public TodoList getTodoList(@PathVariable("No") int nb) {
        return todoListRepository.getTodoList(nb);
    }

    // POST routes qui permet de créer une todolist
    @RequestMapping(value = "/todos", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public TodoList addTodoList(@RequestBody TodoList todo) {
        return todoListRepository.addTodoList(todo);
    }

    // PUT routes qui permet de modifier une todolist
    @RequestMapping(value = "/todos/{No}", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public TodoList updateTodoList(@PathVariable("No") int nb,@RequestBody TodoList todo) {
        return todoListRepository.updateTodoList(nb-1,todo);
    }

    // DELETE routes qui permet de supprimer une todolist
    @RequestMapping(value = "/todos/{No}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public TodoList deleteTodoList(@PathVariable("No") int nb) {
        return todoListRepository.deleteTodoList(nb-1);
    }
}

