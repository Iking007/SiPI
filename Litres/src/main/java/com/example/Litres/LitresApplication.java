package com.example.Litres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * \brief Основной класс приложениия
 */
@SpringBootApplication
public class LitresApplication {

	/**
	 * \brief Точка входа в программу
	 * @param[in] args Аргументы командной строки
	 */
	public static void main(String[] args) {
		SpringApplication.run(LitresApplication.class, args);
	}

}
