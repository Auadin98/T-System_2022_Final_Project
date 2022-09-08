package sk.tsystems.coronastudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sk.tsystems.coronastudio.entity.Regions;
import sk.tsystems.coronastudio.server.service.RegionsService;

import java.util.List;

public class RegionWebServiceRest {
    @Autowired
    private RegionsService regionService;

    @PostMapping
    public void addRegion(@RequestBody Regions region) {
        regionService.addRegion(region);
    }

    @GetMapping
    public List<Regions> getRegions() {
        return regionService.getRegions();
    }
}