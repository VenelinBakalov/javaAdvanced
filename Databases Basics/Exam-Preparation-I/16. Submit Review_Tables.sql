CREATE TABLE customer_reviews(
	review_id INT AUTO_INCREMENT,
	review_content VARCHAR(255) NOT NULL,
	review_grade INT NOT NULL,
	airline_id INT,
	customer_id INT,
	CONSTRAINT pk_customer_reviews PRIMARY KEY(review_id),
	CONSTRAINT fk_customer_reviews_airlines FOREIGN KEY(airline_id) REFERENCES airlines(airline_id),
	CONSTRAINT fk_customer_reviews_customers FOREIGN KEY(customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE customer_bank_accounts(
	account_id INT AUTO_INCREMENT,
	account_number VARCHAR(10) UNIQUE NOT NULL,
	balance DECIMAL(10, 2) NOT NULL,
	customer_id INT,
	CONSTRAINT pk_customer_bank_accounts PRIMARY KEY(account_id),
	CONSTRAINT fk_customer_bank_accounts_customers FOREIGN KEY(customer_id) REFERENCES customers(customer_id)
);
