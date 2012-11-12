CREATE  TABLE `newgenpos`.`Sales` (
  `salesNumber` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `date` VARCHAR(45) NOT NULL ,
  `total` DOUBLE UNSIGNED NOT NULL ,
  `paymentMethod` VARCHAR(255) NOT NULL ,
  `items` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`salesNumber`) ,
  UNIQUE INDEX `salesNumber_UNIQUE` (`salesNumber` ASC) );
