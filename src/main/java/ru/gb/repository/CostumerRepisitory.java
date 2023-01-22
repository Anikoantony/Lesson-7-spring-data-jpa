package ru.gb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.model.Costumer;

import java.util.Optional;

public interface CostumerRepisitory extends JpaRepository<Costumer, Long> {

    Optional<Costumer> findByPhoneNumber(String number);
}
