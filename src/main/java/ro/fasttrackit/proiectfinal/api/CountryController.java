package ro.fasttrackit.proiectfinal.api;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.proiectfinal.country.Country;
import ro.fasttrackit.proiectfinal.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("api/countries")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAll(){
        return countryService.getAll();
    }

    @GetMapping ("{id}")
    public Country getCountryOrThrow(@PathVariable Integer id){
        return countryService.getCountryOrThrow(id);
    }

    @PostMapping
    Country addCountry(@RequestBody Country country){
        return countryService.addCountry(country);
    }

    @PutMapping("{id}")
    Country replaceCountry(@PathVariable int id, @RequestBody Country country){
        return countryService.replaceCountry(country, id);
    }

    @DeleteMapping("{id}")
    Country country(@PathVariable int id){
        return countryService.deleteCountry(id);
    }

}
