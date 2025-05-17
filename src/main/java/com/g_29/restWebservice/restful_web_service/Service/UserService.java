package com.g_29.restWebservice.restful_web_service.Service;

import com.g_29.restWebservice.restful_web_service.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserService {

    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    static {
        users.add(new User(usersCount++, "Adam", LocalDate.now().minusMonths(30)));
        users.add(new User(usersCount++, "Eve", LocalDate.now().minusMonths(45)));
        users.add(new User(usersCount++, "Jim", LocalDate.now().minusMonths(20)));
        users.add(new User(usersCount++, "Gowtham", LocalDate.now().minusMonths(70)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findUserById(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User addUser(User user) {
        user.setId(usersCount++);
        users.add(user);
        return user;
    }

    public boolean deleteUser(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        return users.removeIf(predicate);
    }
}
