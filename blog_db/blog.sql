create table `b_user`
(
    `id`           bigint(10) not null auto_increment comment '用户id',
    `username`     varchar(64)         default null comment '用户名',
    `password`     varchar(64)         default null comment '密码',
    `email`        varchar(64)         default null comment '邮箱',
    `avatar`       varchar(255)        default null comment '头像',
    `status`       int(5)     not null comment '状态',
    `last_login`   datetime            default null comment '最近登录',
    `version`      int(10)    not null default 1 comment '乐观锁',
    `deleted`      int(1)     not null default 0 comment '逻辑删除',
    `gmt_create`   datetime   not null default current_timestamp comment '创建时间',
    `gmt_modified` datetime   not null default current_timestamp comment '更新时间',
    primary key (`id`),
    key `UK_USERNAME` (`username`) using BTREE
) engine = innodb
  default charset = utf8;

create table `b_blog`
(
    `id`           bigint(20)   not null auto_increment comment '博文id',
    `user_id`      bigint(10)   not null comment '博主id',
    `title`        varchar(255) not null comment '博文标题',
    `description`  varchar(255) not null comment '博文简述',
    `context`      longtext comment '博文内容',
    `version`      int(5)       not null default 1 comment '乐观锁',
    `deleted`      int(1)       not null default 0 comment '逻辑删除',
    `gmt_create`   datetime     not null default current_timestamp comment '创建时间',
    `gmt_modified` datetime     not null default current_timestamp comment '更新时间',
    primary key (`id`)
) engine = innodb
  auto_increment = 2
  default charset = utf8;

insert into `blog_1`.`b_user`(id, username, password, email, avatar, status, version, deleted, gmt_create, gmt_modified)
VALUES (1, 'root', 'E10ADC3949BA59ABBE56E057F20F883E', '1001@qq.com', NULL, 0, 1, 0, current_timestamp,
        current_timestamp);