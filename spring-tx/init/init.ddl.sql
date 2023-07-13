CREATE TABLE `user` (
                        `id` bigint(20) NOT NULL,
                        `name` varchar(30) DEFAULT NULL,
                        `account_type` tinyint(2) DEFAULT NULL,
                        `money` int(10) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` (`id`, `name`, `account_type`, `money`) VALUES (0, 'zhangsan', 1, 5000);
INSERT INTO `user` (`id`, `name`, `account_type`, `money`) VALUES (1, 'lisi', 1, 5000);
