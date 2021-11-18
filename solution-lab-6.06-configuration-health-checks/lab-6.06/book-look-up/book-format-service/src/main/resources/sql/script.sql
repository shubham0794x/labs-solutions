GRANT ALL PRIVILEGES ON book_format_service.* TO 'adrialopezbou'@'localhost';
DROP SCHEMA book_format_service;
CREATE SCHEMA book_format_service;
USE book_format_service;


CREATE TABLE book_format(
	id BIGINT NOT NULL AUTO_INCREMENT,
	isbn BIGINT NOT NULL,
    format VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO book_format(isbn, format) VALUES 
(1234, 'HARDCOVER'),
(1234, 'AUDIO')
;