package sk.tsystem.coronastudio.services;

import sk.tsystem.coronastudio.entity.City;
import sk.tsystem.coronastudio.entity.Hospital;

import java.util.List;

public interface CityService {
    public List<City> getCities();
    void addCity(City city);


}
