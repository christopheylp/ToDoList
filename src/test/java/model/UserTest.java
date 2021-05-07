package model;

import junit.framework.TestCase;
import org.testng.annotations.Test;


import java.time.LocalDate;



public class UserTest extends TestCase {

    User user = new User("abc@gmail.com", "Bob", "Joe", "12345678", LocalDate.now().minusYears(20));

    @Test
    public void testIsValid() throws Exception{
        assertTrue(user.isValid());
    }

    @Test
    public void testFirstNameLengthIsLess20() throws Exception{
        assertTrue(user.firstname.length()<20);
    }



}