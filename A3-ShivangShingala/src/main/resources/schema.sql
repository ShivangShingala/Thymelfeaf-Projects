DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;
drop table if exists discussions;

create table users (    
username varchar(50) not null primary key,
password varchar(120) not null,
enabled boolean not null
);

create table authorities (    
username varchar(50) not null,    
authority varchar(50) not null,    
foreign key (username) references users (username)
);

CREATE TABLE Discussions(
id LONG PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255),
datee VARCHAR(255),
thread VARCHAR(255)
);

INSERT INTO Discussions (name, datee, thread) values ('Vatsal', '27/10/2021', 'I like Pizzas' );
INSERT INTO Discussions (name, datee, thread) values ('John', '26/11/2020', 'My favourite game is Valorant' );
