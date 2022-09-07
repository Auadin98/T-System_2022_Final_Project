package sk.tsystems.coronastudio.service;

import sk.tsystems.coronastudio.entity.Vaccines;

public interface VaccinesService {

    void addVaccine(Vaccines vaccines);

    void reset();
}
