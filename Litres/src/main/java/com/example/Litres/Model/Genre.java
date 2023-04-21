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
@Table(name = "book_ganre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kind_of_literature;
    private String name_genre;
}
