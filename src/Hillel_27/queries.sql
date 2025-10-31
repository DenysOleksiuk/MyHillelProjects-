My_hillel_DB=# CREATE TABLE users (
My_hillel_DB(#   UserId SERIAL PRIMARY KEY,
My_hillel_DB(#   name VARCHAR(50) NOT NULL,
My_hillel_DB(#   age INT NOT NULL,
My_hillel_DB(#   email VARCHAR(90) NOT NULL
My_hillel_DB(# );
CREATE TABLE
My_hillel_DB=# \dt
          List of tables
 Schema | Name  | Type  |  Owner
--------+-------+-------+----------
 public | users | table | postgres
(1 row)


My_hillel_DB=# INSERT INTO users (name, age, email) VALUES
My_hillel_DB-# ('John', 30, 'john@example.com'),
My_hillel_DB-# ('Alice', 25, 'alice@example.com');
INSERT 0 2
My_hillel_DB=# INSERT INTO users (name, age, email) VALUES ('Bob', 35, 'bob@example.com');
INSERT 0 1
My_hillel_DB=# SELECT * FROM users;
 userid | name  | age |       email
--------+-------+-----+-------------------
      1 | John  |  30 | john@example.com
      2 | Alice |  25 | alice@example.com
      3 | Bob   |  35 | bob@example.com
(3 rows)


My_hillel_DB=# DELETE FROM users WHERE name = 'Bob';
DELETE 1
My_hillel_DB=# SELECT * FROM users;
 userid | name  | age |       email
--------+-------+-----+-------------------
      1 | John  |  30 | john@example.com
      2 | Alice |  25 | alice@example.com
(2 rows)
