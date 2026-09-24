# Write your MySQL query statement below
Select eu.unique_ID ,e.name
FROM Employees e
LEFT JOIN EmployeeUNI eu
ON eu.ID = e.id;
