package sk.tsystems.coronastudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.coronastudio.entity.User;
import sk.tsystems.coronastudio.service.userServices.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserWebServiceRest {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUser(@PathVariable String username) {
        return userService.getUsersByName(username);
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
}
