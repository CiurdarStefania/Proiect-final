package ro.fasttrackit.proiectfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.proiectfinal.country.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
