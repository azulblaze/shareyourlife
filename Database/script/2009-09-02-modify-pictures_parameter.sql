//add viewed_times to pictures_parameter
rename table pictures_parameter to pictures_parameter_tmp;
go
CREATE  TABLE IF NOT EXISTS pictures_parameter (
  id_pictures BIGINT NOT NULL ,
  upload_account VARCHAR(100) NOT NULL ,
  upload_time TIMESTAMP NULL ,
  status INT NULL DEFAULT 1 ,
  viewed_times BIGINT NULL DEFAULT 0 ,
  device VARCHAR(50) NULL,
  title VARCHAR(100) NULL ,
  description VARCHAR(1000) NULL ,
  addtion_info TEXT NULL ,
  PRIMARY KEY (id_pictures) )
ENGINE = InnoDB;
go
INSERT pictures_parameter (id_pictures, upload_account, upload_time,status,device,title,description,addtion_info) select * from pictures_parameter_tmp;
go
drop table pictures_parameter_tmp;
go