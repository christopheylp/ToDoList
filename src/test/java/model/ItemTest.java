package model;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import springbootserver.model.Item;
import springbootserver.model.TodoList;
import springbootserver.model.User;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ItemTest extends TestCase {

    User user = new User("abc@gmail.com", "Bob", "Joe", "123456789", LocalDate.now().minusYears(20));
    Item item = new Item("item1", "desc1");
    TodoList todo = user.makeTodo("todo1");


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
        String str = IntStream.range(0, 1200).mapToObj(i -> "a").collect(Collectors.joining());
        Item itemTest = new Item("item1", str);
        assertTrue(str.length() > 1000);
        assertTrue(itemTest.content.length() <= 1000);
    }
    
}
