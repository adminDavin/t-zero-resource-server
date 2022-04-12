drop table t_zero_res_info_def;
CREATE TABLE t_zero_res_info_def(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '资源定义ID' ,
    tenant_id INT    COMMENT '租户 ID' ,
    res_info_code VARCHAR(32)    COMMENT '资源编码' ,
    res_info_name VARCHAR(128)    COMMENT '资源名称' ,
    res_info_type VARCHAR(32)    COMMENT '资源类型' ,
    res_info_path VARCHAR(1024)    COMMENT '文件名称' ,
    res_info_size INT    COMMENT '文件大小' ,
    version_id VARCHAR(32)    COMMENT '版本ID' ,
    res_info_desc VARCHAR(128)    COMMENT '文件描述' ,
    res_info_owner_id INT    COMMENT '资源拥有人ID' ,
    res_info_owner_type varchar(32)    COMMENT '资源拥有类型' ,
    created_time DATETIME    COMMENT '创建时间' ,
    created_user_id VARCHAR(32)    COMMENT '创建用户ID' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    updated_user_id VARCHAR(32)    COMMENT '更新用户ID' ,
    is_deleted VARCHAR(32)    COMMENT '是否删除' ,
    PRIMARY KEY (id)
) COMMENT = '资源定义 ';

drop table t_zero_res_tag_def;
CREATE TABLE t_zero_res_tag_def(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '资源标签ID' ,
    tenant_id INT    COMMENT '租户 ID' ,
    res_auth_code VARCHAR(32)    COMMENT '资源标签编码' ,
    res_auth_name VARCHAR(128)    COMMENT '资源标签名称' ,
    res_auth_type VARCHAR(32)    COMMENT '资源标签类型' ,
    created_time DATETIME    COMMENT '创建时间' ,
    created_user_id VARCHAR(32)    COMMENT '创建用户ID' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    updated_user_id VARCHAR(32)    COMMENT '更新用户ID' ,
    is_deleted VARCHAR(32)    COMMENT '是否删除' ,
    PRIMARY KEY (id)
) COMMENT = '资源标签定义 ';

drop table t_zero_res_tag_rel;
CREATE TABLE t_zero_res_tag_rel(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '资源标签关系ID' ,
    res_tag_id INT    COMMENT '资源标签ID' ,
    res_tag_code VARCHAR(32)    COMMENT '资源标签编码' ,
    res_info_id INT    COMMENT '资源定义ID' ,
    created_time DATETIME    COMMENT '创建时间' ,
    created_user_id VARCHAR(32)    COMMENT '创建用户ID' ,
    PRIMARY KEY (id)
) COMMENT = '资源标签关系定义 ';

drop table t_zero_res_auth_def;
CREATE TABLE t_zero_res_auth_def(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '资源鉴权ID' ,
    tenant_id INT    COMMENT '租户 ID' ,
    res_auth_code VARCHAR(32)    COMMENT '资源鉴权编码' ,
    res_auth_name VARCHAR(128)    COMMENT '资源鉴权名称' ,
    created_time DATETIME    COMMENT '创建时间' ,
    created_user_id VARCHAR(32)    COMMENT '创建用户ID' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    updated_user_id VARCHAR(32)    COMMENT '更新用户ID' ,
    is_deleted VARCHAR(32)    COMMENT '是否删除' ,
    PRIMARY KEY (id)
) COMMENT = '资源权限定义 ';

drop table t_zero_res_auth_rel;
CREATE TABLE t_zero_res_auth_rel(
    id INT NOT NULL AUTO_INCREMENT  COMMENT '资源鉴权关系ID' ,
    res_auth_id INT    COMMENT '资源鉴权ID' ,
    res_auth_code VARCHAR(32)    COMMENT '资源鉴权编码' ,
    res_auth_type VARCHAR(32)    COMMENT '资源鉴权类型' ,
    res_auth_path VARCHAR(1024)    COMMENT '资源访问路径' ,
    res_info_id INT    COMMENT '资源定义ID' ,
    created_time DATETIME    COMMENT '创建时间' ,
    created_user_id VARCHAR(32)    COMMENT '创建用户ID' ,
    PRIMARY KEY (id)
) COMMENT = '资源权限关系 ';