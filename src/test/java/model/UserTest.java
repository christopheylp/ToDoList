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
    //TODO email

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
    public void testUserIsOlderThan13YearsOld() throws Exception{
        assertTrue(user.birthdate.isBefore(LocalDate.now().minusYears(13)));
    }

    @Test
    public void testUserIsYoungerThan13YearsOld() throws Exception{
        user.setBirthdate(LocalDate.now().minusYears(10));
        assertFalse(user.birthdate.isBefore(LocalDate.now().minusYears(13)));
    }

}