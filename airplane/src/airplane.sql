use ssm;
create table airpore(
id int(10) primary key auto_increment,
portname varchar(20),
cityname varchar(20)
);

create table airplane(
id int(10) primary key auto_increment,
airno varchar(20),
time int(5) comment '分钟',
price double ,
takeid int(10) comment '起飞机场',
landid int(10) comment '降落机场'
);

insert into airpore values(default ,'A机场','A地点');
insert into airpore values(default ,'B机场','B地点');
insert into airpore values(default ,'C机场','C地点');
insert into airpore values(default ,'D机场','D地点');
insert into airpore values(default ,'E机场','E地点');
insert into airpore values(default ,'F机场','F地点');

insert into airplane values(DEFAULT ,'A飞机',1,1.0,1,2);
insert into airplane values(DEFAULT ,'B飞机',1,1.0,2,3);
insert into airplane values(DEFAULT ,'C飞机',1,1.0,3,4);
insert into airplane values(DEFAULT ,'D飞机',1,1.0,4,5);
insert into airplane values(DEFAULT ,'E飞机',1,1.0,5,1);
insert into airplane values(DEFAULT ,'E飞机',1,1.0,5,1);
insert into airplane values(DEFAULT ,'E飞机',1,1.0,5,1);
insert into airplane values(DEFAULT ,'E飞机',1,1.0,5,1);
insert into airplane values(DEFAULT ,'E飞机',1,1.0,5,1);
insert into airplane values(DEFAULT ,'E飞机',1,1.0,5,1);

select
a.id id,a.airno airno,a.time time,a.price price,a.takeid,a.landid,
b.id tekeid,b.portname takename,b.cityname takecity,
c.id takeid,c.portname landname,c.cityname landcity
from
airplane a left join airpore b on a.takeid = b.id left join airpore c on a.landid = c.id