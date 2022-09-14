package sk.tsystem.coronastudio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import sk.tsystem.coronastudio.entity.User;

import java.util.Arrays;
import java.util.List;

public class UserServiceREST implements UserService{
    @Value("${remote.server.api}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addUser(User user) {
        restTemplate.postForEntity(url+"/user", user, User.class);
    }

    @Override
    public List<User> getUsersByName(String username) {
        return Arrays.asList(restTemplate.getForEntity(url + "/user/" + username, User[].class).getBody());
    }
}
