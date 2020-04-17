CREATE TABLE category (
	
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(50),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY(id)
);


INSERT INTO category (name,description,image_url,is_active)values ('Mobile','This is description for Mobile','mobile.png',true);
INSERT INTO category (name,description,image_url,is_active)values ('TV','This is description for TV','TV.png',true);
INSERT INTO category (name,description,image_url,is_active)values ('Laptop','This is description for Laptop','Laptop.png',true);

CREATE TABLE user_detail (

	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(50),
	email VARCHAR(50),
	contact_number VARCHAR(50),
	CONSTRAINT pk_user_id PRIMARY KEY(id)
	
);

INSERT INTO user_detail (first_name,last_name,role,enabled,password,email,contact_number)values ('Morgan','Freeman','ADMIN',true,'admin','mf@gmail.com',9182737465);
INSERT INTO user_detail (first_name,last_name,role,enabled,password,email,contact_number)values ('Brad','Pitt','SUPPLIER',true,'12345','bp@gmail.com',9156473822);
INSERT INTO user_detail (first_name,last_name,role,enabled,password,email,contact_number)values ('Leo','Caprio','SUPPLIER',true,'12345','lc@gmail.com',8182737489);


CREATE TABLE product (

	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
	CONSTRAINT fk_product_category_id FOREIGN KEY(category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY(supplier_id) REFERENCES user_detail (id)
	
);


INSERT INTO product (code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id,purchases,views)values ('PRCODE1111MOB','iPhone 5','Apple','Old Brand for Apple',30000,20,true,1,2,5,5);
INSERT INTO product (code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id,purchases,views)values ('PRCODE2222MOB','iPhone 6','Apple','New Brand for Apple',40000,10,true,1,3,2,5);

INSERT INTO product (code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id,purchases,views)values ('PRCODE3333TV','Bravia','Onida','Smart TV for Onida',50000,15,true,2,2,5,5);
INSERT INTO product (code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id,purchases,views)values ('PRCODE4444TV','SmartLED','Videocon','Smart LED TV for Videocon',50000,15,true,2,3,5,5);

INSERT INTO product (code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id,purchases,views)values ('PRCODE5555LP','Vostro','Dell','Sub Standard',50000,15,true,3,2,5,5);
INSERT INTO product (code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id,purchases,views)values ('PRCODE6666LP','Inspiron','Dell','Smart LED TV for Videocon',50000,15,true,3,3,5,5);
