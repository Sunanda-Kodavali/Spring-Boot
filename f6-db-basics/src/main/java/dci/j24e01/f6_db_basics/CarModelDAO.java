package dci.j24e01.f6_db_basics;

import java.util.List;

public interface CarModelDAO {

    List<CarModel> getModels();
    List<CarModel> getModelsByBrandId(Long brandId);
}
