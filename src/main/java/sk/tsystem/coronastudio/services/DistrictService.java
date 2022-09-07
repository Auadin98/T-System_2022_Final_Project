package sk.tsystem.coronastudio.services;

import sk.tsystem.coronastudio.entity.City;
import sk.tsystem.coronastudio.entity.District;

import java.util.List;

public interface DistrictService {
    public List<District> getDistrict();
    void addDistricts(District district);
}
