package dci.j24e01.f1_intro;

import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {

    int counter = 0;

    @GetMapping("/")
    public String root() {
        return "Hello World";
    }

    @GetMapping("/contacts")
    public String contacts() {
        return "contacts";
    }

    @RequestMapping(path = "/books", method = RequestMethod.GET)
    public String books() {
        return "books";
    }

    @GetMapping("/counter")
    public String counter() {

        counter += 1;
        return "The Counter is: " + counter;
    }

    @GetMapping("/watch")
    public String watch(@RequestParam(name = "name", required = false, defaultValue = "Sunanda") String name, @RequestParam int age) {
        return "you are " + name + " and you are " + age + " years old";
    }


}
