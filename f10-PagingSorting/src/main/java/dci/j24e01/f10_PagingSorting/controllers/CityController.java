package dci.j24e01.f10_PagingSorting.controllers;

import dci.j24e01.f10_PagingSorting.db.CityRepository;
import dci.j24e01.f10_PagingSorting.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class CityController {

    @Autowired
    CityRepository cityRepository;

    @GetMapping({"/","/pagination"})
    public String index(Model model,
                        @RequestParam(defaultValue = "20") int pageSize,
                        @RequestParam(defaultValue = "id") String sortBy,
                        @RequestParam(defaultValue = "1") int pageNumber) {

        Sort sort;
        switch (sortBy) {
            case "name_asc":
                sort = Sort.by("name").ascending();
                break;
            case "name_desc":
                sort = Sort.by("name").descending();
                break;
            case "pop_asc":
                sort = Sort.by("population").ascending();
                break;
            case "pop_desc":
                sort = Sort.by("population").descending();
                break;
            default:
                sort = Sort.by("id");
        }


        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        Page<City> cityPages = cityRepository.findAll(pageable);
        List<City> cities = cityPages.getContent();

        model.addAttribute("cities", cities);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", cityPages.getTotalPages());
        model.addAttribute("currentPage", pageNumber);

        return "index";
    }

}
