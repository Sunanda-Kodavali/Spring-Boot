package dci.j24e01.f7_springbeans;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PokemonService {
    List<String> getPokemonNames();
    String getPokemonName(int id);
}
