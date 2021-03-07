create table song_group(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(255),
    PRIMARY KEY (id)
)

create table song(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(255),
    path varchar(255),
    group_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (group_id) REFERENCES song_group(id)
)