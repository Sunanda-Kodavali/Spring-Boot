package com.example.ConsumingOpenStreetMapAPI;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AppController {

    @GetMapping("/")
    public String getLocations(Model model) {
        List<Map<String, Object>> locations = new ArrayList<>();
        locations.add(Map.of("lat", 17.385044, "lon", 78.486671, "label", "first"));
        locations.add(Map.of("lat", 17.380000, "lon", 78.486000, "label", "second"));
        locations.add(Map.of("lat", 17.382000, "lon", 78.485800, "label", "third"));
        locations.add(Map.of("lat", 51.1657, "lon", 10.4515, "label", "Germany"));
        model.addAttribute("locations", locations);
        return "index";
    }
}
