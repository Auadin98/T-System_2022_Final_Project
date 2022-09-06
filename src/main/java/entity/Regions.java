package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Regions implements Serializable {

    @Id
    @GeneratedValue
    private long ident;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String Abbreviation;

    public Regions(){}

    public Regions(String title, String code, String abbreviation) {
        this.title = title;
        this.code = code;
        Abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return "Regions{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", Abbreviation='" + Abbreviation + '\'' +
                '}';
    }
}
