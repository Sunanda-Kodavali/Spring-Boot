package dci.j24e01.f5_fragments;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/gallery")
    public String gallery() {
        return "gallery";
    }
}
