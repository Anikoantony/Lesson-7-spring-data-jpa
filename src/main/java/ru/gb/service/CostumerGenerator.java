package ru.gb.service;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.gb.model.Costumer;
import ru.gb.repository.CostumerRepisitory;

@Component
public class CostumerGenerator {

    @Autowired
    private CostumerRepisitory costumerRepisitory;

    @Autowired Faker faker;

    @EventListener(ApplicationReadyEvent.class) //при старте приложения
    // на данном евенте нужно запустить метод
    public void generateCostumer()
    {

        for (int i = 0; i < 10; i++) {
            Costumer costumer = new Costumer();
            costumer.setName(faker.name().fullName());
            costumer.setPhoneNumber(faker.number().digits(6));
            costumer.setAge(faker.number().numberBetween(20,60));
            costumerRepisitory.save(costumer);
        }

    }
}
