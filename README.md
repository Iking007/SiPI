# WEB-приложение "Электронная библиотека"
Общие положения
---------------
* Приложение состоит и **PostgreSQL** базы данных и **Java-файлов**.
* Для обоих компонентов предусмотрены **docker-контейнеры**.
* Для сборки приложения используется **Maven**.
* При новой сборке проекта командой `mvn clean package` происходит копирование получаемого jar-файла в директорию, откуда Docker переносит данный файл в контейнер.

Запуск приложения
-----------------
Для запуска:
1. Переходим в директорию *~/docker-compose/* с файлом **docker-compose.yml** и выполняем команду:

`    docker-compose up`

2. Переходим по адресу <https://localhost:8080/>.

#### Если произошла ошибка 
Ввиду лени разработчиков возможна следующая ошибка при запуске docker-compose.yml:

`Connection to localhost:5432 refused. Check that the hostname and port are correct and that the postmaster is accepting
TCP/IP connections.`

Тогда необходимо запустить отдельно docker-контейнер с базой данных и Java-код.
Для этого:
1. Запускаем docker-контейнер с БД командой `docker-compose up`, если не сделали этого ранее;
2. Во втором терминале запускаем Java-архив с программой по адресу 
*~/docker-compose/docker/java/Litres-0.0.1-SNAPSHOT.jar* командой
`java -jar Litres-0.0.1-SNAPSHOT.jar`; 
3. Переходим по адресу <https://localhost:8080/>.
