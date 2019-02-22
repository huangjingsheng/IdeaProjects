use ssm;
create table user(
id int(10) PRIMARY key auto_increment,
username varchar (20) unique,
password varchar (20)
);

insert into user values (
default,
'张三',
'123456'
);