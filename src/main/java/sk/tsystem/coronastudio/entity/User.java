package sk.tsystem.coronastudio.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;


    @Column(nullable = false, length = 128)
    private String email;

    @Column(nullable = true, length = 128)
    private String password;

    @Column(nullable = true, length = 128)
    private String username;


}
