create table UserRegister(UserId serial primary key,
						 fullName varchar(100) not null,
						 userName  varchar(20) not null,
						 email varchar(100) not null,
						 mobileNumber bigint not null,
						  password varchar(100) not null,
						  address varchar(200),
						  SecurityQuestion varchar(100) not null,
						  SecurityAnswer varchar(100) not null,
						  unique(email),
						  unique(mobileNumber));
select * from UserRegister;