package model;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;



public class UserTest extends TestCase {

    User user = new User("abcaaaaaa@gmail.com", "Bob", "Joe", "12345678", LocalDate.now().minusYears(20));
    User userNoValid = new User("abcaaaaa.gmail.com", "Bob", "Joe", "1", LocalDate.now().minusYears(8));

    @Test
    public void testIsValid() throws Exception{
        assertTrue(userNoValid.isValid());
    }

    @Test
    public void testIsValidWithUserNoValid() throws Exception{
        assertFalse(userNoValid.isValid());
    }

    @Test
    public void testPasswordIsValid(){
        assertTrue(user.passwordIsValid());
        assertFalse(userNoValid.passwordIsValid());
    }

    @Test
    public void testEmailIsValid(){
        assertTrue(user.emailValid());
        assertFalse(userNoValid.emailValid());
    }

    @Test
    public void testFirstNameExist() throws Exception{
        assertNotNull(user.firstname);
    }

    @Test
    public void testLastNameExist() throws Exception{
        assertNotNull(user.lastname);
    }

    @Test
    public void testFirstNameLengthIsLessThan20() throws Exception{
        assertTrue(user.firstname.length()<20);
    }

    @Test
    public void testLastNameLengthIsLessThan20() throws Exception{
        assertTrue(user.lastname.length()<20);
    }

    @Test
    public void testUserAgeIsValid() throws Exception{
        assertTrue(user.AgeIsValid());
        assertFalse(userNoValid.AgeIsValid());
    }

    public void testMakeTodo() {
        TodoList testTodo1 = user.makeTodo("todoValidTest");
        TodoList testTodo2 = userNoValid.makeTodo("todo1");
        assertTrue(testTodo1.name == "todoValidTest");
        assertEquals(null,testTodo2);
    }
}




