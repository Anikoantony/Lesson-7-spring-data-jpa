package ru.gb.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "costumer")
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="phonenumber")
    private String phoneNumber;

    @Column(name = "age")
    private Integer age;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
