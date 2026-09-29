-- 用户基础信息表格
create table tb_user_base (
    id bigint primary key,
    u_id varchar(64) not null,
    u_name varchar(128) not null,
    birthday bigint,
    gender tinyint,
    description text,
    extra longtext
);