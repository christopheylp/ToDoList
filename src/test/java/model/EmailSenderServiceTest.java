package model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmailSenderServiceTest {

    //TODO write at least one unit test
    @Test
    public void testSendMail(){
        User user = new User("abc@gmail.com", "Bob", "Joe", "123", LocalDate.now().minusYears(20));
        Item item = new Item("item1", "desc1");
        TodoList todo = new TodoList(user);


        assertTrue(EmailSenderService.sendEmail());
    }
}