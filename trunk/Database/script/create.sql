
CREATE SCHEMA IF NOT EXISTS twitpic DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE twitpic;

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
  upload_time TIMESTAMP NULL DEFAULT current_timestamp ,
  status INT NULL DEFAULT 1 ,
  viewed_times BIGINT NULL DEFAULT 0 ,
  device VARCHAR(50) NULL ,
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
ENGINE = InnoDB;
go

-- -----------------------------------------------------
-- Table messages
-- -----------------------------------------------------
DROP TABLE IF EXISTS messages;
go
CREATE  TABLE IF NOT EXISTS messages (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  from_user VARCHAR(100) NULL ,
  to_user VARCHAR(100) NULL ,
  type VARCHAR(50) NULL ,
  category VARCHAR(50) NULL ,
  status VARCHAR(50) NULL ,
  title VARCHAR(45) NULL ,
  content TEXT NULL ,
  create_time TIMESTAMP NULL DEFAULT current_timestamp ,
  update_time TIMESTAMP NULL ,
  PRIMARY KEY (id) ,
  INDEX FROM_INDEX (from_user ASC) ,
  INDEX TO_INDEX (to_user ASC) )
ENGINE = InnoDB;
go
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
  id BIGINT NOT NULL AUTO_INCREMENT ,
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
  UNIQUE INDEX C_UNIQUE (account ASC,name ASC) )
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

-- -----------------------------------------------------
-- Table groups
-- -----------------------------------------------------
DROP TABLE IF EXISTS groups ;
go
CREATE  TABLE IF NOT EXISTS groups (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  account VARCHAR(100) NULL ,
  name VARCHAR(45) NULL ,
  create_time TIMESTAMP NULL DEFAULT current_timestamp,
  PRIMARY KEY (id) )
ENGINE = InnoDB
go

-- -----------------------------------------------------
-- Table users_group
-- -----------------------------------------------------
DROP TABLE IF EXISTS users_group ;
go
CREATE  TABLE IF NOT EXISTS users_group (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  id_groups BIGINT NULL ,
  src_account VARCHAR(100) NULL ,
  account VARCHAR(100) NULL ,
  status INT NULL ,
  update_time TIMESTAMP NULL DEFAULT current_timestamp ,
  PRIMARY KEY (id) ,
  INDEX I_GROUP (id_groups ASC) )
ENGINE = InnoDB
go

-- -----------------------------------------------------
-- Table follows
-- -----------------------------------------------------
DROP TABLE IF EXISTS follows ;
go
CREATE  TABLE IF NOT EXISTS follows (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  follow VARCHAR(100) NULL ,
  followed VARCHAR(100) NULL ,
  function VARCHAR(45) NULL ,
  status INT NULL ,
  update_time TIMESTAMP NULL DEFAULT current_timestamp ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
go
