CREATE TABLE IF NOT EXISTS book (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    author VARCHAR(255),
    category VARCHAR(255),
    location VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS borrow_record (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    book_id BIGINT,
    borrower VARCHAR(255),
    borrow_date DATE,
    return_date DATE,
    FOREIGN KEY(book_id) REFERENCES book(id)
);
