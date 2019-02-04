CREATE table account (
id int(10) primary key auto_increment,
accno varchar(18) unique,
password int(6),
balance double,
name varchar(20)
);

insert into account values (default,1,1,1000,'张三');
insert into account values (default,2,2,2000,'李四');
insert into account values (default,3,3,3000,'王五');