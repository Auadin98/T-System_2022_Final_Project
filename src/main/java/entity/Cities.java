package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Cities implements Serializable {

    @Id
    @GeneratedValue
    private long ident;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "Districts.ident", nullable = false)
    private Districts districts;

    public Cities(){}

    public Cities(String title, String code) {
        this.title = title;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", districts=" + districts +
                '}';
    }
}
