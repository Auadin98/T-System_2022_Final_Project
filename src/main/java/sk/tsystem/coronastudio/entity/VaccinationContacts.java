package sk.tsystem.coronastudio.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class VaccinationContacts {

    @Id
    private long id;


    @Column(nullable = false, length = 128)
    private String Phones;

    @Column(nullable = true, length = 128)
    private String Emails;

    @Column(nullable = true, length = 128)
    private String Link;

    @Column(nullable = true, length = 128)
    private String Note;





    @ManyToOne
    @JoinColumn(name="hospital.id", nullable = false)
    private Hospital hospital2;

    public VaccinationContacts(){

    }

    public VaccinationContacts(String phones, String emails, String link, String note) {
        Phones = phones;
        Emails = emails;
        Link = link;
        Note = note;
    }

    public String getPhones() {
        return Phones;
    }

    public void setPhones(String phones) {
        Phones = phones;
    }

    public String getEmails() {
        return Emails;
    }

    public void setEmails(String emails) {
        Emails = emails;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

}
