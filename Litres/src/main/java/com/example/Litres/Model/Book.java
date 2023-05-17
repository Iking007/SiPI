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
    private String download_link;///< Путь к файлу/ссылка для скачивания книги с веб-сайта
    private String image;///< Путь к файлу обложки книги
    
    @Column(columnDefinition = "TEXT")
    private String description;///< Текстовое описание книги
    private String title;///< Название книги
    
    @ManyToOne
    @JoinColumn(name = "id_author")
    private BookAuthor id_author; ///< Идентификатор автора книги
    
    @ManyToOne
    @JoinColumn(name = "id_genre")
    private Genre id_genre; ///< Идентификатор жанра книги

    /** 
     * TODO доделать связь с таблицей оценок книги
     */
    private float total_rating;///< Рейтинг книги

    public Book() {
    }

    public Book(String title, String description, BookAuthor id_author, Genre id_genre) {
        this.title = title;
        this.description = description;
        this.id_author = id_author; 
        this.id_genre = id_genre;
    }
    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }

    /** Getters and setters */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDownload_link() {
        return this.download_link;
    }

    public void setDownload_link(String download_link) {
        this.download_link = download_link;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookAuthor getId_author() {
        return this.id_author;
    }

    public void setId_author(BookAuthor id_author) {
        this.id_author = id_author;
    }

    public Genre getId_genre() {
        return this.id_genre;
    }

    public void setId_genre(Genre id_genre) {
        this.id_genre = id_genre;
    }

    public float getTotal_rating() {
        return this.total_rating;
    }

    public void setTotal_rating(float total_rating) {
        this.total_rating = total_rating;
    }

}



