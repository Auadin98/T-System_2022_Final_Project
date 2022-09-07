package sk.tsystem.coronastudio.services;

import sk.tsystem.coronastudio.entity.Vaccines;

import java.util.List;
public interface VaccineService {
    void addVaccine(Vaccines vaccine);
    List<Vaccines> getVaccines();
}
