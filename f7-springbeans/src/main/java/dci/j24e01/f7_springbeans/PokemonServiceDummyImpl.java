package dci.j24e01.f7_springbeans;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PokemonServiceDummyImpl implements PokemonService {

    @Override
    public List<String> getPokemonNames() {
        return List.of("Sunanda", "Kodavali");
    }

    @Override
    public String getPokemonName(int id) {
        return id==25 ? "Pikachu" : "I dont know";
    }
}
