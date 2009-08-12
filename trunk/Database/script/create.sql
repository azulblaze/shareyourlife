
//CREATE SCHEMA IF NOT EXISTS mydb DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;

//USE mydb;

-- -----------------------------------------------------
-- Table users
-- -----------------------------------------------------
DROP TABLE IF EXISTS users ;
go
CREATE  TABLE IF NOT EXISTS users (
  account VARCHAR(100) NOT NULL ,
  name VARCHAR(100) NOT NULL ,
  email VARCHAR(200) NOT NULL ,
  password VARCHAR(200) NOT NULL ,
  status INT NULL DEFAULT 1 ,
  activity_code VARCHAR(100) NULL ,
  reg_time TIMESTAMP NULL DEFAULT current_timestamp ,
  PRIMARY KEY (account) )
ENGINE = InnoDB;
go
CREATE UNIQUE INDEX UNIQUE_EMAIL ON users (email ASC) ;
go

-- -----------------------------------------------------
-- Table pictures
-- -----------------------------------------------------
DROP TABLE IF EXISTS pictures ;
go
CREATE  TABLE IF NOT EXISTS pictures (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  min VARCHAR(400) NULL ,
  thumb VARCHAR(400) NULL ,
  large VARCHAR(400) NULL ,
  full VARCHAR(400) NULL ,
  PRIMARY KEY (id) )
ENGINE = MyISAM;
go

-- -----------------------------------------------------
-- Table pictures_parameter
-- -----------------------------------------------------
DROP TABLE IF EXISTS pictures_parameter ;
go
CREATE  TABLE IF NOT EXISTS pictures_parameter (
  id_pictures BIGINT NOT NULL ,
  upload_account VARCHAR(100) NOT NULL ,
  upload_time TIMESTAMP NULL ,
  status INT NULL DEFAULT 1 ,
  title VARCHAR(100) NULL ,
  description VARCHAR(1000) NULL ,
  addtion_info TEXT NULL ,
  PRIMARY KEY (id_pictures) )
ENGINE = InnoDB;
go

-- -----------------------------------------------------
-- Table users_profile
-- -----------------------------------------------------
DROP TABLE IF EXISTS users_profile ;
go
CREATE  TABLE IF NOT EXISTS users_profile (
  account VARCHAR(100) NOT NULL ,
  location VARCHAR(200) NULL ,
  picture VARCHAR(400) NULL ,
  signature VARCHAR(100) NULL ,
  self_introduction VARCHAR(1000) NULL ,
  theme INT NULL DEFAULT 1 ,
  login_time TIMESTAMP NULL DEFAULT current_timestamp ,
  PRIMARY KEY (account) )
ENGINE = InnoDB;
go

-- -----------------------------------------------------
-- Table comments
-- -----------------------------------------------------
DROP TABLE IF EXISTS comments ;
go
CREATE  TABLE IF NOT EXISTS comments (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  id_pictures BIGINT NOT NULL ,
  account VARCHAR(100) NOT NULL ,
  comment TEXT NULL ,
  comment_time TIMESTAMP NULL DEFAULT current_timestamp ,
  PRIMARY KEY (id) )
ENGINE = InnoDB;
go

-- -----------------------------------------------------
-- Table tags
-- -----------------------------------------------------
DROP TABLE IF EXISTS tags ;
go
CREATE  TABLE IF NOT EXISTS tags (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(50) NOT NULL ,
  description VARCHAR(200) NULL ,
  account VARCHAR(100) NULL ,
  status INT NULL ,
  create_time TIMESTAMP NULL DEFAULT current_timestamp ,
  PRIMARY KEY (id) )
ENGINE = InnoDB;
go
CREATE UNIQUE INDEX UNIQUE_TAG ON tags (name ASC) ;
go

-- -----------------------------------------------------
-- Table tags_rel
-- -----------------------------------------------------
DROP TABLE IF EXISTS tags_rel ;
go
CREATE  TABLE IF NOT EXISTS tags_rel (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  account VARCHAR(100) NOT NULL ,
  id_pictures BIGINT NULL ,
  id_tags BIGINT NULL ,
  tag_time TIMESTAMP NULL DEFAULT current_timestamp ,
  PRIMARY KEY (id) )
ENGINE = InnoDB;
go
CREATE UNIQUE INDEX UNIQUE_TAG_REL ON tags_rel (id_pictures ASC, id_tags ASC, account ASC) ;
go

-- -----------------------------------------------------
-- Table admins
-- -----------------------------------------------------
DROP TABLE IF EXISTS admins ;
go
CREATE  TABLE IF NOT EXISTS admins (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  account VARCHAR(45) NOT NULL ,
  name VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  start_time TIMESTAMP NULL DEFAULT current_timestamp ,
  end_time TIMESTAMP NULL,
  PRIMARY KEY (id) )
ENGINE = InnoDB
go

select * from admins