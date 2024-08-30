SELECT s.user_id,
       ROUND(
               SUM(CASE WHEN c.action = 'confirmed' THEN 1 ELSE 0 END)::numeric
                   /
               CASE WHEN COUNT(c.action) = 0 THEN 1 ELSE COUNT(c.action) END,
               2
       ) as confirmation_rate
FROM signups s
         FULL OUTER JOIN confirmations c
                         ON s.user_id = c.user_id
GROUP BY s.user_id;