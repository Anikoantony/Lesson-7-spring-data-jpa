package ru.gb.service;


import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.gb.model.Product;
import ru.gb.repository.ProductRepositorty;

@Component
public class ProductGenerator {

    @Autowired
    private ProductRepositorty productRepositorty;

    @Autowired
    private Faker faker;

    // 1. Создать сущность «Товар» (id, название, стоимость) и соответствующую таблицу в БД. Заполнить таблицу тестовыми данными (20 записей).
    @EventListener(ApplicationReadyEvent.class) //при старте приложения , проверить можно через консоль http://localhost:8080/h2-console/
    public void productGenerator()
    {
        for (int i = 0; i < 20; i++) {
            Product product= new Product();
            product.setName(faker.beer().name());
            product.setCost(faker.number().numberBetween(1000,700000));
            productRepositorty.save(product);

        }
    }
}
