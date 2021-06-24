package springbootserver.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import springbootserver.repository.TodoListRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Assert;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TodoListController.class)
class TodoListControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TodoListController todoListController;

    @Test
    void welcome(){
        TodoListController todoListController = new TodoListController();
        String response = todoListController.welcome();
        assertEquals("Welcome to TodoList Controller.", response);
    }

    @Test
    void getTodoLists() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/todos"))
                .andExpect(status().isOk());
    }


    @Test
    public void addTodoList() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/todos"))
                .andExpect(status().isCreated());


    }


    @Test
    void updateTodoList() {
    }

    @Test
    void deleteTodoList() {
    }
}