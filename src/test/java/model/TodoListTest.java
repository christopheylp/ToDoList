package model;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import springbootserver.model.EmailSenderService;
import springbootserver.model.Item;
import springbootserver.model.TodoList;
import springbootserver.model.User;

import java.time.LocalDate;
import java.util.stream.IntStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoListTest extends TestCase {

    User user = new User("abc@gmail.com", "Bob", "Joe", "123456789",LocalDate.now().minusYears(20));
    User userNoValid = new User("abcaaaaaa@gmail.com", "Bob", "Joe", "1", LocalDate.now().minusYears(20));
    Item item = new Item("item1", "desc1");
    TodoList todo = user.makeTodo("todo1");

    private final TodoList todoListMocked = mock(TodoList.class);

    
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
        IntStream.range(0, 12).forEach(i -> this.todo.addItemWithoutTime(new Item("item" + i, "content" + i)));
        assertEquals(this.todo.items.size(),10);
    }

    @Test
    public void testSendEmailWhenThereIs8Items(){
        when(todoListMocked.isThere8Items()).thenReturn(EmailSenderService.sendEmail());
    }

}