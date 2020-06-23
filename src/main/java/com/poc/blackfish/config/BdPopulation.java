package com.poc.blackfish.config;

import com.poc.blackfish.domain.model.Address;
import com.poc.blackfish.domain.model.User;
import com.poc.blackfish.repositories.AddressRepository;
import com.poc.blackfish.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class BdPopulation  implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null,
                "Caio",
                "989898859",
                "caio@email.com",
                "45454545454",
                "495855415",
                LocalDate.of(1993, 8, 25),
                true);
        userRepository.save(u1);

        Address address1 = new Address(null, "Av Martinho", 1027, "Araraquara", "São Paulo", "Brasil", "14801070", u1);
        addressRepository.save(address1);
    }
}
