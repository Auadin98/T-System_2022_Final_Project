package sk.tsystem.coronastudio.services;

import sk.tsystem.coronastudio.entity.District;
import sk.tsystem.coronastudio.entity.Region;

import java.util.List;

public interface RegionService {
    public List<Region> getRegions();
    void addRegion(Region region);


//    void getRegion(String region);
//
//

}
