create table users (
  id INTEGER PRIMARY KEY ,
  name VARCHAR,
  age INTEGER,
  has_license BOOLEAN,
  car_id INTEGER REFERENSE cars (id)
);

create table cars(
    id INTEGER PRIMARY KEY ,
    brand VARCHAR,
    model VARCHAR,
    cost NUMERIC
);