package springbootserver.repository;

import org.springframework.stereotype.Service;
import springbootserver.model.Item;
import springbootserver.model.TodoList;
import springbootserver.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository @Service
public class TodoListRepository {

    public ArrayList<TodoList> todoList = new ArrayList<>();

    public TodoListRepository() {
        User user = new User("abc@gmail.com", "Bob", "Joe", "123456789", LocalDate.now().minusYears(20));
        TodoList todo1 = new TodoList(user, "todo1");
        todoList.add(todo1);
        TodoList todo2 = new TodoList(user, "todo2");
        todoList.add(todo2);
    }

    public TodoList getTodoList(int No) {
        return todoList.get(No);
    }

    public TodoList addTodoList(TodoList todo) {
        todoList.add(todo);
        return todo;
    }

    public TodoList updateTodoList(int numTodo, TodoList todo) {
        todoList.set(numTodo, todo);
        return todo;
    }

    public TodoList deleteTodoList(int nb) {
        return todoList.remove(nb);
    }

    public ArrayList<TodoList> getAllTodoLists() {
        return todoList;
    }



}
