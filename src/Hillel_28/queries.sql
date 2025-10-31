sales_db=# SELECT * FROM sales;
 sales_id | product |  price  | quantity
----------+---------+---------+----------
        1 | Laptop  | 1000.00 |        5
        2 | Phone   |  700.00 |        3
        3 | Tablet  |  500.00 |        2
        4 | Printer |  300.00 |        4
(4 rows)


sales_db=# SELECT * FROM sales LIMIT 2;
 sales_id | product |  price  | quantity
----------+---------+---------+----------
        1 | Laptop  | 1000.00 |        5
        2 | Phone   |  700.00 |        3
(2 rows)


sales_db=# SELECT SUM(price) FROM sales;
   sum
---------
 2500.00
(1 row)


sales_db=# SELECT product, COUNT(*), AVG(price), FROM sales, GROUP BY product;
ОШИБКА:  ошибка синтаксиса (примерное положение: "FROM")
LINE 1: SELECT product, COUNT(*), AVG(price), FROM sales, GROUP BY p...
                                              ^
sales_db=#  SELECT product, COUNT(*), AVG(price), FROM sales GROUP BY product;
ОШИБКА:  ошибка синтаксиса (примерное положение: "FROM")
LINE 1: SELECT product, COUNT(*), AVG(price), FROM sales GROUP BY pr...
                                              ^
sales_db=#  SELECT product, COUNT(*), AVG(price) FROM sales GROUP BY product;
 product | count |          avg
---------+-------+-----------------------
 Printer |     1 |  300.0000000000000000
 Tablet  |     1 |  500.0000000000000000
 Phone   |     1 |  700.0000000000000000
 Laptop  |     1 | 1000.0000000000000000
(4 rows)