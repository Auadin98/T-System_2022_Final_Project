package sk.tsystems.coronastudio.service.userServices;

import sk.tsystems.coronastudio.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getUsersByName(String username);

}
