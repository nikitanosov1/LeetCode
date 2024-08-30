SELECT e2.name FROM employee e1
JOIN employee e2
     ON e1.managerid = e2.id
GROUP BY e1.managerid, e2.name
HAVING COUNT(e1.id) >= 5


-- SELECT em.name FROM employee em
-- WHERE em.id in (
--     SELECT e.managerid FROM employee e
--     GROUP BY managerid
--     HAVING COUNT(e.id) >= 5)