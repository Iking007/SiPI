package com.example.Litres.Model;
import lombok.Data;

import javax.persistence.*;

/**
 * \brief Сущность Книга - содержит информацию о книге.
 * \details Класс Book создан для хранения всей необходимой информации о книге, нужной для заполнения страницы книги.
 * \author Stanislav
 * \date 11 March 2023
 */

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;///< Идентификатор книги 
    
    private String title;///< Название книги
    private String img;///< Путь к файлу обложки книги
    private String download;///< Путь к файлу/ссылка для скачивания книги с веб-сайта
    @Column(columnDefinition = "TEXT")
    private String str;///< Текстовое описание книги
    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author author; ///< Идентификатор автора книги
    @ManyToOne
    @JoinColumn(name = "id_genre")
    private Genre genre; ///< Идентификатор жанра книги

    public Book() {
    }

    public Book(String title, String str, Author writer, Genre genre) {
        this.title = title;
        this.str = str;
        /**
         * \todo Дописать, когда будет добавлена таблица писателей: this.id_author = (long) 0; this.id_genre = (long) 0;
         */
    }
    public Book(String title, String str) {
        this.title = title;
        this.str = str;
    }
}



