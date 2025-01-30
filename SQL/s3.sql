# 595. Big Countries . Write your MySQL query statement below
/*Table: World

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| name        | varchar |
| continent   | varchar |
| area        | int     |
| population  | int     |
| gdp         | bigint  |
+-------------+---------+
A country is big if:

it has an area of at least three million (i.e., 3000000 km2), or
it has a population of at least twenty-five million (i.e., 25000000).

find the name, population, and area of the big countries.

Return the result table in any order.*/
select name, population, area from World where area >= '3000000' or population >='25000000';
