package com.example.Litres.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * \brief Сущность Избранное - содержит информацию о избранном пользователя.
 * \details Класс Favorites необходим для реализации сущности Избранное.
 * \author Roslov
 * \date 17 March 2023
 */

public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;///< Идентификатор избранного

    @OneToMany
    @JoinColumn(name = "id_book")
    private Book book;///< Идентификатор книги, которая добавлена в избранное
    
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;///< Идентификатор пользователя

    public Favorite(){};

    /** Getters and setters */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
