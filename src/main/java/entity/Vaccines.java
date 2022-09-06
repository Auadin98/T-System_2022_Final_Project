package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Vaccines implements Serializable {

    @Id
    @GeneratedValue
    private long ident;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String manufacturer;


}
