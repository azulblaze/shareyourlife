-- -----------------------------------------------------
-- Table viewed_pritures
-- -----------------------------------------------------
DROP TABLE IF EXISTS viewed_pritures;
go
CREATE  TABLE IF NOT EXISTS viewed_pritures (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  account VARCHAR(100) NULL ,
  id_pictures BIGINT NULL ,
  viewed_time TIMESTAMP NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
go

-- -----------------------------------------------------
-- Table collections
-- -----------------------------------------------------
DROP TABLE IF EXISTS collections;
go
CREATE  TABLE IF NOT EXISTS collections (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  account VARCHAR(100) NULL ,
  name VARCHAR(100) NULL ,
  cover BIGINT NULL ,
  description VARCHAR(200) NULL ,
  create_time TIMESTAMP NULL ,
  PRIMARY KEY (id) ,
  UNIQUE INDEX C_UNIQUE (name ASC) )
ENGINE = InnoDB
go

-- -----------------------------------------------------
-- Table pictures_collection
-- -----------------------------------------------------
DROP TABLE IF EXISTS pictures_collection;
go
CREATE  TABLE IF NOT EXISTS pictures_collection (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  id_collections BIGINT NULL ,
  id_pictures BIGINT NULL ,
  create_time TIMESTAMP NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
go

