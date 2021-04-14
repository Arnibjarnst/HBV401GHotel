DROP TABLE IF EXISTS hotels;
DROP TABLE IF EXISTS hotelrooms;
DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS bookings;

CREATE TABLE hotels (
	id INTEGER NOT NULL,
	name VARCHAR(40),
	location VARCHAR(40),
	stars INTEGER,
	PRIMARY KEY (id)
);

CREATE TABLE hotelrooms ( 
	hotelid INTEGER NOT NULL,
	hotel VARCHAR(40),
	roomtype VARCHAR(40),
	roomcount INTEGER,
	price FLOAT
);

CREATE TABLE reviews (
	hotelid INTEGER NOT NULL,
	rating FLOAT,
	review VARCHAR(280),
	username VARCHAR(40) NOT NULL,
	CONSTRAINT hotelreview PRIMARY KEY (hotelid, username)
);

CREATE TABLE bookings (
	hotelid INTEGER NOT NULL,
	username VARCHAR(40) NOT NULL,
	roomtype VARCHAR(40),
	checkin DATE,
	checkout DATE,
	CONSTRAINT hotelbooking PRIMARY KEY (hotelid, username, checkin)
);

insert into hotels (1,'Kea', 'Akureyri', 3);
insert into hotels (2, 'Hilton', 'London', 4);
insert into hotels (3, 'Hilton', 'Paris', 4);
insert into hotels (4, 'Saga', 'Paris', 5);
insert into hotels (5, 'Bellagio', 'Las Vegas', 5);
insert into hotels (6, 'Aria', 'Las Vegas', 5);
insert into hotels (7, 'MGM Grand', 'Las Vegas', 4);
insert into hotels (8, 'Citadines', 'Tokyo', 3);
insert into hotels (9, 'Exsaison', 'Tokyo', 2);
insert into hotels (10, 'Marriot', 'New York', 4);
insert into hotels (11, 'Marriot', 'London', 4);
insert into hotelrooms (1, 'Kea', 'single room', 10, 5000);
insert into hotelrooms (1, 'Kea', 'double room', 8, 8000);
insert into hotelrooms (1, 'Kea', 'Suite', 2, 15000);
insert into hotelrooms (2, 'Hilton', 'double room', 50, 10000); 
insert into hotelrooms (2, 'Hilton', 'Queen deluxe room', 20, 20000);
insert into hotelrooms (2, 'Hilton', 'King Executive Suite', 3, 45000);
insert into hotelrooms (3, 'Hilton', 'double room', 50, 10000); 
insert into hotelrooms (3, 'Hilton', 'Superior room', 37, 17000);
insert into hotelrooms (3, 'Hilton', 'Queen deluxe room', 20, 20000);
insert into hotelrooms (3, 'Hilton', 'King Executive Suite', 3, 45000);
insert into hotelrooms (4, 'Saga', 'double room', 40, 15000);
insert into hotelrooms (4, 'Saga', 'suite', 5, 25000);
insert into hotelrooms (5, 'Bellagio', 'double room', 60, 10000);
insert into hotelrooms (5, 'Bellagio', 'suite', 25, 20000);
insert into hotelrooms (5, 'Bellagio', 'King Executive Suite', 5, 50000);
insert into hotelrooms (6, 'Aria', 'double room', 20, 6000);
insert into hotelrooms (6, 'Aria', 'suite', 5, 15000);
insert into hotelrooms (7, 'MGM Grand', 'double room', 100, 8000);
insert into hotelrooms (7, 'MGM Grand', 'suite', 50, 20000);
insert into hotelrooms (7, 'MGM Grand', 'King Executive Suite', 10, 50000);
insert into hotelrooms (7, 'MGM Grand', 'Superior King Suite', 1, 100000);
insert into hotelrooms (8, 'Citadines', 'double room', 20, 5000);
insert into hotelrooms (9, 'Exsaison', 'double room', 10, 4000);
insert into hotelrooms (10, 'Marriot', 'double room', 20, 6000);
insert into hotelrooms (10, 'Marriot', 'junior suite', 10, 15000);
insert into hotelrooms (11, 'Marriot', 'double room', 30, 10000);
insert into hotelrooms (11, 'Marriot', 'suite', 10, 20000);
insert into reviews (1, 4.5, 'Amazing', JesusKrist);
insert into reviews (2, 3.5, 'Noice', HakonLitli);
insert into reviews (3, 2.5, 'Meh', Hjaltalin7);
insert into reviews (4, 4, 'Very fine', JonaAlexPe);
insert into reviews (5, 5, 'Exquisite', IsakLoftss);
insert into reviews (6, 1, 'Terrible', AnnaSigga2);
insert into reviews (1, 3, 'It was ok', DiegoB2434);
insert into reviews (7, 2, 'Alright', NinjaBunny);
insert into reviews (7, 4, 'I loved it', OlafurRagn);
insert into reviews (8, 5, 'Perfect', DarriMarTh);
insert into reviews (9, 1, 'Reported', LifandiJon);
insert into reviews (10, 3, 'Not too bad', BaldurThor);
insert into reviews (11, 2, 'O.K.', Gudmundur6);
insert into reviews (1, 2, 'Sad', AnnaLara20);
insert into reviews (2, 3, 'Nice room', IsakArniJ2);
insert into reviews (3, 4.5, 'Good food', ArniBjarns);
insert into reviews (4, 2, 'Not fine', DiscordGuy);
insert into reviews (5, 1, 'Im crying', HakonOrnHa);
insert into reviews (6, 5, 'Too good', LarusGummi);
insert into reviews (2, 3.5, 'It was good', Sigthor405);
insert into reviews (7, 4, 'Ok for me', GeirHHorde);
insert into reviews (7, 2, 'I didnt like it', Grimson243);
insert into reviews (5, 1, 'Should be shut down', KariJohann);
insert into reviews (9, 5, 'Will recommend', );
insert into reviews (10, 1, 'I have called the police', );
insert into reviews (11, 4, 'Staff was nice', );
insert into bookings (1, JesusKrist, 'single room', '2020-01-19', '2020-01-26')
insert into bookings (1, AnnaLara20, 'double room', '2019-02-19', '2020-02-26')
insert into bookings (1, DiegoB2434, 'suite', '2019-03-19', '2020-03-26')
insert into bookings (2, Sigthor405, 'Queen deluxe room', '2019-04-19', '2020-04-26')
insert into bookings (2, HakonLitli, 'King Executive suite', '2019-05-19', '2020-05-26')
insert into bookings (2, IsakArniJ2, 'double room', '2019-06-19', '2020-06-26')
insert into bookings (3, Hjaltalin7, 'Superior room', '2019-07-19', '2020-07-26')
insert into bookings (3, ArniBjarns, 'King executive suite', '2020-01-19', '2020-01-26')
insert into bookings (4, JonaAlexPe, 'double room', '2020-02-19', '2020-02-26')
insert into bookings (4, DiscordGuy, 'suite', '2020-03-19', '2020-03-26')
insert into bookings (5, IsakLoftss, 'double room', '2020-04-19', '2020-04-26')
insert into bookings (5, HakonOrnHa, 'suite', '2020-05-19', '2020-05-26')
insert into bookings (5, KariJohann, 'King Executive room', '2020-06-19', '2020-06-26')
insert into bookings (6, AnnaSigga2, 'double room', '2020-07-19', '2020-07-26')
insert into bookings (6, LarusGummi, 'suite', '2020-08-19', '2020-08-26')
insert into bookings (7, NinjaBunny, 'double room', '2020-09-19', '2020-09-26')
insert into bookings (7, GeirHHorde, 'suite', '2020-10-19', '2020-10-26')
insert into bookings (7, OlafurRagn, 'King Executive Suite', '2020-11-19', '2020-11-26')
insert into bookings (7, Grimson243, 'Superior King Suite', '2020-12-19', '2020-12-26')
insert into bookings (8, DarriMarTh, 'double room', '2020-01-19', '2020-01-26')
insert into bookings (10, BaldurThor, 'junior suite', '2020-02-19', '2020-02-26')
insert into bookings (11, Gudmundur6, 'suite', '2020-03-19', '2020-03-26')
insert into bookings (9, LifandiJon, 'double room', '2020-04-19', '2020-04-26')
insert into bookings (8, DarriMarTh, 'double room', '2020-01-19', '2020-01-26')
insert into bookings (10, BaldurThor, 'junior suite', '2020-02-19', '2020-02-26')
insert into bookings (11, Gudmundur6, 'suite', '2020-03-19', '2020-03-26')
insert into bookings (9, LifandiJon, 'double room', '2020-04-19', '2020-04-26')