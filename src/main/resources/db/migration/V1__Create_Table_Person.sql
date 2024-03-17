CREATE TABLE `tb_person`
(
    `id`         binary(16) NOT NULL,
    `first_name` varchar(255) DEFAULT NULL,
    `last_name`  varchar(255) DEFAULT NULL,
    `gender`     varchar(255) DEFAULT NULL,
    `address`    varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);


-- *************** PostgreSql ***************
-- CREATE TABLE tb_person
-- (
--     id         uuid NOT NULL,
--     first_name varchar(255) DEFAULT NULL,
--     last_name varchar(255) DEFAULT NULL,
--     gender     varchar(255) DEFAULT NULL,
--     address    varchar(255) DEFAULT NULL,
--     PRIMARY KEY (id)
-- );
