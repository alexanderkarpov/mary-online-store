create database mary_online_store;
create user 'store_admin'@'localhost' identified by 'store_admin'; -- Creates the user
grant all on mary_online_store.* to 'store_admin'@'localhost';