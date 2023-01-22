package ru.gb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.model.Product;
import ru.gb.repository.ProductRepositorty;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
 /*
    2. Сделать RestController позволяющий выполнять следующий набор операции над этой сущностью:
    получение товара по id [ GET .../app/products/{id} ]
    получение всех товаров [ GET .../app/products ]
    создание нового товара [ POST .../app/products ]
    удаление товара по id.[ GET .../app/products/delete/{id} ]
    (Замечание: пока делаем немного не по правилам REST API, эта тема будет разбираться на следующих занятиях, поэтому удаление выполняется через http-метод GET, а не DELETE)
*/

    @Autowired
    private ProductRepositorty productRepositorty;

    public Optional<Product> findById(Long id)
    {
        return productRepositorty.findById(id);
    };

    public List<Product> findAll()
    {
        return productRepositorty.findAll();
    };

    public void addProduct(Product product)
    {
        productRepositorty.save(product);
    };

    public void deleteProductById(Long id)
    {
        productRepositorty.deleteById(id);
    };

}

