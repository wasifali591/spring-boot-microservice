package com.wasif.springbootmicroservice.services;

import com.wasif.springbootmicroservice.entities.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserService {

    //JPA/Hibernate > Database
    // Static List
    private static List<User> users = new ArrayList<>();
    private static int userCount = 0;
    static {
        users.add(new User(++userCount,"Wasif", LocalDate.now()));
        users.add(new User(++userCount,"Altaf", LocalDate.now().minusYears(20)));
        users.add(new User(++userCount,"Sakir", LocalDate.now().minusYears(24)));
    }

    //get all user
    public List<User> getAll() {
        return users;
    }

    //get user by id
    public User getById(Integer id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    //add a user
    public User add(User user){
        user.setId(++userCount);
        users.add(user);

        return  user;
    }

    // delete a user
    public void delete(Integer id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
