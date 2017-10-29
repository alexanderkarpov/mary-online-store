create database mary_online_store;
create user 'store_admin'@'localhost' identified by 'store_admin'; -- Creates the user
grant all on mary_online_store.* to 'store_admin'@'localhost';

#enable unicode support
ALTER DATABASE mary_online_store CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;