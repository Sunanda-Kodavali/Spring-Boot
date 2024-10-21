package dci.j24.e01.forms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AppController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/submitform")
    public String submitform(@ModelAttribute Form form,
                             Model model) {
        System.out.println(form);

        String description = form.description();
        description = description.replaceAll(" ", "&nbsp;").replaceAll("\n", "<br/>");

        Map<String, Object> attributes = new HashMap<>();
        attributes.put("userName", form.userName());
        attributes.put("placeOfBirth", form.placeOfBirth());
        attributes.put("yearOfBirth", form.yearOfBirth());
        attributes.put("programmingLanguages", form.programmingLanguages());
        attributes.put("description", description);

        model.addAllAttributes(attributes);

        /*
        model.addAttribute("userName", form.userName());
        model.addAttribute("placeOfBirth", form.placeOfBirth());
        model.addAttribute("yearOfBirth", form.yearOfBirth());
        model.addAttribute("programmingLanguages", form.programmingLanguages());
        model.addAttribute("description", form.description());*/

        return "formDetails";
    }

    @GetMapping("/articles")
    public String articles() {
        return "articles";
    }
}
