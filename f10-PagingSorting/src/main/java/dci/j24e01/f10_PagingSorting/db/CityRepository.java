package dci.j24e01.f10_PagingSorting.db;

import dci.j24e01.f10_PagingSorting.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
