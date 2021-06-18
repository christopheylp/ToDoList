package springbootserver.repository;

import springbootserver.model.Item;
import springbootserver.model.TodoList;
import springbootserver.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class TodoListRepository {

    private static final ArrayList<TodoList> todoList = new ArrayList<>();

    static {
        initTodo();
    }

    private static void initTodo() {
        User user = new User("abc@gmail.com", "Bob", "Joe", "123456789", LocalDate.now().minusYears(20));
        TodoList todo1 = new TodoList(user, "todo1");
        TodoList todo2 = new TodoList(user, "todo2");
        TodoList todo3 = new TodoList(user, "todo3");
        todoList.add(todo1);
        todoList.add(todo2);
        todoList.add(todo3);
    }

    public TodoList getTodoList(int No) {
        return todoList.get(No - 1);
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
