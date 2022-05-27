use yg_crm;

drop table if exists yg_corp_info;
CREATE TABLE yg_corp_info(
    id int auto_increment NOT NULL  COMMENT '公司ID' ,
    pv_code VARCHAR(64)    COMMENT '公司编码' ,
    tenant_id INT    COMMENT '租户ID' ,
    corp_brief VARCHAR(128)    COMMENT '公司简称' ,
    corp_name VARCHAR(256)    COMMENT '公司名称' ,
    corp_type VARCHAR(32)    COMMENT '公司类型' ,
    industry_code VARCHAR(64)    COMMENT '行业编码' ,
    pv_status VARCHAR(16)    COMMENT '公司状态' ,
    corp_level int     COMMENT '公司等级' ,
    corp_source VARCHAR(32)    COMMENT '公司来源' ,
    pv_desc json   COMMENT '基本信息描述(logo, 简介, 其他公司基本属性)' ,
    created_user_id VARCHAR(32)    COMMENT '创建人' ,
    created_time DATETIME    COMMENT '创建时间' ,
    updated_user_id VARCHAR(32)    COMMENT '更新人' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    is_deleted VARCHAR(1)   DEFAULT '0'  COMMENT '是否删除 标记文件是否删除' ,
    PRIMARY KEY (id)
) COMMENT = '企业基本信息 ';


drop table if exists yg_corp_account;
CREATE TABLE yg_corp_account(
    id int auto_increment NOT NULL   COMMENT '公司账号ID' ,
    pv_code VARCHAR(64)    COMMENT '公司账号编码' ,
    tenant_id INT   DEFAULT 1 COMMENT '租户ID' ,
    corp_id INT   COMMENT '所属公司ID' ,
    corp_code VARCHAR(128)    COMMENT '公司编码' ,
    account_type VARCHAR(32)    COMMENT '公司账户类型(外汇, 银行)' ,
    account_name VARCHAR(256)    COMMENT '公司账户名称' ,
    bank_name VARCHAR(128)    COMMENT '银行名称' ,
    bank_account VARCHAR(64)    COMMENT '银行账号' ,
    bank_address VARCHAR(512)    COMMENT '银行地址' ,
    bank_number VARCHAR(64)    COMMENT '银行行号' ,
    pv_status VARCHAR(16)    COMMENT '公司账号状态' ,
    pv_desc json    COMMENT '账号信息描述(logo, 简介, 其他公司基本属性)' ,
    created_user_id VARCHAR(32)    COMMENT '创建人' ,
    created_time DATETIME    COMMENT '创建时间' ,
    updated_user_id VARCHAR(32)    COMMENT '更新人' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    is_deleted VARCHAR(1) DEFAULT '0'   COMMENT '是否删除 标记文件是否删除' ,
    PRIMARY KEY (id)
) COMMENT = '企业账户 ';

drop table if exists yg_corp_contact;
CREATE TABLE yg_corp_contact(
    id int auto_increment NOT NULL   COMMENT '公司联系人ID' ,
    pv_code VARCHAR(64)    COMMENT '公司联系人编码' ,
    tenant_id INT   DEFAULT 1 COMMENT '所属公司ID' ,
    corp_id INT    COMMENT '所属公司ID' ,
    corp_code VARCHAR(64)    COMMENT '公司编码' ,
    contact_type VARCHAR(32)    COMMENT '联系人类型' ,
    contact_name VARCHAR(64)    COMMENT '联系人姓名' ,
    telephone VARCHAR(32)    COMMENT '联系人电话' ,
    pv_status VARCHAR(16)    COMMENT '联系人状态' ,
    pv_desc json    COMMENT '联系人描述(性别, 身份证好, 等联系人属性)' ,
    created_user_id VARCHAR(32)    COMMENT '创建人' ,
    created_time DATETIME    COMMENT '创建时间' ,
    updated_user_id VARCHAR(32)    COMMENT '更新人' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    is_deleted VARCHAR(1)  DEFAULT '0'  COMMENT '是否删除 标记文件是否删除' ,
    PRIMARY KEY (id)
) COMMENT = '企业联系人 ';

