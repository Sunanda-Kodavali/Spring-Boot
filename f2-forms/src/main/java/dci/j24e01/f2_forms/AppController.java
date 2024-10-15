package dci.j24e01.f2_forms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("welcomeMessage","hello contact");
        return "contact";
    }

    @GetMapping("/question")
    public String question() {
        return "question";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam String name, Model model) {
        model.addAttribute("name",name);
        return "greeting";
    }
}
