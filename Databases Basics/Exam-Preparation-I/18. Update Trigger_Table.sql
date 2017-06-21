CREATE TABLE arrived_flights(
	flight_id INT,
	arrival_time DATETIME,
	origin VARCHAR(50),
	destination VARCHAR(50),
	passengers INT,
	CONSTRAINT PK_arrived_flights PRIMARY KEY(flight_id)
);