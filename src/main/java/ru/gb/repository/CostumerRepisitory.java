package ru.gb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gb.model.Costumer;

import java.util.List;
import java.util.Optional;


// Spring создает BIN репозитория
public interface CostumerRepisitory extends JpaRepository<Costumer, Long> {

    // Spring маппирует phoneNumber поле и название метода по PhoneNumber
    // или findByPhoneNumberAndAge , тогда сгенерится запрос select * from costumer
    // where phonenumber =:phonenumber and age =:age
    Optional<Costumer> findByPhoneNumber(String number);

    List<Costumer> findByNameContaining(String name);


    // jql
    @Query("select c from Costumer c where c.age=(select max(cc.age) from Costumer cc)")
    Costumer getFindOldest();

}
