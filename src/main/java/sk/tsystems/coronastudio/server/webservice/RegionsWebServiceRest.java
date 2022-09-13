package sk.tsystems.coronastudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.coronastudio.entity.Regions;
import sk.tsystems.coronastudio.service.RegionsService;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionsWebServiceRest {

    @Autowired
    private RegionsService regionsService;

    @PostMapping
    public void addRegions(@RequestBody Regions regions){
        regionsService.addRegion(regions);
    }

    @GetMapping
    public List<Regions> getRegions(){
        return regionsService.getRegions();
    }
}
