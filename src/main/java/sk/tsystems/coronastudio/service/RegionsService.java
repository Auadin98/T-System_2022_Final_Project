package sk.tsystems.coronastudio.service;

import sk.tsystems.coronastudio.entity.Cities;
import sk.tsystems.coronastudio.entity.Regions;

import java.util.List;

public interface RegionsService {

    public void addRegion(Regions regions);

    public List<Regions> getRegions();

    public void reset();
}
