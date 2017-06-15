

SELECT co.continent_code, cu.currency_code, COUNT(cu.currency_code) AS currency_usage
FROM continents AS co 
INNER JOIN countries AS c
ON co.continent_code = c.continent_code
INNER JOIN currencies AS cu
ON c.currency_code = cu.currency_code
GROUP BY co.continent_code, cu.currency_code
HAVING currency_usage > 1;