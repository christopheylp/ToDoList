package model;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;



public class TodoListTest extends TestCase {

    User user = new User("abc@gmail.com", "Bob", "Joe", "123",LocalDate.now().minusYears(20));
    Item item = new Item("item1", "desc1");
    TodoList todo = new TodoList(user);

    @Test
    public void testAddItem() {
        this.todo.addItemWithoutTime(item);
        assertEquals(this.todo.items.size(),1);
    }

    @Test
    public void testAddSameItem(){
        this.todo.addItemWithoutTime(item);
        this.todo.addItemWithoutTime(item);
        assertEquals(this.todo.items.size(),1);
    }

    @Test
    public void testVerifyLastInputItem() {
        assertTrue(todo.verifyLastInputItem());
        this.todo.addItem(item);
        assertFalse(todo.verifyLastInputItem());
    }

    @Test
    public void testAddMoreThan10Items(){
        for(int i=0;i<12;i++){
            this.todo.addItemWithoutTime(new Item("item"+i,"content"+i));
        }
        assertEquals(this.todo.items.size(),10);
    }



}