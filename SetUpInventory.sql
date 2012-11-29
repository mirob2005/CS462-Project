CREATE SCHEMA `NewGenPOS`;
CREATE  TABLE `newgenpos`.`Inventory` (
  `itemID` INT UNSIGNED NOT NULL ,
  `description` VARCHAR(255) NOT NULL ,
  `price` DOUBLE UNSIGNED NOT NULL ,
  `stock` INT UNSIGNED NULL ,
  PRIMARY KEY (`itemID`) ,
  UNIQUE INDEX `itemID_UNIQUE` (`itemID` ASC) );
INSERT INTO `NewGenPOS`.`Inventory` (`itemID`, `description`, `price`, `stock`) VALUES ('100001', 'Apple iPad Mini', '329.00', '99');
INSERT INTO `NewGenPOS`.`Inventory` (`itemID`, `description`, `price`, `stock`) VALUES ('100002', 'Apple iPad 2', '399.00', '99');
INSERT INTO `NewGenPOS`.`Inventory` (`itemID`, `description`, `price`, `stock`) VALUES ('100010', 'Google Chomebook', '249.00', '99');
INSERT INTO `NewGenPOS`.`Inventory` (`itemID`, `description`, `price`, `stock`) VALUES ('111111', 'USB Cable', '0.99', '99');
