package entity;

import javax.persistence.*;

@Entity
public class VaccinationContacts {
    @Id
    @GeneratedValue
    private long ident;

    @ManyToOne
    @JoinColumn(name = "Hospitals.ident", nullable = false)
    private Hospitals hospitals;
}
