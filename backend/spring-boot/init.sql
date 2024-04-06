-- MySQL Script updated for compatibility with MySQL 8.0
-- Adjustments made for best practices and compatibility

-- Setting session variables for this script execution
SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- Drop schema if it exists and then create it
DROP SCHEMA IF EXISTS `forumDB`;
CREATE SCHEMA IF NOT EXISTS `forumDB` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `forumDB`;

-- User table
DROP TABLE IF EXISTS `User`;
CREATE TABLE IF NOT EXISTS `User` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `bio` TEXT NULL,
  `dateOfBirth` DATE NULL,
  `location` VARCHAR(55) NULL,
  `admin` BOOLEAN NOT NULL DEFAULT FALSE,
  PRIMARY KEY (`idUser`),
  UNIQUE INDEX `idUser_UNIQUE` (`idUser`),
  UNIQUE INDEX `userName_UNIQUE` (`userName`)
) ENGINE = InnoDB;


-- Insert an example user
-- INSERT INTO `User` (`userName`, `email`) VALUES ('exampleUser', 'example@example.com', 'example bio', '2000-1-1', 'Tampere');

-- Posts table
DROP TABLE IF EXISTS `Posts`;
CREATE TABLE IF NOT EXISTS `Posts` (
  `postID` INT NOT NULL AUTO_INCREMENT,
  `Content` LONGTEXT NOT NULL,
  `Category` VARCHAR(25),
  `postDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `idUser` INT NOT NULL,
  PRIMARY KEY (`postID`),
  UNIQUE INDEX `idPosts_UNIQUE` (`postID`),
  INDEX `userID_idx` (`idUser`),
  CONSTRAINT `userID`
    FOREIGN KEY (`idUser`)
    REFERENCES `User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB;

-- postComments table
DROP TABLE IF EXISTS `postComments`;
CREATE TABLE IF NOT EXISTS `postComments` (
  `commentID` INT NOT NULL AUTO_INCREMENT,
  `content` TEXT NOT NULL,
  `commentDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idUser` INT NOT NULL,
  `postID` INT NOT NULL,
  PRIMARY KEY (`commentID`),
  UNIQUE INDEX `commentID_UNIQUE` (`commentID`),
  INDEX `UserID_idx` (`idUser`),
  INDEX `postID_idx` (`postID`),
  CONSTRAINT `postID_fk`
    FOREIGN KEY (`postID`)
    REFERENCES `Posts` (`postID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idUser_fk`
    FOREIGN KEY (`idUser`)
    REFERENCES `User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB;

-- Resetting session variables to their original values
SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
