-- 用户表
CREATE TABLE IF NOT EXISTS User (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP
    );

-- 分类表
CREATE TABLE IF NOT EXISTS Category (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        name VARCHAR(100) NOT NULL UNIQUE
    );

-- 文章表
CREATE TABLE IF NOT EXISTS Article (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       title VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    user_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES Category(id) ON DELETE CASCADE
    );

-- 评论表
CREATE TABLE IF NOT EXISTS Comment (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       article_id BIGINT NOT NULL,
                                       username VARCHAR(50) NOT NULL,
    content TEXT NOT NULL,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (article_id) REFERENCES Article(id) ON DELETE CASCADE
    );
-- 添加索引优化查询
CREATE INDEX idx_user_username ON User(username);
CREATE INDEX idx_article_title ON Article(title);
CREATE INDEX idx_article_user_id ON Article(user_id);
CREATE INDEX idx_article_category_id ON Article(category_id);
CREATE INDEX idx_comment_article_id ON Comment(article_id);
CREATE INDEX idx_comment_username ON Comment(username);

-- 插入测试用户
INSERT INTO User (username, password) VALUES
                                          ('admin', 'admin123'),
                                          ('author1', 'author123'),
                                          ('reader1', 'reader123');

-- 插入测试分类
INSERT INTO Category (name) VALUES
                                ('Java编程'),
                                ('前端开发'),
                                ('数据库'),
                                ('操作系统'),
                                ('开发工具');

-- 插入测试文章
INSERT INTO Article (title, content, user_id, category_id) VALUES
                                                               ('Java多线程编程', '本文介绍Java多线程的基本概念和用法...', 2, 1),
                                                               ('React组件化开发', 'React是一个用于构建用户界面的JavaScript库...', 2, 2),
                                                               ('MySQL性能优化', 'MySQL数据库性能优化是一个复杂的过程...', 2, 3),
                                                               ('Linux常用命令', '本文介绍Linux系统中常用的命令和操作...', 2, 4),
                                                               ('IntelliJ IDEA使用技巧', 'IntelliJ IDEA是一款强大的Java集成开发环境...', 2, 5);

-- 插入测试评论
INSERT INTO Comment (article_id, username, content) VALUES
                                                        (1, 'reader1', '非常实用的文章，谢谢分享！'),
                                                        (1, 'reader2', '请问有更深入的教程吗？'),
                                                        (2, 'reader1', 'React的虚拟DOM是其核心优势之一'),
                                                        (3, 'reader3', '索引优化确实很重要'),
                                                        (4, 'reader1', '学习Linux命令对开发很有帮助');
