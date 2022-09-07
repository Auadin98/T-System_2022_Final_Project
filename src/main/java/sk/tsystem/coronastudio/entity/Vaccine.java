package sk.tsystem.coronastudio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vaccine {

    @Id
    private long id;


    @Column(nullable = false, length = 128)
    private String vaccine;


    @Column(nullable = false, length = 128)
    private String manufacturer;

    public Vaccine() {
    }

    public Vaccine(String vaccine, String manufacturer) {
        this.vaccine = vaccine;
        this.manufacturer = manufacturer;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
