CREATE TABLE `location` (
                            `zip_code` VARCHAR(5)  PRIMARY KEY,
                            `city` VARCHAR(50),
                            `state` VARCHAR(50)
);

CREATE TABLE `vehicle`
(
    `vin`         VARCHAR(17) PRIMARY KEY,
    `year`        INT,
    `make`        VARCHAR(50),
    `model`       VARCHAR(50),
    `fk_location` VARCHAR(5),
    FOREIGN KEY (`fk_location`) REFERENCES `location` (`zip_code`)
);