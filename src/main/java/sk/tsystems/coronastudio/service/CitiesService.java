package sk.tsystems.coronastudio.service;

import sk.tsystems.coronastudio.entity.Cities;

import java.util.List;
import java.util.Map;

public interface CitiesService {

    public void addCity(Cities cities);

    public List<Cities> getCities();

    List<Map<String, Object>> getActualDataCities();

    public void reset();
}
