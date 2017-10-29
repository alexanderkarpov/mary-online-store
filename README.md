# mary-online-store
Online Store Full Stack (Java 8, Spring Boot, MySQL, AngularJS, Bootstrap)

**Before  you start:**
1. install git
2. install jdk8
3. install maven2
4. install mysql 5.5+
5. to enable unicode characters support add/replace the following properties in /etc/my.cnf:
``` 
[client]
default-character-set = utf8mb4
[mysql]
default-character-set = utf8mb4
[mysqld]
init-connect='SET NAMES utf8mb4'
collation_server=utf8mb4_unicode_ci
character_set_server=utf8mb4
skip-character-set-client-handshake
```  


**How to start:**
1. ```git clone https://github.com/alexanderkarpov/mary-online-store.git```
2. ```cd mary-online-store```
3. run ```src/main/resources/db/init.sql``` script in the mysql console
4. ```mvn spring-boot:run```
5. visit [localhost:8080](http://localhost:8080)
6. user: ```user```, password: ```111```