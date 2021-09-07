CREATE DATABASE rentbook;
\c rentbook

CREATE TABLE tenants(id serial PRIMARY KEY, name varchar, email varchar, phone_number varchar, id_number varchar, age int,  occupation varchar, gender varchar, has_family boolean, paid_deposit bigint, paid_rent bigint, rent_balance bigint, house_number varchar, property_id int);
CREATE TABLE landlords(id serial PRIMARY KEY, name varchar, email varchar, phone_number varchar, gender varchar, location varchar);
CREATE TABLE properties(id serial PRIMARY KEY, name varchar, location varchar, number_of_units int, rent_per_unit bigint, has_electricity boolean, has_water boolean, has_internet boolean, caretaker_name varchar, caretaker_phone_number varchar, landlord_id int);

CREATE DATABASE rentbook_test WITH TEMPLATE rentbook;