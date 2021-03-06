package springbootserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import springbootserver.model.Item;
import springbootserver.model.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springbootserver.repository.ItemRepository;
import springbootserver.repository.TodoListRepository;

import java.util.ArrayList;

@RestController
@Service
public class TodoListController
{
    @Autowired
    public TodoListRepository todoListRepository = new TodoListRepository();

    @Autowired
    public ItemRepository itemRepository;

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
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/todos", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public TodoList addTodoList(@RequestBody TodoList todo) {
        return todoListRepository.addTodoList(todo);
    }

    // PUT routes qui permet de modifier une todolist
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/todos/{No}", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public TodoList updateTodoList(@PathVariable("No") int nb,@RequestBody TodoList todo) {
        return todoListRepository.updateTodoList(nb,todo);
    }

    // DELETE routes qui permet de supprimer une todolist
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/todos/{No}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public TodoList deleteTodoList(@PathVariable("No") int nb) {
        return todoListRepository.deleteTodoList(nb);
    }

    // GET routes qui permet de retourner tout les items
    @RequestMapping(value = "/items", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ArrayList<Item> getAllItems() {
        return itemRepository.getAllItems();
    }


    // GET routes qui permet de retourner un item grace a sa position
    @RequestMapping(value = "/items/{No}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Item getItem(@PathVariable("No") int nb) {
        return itemRepository.getItem(nb);
    }


    // PUT routes qui permet d'ajouter un item a une todolist'
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/items/inTodo/{No}", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public TodoList addItemInTodo(@PathVariable("No") int indexTodo, @RequestBody Item item) {
        return itemRepository.addItemInTodo(todoListRepository.getTodoList(indexTodo),item);
    }

    // DELETE routes qui permet de supprimer une todolist TODO
    @RequestMapping(value = "/items/inTodo/{indexTodo}/{indexItem}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public TodoList deleteItemInTodo(@PathVariable("indexTodo") int indexTodo, @PathVariable("indexItem") int indexItem) {
        return itemRepository.deleteItemInTodo(todoListRepository.getTodoList(indexTodo),indexItem);
    }
}



