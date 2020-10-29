package ro.fasttrackit.proiectfinal.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.proiectfinal.country.Country;
import ro.fasttrackit.proiectfinal.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository repository;

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public List<Country> getAll() {
        return repository.findAll();
    }

    public Country getCountryOrThrow(final Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find country with id " + id));
    }

    public Optional<Country> getById(final Integer id) {
        return repository.findById(id);
    }

    public Country addCountry(Country country) {
        return repository.save(country);
    }

    public Country replaceCountry(Country country, Integer id) {
        country.setId(id);
        return repository.save(country);
    }

    public Country deleteCountry(Integer id) {
        Country country = getCountryOrThrow(id);
        repository.deleteById(id);
        return country;
    }

}
