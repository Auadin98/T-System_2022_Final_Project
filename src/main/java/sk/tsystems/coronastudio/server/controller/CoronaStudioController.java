package sk.tsystems.coronastudio.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import sk.tsystems.coronastudio.entity.Comment;
import sk.tsystems.coronastudio.service.userServices.CommentService;

import java.util.Date;

@Controller
@RequestMapping("/coronastudio")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class CoronaStudioController {
    @Autowired
    private UserController userController;

    @Autowired
    private CommentService commentService;

    @RequestMapping
    public String processUserInput(Model model) {
        prepareModel(model);
        return "coronastudio";
    }

    @RequestMapping(value = "/jsoncomment", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addComment(@RequestBody String comment) {
        if (userController.isLoggedIn())
            commentService.addComment(new Comment(userController.getLoggedUser(), comment, new Date()));
    }

    private void prepareModel(Model model) {
        model.addAttribute("comments", commentService.getComment());
    }
}
