package model;

import junit.framework.TestCase;
import org.testng.annotations.Test;


import java.time.LocalDate;



public class UserTest extends TestCase {

    User user = new User("abc@gmail.com", "Bob", "Joe", "123", LocalDate.now().minusYears(20));

    @Test
    public void testIsValid() throws Exception{
        assertTrue(user.isValid(user));
    }

    @Test
    public void testFirstNameLengthIsLess20() throws Exception{
        assertTrue(user.firstname.length()<20);
    }



}