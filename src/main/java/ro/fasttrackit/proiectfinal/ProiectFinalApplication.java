package ro.fasttrackit.proiectfinal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.proiectfinal.country.Country;
import ro.fasttrackit.proiectfinal.repository.CountryRepository;

import java.util.List;

@SpringBootApplication
public class ProiectFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProiectFinalApplication.class, args);
	}
    @Bean
	CommandLineRunner atStartup(CountryRepository repository){
		return args -> repository.saveAll(List.of(  new Country("Romania", "Bucuresti", "Europa", 19861408),
				new Country("Bulgaria", "Sofia", "Europa", 7153784),
				new Country("United States of America", "Washington, D.C.", "America", 323947000),
		         new Country("Ungaria", "Budapesta", "Europa", 9772756),
		         new Country("Vietnam","Hanoi", "Asia", 96208984 ),
				new Country("China", "Beijing", "Asia",1403440000),
				new Country("Cuba", "Havana", "America",11210064),
				new Country("Spania", "Barcelona", "Europa",46934632)
		));


	};

	}

