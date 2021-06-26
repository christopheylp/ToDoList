package springbootserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import springbootserver.model.TodoList;
import springbootserver.model.User;
import springbootserver.repository.ItemRepository;
import springbootserver.repository.TodoListRepository;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TodoListControllerTest{

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    public TodoListRepository todoListRepository;

    @MockBean
    public ItemRepository itemRepository;

    public static ObjectMapper mapper = new ObjectMapper();

    @Test
    @Order(1)
    public void testGetAllTodoLists() throws Exception{
        ArrayList<TodoList> todoList = new ArrayList<>();
        User user = new User("abc@gmail.com", "Bob", "Joe", "123456789", LocalDate.now().minusYears(20));
        TodoList todo1 = new TodoList(user, "todo1");
        todoList.add(todo1);
        TodoList todo2 = new TodoList(user, "todo2");
        todoList.add(todo2);

        Mockito.when(todoListRepository.getAllTodoLists()).thenReturn(todoList);
        mockMvc.perform(get("/todos")).andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].name", Matchers.equalTo("todo1")))
                .andExpect(jsonPath("$[1].name", Matchers.equalTo("todo2")));
    }

    @Test
    @Order(2)
    public void testGetOneTodoList() throws Exception {
        ArrayList<TodoList> todoList = new ArrayList<>();
        User user = new User("abc@gmail.com", "Bob", "Joe", "123456789", LocalDate.now().minusYears(20));
        TodoList todo1 = new TodoList(user, "todo1");
        todoList.add(todo1);
        TodoList todo2 = new TodoList(user, "todo2");
        todoList.add(todo2);

        Mockito.when(todoListRepository.getTodoList(1)).thenReturn(todoList.get(1));
        mockMvc.perform(get("/todos/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.equalTo("todo2")));
    }

    @Test
    @Order(3)
    public void testDeleteTodoList() throws Exception {
        ArrayList<TodoList> todoList = new ArrayList<>();
        User user = new User("abc@gmail.com", "Bob", "Joe", "123456789", LocalDate.now().minusYears(20));
        TodoList todo1 = new TodoList(user, "todo1");
        todoList.add(todo1);
        TodoList todo2 = new TodoList(user, "todo2");
        todoList.add(todo2);

        Mockito.when(todoListRepository.deleteTodoList(0)).thenReturn(todoList.remove(0));

        mockMvc.perform(delete("/todos/0"))
                .andExpect(jsonPath("$.name", Matchers.equalTo("todo1")))
                .andExpect(status().is(204)).andReturn();
    }

    @Test
    @Order(4)
    public void testUpdateTodoList() throws Exception {
//        todoListRepository = new TodoListRepository();
//
//        TodoList todo = new TodoList(new User("abc@gmail.com"),"newtodo");
//
//        Mockito.when(todoListRepository.addTodoList(ArgumentMatchers.any())).thenReturn(todo);
//        String json = mapper.writeValueAsString(todo);
//
//        mockMvc.perform(put("/todos").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
//                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
//                .andExpect(jsonPath("$.name", Matchers.equalTo("newtodo")));
    }

    @Test
    @Order(5)
    public void testAddTodoList() throws Exception {
//        ArrayList<TodoList> todoList = new ArrayList<>();
//        User user = new User("abc@gmail.com", "Bob", "Joe", "123456789", LocalDate.now().minusYears(20));
//        TodoList todo1 = new TodoList(user, "todo1");
//        todoList.add(todo1);
//        TodoList todo2 = new TodoList(user, "todo2");
//        todoList.add(todo2);
//
//        TodoList newtodo = new TodoList(new User("abc@gmail.com"),"newtodo");
//        todoList.add(newtodo);
//
//        Mockito.when(todoListRepository.addTodoList(ArgumentMatchers.any())).thenReturn(todoList.get(2));
//        String json = mapper.writeValueAsString(todoList.get(2));
//
//        mockMvc.perform(post("/todos").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
//                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
//                .andExpect(jsonPath("$.name", Matchers.equalTo("newtodo")));
    }
}