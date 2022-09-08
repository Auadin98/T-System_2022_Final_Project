package sk.tsystems.coronastudio.server.service;

import sk.tsystems.coronastudio.entity.Districts;

import java.util.List;

public interface DistrictsService {

    public void addDistrict(Districts districts);

    public List<Districts> getDistricts();

    public void reset();
}
