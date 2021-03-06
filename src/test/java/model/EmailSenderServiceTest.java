package model;

import org.junit.jupiter.api.Test;
import springbootserver.model.EmailSenderService;
import springbootserver.model.Item;
import springbootserver.model.TodoList;
import springbootserver.model.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmailSenderServiceTest {

    //TODO write at least one unit test
    @Test
    public void testSendMail(){
        User user = new User("abc@gmail.com", "Bob", "Joe", "123456789", LocalDate.now().minusYears(20));
        Item item = new Item("item1", "desc1");
        TodoList todo = user.makeTodo("todo1");
        assertTrue(EmailSenderService.sendEmail());
    }
}