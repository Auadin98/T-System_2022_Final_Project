package entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Hospitals implements Serializable{

    @Id
    @GeneratedValue
    private long ident;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "Cities.ident", nullable = false)
    private Cities cities;

    public Hospitals(){}

    public Hospitals(String title, String code) {
        this.title = title;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Hospitals{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", cities=" + cities +
                '}';
    }
}
