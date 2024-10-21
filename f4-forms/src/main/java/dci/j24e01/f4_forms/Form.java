package dci.j24e01.f4_forms;

import java.time.LocalDate;
import java.util.List;

public record Form(String name,
                   String password,
                   String email,
                   String telephone,
                   LocalDate dateOfBirth,
                   List<String> favCountries,
                   List<String> favDays,
                   String likeOrNot,
                   String description
                   ) {

}
