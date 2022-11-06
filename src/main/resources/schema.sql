DROP TABLE IF EXISTS login_log;
CREATE TABLE login_log (
    id SERIAL PRIMARY KEY,
    user_name VARCHAR(32) NOT NULL,
    login_time TIMESTAMP NULL,
    message VARCHAR(128) NULL
);
COMMENT ON TABLE login_log IS '用户登录记录表';
COMMENT ON COLUMN login_log.id IS '主键';
COMMENT ON COLUMN login_log.user_name IS '用户名称';
COMMENT ON COLUMN login_log.login_time IS '登陆时间';
COMMENT ON COLUMN login_log.message IS '登陆信息';

ALTER TABLE login_log OWNER TO test;
GRANT ALL PRIVILEGES ON TABLE login_log TO test;

INSERT INTO login_log(id, user_name, login_time, message)
VALUES(DEFAULT, 'tester', '2022-10-26 10:11:12', 'hello')