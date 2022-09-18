package sk.tsystems.coronastudio.server.webservice.agTestsWebServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystems.coronastudio.entity.agTests.SlovakiaAgTests;
import sk.tsystems.coronastudio.service.agTestsServices.SlovakiaAgTestsService;

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

    @GetMapping("/slovakiaSumAgTests")
    public List<SlovakiaAgTests> getSumSlovAgTests(){
        return slovakiaAgTestsService.getSumSlovAgTests();
    }

    @GetMapping("/avgPosRate")
    public List<SlovakiaAgTests> getAvgPosRate(){
        return slovakiaAgTestsService.getAvgPosRate();
    }

    @GetMapping("/posCount")
    public int getPosCount(){
        return slovakiaAgTestsService.getPosCount();
    }

    @GetMapping("/posSum")
    public int getPosSum(){
        return slovakiaAgTestsService.getPosSum();
    }
}
