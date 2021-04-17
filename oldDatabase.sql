DROP TABLE IF EXISTS hotels;
DROP TABLE IF EXISTS hotelrooms;
DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS bookings;

CREATE TABLE IF NOT EXISTS hotels(
	id INTEGER NOT NULL PRIMARY KEY,
	name VARCHAR(40),
	location VARCHAR(40),
	stars INTEGER
);

CREATE TABLE IF NOT EXISTS hotelrooms(
    hotelid INTEGER NOT NULL,
    roomtype VARCHAR(40),
    roomcount INTEGER,
    price FLOAT,
	PRIMARY KEY(hotelid, roomtype),
	FOREIGN KEY(hotelid) REFERENCES hotels(id)
);

CREATE TABLE IF NOT EXISTS reviews(
	hotelid INTEGER NOT NULL,
  	rating FLOAT,
  	review VARCHAR(280),
  	username VARCHAR(40) NOT NULL,
  	PRIMARY KEY(hotelid, username)
  );

CREATE TABLE IF NOT EXISTS bookings(
	hotelid INTEGER NOT NULL,
	username VARCHAR(40) NOT NULL,
	roomtype VARCHAR(40),
	checkin DATE,
	checkout DATE,
	FOREIGN KEY (hotelid,roomtype) REFERENCES hotelrooms(hotelid,roomtype)
);


