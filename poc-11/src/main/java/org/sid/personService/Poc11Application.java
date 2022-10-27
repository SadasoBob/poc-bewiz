package org.sid.personService;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.sid.personService.model.Person;
import org.sid.personService.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class 	Poc11Application {

	public static void main(String[] args) {
		SpringApplication.run(Poc11Application.class, args);
	}
	
	@Bean
	CommandLineRunner start(PersonRepository personRepository) {
		return args ->{
			for(int i=0; i<100; i++) {

				long startMillis = new Date(100).getTime();
				long endMillis = new Date(10000).getTime();
				long randomMillisSinceEpoch = ThreadLocalRandom
						.current()
						.nextLong(startMillis, endMillis);
				Date randomDate = new Date(randomMillisSinceEpoch);

				Boolean randomSexe = new Random().nextBoolean();

				personRepository.save(new Person(null, createRandomString(), createRandomString(), randomDate, randomSexe));

			}
		};
	}

	public String createRandomString() {
		// create a string of all characters
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		// create random string builder
		StringBuilder sb = new StringBuilder();

		// create an object of Random class
		Random random = new Random();

		// specify length of random string
		int length = 7;

		for(int i = 0; i < length; i++) {

			// generate random index number
			int index = random.nextInt(alphabet.length());

			// get character specified by index
			// from the string
			char randomChar = alphabet.charAt(index);

			// append the character to string builder
			sb.append(randomChar);
		}

		return sb.toString();
	}

}
