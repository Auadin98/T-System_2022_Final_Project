package sk.tsystem.coronastudio.server.webservice.AgTestsWebServiceRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystem.coronastudio.entity.AgTests.RegionAgTests;
import sk.tsystem.coronastudio.entity.AgTests.SlovakiaAgTests;
import sk.tsystem.coronastudio.services.AgTestsServices.RegionAgTestsService;
import sk.tsystem.coronastudio.services.AgTestsServices.SlovakiaAgTestsService;

import java.util.List;

@RestController
@RequestMapping("/api/slovakiaAgTests")
public class SlovakiaAgTestsWebServiceRest {
    @Autowired
    private SlovakiaAgTestsService slovakiaAgTestsService;

    @PostMapping
    public void addSlovAgTest(@RequestBody SlovakiaAgTests slovakiaAgTest){
        slovakiaAgTestsService.addSlovAgTest(slovakiaAgTest);
    }

    @GetMapping
    public List<SlovakiaAgTests> getSlovAgTests(){
        return slovakiaAgTestsService.getSlovAgTests();
    }
}