insert into hotels VALUES(1,'Kea', 'Akureyri', 3);
insert into hotels VALUES(2, 'Hilton', 'London', 4);
insert into hotels VALUES(3, 'Hilton', 'Paris', 4);
insert into hotels VALUES(4, 'Saga', 'Paris', 5);
insert into hotels VALUES(5, 'Bellagio', 'Las Vegas', 5);
insert into hotels VALUES(6, 'Aria', 'Las Vegas', 5);
insert into hotels VALUES(7, 'MGM Grand', 'Las Vegas', 4);
insert into hotels VALUES(8, 'Citadines', 'Tokyo', 3);
insert into hotels VALUES(9, 'Exsaison', 'Tokyo', 2);
insert into hotels VALUES(10, 'Marriot', 'New York', 4);
insert into hotels VALUES(11, 'Marriot', 'London', 4);
insert into hotelrooms VALUES(1, 'single room', 10, 5000);
insert into hotelrooms VALUES(1, 'double room', 8, 8000);
insert into hotelrooms VALUES(1, 'Suite', 2, 15000);
insert into hotelrooms VALUES(2, 'double room', 50, 10000);
insert into hotelrooms VALUES(2, 'Queen deluxe room', 20, 20000);
insert into hotelrooms VALUES(2, 'King Executive Suite', 3, 45000);
insert into hotelrooms VALUES(3, 'double room', 50, 10000);
insert into hotelrooms VALUES(3, 'Superior room', 37, 17000);
insert into hotelrooms VALUES(3, 'Queen deluxe room', 20, 20000);
insert into hotelrooms VALUES(3, 'King Executive Suite', 3, 45000);
insert into hotelrooms VALUES(4, 'double room', 40, 15000);
insert into hotelrooms VALUES(4, 'suite', 5, 25000);
insert into hotelrooms VALUES(5, 'double room', 60, 10000);
insert into hotelrooms VALUES(5, 'suite', 25, 20000);
insert into hotelrooms VALUES(5, 'King Executive Suite', 5, 50000);
insert into hotelrooms VALUES(6, 'double room', 20, 6000);
insert into hotelrooms VALUES(6, 'suite', 5, 15000);
insert into hotelrooms VALUES(7, 'double room', 100, 8000);
insert into hotelrooms VALUES(7, 'suite', 50, 20000);
insert into hotelrooms VALUES(7, 'King Executive Suite', 10, 50000);
insert into hotelrooms VALUES(7, 'Superior King Suite', 1, 100000);
insert into hotelrooms VALUES(8, 'double room', 20, 5000);
insert into hotelrooms VALUES(9, 'double room', 10, 4000);
insert into hotelrooms VALUES(10, 'double room', 20, 6000);
insert into hotelrooms VALUES(10, 'junior suite', 10, 15000);
insert into hotelrooms VALUES(11, 'double room', 30, 10000);
insert into hotelrooms VALUES(11, 'suite', 10, 20000);
insert into reviews VALUES(1, 4.5, 'Amazing', 'JesusKrist');
insert into reviews VALUES(2, 3.5, 'Noice', 'HakonLitli');
insert into reviews VALUES(3, 2.5, 'Meh', 'Hjaltalin7');
insert into reviews VALUES(4, 4, 'Very fine', 'JonaAlexPe');
insert into reviews VALUES(5, 5, 'Exquisite', 'IsakLoftss');
insert into reviews VALUES(6, 1, 'Terrible', 'AnnaSigga2');
insert into reviews VALUES(1, 3, 'It was ok', 'DiegoB2434');
insert into reviews VALUES(7, 2, 'Alright', 'NinjaBunny');
insert into reviews VALUES(7, 4, 'I loved it', 'OlafurRagn');
insert into reviews VALUES(8, 5, 'Perfect', 'DarriMarTh');
insert into reviews VALUES(9, 1, 'Reported', 'LifandiJon');
insert into reviews VALUES(10, 3, 'Not too bad', 'BaldurThor');
insert into reviews VALUES(11, 2, 'O.K.', 'Gudmundur6');
insert into reviews VALUES(1, 2, 'Sad', 'AnnaLara20');
insert into reviews VALUES(2, 3, 'Nice room', 'IsakArniJ2');
insert into reviews VALUES(3, 4.5, 'Good food', 'ArniBjarns');
insert into reviews VALUES(4, 2, 'Not fine', 'DiscordGuy');
insert into reviews VALUES(5, 1, 'Im crying', 'HakonOrnHa');
insert into reviews VALUES(6, 5, 'Too good', 'LarusGummi');
insert into reviews VALUES(2, 3.5, 'It was good', 'Sigthor405');
insert into reviews VALUES(7, 4, 'Ok for me', 'GeirHHorde');
insert into reviews VALUES(7, 2, 'I didnt like it', 'Grimson243');
insert into reviews VALUES(5, 1, 'Should be shut down', 'KariJohann');
insert into reviews VALUES(9, 5, 'Will recommend', 'SiggiBK');
insert into reviews VALUES(10, 1, 'I have called the police', 'Kenny');
insert into reviews VALUES(11, 4, 'Staff was nice', 'JFK');
insert into bookings VALUES(1, 'JesusKrist', 'single room', '2020-01-19', '2020-01-26');
insert into bookings VALUES(1, 'AnnaLara20', 'double room', '2019-02-19', '2020-02-26');
insert into bookings VALUES(1, 'DiegoB2434', 'suite', '2019-03-19', '2020-03-26');
insert into bookings VALUES(2, 'Sigthor405', 'Queen deluxe room', '2019-04-19', '2020-04-26');
insert into bookings VALUES(2, 'HakonLitli', 'King Executive suite', '2019-05-19', '2020-05-26');
insert into bookings VALUES(2, 'IsakArniJ2', 'double room', '2019-06-19', '2020-06-26');
insert into bookings VALUES(3, 'Hjaltalin7', 'Superior room', '2019-07-19', '2020-07-26');
insert into bookings VALUES(3, 'ArniBjarns', 'King executive suite', '2020-01-19', '2020-01-26');
insert into bookings VALUES(4, 'JonaAlexPe', 'double room', '2020-02-19', '2020-02-26');
insert into bookings VALUES(4, 'DiscordGuy', 'suite', '2020-03-19', '2020-03-26');
insert into bookings VALUES(5, 'IsakLoftss', 'double room', '2020-04-19', '2020-04-26');
insert into bookings VALUES(5, 'HakonOrnHa', 'suite', '2020-05-19', '2020-05-26');
insert into bookings VALUES(5, 'KariJohann', 'King Executive room', '2020-06-19', '2020-06-26');
insert into bookings VALUES(6, 'AnnaSigga2', 'double room', '2020-07-19', '2020-07-26');
insert into bookings VALUES(6, 'LarusGummi', 'suite', '2020-08-19', '2020-08-26');
insert into bookings VALUES(7, 'NinjaBunny', 'double room', '2020-09-19', '2020-09-26');
insert into bookings VALUES(7, 'GeirHHorde', 'suite', '2020-10-19', '2020-10-26');
insert into bookings VALUES(7, 'OlafurRagn', 'King Executive Suite', '2020-11-19', '2020-11-26');
insert into bookings VALUES(7, 'Grimson243', 'Superior King Suite', '2020-12-19', '2020-12-26');
insert into bookings VALUES(8, 'DarriMarTh', 'double room', '2020-01-19', '2020-01-26');
insert into bookings VALUES(10, 'BaldurThor', 'junior suite', '2020-02-19', '2020-02-26');
insert into bookings VALUES(11, 'Gudmundur6', 'suite', '2020-03-19', '2020-03-26');
insert into bookings VALUES(9, 'LifandiJon', 'double room', '2020-04-19', '2020-04-26');
insert into bookings VALUES(8, 'DarriMarTh', 'double room', '2020-01-19', '2020-01-26');
insert into bookings VALUES(10, 'BaldurThor', 'junior suite', '2020-02-19', '2020-02-26');
insert into bookings VALUES(11, 'Gudmundur6', 'suite', '2020-03-19', '2020-03-26');
insert into bookings VALUES(9, 'LifandiJon', 'double room', '2020-04-19', '2020-04-26');
