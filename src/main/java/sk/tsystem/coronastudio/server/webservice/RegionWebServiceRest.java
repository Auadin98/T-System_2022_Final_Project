package sk.tsystem.coronastudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystem.coronastudio.entity.HospitalStaff;
import sk.tsystem.coronastudio.entity.Regions;
import sk.tsystem.coronastudio.services.HospitalStaffService;
import sk.tsystem.coronastudio.services.RegionService;

import java.util.List;

public class RegionWebServiceRest {
    @Autowired
    private RegionService regionService;

    @PostMapping
    public void addRegion(@RequestBody Regions region){
        regionService.addRegion(region);
    }

    @GetMapping
    public List<Regions> getRegions(){
        return regionService.getRegions();
    }
}
