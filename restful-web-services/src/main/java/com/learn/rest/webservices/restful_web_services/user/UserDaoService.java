package com.learn.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

    public static List<User> users = new ArrayList<>();

    public static int usercount = 0;

    static{
        users.add(new User(++usercount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usercount, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++usercount, "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findUser(Integer id){
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }

    public User save(User user){
        user.setId(++usercount);
        users.add(user);
        return user;
    }
}
