package model;

import junit.framework.TestCase;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class TodoListTest extends TestCase {

    User user = new User("abc@gmail.com", "Bob", "Joe", "123",LocalDate.now().minusYears(20));
    Item item = new Item("item1", "desc1");
    TodoList todo = new TodoList(user);

    @Test
    public void testAddItem() {
        this.todo.addItem(item);
        assertEquals(this.todo.items.size(),1);
    }

    @Test
    public void testAddMoreThan10Items(){
        //mock
        for(int i=0; i<15;i++){
            this.todo.addItem(item);
        }
        assertEquals(this.todo.items.size(),10);
    }

}