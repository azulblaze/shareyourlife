-- -----------------------------------------------------
-- Table program_info
-- -----------------------------------------------------
DROP TABLE IF EXISTS program_info ;
go
CREATE  TABLE IF NOT EXISTS program_info (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(100) NULL ,
  short VARCHAR(10) NULL ,
  website VARCHAR(200) NULL ,
  email VARCHAR(200) NULL ,
  log VARCHAR(400) NULL ,
  description TEXT NULL ,
  reg_date TIMESTAMP NULL DEFAULT current_timestamp ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;
go
CREATE INDEX I_NAME ON program_info (name ASC) ;
go

-- -----------------------------------------------------
-- Table discount_info
-- -----------------------------------------------------
DROP TABLE IF EXISTS discount_info ;
go
CREATE  TABLE IF NOT EXISTS discount_info (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  approve_user VARCHAR(100) NOT NULL ,
  approve_result BOOLEAN NULL ,
  approve_time TIMESTAMP NULL ,
  sender_name VARCHAR(100) NOT NULL ,
  sender_mail VARCHAR(100) NOT NULL ,
  sender_link VARCHAR(400) NULL ,
  sender_time TIMESTAMP NULL DEFAULT current_timestamp ,
  read_times BIGINT NULL DEFAULT 0 ,
  support_times BIGINT NULL DEFAULT 0 ,
  content_points BIGINT NULL DEFAULT 0 ,
  content_points_times BIGINT NULL DEFAULT 0 ,
  publish_points BIGINT NULL DEFAULT 0 ,
  publish_points_times BIGINT NULL DEFAULT 0 ,
  p_id BIGINT NOT NULL ,
  discount_category VARCHAR(400) NULL ,
  discount_area VARCHAR(400) NULL ,
  discount_start TIMESTAMP NULL ,
  discount_end TIMESTAMP NULL ,
  info_source VARCHAR(400) NULL ,
  info_title VARCHAR(200) NULL ,
  info_review VARCHAR(1000) NULL ,
  nfo_content TEXT NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;
go

-- -----------------------------------------------------
-- Table merchandise_category
-- -----------------------------------------------------
DROP TABLE IF EXISTS merchandise_category ;
go
CREATE  TABLE IF NOT EXISTS merchandise_category (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  father BIGINT NOT NULL DEFAULT 0 ,
  is_system BOOLEAN NOT NULL DEFAULT false ,
  name VARCHAR(100) NULL ,
  description VARCHAR(500) NULL ,
  add_time TIMESTAMP NULL DEFAULT current_timestamp ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;
go
CREATE INDEX I_NAME ON merchandise_category (name ASC) ;
go

-- -----------------------------------------------------
-- Table manage_user
-- -----------------------------------------------------
DROP TABLE IF EXISTS manage_user ;
go
CREATE  TABLE IF NOT EXISTS manage_user (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  account VARCHAR(100) NOT NULL ,
  password VARCHAR(200) NULL ,
  name VARCHAR(100) NULL ,
  email VARCHAR(200) NULL ,
  isvalid BOOLEAN NOT NULL DEFAULT true ,
  update_time TIMESTAMP NULL DEFAULT current_timestamp ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

go
-- -----------------------------------------------------
-- Table province
-- -----------------------------------------------------
DROP TABLE IF EXISTS province ;
go
CREATE  TABLE IF NOT EXISTS province (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(200) NOT NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;
go
CREATE INDEX I_NAME ON province (name ASC) ;
go

-- -----------------------------------------------------
-- Table City
-- -----------------------------------------------------
DROP TABLE IF EXISTS City ;
go
CREATE  TABLE IF NOT EXISTS City (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  province_id BIGINT NULL ,
  name VARCHAR(200) NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;
go
CREATE INDEX I_NAME ON City (name ASC) ;
go

-- -----------------------------------------------------
-- Table County
-- -----------------------------------------------------
DROP TABLE IF EXISTS County ;
go
CREATE  TABLE IF NOT EXISTS County (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  city_id BIGINT NULL ,
  postcode VARCHAR(20) NULL ,
  name VARCHAR(200) NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;
go
CREATE INDEX I_NAME ON County (name ASC) ;

go

