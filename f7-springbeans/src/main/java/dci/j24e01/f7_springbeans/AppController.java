package dci.j24e01.f7_springbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Autowired
    private FancyLogic fancyLogic;

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/")
    public String index() {
        System.out.println(pokemonService.getPokemonNames());
        fancyLogic.doTheFancyLogic();
        return "index";
    }
}
