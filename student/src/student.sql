CREATE TABLE teacher(
id int(10) primary key auto_increment COMMENT '主键',
name VARCHAR(20) COMMENT '姓名'
)COMMENT '老师表';

CREATE TABLE student(
id int(10) primary key auto_increment COMMENT '主键',
name VARCHAR(20) COMMENT '姓名' ,
age INT(3) COMMENT '年龄',
tid int(10) COMMENT '外键id',
CONSTRAINT fk_teacher FOREIGN KEY (tid) REFERENCES teacher(id)
) COMMENT '学生表,tid与teacher表的id关联';

insert into teacher values (default ,'老师1');
insert into teacher values (default ,'老师2');
insert into teacher values (default ,'老师3');

insert into student values (default ,'学生1',1,1);
insert into student values (default ,'学生2',1,1);
insert into student values (default ,'学生3',1,1);
insert into student values (default ,'学生4',1,1);
insert into student values (default ,'学生5',1,1);
insert into student values (default ,'学生6',1,1);
insert into student values (default ,'学生7',1,1);
insert into student values (default ,'学生8',1,1);
insert into student values (default ,'学生9',1,1);
insert into student values (default ,'学生10',1,1);
insert into student values (default ,'学生11',1,1);
insert into student values (default ,'学生12',1,1);
insert into student values (default ,'学生13',1,1);
insert into student values (default ,'学生14',1,1);
insert into student values (default ,'学生15',1,1);
insert into student values (default ,'学生16',1,1);
insert into student values (default ,'学生17',1,3);
insert into student values (default ,'学生18',1,2);
insert into student values (default ,'学生19',1,2);
insert into student values (default ,'学生20',1,2);
