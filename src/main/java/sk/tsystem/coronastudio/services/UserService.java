package sk.tsystem.coronastudio.services;

import sk.tsystem.coronastudio.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getUsersByName(String username);

}
