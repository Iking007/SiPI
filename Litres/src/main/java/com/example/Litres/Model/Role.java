package com.example.Litres.Model;

import org.springframework.security.core.GrantedAuthority;

/**
 * \brief Сущность Роль - содержит информацию о роли пользователя.
 * \details Перечисление Role создано для реализации ролей пользователей, зарегистрированных на сайте. Содержит три роли.
 * \author Stanislav
 * \date 10 March 2023
 */

public enum Role implements GrantedAuthority {
    USER,
    MODER,
    ADMIN;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}
