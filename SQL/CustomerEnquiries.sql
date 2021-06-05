create table CustomerEnquiry (id serial not null primary key,
							   username varchar(100) not null,
							   subject varchar(100) not null,
							   message varchar(200) not null,
							   sendTo varchar(30) not null,
							   messageSentDate date not null,
							   messageSenttime time not null
							   );
							   select * from CustomerEnquiry ;
							   