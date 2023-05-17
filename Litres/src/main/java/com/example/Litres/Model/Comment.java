package com.example.Litres.Model;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * \brief Сущность Комментарий - содержит информацию о комментарии, оставленнго пользователем.
 * \details Класс Comment необходим для реализации сущности Комментарий. Его может оставлять пользователь под любой книгой.
 * \author Stanislav
 * \date 11 March 2023
 */

@Entity
@Data
public class Comment{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;///< Идентификатор комментария

    @OneToMany
    @JoinColumn(name = "id_book")
    private Book book;///< Идентификатор книги, под которой оставлен комментарий
    private Date date;///< Дата, когда был оставлен комментарий
    @Column(columnDefinition="TEXT")
    private String text;///< Текст комментария
    @ManyToOne
    @JoinColumn(name = "id_author")
    private User author;///< Идентификатор автора комментария
}