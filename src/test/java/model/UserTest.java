package model;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;



public class UserTest extends TestCase {


    User user = new User("abcaaaaaa@gmail.com", "Bob", "Joe", "12345678", LocalDate.now().minusYears(20));

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    User userMocked =  Mockito.mock(User.class);


    @Test
    public void testIsValid() throws Exception{
        assertTrue(user.isValid());
    }
    @Test
    public void testEmailIsValid(){
        assertTrue(user.emailValid());
    }
    @Test
    public void testEmailWithoutAtMark(){
        //TODO user.email only
        User user1 = new User("abc.gmail.com", "Bob", "Joe", "12345678", LocalDate.now().minusYears(20));
        assertFalse(user1.emailValid());
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
    public void testUserIsOlderThan13YearsOld() throws Exception{
        assertTrue(user.birthdate.isBefore(LocalDate.now().minusYears(13)));
    }

    @Test
    public void testUserIsYoungerThan13YearsOld() throws Exception{
        user.setBirthdate(LocalDate.now().minusYears(10));
        assertFalse(user.birthdate.isBefore(LocalDate.now().minusYears(13)));
    }

}




