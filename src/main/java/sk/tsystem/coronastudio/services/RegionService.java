package sk.tsystem.coronastudio.services;

import sk.tsystem.coronastudio.entity.Regions;

import java.util.List;
public interface RegionService {
    void addRegion(Regions region);
    List<Regions> getRegions();
}
