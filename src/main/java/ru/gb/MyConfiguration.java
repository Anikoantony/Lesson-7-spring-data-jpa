package ru.gb;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyConfiguration {

    // Faker - генерит данные и загружаем его в Bean.
    @Bean
    public Faker faker()
    {return new Faker();
    }
}
