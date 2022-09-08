package sk.tsystems.coronastudio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Cities implements Serializable {

    @Id
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "Districts.id", nullable = false)
    private Districts districts;

    @OneToMany(mappedBy = "id")
    private List<Hospitals> hospitals;

    public Cities(){}

    public Cities(int id, String title, String code, Districts districts) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.districts = districts;
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
