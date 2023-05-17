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

public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;///< Идентификатор избранного

    @OneToMany
    @JoinColumn(name = "id_book")
    private Book book;///< Идентификатор книги, которая добалена в избранное
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;///< Идентификатор пользователя
}
