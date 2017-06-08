SELECT `product_name`, `order_date`,
	DATE_ADD(`order_date`, INTERVAL 3 DAY) AS `pay_due`,
	DATE_ADD(`order_date`, INTERVAL 1 MONTH) AS `deliver_due`
FROM `orders`;