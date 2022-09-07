package sk.tsystem.coronastudio.services;

import sk.tsystem.coronastudio.entity.Cities;

import java.util.List;

public interface CityService {
    void addCity(Cities city);

    List<Cities> getCities();
}
