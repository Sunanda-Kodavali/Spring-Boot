package dci.j24.e01.forms;


import java.util.List;

public record Form(String userName,
                   String placeOfBirth,
                   String yearOfBirth,
                   List<String> programmingLanguages,
                   String description) {
}
