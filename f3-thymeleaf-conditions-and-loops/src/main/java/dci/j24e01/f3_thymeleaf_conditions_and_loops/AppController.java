package dci.j24e01.f3_thymeleaf_conditions_and_loops;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppController {

    @GetMapping("/")
    public String root(Model model) {

        List<String> sfGames = List.of(
                "Street Fighter (1987)",
                "Street Fighter II (1991)",
                "Street Fighter II: Champion Edition (1992)",
                "Super Street Fighter II (1993)",
                "Street Fighter Alpha (1995)",
                "Street Fighter Alpha 2 (1996)",
                "Street Fighter Alpha 3 (1998)",
                "Street Fighter III: New Generation (1997)",
                "Street Fighter III: 2nd Impact (1997)",
                "Street Fighter III: 3rd Strike (1999)",
                "Street Fighter IV (2008)",
                "Super Street Fighter IV (2010)",
                "Street Fighter V (2016)",
                "Street Fighter 6 (2023)"
        );

        List<Link> links = List.of(
                new Link("https://www.google.de/", "Google"),
                new Link("https://www.amazon.de/", "Amazon"),
                new Link("https://www.facebook.com/", "Facebook"),
                new Link("https://www.twitter.com/", "Twitter"),
                new Link("https://www.github.com/", "GitHub"),
                new Link("https://www.youtube.com/", "YouTube"),
                new Link("https://www.wikipedia.org/", "Wikipedia"),
                new Link("https://www.linkedin.com/", "LinkedIn"),
                new Link("https://www.netflix.com/", "Netflix"),
                new Link("https://www.reddit.com/", "Reddit")
        );


        model.addAttribute("links", links);
        model.addAttribute("sfGames", sfGames);
        return "index";
    }

    @GetMapping("/bulma")
    public String bulma(Model model) {
        List<Person> people = List.of(
                new Person("Joe", "mightyjoe"),
                new Person("Bob", "b0b"),
                new Person("Jane", "j4n3"),
                new Person("Jack", "j4n3"),
                new Person("Martha", "mightyjoe 1"),
                new Person("Donald", "mightyjoe 2"),
                new Person("Max", "mightyjoe 3"),
                new Person("Maxine", "mightyjoe 4"),
                new Person("Joe", "mightyjoe 5")
        );

        model.addAttribute("people", people);
        return "bulmaExample";
    }
}