drop table if exists yg_corp_address;
CREATE TABLE yg_corp_address(
    id int auto_increment NOT NULL   COMMENT '公司地址ID' ,
    pv_code VARCHAR(64)    COMMENT '公司地址编码' ,
    tenant_id INT   DEFAULT 1 COMMENT '租户ID' ,
    corp_id INT   DEFAULT 1 COMMENT '所属公司ID' ,
    corp_code VARCHAR(64)     COMMENT '公司编码' ,
    address_type VARCHAR(64)    COMMENT '地址类型(公司地址,收货地址)' ,
    country VARCHAR(32)    COMMENT '所在城市' ,
    postal_code VARCHAR(16)    COMMENT '邮编' ,
    address_name VARCHAR(256)    COMMENT '公司地址名称' ,
    contactor VARCHAR(64)    COMMENT '联系人' ,
    telephone VARCHAR(32)    COMMENT '联系人联系方式' ,
    pv_status VARCHAR(16)    COMMENT '地址状态' ,
    pv_desc json   COMMENT '联系人描述(备注等其他地址属性)' ,
    created_user_id VARCHAR(32)    COMMENT '创建人' ,
    created_time DATETIME    COMMENT '创建时间' ,
    updated_user_id VARCHAR(32)    COMMENT '更新人' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    is_deleted VARCHAR(1)  DEFAULT '0'   COMMENT '是否删除 标记文件是否删除' ,
    PRIMARY KEY (id)
) COMMENT = '公司地址(收货地址) ';

drop table if exists yg_customer_info;
CREATE TABLE yg_customer_info(
    id int auto_increment NOT NULL   COMMENT '客户信息ID' ,
    pv_code VARCHAR(64)    COMMENT '客户编码' ,
    tenant_id INT   DEFAULT 1 COMMENT '租户ID' ,
    corp_id INT   DEFAULT 1 COMMENT '所属公司ID' ,
    corp_code VARCHAR(64)    COMMENT '公司编码' ,
    customer_name VARCHAR(128)    COMMENT '客户名称(和公司名称同名)' ,
    customer_quota VARCHAR(32)    COMMENT '客户额度' ,
    pv_status VARCHAR(16)    COMMENT '客户状态' ,
    pv_desc json  COMMENT '客户描述(备注等其他属性)' ,
    created_user_id VARCHAR(32)    COMMENT '创建人' ,
    created_time DATETIME    COMMENT '创建时间' ,
    updated_user_id VARCHAR(32)    COMMENT '更新人' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    is_deleted VARCHAR(1) DEFAULT '0'    COMMENT '是否删除 标记文件是否删除' ,
    PRIMARY KEY (id)
) COMMENT = '客户信息 ';

drop table if exists yg_supplier_info;
CREATE TABLE yg_supplier_info(
    id  int auto_increment NOT NULL   COMMENT '供应商信息ID' ,
    pv_code VARCHAR(64)    COMMENT '供应商编码' ,
    tenant_id INT   DEFAULT 1 COMMENT '租户ID' ,
    corp_id INT   DEFAULT 1 COMMENT '所属公司ID' ,
    corp_code VARCHAR(64)    COMMENT '公司编码' ,
    supplier_name VARCHAR(128)    COMMENT '供应商名称(和公司名称同名)' ,
    supplier_quota VARCHAR(32)    COMMENT '供应商额度' ,
    pv_status VARCHAR(16)    COMMENT '供应商状态' ,
    pv_desc json    COMMENT '供应商描述(备注等其他属性)' ,
    created_user_id VARCHAR(32)    COMMENT '创建人' ,
    created_time DATETIME    COMMENT '创建时间' ,
    updated_user_id VARCHAR(32)    COMMENT '更新人' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    is_deleted VARCHAR(1)  DEFAULT '0'  COMMENT '是否删除 标记文件是否删除' ,
    PRIMARY KEY (id)
) COMMENT = '供应商信息 ';

drop table if exists yg_facilitator_info;
CREATE TABLE yg_facilitator_info(
    id  int auto_increment NOT NULL  COMMENT '服务商信息ID' ,
    pv_code VARCHAR(64)    COMMENT '服务商编码' ,
    tenant_id INT   DEFAULT 1 COMMENT '租户ID' ,
    corp_id INT   DEFAULT 1 COMMENT '所属公司ID' ,
    corp_code VARCHAR(64)    COMMENT '公司编码' ,
    facilitator_name VARCHAR(128)    COMMENT '服务商名称(和公司名称同名)' ,
    facilitator_quota VARCHAR(32)    COMMENT '服务商额度' ,
    pv_status VARCHAR(16)    COMMENT '服务商状态' ,
    pv_desc json    COMMENT '服务商描述(备注等其他属性)' ,
    created_user_id VARCHAR(32)    COMMENT '创建人' ,
    created_time DATETIME    COMMENT '创建时间' ,
    updated_user_id VARCHAR(32)    COMMENT '更新人' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    is_deleted VARCHAR(1)  DEFAULT '0'  COMMENT '是否删除 标记文件是否删除' ,
    PRIMARY KEY (id)
) COMMENT = '服务商信息 ';