ALTER TABLE `users` DROP COLUMN `username`;

ALTER TABLE `users` ADD COLUMN `name` varchar(100) NOT NULL;
