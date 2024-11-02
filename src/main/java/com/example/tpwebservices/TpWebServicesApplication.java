package com.example.tpwebservices;

import com.example.tpwebservices.Entity.Compte;
import com.example.tpwebservices.Repository.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class TpWebServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpWebServicesApplication.class, args);
    }


    @Bean
    CommandLineRunner start(CompteRepository compteRepository) {
        return args -> {
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), Compte.TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), Compte.TypeCompte.COURANT));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), Compte.TypeCompte.EPARGNE));

            compteRepository.findAll().forEach(System.out::println);
        };
    }
}
