# Write your MySQL query statement below
''' find the ids of products that are both low fat and recyclable any order.
Products

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| product_id  | int     |
| low_fats    | enum    |
| recyclable  | enum    |
+-------------+---------+
'''
SELECT product_id from Products where low_fats='Y' and recyclable='Y';
