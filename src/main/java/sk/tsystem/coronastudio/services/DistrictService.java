package sk.tsystem.coronastudio.services;

import sk.tsystem.coronastudio.entity.Districts;

import java.util.List;
public interface DistrictService {
    void addDistrict(Districts district);

    List<Districts> getDistricts();
}
