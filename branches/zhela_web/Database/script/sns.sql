-- -----------------------------------------------------
-- Table user
-- -----------------------------------------------------
DROP TABLE IF EXISTS user ;

CREATE  TABLE IF NOT EXISTS user (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  account VARCHAR(100) NOT NULL ,
  password VARCHAR(200) NOT NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE UNIQUE INDEX pk_user ON user (account ASC) ;

-- -----------------------------------------------------
-- Table userinfo
-- -----------------------------------------------------
DROP TABLE IF EXISTS userinfo ;

CREATE  TABLE IF NOT EXISTS userinfo (
  user_id BIGINT NOT NULL ,
  name VARCHAR(50) NULL ,
  email VARCHAR(100) NULL ,
  avatar VARCHAR(200) NULL ,
  avatar_pic VARCHAR(200) NULL ,
  zone_id INT NULL ,
  registered_date TIMESTAMP NULL ,
  last_login TIMESTAMP NULL ,
  question_id BIGINT NULL ,
  security_answer VARCHAR(100) NULL ,
  activation_key VARCHAR(50) NULL ,
  recommend_user_id BIGINT NULL ,
  PRIMARY KEY (user_id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table block_user
-- -----------------------------------------------------
DROP TABLE IF EXISTS block_user ;

CREATE  TABLE IF NOT EXISTS block_user (
  user_id BIGINT NOT NULL ,
  blocked_user_id BIGINT NOT NULL )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE UNIQUE INDEX pk_bu ON block_user (user_id ASC, blocked_user_id ASC) ;


-- -----------------------------------------------------
-- Table inbox_message
-- -----------------------------------------------------
DROP TABLE IF EXISTS inbox_message ;

CREATE  TABLE IF NOT EXISTS inbox_message (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  from_id BIGINT NULL ,
  user_id BIGINT NULL ,
  subject VARCHAR(100) NULL ,
  message_type INT NULL DEFAULT 0 ,
  message_status VARCHAR(50) NULL ,
  parameters VARCHAR(45) NULL ,
  message VARCHAR(1000) NULL ,
  update_time TIMESTAMP NULL ,
  is_deleted TINYINT(1) NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE INDEX i_im ON inbox_message (user_id ASC) ;

-- -----------------------------------------------------
-- Table outbox_message
-- -----------------------------------------------------
DROP TABLE IF EXISTS outbox_message ;

CREATE  TABLE IF NOT EXISTS outbox_message (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  user_id BIGINT NULL ,
  to_id BIGINT NULL ,
  subject VARCHAR(100) NULL ,
  message_type INT NULL DEFAULT 0 ,
  message_status VARCHAR(50) NULL ,
  message VARCHAR(1000) NULL ,
  update_time TIMESTAMP NULL ,
  is_deleted TINYINT(1) NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE INDEX i_om ON outbox_message (user_id ASC) ;

-- -----------------------------------------------------
-- Table friend_list
-- -----------------------------------------------------
DROP TABLE IF EXISTS friend_list ;

CREATE  TABLE IF NOT EXISTS friend_list (
  user_id BIGINT NOT NULL ,
  friend_id BIGINT NOT NULL ,
  status INT NULL DEFAULT 0 ,
  update_time TIMESTAMP NULL )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE INDEX pk_fl ON friend_list (user_id ASC, friend_id ASC) ;

-- -----------------------------------------------------
-- Table base_profile
-- -----------------------------------------------------
DROP TABLE IF EXISTS base_profile ;

CREATE  TABLE IF NOT EXISTS base_profile (
  user_id BIGINT NOT NULL ,
  sex VARCHAR(10) NULL ,
  interested_in BIGINT NULL ,
  talkself VARCHAR(500) NULL ,
  birthday DATETIME NULL ,
  birthday_visibility INT NULL ,
  city VARCHAR(45) NULL ,
  state_province VARCHAR(45) NULL ,
  country VARCHAR(45) NULL ,
  email VARCHAR(100) NULL ,
  email_visibility INT NULL ,
  web_site VARCHAR(300) NULL ,
  web_site_visibility INT NULL ,
  PRIMARY KEY (user_id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table security_question
-- -----------------------------------------------------
DROP TABLE IF EXISTS security_question ;

CREATE  TABLE IF NOT EXISTS security_question (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  question VARCHAR(200) NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table contact_profile
-- -----------------------------------------------------
DROP TABLE IF EXISTS contact_profile ;

CREATE  TABLE IF NOT EXISTS contact_profile (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  user_id BIGINT NULL ,
  visibility INT NULL ,
  mobile VARCHAR(20) NULL ,
  phone VARCHAR(20) NULL ,
  address VARCHAR(200) NULL ,
  city VARCHAR(45) NULL ,
  state_province VARCHAR(45) NULL ,
  country VARCHAR(45) NULL ,
  zip_code VARCHAR(45) NULL ,
  update_time TIMESTAMP NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE INDEX i_cp ON contact_profile (user_id ASC) ;

-- -----------------------------------------------------
-- Table certification
-- -----------------------------------------------------
DROP TABLE IF EXISTS certification ;

CREATE  TABLE IF NOT EXISTS certification (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(45) NULL ,
  icon VARCHAR(200) NULL ,
  description VARCHAR(1000) NULL ,
  update_time TIMESTAMP NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table user_certification
-- -----------------------------------------------------
DROP TABLE IF EXISTS user_certification ;

CREATE  TABLE IF NOT EXISTS user_certification (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  user_id BIGINT NULL ,
  cert_id BIGINT NULL ,
  parameter VARCHAR(100) NULL ,
  start_date TIMESTAMP NULL ,
  end_date TIMESTAMP NULL ,
  note VARCHAR(1000) NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE INDEX i_uc ON user_certification (user_id ASC) ;

-- -----------------------------------------------------
-- Table grouper
-- -----------------------------------------------------
DROP TABLE IF EXISTS grouper ;

CREATE  TABLE IF NOT EXISTS grouper (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  user_id BIGINT NULL ,
  visibility INT NULL ,
  name VARCHAR(45) NULL ,
  description VARCHAR(1000) NULL ,
  category VARCHAR(45) NULL ,
  avatar VARCHAR(200) NULL ,
  avatar_pic VARCHAR(200) NULL ,
  max_user INT NULL ,
  curr_user INT NULL ,
  update_time TIMESTAMP NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table group_category
-- -----------------------------------------------------
DROP TABLE IF EXISTS group_category ;

CREATE  TABLE IF NOT EXISTS group_category (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(45) NULL ,
  description VARCHAR(1000) NULL ,
  update_time TIMESTAMP NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table group_wall
-- -----------------------------------------------------
DROP TABLE IF EXISTS group_wall ;

CREATE  TABLE IF NOT EXISTS group_wall (
  group_id BIGINT NULL ,
  post_user_id BIGINT NULL ,
  name VARCHAR(200) NULL ,
  description VARCHAR(1000) NULL ,
  update_time TIMESTAMP NULL ,
  status INT NULL DEFAULT 0 ,
  PRIMARY KEY (group_id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table group_discussion
-- -----------------------------------------------------
DROP TABLE IF EXISTS group_discussion ;

CREATE  TABLE IF NOT EXISTS group_discussion (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  group_id BIGINT NULL ,
  create_user_id BIGINT NULL ,
  topic VARCHAR(200) NULL ,
  status INT NULL ,
  update_time TIMESTAMP NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE INDEX i_gd ON group_discussion (group_id ASC) ;

-- -----------------------------------------------------
-- Table group_discussion_post
-- -----------------------------------------------------
DROP TABLE IF EXISTS group_discussion_post ;

CREATE  TABLE IF NOT EXISTS group_discussion_post (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  group_dis_id BIGINT NULL ,
  post_user_id BIGINT NULL ,
  replied_to_id BIGINT NULL ,
  content TEXT NULL ,
  update_time TIMESTAMP NULL ,
  status INT NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE INDEX i_gdp ON group_discussion_post (group_dis_id ASC) ;

-- -----------------------------------------------------
-- Table group_user
-- -----------------------------------------------------
DROP TABLE IF EXISTS group_user ;

CREATE  TABLE IF NOT EXISTS group_user (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  group_id BIGINT NULL ,
  user_id BIGINT NULL ,
  permission INT NULL DEFAULT 0 ,
  updatetime TIMESTAMP NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE INDEX i_gu ON group_user (group_id ASC) ;

-- -----------------------------------------------------
-- Table goods
-- -----------------------------------------------------
DROP TABLE IF EXISTS goods ;

CREATE  TABLE IF NOT EXISTS goods (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  topic VARCHAR(200) NULL ,
  description TEXT NULL ,
  SN VARCHAR(50) NULL ,
  icon VARCHAR(200) NULL ,
  picture VARCHAR(200) NULL ,
  category VARCHAR(100) NULL ,
  source VARCHAR(300) NULL ,
  buy_link VARCHAR(300) NULL ,
  update_time TIMESTAMP NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table goods_comment
-- -----------------------------------------------------
DROP TABLE IF EXISTS goods_comment ;

CREATE  TABLE IF NOT EXISTS goods_comment (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  goods_id BIGINT NULL ,
  SN VARCHAR(50) NULL ,
  user_id BIGINT NULL ,
  replied_id BIGINT NULL ,
  content VARCHAR(1000) NULL ,
  update_time TIMESTAMP NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE INDEX i_gc ON goods_comment (goods_id ASC) ;

-- -----------------------------------------------------
-- Table goods_track
-- -----------------------------------------------------
DROP TABLE IF EXISTS goods_track ;

CREATE  TABLE IF NOT EXISTS goods_track (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  user_id BIGINT NULL ,
  goods_id BIGINT NULL ,
  visibility INT NULL ,
  ratting FLOAT NULL ,
  SN VARCHAR(50) NULL ,
  trackprice TINYINT(1) NULL ,
  update_time TIMESTAMP NULL ,
  goods_tag_id BIGINT NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE INDEX i_gt ON goods_track (goods_id ASC) ;

-- -----------------------------------------------------
-- Table goods_tag
-- -----------------------------------------------------
DROP TABLE IF EXISTS goods_tag ;

CREATE  TABLE IF NOT EXISTS goods_tag (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(100) NULL ,
  update_time TIMESTAMP NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;
CREATE INDEX i_gt ON goods_tag (name ASC) ;

-- -----------------------------------------------------
-- Table goods_user_tag
-- -----------------------------------------------------
DROP TABLE IF EXISTS goods_user_tag ;

CREATE  TABLE IF NOT EXISTS goods_user_tag (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  user_id BIGINT NULL ,
  goods_tag_id BIGINT NULL ,
  update_time TIMESTAMP NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE INDEX i_gut ON goods_user_tag (user_id ASC) ;

-- -----------------------------------------------------
-- Table goods_price
-- -----------------------------------------------------
DROP TABLE IF EXISTS goods_price ;

CREATE  TABLE IF NOT EXISTS goods_price (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  good_id BIGINT NULL ,
  SN VARCHAR(50) NULL ,
  provide_user_id BIGINT NULL ,
  price FLOAT NULL ,
  topic VARCHAR(200) NULL ,
  status INT NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE INDEX i_gp ON goods_price (good_id ASC) ;


-- -----------------------------------------------------
-- Table goods_sell_addr
-- -----------------------------------------------------
DROP TABLE IF EXISTS goods_sell_addr ;

CREATE  TABLE IF NOT EXISTS goods_sell_addr (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  goods_price_id BIGINT NULL ,
  addr_type INT NULL ,
  buy_link VARCHAR(300) NULL ,
  buy_country VARCHAR(45) NULL ,
  buy_state_province VARCHAR(45) NULL ,
  buy_city VARCHAR(45) NULL ,
  buy_addr VARCHAR(45) NULL ,
  status INT NULL ,
  longitude FLOAT NULL ,
  latitude FLOAT NULL ,
  update_time TIMESTAMP NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE INDEX i_gsa ON goods_sell_addr (goods_price_id ASC) ;

-- -----------------------------------------------------
-- Table web_site_collection
-- -----------------------------------------------------
DROP TABLE IF EXISTS web_site_collection ;

CREATE  TABLE IF NOT EXISTS web_site_collection (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  collection_type INT NULL ,
  site_exp VARCHAR(100) NULL ,
  tag_start VARCHAR(200) NULL ,
  tag_end VARCHAR(200) NULL ,
  update_time TIMESTAMP NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE INDEX i_wsc ON web_site_collection (site_exp ASC) ;

-- -----------------------------------------------------
-- Table url_redirection
-- -----------------------------------------------------
DROP TABLE IF EXISTS url_redirection ;

CREATE  TABLE IF NOT EXISTS url_redirection (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  count BIGINT NULL ,
  site_exp VARCHAR(100) NULL ,
  level INT NULL ,
  update_time TIMESTAMP NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE INDEX i_ur ON url_redirection (site_exp ASC) ;

-- -----------------------------------------------------
-- Table user_privacy
-- -----------------------------------------------------
DROP TABLE IF EXISTS user_privacy ;

CREATE  TABLE IF NOT EXISTS user_privacy (
  id BIGINT NOT NULL AUTO_INCREMENT ,
  user_id BIGINT NULL ,
  type INT NULL ,
  parameter1 INT NULL ,
  parameter2 INT NULL ,
  update_time TIMESTAMP NULL ,
  PRIMARY KEY (id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE INDEX i_up ON user_privacy (user_id ASC) ;
