package sk.tsystem.coronastudio.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tsystem.coronastudio.entity.AgTests;
import sk.tsystem.coronastudio.services.AgTestsService;
import java.util.List;
@RestController
@RequestMapping("/api/agTests")
public class AgTestsWebServiceRest {
    @Autowired
    private AgTestsService agTestsService;

    @PostMapping
    public void addAgTest(@RequestBody AgTests agTest){
        agTestsService.addAgTest(agTest);
    }

    @GetMapping
    public List<AgTests> getAgTests(){
        return agTestsService.getAgTests();
    }
}
