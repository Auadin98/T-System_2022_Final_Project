package sk.tsystems.coronastudio.server.service;

import sk.tsystems.coronastudio.entity.Vaccines;

import java.util.List;

public interface VaccinesService {

    void addVaccine(Vaccines vaccines);



    List<Vaccines> getVaccines();

    void reset();
}
