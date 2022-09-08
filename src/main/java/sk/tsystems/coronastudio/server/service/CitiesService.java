package sk.tsystems.coronastudio.server.service;

import sk.tsystems.coronastudio.entity.Cities;

import java.util.List;

public interface CitiesService {

    public void addCity(Cities cities);

    public List<Cities> getCities();

    public void reset();
}
