package com.example.Litres.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Litres.Model.BookAuthor;
import com.example.Litres.Model.Book;
import com.example.Litres.Model.Genre;

import java.util.List;


public interface BooksRepository extends JpaRepository<Book, Long> {

    List<Book> findAll();
    List<Book> findById(long id);
    List<Book> findByTitle(String title);
    

    @Query("""
        SELECT b FROM Book b WHERE LOWER(b.title) LIKE CONCAT('%', LOWER(:title), '%')
            """)
    List<Book> searchByTitle(@Param("title") String title);

    @Query("""
        SELECT b FROM Book b WHERE b.id_genre = :genre
            """)
    List<Book> searchByGenre(@Param("genre") Genre genre);
    
    @Query("""
        SELECT b FROM Book b WHERE b.id_author = :author
            """)
    List<Book> searchByAuthor(@Param("author") BookAuthor author);
}

