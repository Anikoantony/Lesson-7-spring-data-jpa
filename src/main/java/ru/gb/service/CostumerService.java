package ru.gb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.model.Costumer;
import ru.gb.repository.CostumerRepisitory;

import java.util.List;
import java.util.Optional;

@Service
public class CostumerService {

    @Autowired
    private CostumerRepisitory costumerRepisitory;

    public Optional<Costumer> findById(Long id)
    {
        return costumerRepisitory.findById(id);
    }

    public Optional<Costumer> findByPhoneNumber(String phoneNumber)
    {
        return costumerRepisitory.findByPhoneNumber(phoneNumber);
    }

    public List<Costumer> findByName(String name)
    {return costumerRepisitory.findByNameContaining(name);
    }

    public Costumer findOdest()
    {return costumerRepisitory.getFindOldest();}


    public List<Costumer> findAll()
    {
        return costumerRepisitory.findAll();
    }
}
