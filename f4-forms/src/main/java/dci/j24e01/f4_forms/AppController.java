package dci.j24e01.f4_forms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/formDetails")
    public String formDetails(@ModelAttribute Form form, Model model) {

        System.out.println(form);
        model.addAttribute("form", form);
        return "formDetails";
    }
}
