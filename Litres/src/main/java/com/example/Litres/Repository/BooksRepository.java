package com.example.Litres.Repository;

import com.example.Litres.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * \brief Репозиторий книг.
 * \details Интерфейс Spring Data, называемый книжным репозиторием, представляющий собой DAO. Содержит методы для получения всех книг, конкретной книги по идентификатору, и по названию.
 * Необходим для создания страницы книги и реализации поиска книг. 
 * \author Ivan
 * \date 23 March 2023
 * \warning SQL-запрос для демонстрационных целей.
 */

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {

    List<Book> findAll();
    List<Book> findById(long id);
    List<Book> findByTitle(String title);

    // @Query("""
    //         select b from Book b
    //         where upper(b.title) like upper(concat(?1, '%')) or upper(b.writer) like upper(concat(?2, '%')) or upper(b.title) like upper(concat('%', ?3)) or upper(b.writer) like upper(concat('%', ?4))""")
    // List<Book> search(String title, String writer, String title1, String writer1);
    
    




}

