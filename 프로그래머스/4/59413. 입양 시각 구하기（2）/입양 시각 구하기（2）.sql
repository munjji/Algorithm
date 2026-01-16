-- 코드를 입력하세요
WITH RECURSIVE hours AS (
    SELECT 0 AS hour
    UNION ALL
    SELECT hour + 1
    FROM hours
    WHERE hour < 23
)

SELECT 
    h.hour AS HOUR,
    COALESCE(COUNT(a.ANIMAL_ID), 0) AS COUNT
FROM hours h
LEFT JOIN ANIMAL_OUTS a
  ON h.hour = HOUR(a.DATETIME)
GROUP BY h.hour
ORDER BY h.hour;