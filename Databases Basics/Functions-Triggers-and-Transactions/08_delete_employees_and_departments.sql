DELIMITER $$

CREATE TRIGGER `tr_delete_employees`
BEFORE DELETE
ON `employees`
FOR EACH ROW
BEGIN
	DELETE FROM `employees_projects`
	WHERE employee_id = old.employee_id;
	
	UPDATE `employees`
	SET `manager_id` = NULL
	WHERE `manager_id` = old.employee_id;
END $$diablo

DELIMITER ;

DELETE FROM `employees`
WHERE `department_id` IN 
	(SELECT d.department_id FROM `departments` AS d 
	 WHERE d.name IN ('Production', 'Production Control'));