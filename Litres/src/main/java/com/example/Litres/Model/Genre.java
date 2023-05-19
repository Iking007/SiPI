package com.example.Litres.Model;

import javax.persistence.*;

import lombok.Data;

/**
 * \brief Сущность Жанр - для описания жанра, которому принадлежит книга.
 * \details Класс Genre содержит данные жанра книги. Необходим для фильтрации и сортировки книг по жанрам.
 * \author Stanislav
 * \date 10 March 2023
 */

@Entity
@Data
@Table(name = "book_genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String kind_of_literature;
    private String name;

    public Genre(){};


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKind_of_literature() {
        return this.kind_of_literature;
    }

    public void setKind_of_literature(String kind_of_literature) {
        this.kind_of_literature = kind_of_literature;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
