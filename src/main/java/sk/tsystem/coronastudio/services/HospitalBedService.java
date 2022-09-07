package sk.tsystem.coronastudio.services;

import sk.tsystem.coronastudio.entity.City;

import java.util.List;

public interface HospitalBedService {

    public List<City> getCities();
    void addCity(City city);

}
