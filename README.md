# qaforum
   基于SpringBoot，SpringMVC，MyBtis的问答平台，现有功能：通过github第三方登录，首页问题列表，登录后发起问题，回复，浏览数和回复数统计；后续会继续更新，本项目目的是熟练SpringBoot使用，顺便学习从0开始运用前端框架。

# 技术栈
后端：Spring Boot，SpringMVC，MyBtis，MyBatis Generator
前端：Bootstrap，jQuery，Ajax
数据库：MySQL

# 数据库设计
```sql
CREATE DATABASE qaforum;
CREATE DATABASE  qaforum DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE qaforum;
CREATE TABLE `user`(
id INT AUTO_INCREMENT PRIMARY KEY,
account_id VARCHAR(100),
NAME VARCHAR(50),
token CHAR(36),
gmt_create BIGINT,
gmt_modified BIGINT)
DEFAULT CHARSET=utf8,COLLATE utf8_general_ci;

CREATE TABLE question
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50),
    description TEXT,
    gmt_create BIGINT,
    gmt_modified BIGINT,
    creator INT,
    comment_count INT DEFAULT 0,
    view_count INT DEFAULT 0,
    like_count INT DEFAULT 0,
    tag VARCHAR(256)
)
DEFAULT CHARSET=utf8,COLLATE utf8_general_ci;

CREATE TABLE COMMENT
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    parent_id BIGINT NOT NULL COMMENT '父类ID',
    TYPE INT NOT NULL COMMENT '父类类型',
    content VARCHAR(1024) NULL COMMENT '评论内容',
    commentator INT COMMENT '评论人ID',
    gmt_create BIGINT COMMENT '创建时间',
    gmt_modified BIGINT COMMENT '更新时间',
    like_count INT DEFAULT 0 COMMENT '点赞数'
)DEFAULT CHARSET=utf8,COLLATE utf8_general_ci;
```