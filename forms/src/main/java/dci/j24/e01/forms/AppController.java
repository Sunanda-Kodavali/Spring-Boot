package dci.j24.e01.forms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/articles")
    public String articles() {
        return "articles";
    }
}
