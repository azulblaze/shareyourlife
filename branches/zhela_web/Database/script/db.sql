-- -----------------------------------------------------
-- Table program_info
-- -----------------------------------------------------
DROP TABLE IF EXISTS program_info ;
go
CREATE  TABLE IF NOT EXISTS program_info (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(100) NULL ,
  short_name VARCHAR(10) NULL ,
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
DROP TABLE IF EXISTS discount_news ;
go
CREATE  TABLE IF NOT EXISTS discount_news (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  approve_user VARCHAR(100) NULL ,
  approve_result BOOLEAN DEFAULT false ,
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
  news_source VARCHAR(400) NULL ,
  news_title VARCHAR(200) NULL ,
  news_review VARCHAR(1000) NULL ,
  news_content TEXT NULL ,
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
  child BIGINT NOT NULL DEFAULT 0 ,
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
  account VARCHAR(100) NOT NULL ,
  password VARCHAR(200) NULL ,
  name VARCHAR(100) NULL ,
  email VARCHAR(200) NULL ,
  isvalid BOOLEAN NOT NULL DEFAULT true ,
  update_time TIMESTAMP NULL DEFAULT current_timestamp ,
  PRIMARY KEY (account) )
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
DROP TABLE IF EXISTS city ;
go
CREATE  TABLE IF NOT EXISTS city (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  province_id BIGINT NULL ,
  name VARCHAR(200) NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;
go
CREATE INDEX I_NAME ON city (name ASC) ;
go

-- -----------------------------------------------------
-- Table County
-- -----------------------------------------------------
DROP TABLE IF EXISTS county ;
go
CREATE  TABLE IF NOT EXISTS county (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  city_id BIGINT NULL ,
  postcode VARCHAR(20) NULL ,
  name VARCHAR(200) NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;
go
CREATE INDEX I_NAME ON county (name ASC) ;

go

-- -----------------------------------------------------
-- Table comments
-- -----------------------------------------------------
DROP TABLE IF EXISTS comments ;
go
CREATE  TABLE IF NOT EXISTS comments (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  discount_info_id BIGINT NOT NULL ,
  user_name VARCHAR(100) NULL ,
  user_index VARCHAR(200) NULL ,
  user_email VARCHAR(200) NULL ,
  ip_addr VARCHAR(200) NULL ,
  content VARCHAR(1000) NULL ,
  support_times BIGINT NULL DEFAULT 0 ,
  against_times BIGINT NULL DEFAULT 0 ,
  comment_time TIMESTAMP NULL DEFAULT current_timestamp ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
go
CREATE INDEX I_DISCOUNT ON comments (discount_info_id ASC) ;
go

-- -----------------------------------------------------
-- Table attachments
-- -----------------------------------------------------
DROP TABLE IF EXISTS attachments ;
go
CREATE  TABLE IF NOT EXISTS attachments (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  rel_table VARCHAR(45) NOT NULL ,
  rel_table_id BIGINT NULL ,
  file_name VARCHAR(200) NULL ,
  update_time TIMESTAMP  NULL DEFAULT current_timestamp ,
  PRIMARY KEY (id) ,
  INDEX I_TABLE (rel_table ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
go

-- -----------------------------------------------------
-- Table blog_detail
-- -----------------------------------------------------
DROP TABLE IF EXISTS blog_detail ;
go
CREATE  TABLE IF NOT EXISTS blog_detail (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  published BOOLEAN DEFAULT false ,
  staticed BOOLEAN DEFAULT false ,
  update_time TIMESTAMP NULL DEFAULT current_timestamp,
  category VARCHAR(100) NULL ,
  title VARCHAR(200) NULL ,
  review VARCHAR(1000) NULL ,
  content TEXT NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;
go

-- -----------------------------------------------------
-- Table tags
-- -----------------------------------------------------
DROP TABLE IF EXISTS tags ;
go
CREATE  TABLE IF NOT EXISTS tags (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  update_time TIMESTAMP NULL DEFAULT current_timestamp,
  name VARCHAR(100) NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;
go


-- -----------------------------------------------------
-- Table blog_tag
-- -----------------------------------------------------
DROP TABLE IF EXISTS blog_tag ;
go
CREATE  TABLE IF NOT EXISTS blog_tag (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  blog_id BIGINT NOT NULL,
  tag_id BIGINT NOT NULL,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;
go



-- -----------------------------------------------------
-- Table blog_comments
-- -----------------------------------------------------
DROP TABLE IF EXISTS blog_comments ;
go
CREATE  TABLE IF NOT EXISTS blog_comments (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  blog_id BIGINT NOT NULL ,
  user_name VARCHAR(100) NULL ,
  user_index VARCHAR(200) NULL ,
  user_email VARCHAR(200) NULL ,
  ip_addr VARCHAR(200) NULL ,
  content VARCHAR(1000) NULL ,
  comment_time TIMESTAMP NULL DEFAULT current_timestamp ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
go
CREATE INDEX I_BLOG ON blog_comments (blog_id ASC) ;
go

