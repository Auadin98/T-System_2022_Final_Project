package sk.tsystem.coronastudio.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CoronaStudioController {
    @RequestMapping("/coronastudio")
    public String mainPage(){return "coronastudio";}
}
