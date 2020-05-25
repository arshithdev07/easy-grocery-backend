package com.grocery.management;

import com.grocery.management.domain.Currency;
import com.grocery.management.domain.User;
import com.grocery.management.repository.CurrencyRepository;
import com.grocery.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class GroceryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceryManagementApplication.class, args);
	}

	@Autowired
	private CurrencyRepository currencyRepository;

	@Autowired
	private UserRepository userRepository;

	@Bean
	CommandLineRunner runner() {
		return args -> {
//            Save demo data after start
			userRepository.save(new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG"));
			userRepository.save(new User("sullysh", "$2a$04$dBq6WXKrI5Tt0SUTjwImOOZSfTjJ1kbu.0qzfihS2r1Nko8s7AYEi"));

			currencyRepository.save(new Currency("US Dolar", "USD", new BigDecimal(100), new BigDecimal(3.92)));
			currencyRepository.save(new Currency("Euro", "EUR", new BigDecimal(300), new BigDecimal(4.52)));
		};
	}

}
