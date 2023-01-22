package ru.gb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.gb.model.Costumer;
import ru.gb.service.CostumerService;

import java.util.List;

@RestController
@RequestMapping("/costumer")
public class CostumerController {

    @Autowired
    private CostumerService costumerService;

    @GetMapping("/{id}")
    public Costumer getById(@PathVariable Long id)
    {
        return costumerService.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/id")
    public Costumer getById2(@RequestParam Long id)
    {
        return costumerService.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // сперва или в h2 консоли найти нумбер или из контроллера по id http://localhost:8080/costumer/id?id=1
    // далее перейти по http://localhost:8080/costumer/phone?number=516885
    @GetMapping("/phone")
    public Costumer getByPhoneNumber(@RequestParam String number)
    {
        return costumerService.findByPhoneNumber(number)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // http://localhost:8080/costumer/search?name=Sang%20Gusikowski
    @GetMapping("/search")
    public List<Costumer> findByName(@RequestParam String name)
    {
        return costumerService.findByName(name);

    }

    // http://localhost:8080/costumer/findold
    @GetMapping("/findold")
    public Costumer findOld()
    {
        return costumerService.findOdest();
    }

}
