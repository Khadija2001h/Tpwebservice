package com.example.tpwebservices.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tpwebservices.Entity.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}
