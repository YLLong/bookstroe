/*用户表*/
create table bs_user (
	uid varchar(30) primary key,
	uname varchar(30),
	password varchar(30)
);
insert into bs_user values("1001", "周杰伦", "123");

/*分类表*/
create table bs_category(
	cid varchar(6) primary key,
	cname varchar(30)
);
insert into bs_category values("1001", "JAVASE");
insert into bs_category values("1002", "JAVAEE");
insert into bs_category values("1003", "JAVAScript");

/*books表*/
create table bs_book(
	bid varchar(6) primary key,
	bname varchar(50),
	author varchar(50),
	price decimal(5,1),
	image varchar(100),
	category_cid varchar(6),
	constraint fk_book_category  foreign key (category_cid) references bs_category(cid)
);
insert into bs_book(bid, bname, price, author, image, category_cid) values
	('1', 'Java编程思想（第4版', 75.6, 'Bruce Eckel', 'book_img/9317290-1_l.jpg', '1001'),
	('2', 'Java核心技术卷1', 68.5, 'someone', 'book_img/20285763-1_l.jpg', '1002'),
	('3', 'Java就业培训教程', 39.9, '张孝祥', 'book_img/8758723-1_l.jpg', '1003'),
	('4', 'Head First java', 47.5, '（美）塞若', 'book_img/9265169-1_l.jpg', '1001'),
	('5', 'JavaWeb开发详解', 83.3, '孙鑫', 'book_img/22788412-1_l.jpg', '1001'),
	('6', 'Struts2深入详解', 63.2, '孙鑫', 'book_img/20385925-1_l.jpg', '1003'),
	('7', '精通Hibernate', 30.0, '孙卫琴', 'book_img/8991366-1_l.jpg', '1003'),
	('8', '精通Spring2.x', 63.2, '陈华雄', 'book_img/20029394-1_l.jpg', '1002'),
	('9', 'Javascript权威指南', 93.6, '（美）弗兰纳根', 'book_img/22722790-1_l.jpg', '1002');

/*订单表*/
create table bs_order(
	oid varchar(30) primary key,
	ordertime date,
	total decimal(10,1),
	address varchar(200),
	uid varchar(30),
	state int,
	foreign key(uid) references bs_user(uid)
);

/*订单条目表*/
create table bs_orderItem(
	iid varchar(30) primary key,
	bid varchar(6),
	count int,
	subtotal decimal(10,1),
	oid varchar(30),
	foreign key(bid) references bs_book(bid),
	foreign key(oid) references bs_order(oid)
);

/*员工表*/
create table emp(
	eno int primary key,
	ename varchar(30),
	deptno int,
	constraint fk_emp_dept  foreign key (deptno) references dept(dno)
);

/*部门表*/
create table dept(
	dno int primary key,
	dname varchar(30),
);

/*一对一*/
create table tb_aa(
	aid int primary key,
	name varchar(30),
);
insert into tb_aa values(1, "AA");
insert into tb_aa values(2, "Aa");
insert into tb_aa values(3, "aa");
create table tb_bb(
	bid int primary key,
	name varchar(30),
	foreign key bid references tb_aa(aid)
);
insert into tb_bb values(10, "BB");
insert into tb_bb values(20, "Bb");
insert into tb_bb values(30, "bb");

/*多对多*/
create table teacher(
	tid int primary key,
	tname varchar(30)
);
insert into teacher values(1, "aa");
insert into teacher values(2, "bb");
insert into teacher values(3, "cc");
create table student(
	sid int primary key,
	sname varchar(30)
);
insert into student values(10, "AA");
insert into student values(20, "BB");
insert into student values(30, "CC");
create table tb_t_s(
	tid int,
	sid int,
	foreign key tid references teacher(tid),
	foreign key sid references student(sid)
);
insert into tb_t_s values(1,10);
insert into tb_t_s values(1,20);
insert into tb_t_s values(1,30);
insert into tb_t_s values(2,20);
insert into tb_t_s values(2,30);
insert into tb_t_s values(3,30);