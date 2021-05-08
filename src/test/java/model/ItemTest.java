package model;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;


public class ItemTest extends TestCase {

    User user = new User("abc@gmail.com", "Bob", "Joe", "123", LocalDate.now().minusYears(20));
    Item item = new Item("item1", "desc1");
    TodoList todo = new TodoList(user);


    @Test
    public void testVerifAssigned() {
        item.assigned =  null;
        assertFalse(item.verifAssigned());
    }

    @Test
    public void testAddAssignement() {
        item.addAssignement(user);
        assertEquals(user.assigned,item);
        assertEquals(item.assigned,user);
    }

    @Test
    public void testAddInTodo() {
        assertTrue(todo.addItem(item));
    }

    @Test
    public void testContentIsLessThan1000(){
        String str = "";
        for(int i=0; i<1200;i++) str += "a";
        Item itemTest = new Item("item1", str);
        assertTrue(str.length() > 1000);
        assertTrue(itemTest.content.length() <= 1000);
    }
}