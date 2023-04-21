package com.example.Litres.Model;
import lombok.Data;

import java.sql.Date;

import javax.persistence.*;

/**
 * \brief Сущность Автор - содержит информацию об авторе книги.
 * \details Класс Author создан для реализации сущности Автора книги. Необходим для фильтрации и сортировки книг по авторам.
 * \author Stanislav
 * \date 11 March 2023
 */

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;///< Идентификатор автора

    private String surname_author;///< Фамилия автора
    private String name_author;///< Имя автора
    private String middle_name_author;///< Отчество/второе имя автора
    private Date date_of_birth;///< Дата рождения автора 
    @Column(columnDefinition="text")
    private String description_author;///< Краткая биография автора

    
}