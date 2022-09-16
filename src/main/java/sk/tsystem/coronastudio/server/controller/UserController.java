package sk.tsystem.coronastudio.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import sk.tsystem.coronastudio.entity.Comment;
import sk.tsystem.coronastudio.entity.User;
import sk.tsystem.coronastudio.services.CommentService;
import sk.tsystem.coronastudio.services.UserService;

import java.util.Date;
import java.util.List;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class UserController {
    private String loggedUser;

    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;

    @RequestMapping("/register")
    public String register(String userName, String password){
        if(userName.length() > 0 && userName.length() < 16 && password.length() > 0 && password.length() < 16) {
            User user = new User(userName, password);
            userService.addUser(user);
        }
        return "redirect:/coronastudio";
    }

    @RequestMapping("/login")
    public String login(String userName, String password){
        if(isRegistered(userName)) {
            if ((userService.getUsersByName(userName).get(0).getPassword()).equals(password)) {
                this.loggedUser = userName.trim();
                System.out.println(loggedUser);
                return "redirect:/coronastudio";
            }
        }
        this.loggedUser = null;
        return "redirect:/coronastudio";
    }

    @RequestMapping("/logout")
    public String login(){
        this.loggedUser = null;
        return "redirect:/coronastudio";
    }

    public String getLoggedUser() {
        return loggedUser;
    }

    public boolean isLoggedIn() {
        return loggedUser != null;
    }
    public boolean isLogged(){
        return loggedUser.length() != 0;
    }

    public boolean isRegistered(String username) {
        List<User> users = userService.getUsersByName(username);
        int noOfFoundUsers = users.size();
        return noOfFoundUsers != 0;
    }


}
