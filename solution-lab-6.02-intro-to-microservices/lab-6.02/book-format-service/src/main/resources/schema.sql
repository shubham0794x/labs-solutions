DROP TABLE IF EXISTS book_format;

CREATE TABLE book_format(
	id BIGINT NOT NULL AUTO_INCREMENT,
	isbn BIGINT NOT NULL,
    format VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);