CREATE TABLE cargo_entity (
        flight_id BIGINT PRIMARY KEY);

CREATE TABLE baggage (
    id BIGINT,
    weight BIGINT,
    weight_unit VARCHAR(255),
    pieces BIGINT,
    flight_Id BIGINT NOT NULL);

CREATE TABLE cargo (
      id BIGINT,
      weight BIGINT,
      weight_unit VARCHAR(255),
      pieces BIGINT,
      flight_Id BIGINT NOT NULL);

ALTER TABLE baggage
       ADD CONSTRAINT baggage_flight_id
       FOREIGN KEY (flight_id) REFERENCES cargo_entity(flight_id);

ALTER TABLE cargo
        ADD CONSTRAINT cargo_flight_id
        FOREIGN KEY (flight_id) REFERENCES cargo_entity(flight_id);

CREATE TABLE flight_entity (
        flight_id BIGINT PRIMARY KEY,
        flight_number BIGINT,
        departure_airportiatacode VARCHAR(255),
        arrival_airportiatacode VARCHAR(255),
        departure_date VARCHAR(255));