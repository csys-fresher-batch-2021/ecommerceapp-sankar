create table productInfo(SerialNo serial not null,
					  ProductId varchar(20) primary key,
					ProductName varchar(200) not null,
					Category varchar(100) not null,
					   Price int not null,
					  quantity int not null,
					  Status varchar(20) not null default 'available',
					  check (status in('available' ,'not available'))
					 );
					 select * from productInfo; 
					 // command used to check whether product Id and product category exists or not;
					 "select * from productInfo where ProductId='"+productId+"' and Category='"+category+"' ";
					 