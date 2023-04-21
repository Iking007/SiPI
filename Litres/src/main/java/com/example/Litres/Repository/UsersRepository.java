package com.example.Litres.Repository;


import com.example.Litres.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * \brief Репозиторий пользователей.
 * \details Интерфейс Spring Data, называемый репозиториемпользователей, представляющий собой DAO. Содержит методы для получения всех пользователей, конкретного пользователя по email.
 * \author Ivan
 * \date 24 March 2023
 */

public interface UsersRepository extends JpaRepository<User, Long> {

    List<User> findAll();
    User findByEmail(String email);
}
