package sk.tsystems.coronastudio.entity.vaccinations;

import sk.tsystems.coronastudio.entity.Hospitals;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class VaccinationContacts implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "Hospitals.id", nullable = false)
    private Hospitals hospitals;

    @Column(nullable = false)
    private String substitutes_phones;

    @Column(nullable = false)
    private String substitutes_emails;

    @Column(nullable = false)
    private String substitutes_link;

    @Column(nullable = false)
    private String substitutes_note;

    private boolean is_accepting_new_registrations;

    private Date updated_at;

    public VaccinationContacts(){}

    public VaccinationContacts(Hospitals hospitals, String substitutes_phones, String substitutes_emails, String substitutes_link,
                               String substitutes_note, boolean is_accepting_new_registrations, Date updated_at) {
        this.hospitals = hospitals;
        this.substitutes_phones = substitutes_phones;
        this.substitutes_emails = substitutes_emails;
        this.substitutes_link = substitutes_link;
        this.substitutes_note = substitutes_note;
        this.is_accepting_new_registrations = is_accepting_new_registrations;
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "VaccinationContacts{" +
                "hospitals=" + hospitals +
                ", substitutes_phones='" + substitutes_phones + '\'' +
                ", substitutes_emails='" + substitutes_emails + '\'' +
                ", substitutes_link='" + substitutes_link + '\'' +
                ", substitutes_note='" + substitutes_note + '\'' +
                ", is_accepting_new_registrations=" + is_accepting_new_registrations +
                ", updated_at=" + updated_at +
                '}';
    }
}
