# Write your MySQL query statement below
SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee
where Salary < (
    SELECT Salary FROM Employee ORDER BY Salary DESC LIMIT 1
)