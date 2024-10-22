package dci.j24e01.f6_db_basics;

public record CarModel(
        Long id,
        Long brandId,
        String name,
        Long year,
        Long horsePower) {
}
