package com.example.Litres.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.Calendar;
import java.util.Collection;
import java.util.Set;
import java.util.Objects;

/**
 * \brief Сущность Пользователь - содержит информацию о пользователе информационной системы.
 * \details Класс User создан для реализации сущности Пользователя информационной системы, зарегистрированного на сайте.
 * \author Stanislav
 * \date 10 March 2023
 */

@Entity
@Table(name = "user_data")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private boolean account_activity;
    private String password;
    private String username;
    private String email;
    private String surname;
    private String name;
    private String middle_name;
    private Calendar birth_date;

    public User() {
    }

    public User(String password, String username, String email, String surname, String name, String middle_name, Calendar birth_date) {
        this.account_activity = true;
        this.password = password;
        this.username = username;
        this.email = email;
        this.surname = surname;
        this.name = name;
        this.middle_name = name;
        this.birth_date = birth_date;      
    }

    public User(String password, String username){
        this.password = password;
        this.username = username;
    }
    
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        throw new UnsupportedOperationException("Unimplemented method 'isEnabled'");
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRole();
    }

    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<UserRole> role;

    public Set<UserRole> getRole() {
        return role;
    }

    public void setRole(Set<UserRole> role) {
        this.role = role;
    }

    public void newRole(Set<UserRole> role){
        this.role = null;
        this.role = role;
    }

    /** Getters and Setters */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getAccount_activity() {
        return this.account_activity;
    }

    public void setAccount_activity(boolean account_activity) {
        this.account_activity = account_activity;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddle_name() {
        return this.middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public Calendar getBirth_date() {
        return this.birth_date;
    }

    public void setBirth_date(Calendar birth_date) {
        this.birth_date = birth_date;
    }
}
