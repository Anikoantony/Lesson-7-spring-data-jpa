package ru.gb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.model.Product;

public interface ProductRepositorty extends JpaRepository<Product, Long> {


}
