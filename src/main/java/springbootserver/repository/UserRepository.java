package springbootserver.repository;

import springbootserver.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class UserRepository {

    public static final ArrayList<User> userList = new ArrayList<>();

    static {
        initUsers();
    }

    public static void initUsers() {
        User user1 = new User("abc@gmail.com", "Bob", "Joe", "123456789", LocalDate.now().minusYears(20));
        userList.add(user1);
    }

    public User getUser(int userNo) {
        return userList.get(userNo - 1);
    }

    public User addUser(User user) {
        userList.add(user);
        return user;
    }

    public User updateUser(int nbUser, User user) {
        userList.set(nbUser, user);
        return user;
    }

    public void deleteUser(int nbUser) {
        userList.remove(nbUser);
    }

    public ArrayList<User> getAllUsers() {
        return userList;
    }

}
