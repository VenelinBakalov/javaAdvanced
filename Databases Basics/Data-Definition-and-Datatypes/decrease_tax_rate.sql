USE `hotel`;

UPDATE `payments`
	SET `tax_rate`=`tax_rate` - 0.03 * `tax_rate`;

SELECT `tax_rate` FROM `payments`;
