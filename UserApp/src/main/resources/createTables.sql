

CREATE TABLE user (
    id        INTEGER       NOT NULL
                            PRIMARY KEY AUTOINCREMENT,
    firstName VARCHAR (50) DEFAULT NULL,
    lastName  VARCHAR (50) DEFAULT NULL
);

CREATE TABLE address (
    id         INTEGER      PRIMARY KEY AUTOINCREMENT,
    userid     INTEGER      REFERENCES user (id) ON DELETE CASCADE
                                                 ON UPDATE CASCADE,
    street     VARCHAR (50),
    city       VARCHAR (50),
    state      VARCHAR (50),
    postalcode VARCHAR (50) 
)

