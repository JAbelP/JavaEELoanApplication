CREATE TABLE employer(
  	id serial PRIMARY KEY,
  	startDate date,
  	endDate date,
  	employerName VARCHAR,
  	employerPhone VARCHAR,
	borrowerId int
	);
  
  INSERT INTO employer(startDate,endDate,employerName,employerPhone, borrowerId)
  VALUES('2021-10-04','2022-10-04','Five Below',9999999999,1 );
  INSERT INTO employer(startDate,endDate,employerName,employerPhone,borrowerId)
  VALUES('1997-10-04','2022-10-04','IBM',8888888888,1);
  INSERT INTO employer(startDate,endDate,employerName,employerPhone,borrowerId)
  VALUES('2010-10-04','2022-10-04','Stack leader',77777777777,3);
  
  CREATE TABLE borrowers(
  	id serial PRIMARY KEY,
	firstName VARCHAR  not NULL,
  	lastName VARCHAR not NULL,
  	age int not NULL,
  	address VARCHAR not NULL,
    city VARCHAR NOT NULL,
    stat VARCHAR NOT NULL,
  	zip int not NULL,
  	ssn int not NULL,
  	relation VARCHAR not NULL,
  	appID int not NULL
  );
  
  INSERT INTO borrowers(firstName,lastName,age,address,city,stat,zip,ssn,relation,appID)
  VALUES('abel','P',24,'example road','garner','NC',2222222,000000000,'son',1);
  INSERT INTO borrowers(firstName,lastName,age,address,city,stat,zip,ssn,relation,appID)
  VALUES('Joel','P',50,'example road','garner','NC',2222222,111111111,'father',1);
  INSERT INTO borrowers(firstName,lastName,age,address,city,stat,zip,ssn,relation,appID)
  VALUES('Eva','C',50,'example road','Cow Drive','NY',2222222,222222222,'mother',2);
  
CREATE TABLE applications(
  	id serial PRIMARY KEY,
  	creditLimit int  NOT NULL,
  	cardType VARCHAR,
  	lendType VARCHAR
  );
  INSERT INTO applications(creditLimit,cardType,lendType )VALUES(500,'VISA','Credit Card');
  INSERT INTO applications(creditLimit,cardType,lendType )VALUES(3010,'MasterCard','Credit Card');
  
  
