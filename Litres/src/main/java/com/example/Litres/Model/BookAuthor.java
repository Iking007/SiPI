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
public class BookAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;///< Идентификатор автора
    private String surname;///< Фамилия автора
    private String name;///< Имя автора
    private String middle_name;///< Отчество/второе имя автора
    private Date birth_date;///< Дата рождения автора 
    
    @Column(columnDefinition="text")
    private String short_bio;///< Краткая биография автора

    public BookAuthor(){};
    /** Getters and setters */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddle_name() {
        return this.middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public Date getBirth_date() {
        return this.birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getShort_bio() {
        return this.short_bio;
    }

    public void setShort_bio(String short_bio) {
        this.short_bio = short_bio;
    }

}