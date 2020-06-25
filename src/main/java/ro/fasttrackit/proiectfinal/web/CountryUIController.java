package ro.fasttrackit.proiectfinal.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.fasttrackit.proiectfinal.country.Country;
import ro.fasttrackit.proiectfinal.service.CountryService;

import java.util.Optional;

@Controller
public class CountryUIController {
    private final CountryService service;

    public CountryUIController(CountryService service) {
        this.service = service;
    }
    @GetMapping
    public String rootPage() {
        return "redirect:/countries";
    }

    @GetMapping("countries")
    public String countriesPage(Model page) {
        page.addAttribute("countries", service.getAll());
        return "countries";
    }

    @GetMapping("countries/{id}")
    public String countryDetails(@PathVariable Integer id, Model page) {
        Optional<Country> country= service.getById(id);
        if (country.isPresent()) {
            page.addAttribute("details", true);
            page.addAttribute("selectedCountry", service.getCountryOrThrow(id));
            return countriesPage(page);
        } else {
            return "redirect:/countries";
        }
    }

}