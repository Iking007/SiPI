package com.example.Litres.service;

import com.example.Litres.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/**
 * \brief Класс получения аутентификационной информации.
 * \details Класс, необходимый для поиска и проверки пользователя по его email в базе данных, реализующий интерфейс UserDetailsService, основанный на DAO.
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usersRepository.findByEmail(email);
    }
}
