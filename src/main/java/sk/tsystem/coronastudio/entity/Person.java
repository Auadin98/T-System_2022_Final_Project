package sk.tsystem.coronastudio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false,length = 30)
    private String email;
    @Column(nullable = false,length = 30)
    private String username;
    @Column(nullable = false,length = 30)
    private String password;



    public Person(){
   }
    public Person(long id, String email, String password, String username) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonname() {
        return username;
    }

    public void setPersonname(String username) {
        this.username = username;
    }
}
