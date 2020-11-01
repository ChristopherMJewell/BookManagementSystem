-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bookManagementSystem
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bookManagementSystem
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bookManagementSystem` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `bookManagementSystem` ;

-- -----------------------------------------------------
-- Table `bookManagementSystem`.`Authors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookManagementSystem`.`Authors` (
  `authorsId` INT NOT NULL,
  `firstName` VARCHAR(45) NULL DEFAULT NULL,
  `lastName` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`authorsId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookManagementSystem`.`Reviews`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookManagementSystem`.`Reviews` (
  `reviewId` INT NOT NULL,
  `score` INT NULL DEFAULT NULL,
  `review` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`reviewId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bookManagementSystem`.`Books`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookManagementSystem`.`Books` (
  `bookId` INT NOT NULL,
  `title` VARCHAR(45) NULL DEFAULT NULL,
  `bookDescription` VARCHAR(45) NULL DEFAULT NULL,
  `genre` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`bookId`),
  CONSTRAINT `fk_Books_1`
    FOREIGN KEY (`bookId`)
    REFERENCES `bookManagementSystem`.`Authors` (`authorsId`),
  CONSTRAINT `fk_Books_2`
    FOREIGN KEY (`bookId`)
    REFERENCES `bookManagementSystem`.`Reviews` (`reviewId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
