-- -----------------------------------------------------
-- Table providers
-- -----------------------------------------------------
DROP TABLE IF EXISTS providers ;

CREATE  TABLE IF NOT EXISTS providers (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT ,
  name VARCHAR(45) NULL ,
  title VARCHAR(100) NULL ,
  img VARCHAR(200) NULL ,
  domain VARCHAR(200) NULL ,
  level INT NULL ,
  reg_time TIMESTAMP NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci

-- -----------------------------------------------------
-- Table providers_log
-- -----------------------------------------------------
DROP TABLE IF EXISTS providers_log ;

CREATE  TABLE IF NOT EXISTS providers_log (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT ,
  provider_id BIGINT NOT NULL ,
  type VARCHAR(45) NULL ,
  start_time TIMESTAMP NULL ,
  end_time TIMESTAMP NULL ,
  time_lenght VARCHAR(45) NULL ,
  remark VARCHAR(45) NULL ,
  update_time VARCHAR(45) NULL ,
  PRIMARY KEY (id) ,
  INDEX PL_INDEX (id ASC, provider_id ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci

