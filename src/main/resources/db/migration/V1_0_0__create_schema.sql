CREATE TABLE `users`
(
    `id`               bigint NOT NULL AUTO_INCREMENT,
    `first_name`       varchar(255) DEFAULT NULL,
    `last_name`        varchar(255) DEFAULT NULL,
    `role`             enum('ADMIN','DEVELOPER','EMPLOYEE','MANAGER','USER') DEFAULT NULL,
    `registration_date` timestamp(6) DEFAULT NULL,
    `time_zone_offset` varchar(6) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

