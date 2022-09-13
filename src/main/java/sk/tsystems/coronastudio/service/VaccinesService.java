package sk.tsystems.coronastudio.service;

import sk.tsystems.coronastudio.entity.Vaccines;

import java.util.List;

public interface VaccinesService {

    public void addVaccine(Vaccines vaccines);

    public List<Vaccines> getVaccines();
    public void reset();
}
