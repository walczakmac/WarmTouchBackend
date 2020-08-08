CREATE TABLE news (
    id INT PRIMARY KEY auto_increment,
    title varchar(32),
    content text,
    post_date datetime,
    type varchar(32),
    deleted boolean default false
);