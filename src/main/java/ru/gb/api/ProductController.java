package ru.gb.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.gb.model.Product;
import ru.gb.service.ProductService;

import java.util.List;

 /*
    2. Сделать RestController позволяющий выполнять следующий набор операции над этой сущностью:
    получение товара по id [ GET .../app/products/{id} ]
    получение всех товаров [ GET .../app/products ]
    создание нового товара [ POST .../app/products ]
    удаление товара по id.[ GET .../app/products/delete/{id} ]
    (Замечание: пока делаем немного не по правилам REST API, эта тема будет разбираться на следующих занятиях, поэтому удаление выполняется через http-метод GET, а не DELETE)
*/

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // http://localhost:8080/products/find/1
    @GetMapping("find/{id}")
    public Product getById(@PathVariable Long id)
    {
        return productService.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // http://localhost:8080/products/all
    // консоль для h2 http://localhost:8080/h2-console
    @GetMapping("/all")
    public List<Product> getAll()
    {
        return productService.findAll();
    }
    // удаление товара по id.[ GET .../app/products/delete/{id} ]
    // (Замечание: пока делаем немного не по правилам REST API, эта тема будет разбираться на следующих занятиях, поэтому удаление выполняется через http-метод GET, а не DELETE)

    // http://localhost:8080/products/delete/1
    @GetMapping("delete/{id}")
    public void deleteById(@PathVariable Long id)
    {
        productService.deleteProductById(id);
    }
    // создание нового товара [ POST .../app/products ]
    // http://localhost:8080/products/add
    @PostMapping("/add")
    public void addProduct(@RequestBody Product product)
    {productService.addProduct(product);}

    /*
    {
        "id" : 3,
            "name" : "Founders Kentucky Breakfast",
            "cost" : 154913
    }
     */



}
