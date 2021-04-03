CREATE TABLE IF NOT EXISTS `users` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(20),
    `password` varchar(50),
    )ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `book` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(200),
    `author` varchar(100),
    )ENGINE=InnoDB DEFAULT CHARSET=UTF8;