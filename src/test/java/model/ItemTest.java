package model;

import junit.framework.TestCase;
import org.junit.Test;

import java.time.LocalDate;

public class ItemTest extends TestCase {

    User user = new User("abc@gmail.com", "Bob", "Joe", "123", LocalDate.now().minusYears(20));
    Item item = new Item("item1", "desc1");
    TodoList todo = new TodoList(user);

    @Test
    public void testVerifAssigned() {
        assertEquals(false,item.verifAssigned(user));
    }

    @Test
    public void testAddAssignement() {
        item.addAssignement(user);
        assertEquals(user.assigned,item);
        assertEquals(item.assigned,user);
    }

    @Test
    public void testAddInTodo() {
        assertEquals(item.addInTodo(todo),todo.items);
    }
}