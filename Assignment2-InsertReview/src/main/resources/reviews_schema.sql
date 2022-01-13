CREATE TABLE reviews (
id int PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255),
datee NUMBER,
timee NUMBER,
review VARCHAR(200)
);
INSERT INTO reviews (name, datee, timee, review) values ('Taj', 27, 9, 'Good sizzlers' );
INSERT INTO reviews (name, datee, timee, review) values ('Hilton', 25, 10, 'Bad services');
INSERT INTO reviews (name, datee, timee, review) values ('Ramada', 10, 15, 'Excellent hospitality');