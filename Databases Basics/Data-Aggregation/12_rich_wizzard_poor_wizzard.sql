CREATE VIEW `rw_pw` AS
SELECT w1.`first_name` AS 'host_wizard', w1.`deposit_amount` AS 'host_wizard_deposit',
		 w2.`first_name` AS 'guest wizard', w2.`deposit_amount` AS 'guest_wizard_deposit',
		 w1.`deposit_amount` - w2.`deposit_amount` AS 'difference'	
FROM `wizzard_deposits` AS w1, `wizzard_deposits` AS w2
WHERE w1.`id` + 1 = w2.`id`;

SELECT SUM(`difference`) AS 'sum_difference'
FROM `rw_pw`;

SELECT SUM(`difference`) AS 'sum_difference'
FROM (
SELECT w1.`first_name` AS 'host_wizard', w1.`deposit_amount` AS 'host_wizard_deposit',
		 w2.`first_name` AS 'guest wizard', w2.`deposit_amount` AS 'guest_wizard_deposit',
		 w1.`deposit_amount` - w2.`deposit_amount` AS 'difference'	
FROM `wizzard_deposits` AS w1, `wizzard_deposits` AS w2
WHERE w1.`id` + 1 = w2.`id`) AS w;
