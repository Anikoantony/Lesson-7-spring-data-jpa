package ru.gb.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.gb.model.Product;
import ru.gb.service.ProductService;

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

    // http://localhost:8080/products/1
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id)
    {
        return productService.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
