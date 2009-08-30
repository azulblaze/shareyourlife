-- -----------------------------------------------------
-- Table permissions
-- -----------------------------------------------------
DROP TABLE IF EXISTS permissions;
go
CREATE  TABLE IF NOT EXISTS permissions (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  account VARCHAR(100) NULL ,
  name VARCHAR(100) NULL ,
  PRIMARY KEY (id) ,
  UNIQUE INDEX UNIQUE_P (account ASC, name ASC) )
ENGINE = InnoDB
go
-- -----------------------------------------------------
-- Table resources_permission
-- -----------------------------------------------------
DROP TABLE IF EXISTS resources_permission;
go
CREATE  TABLE IF NOT EXISTS resources_permission (
  id INT NOT NULL AUTO_INCREMENT ,
  dest_type VARCHAR(50) NULL ,
  dest_value VARCHAR(100) NULL ,
  id_permissions BIGINT NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
go
-- -----------------------------------------------------
-- Table permissions_scheme
-- -----------------------------------------------------
DROP TABLE IF EXISTS permissions_scheme;
go
CREATE  TABLE IF NOT EXISTS permissions_scheme (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  id_permissions BIGINT NULL ,
  action VARCHAR(50) NULL ,
  dest_type VARCHAR(50) NULL ,
  dest_value VARCHAR(100) NULL ,
  PRIMARY KEY (id) ,
  INDEX INDEX_PERMISSION (id_permissions ASC) ,
  UNIQUE INDEX UNIQUE_PS (id_permissions ASC, action ASC, dest_type ASC, dest_value ASC) )
ENGINE = InnoDB
go