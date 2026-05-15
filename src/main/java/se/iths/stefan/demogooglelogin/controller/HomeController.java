package se.iths.stefan.demogooglelogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.iths.stefan.demogooglelogin.service.QNAService;

@Controller
@RequestMapping("/")
public class HomeController {
    private final QNAService service;

    public HomeController(QNAService service) {
        this.service = service;
    }

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("display", service.displayAll());
        return "home";
    }
}
