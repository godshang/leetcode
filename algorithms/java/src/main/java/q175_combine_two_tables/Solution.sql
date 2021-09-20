# Write your MySQL query statement below
SELECT p.FirstName AS FirstName, p.LastName AS LastName, a.City AS City, a.State AS State
FROM Person p
LEFT JOIN Address a ON p.PersonId = a.PersonId