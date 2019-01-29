use ssm;
create table peopel(
id int(10) primary key auto_increment comment "编号",
name varchar(20) comment "姓名",
age int(3) comment "年龄",
) comment "人员信息表";

insert into peopel value (default ,"张三",21);
insert into peopel value (default ,"李四",22);