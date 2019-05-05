## `SELECT getdate() AS DateTime`  调用getdate（）这个函数时，总是报错：`1305 - FUNCTION job.getdate does not exist`。数据库名叫job

### 问题分析


      getdate()  是  SQL Server  的函数。
      MySQL 里面,用 now()  函数

### 问题解决

      mysql> use job
      Database changed
      mysql> SELECT getdate() AS DateTime
          -> ;
      ERROR 1305 (42000): FUNCTION test.getdate does not exist


      mysql> select now() as  DateTime;
      +---------------------+
      | DateTime            |
      +---------------------+
      | 2018-07-14 16:19:02 |
      +---------------------+
      1 row in set (0.00 sec)
