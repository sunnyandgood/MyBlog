# 错误提示

    Exception in thread "main" com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: 
                                                            Duplicate entry '1' for key 'PRIMARY'
      at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
      at sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)
      at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)
      at java.lang.reflect.Constructor.newInstance(Unknown Source)
      at com.mysql.jdbc.Util.handleNewInstance(Util.java:377)
      at com.mysql.jdbc.Util.getInstance(Util.java:360)
      at com.mysql.jdbc.SQLError.createSQLException(SQLError.java:971)
      at com.mysql.jdbc.MysqlIO.checkErrorPacket(MysqlIO.java:3887)
      at com.mysql.jdbc.MysqlIO.checkErrorPacket(MysqlIO.java:3823)
      at com.mysql.jdbc.MysqlIO.sendCommand(MysqlIO.java:2435)
      at com.mysql.jdbc.MysqlIO.sqlQueryDirect(MysqlIO.java:2582)
      at com.mysql.jdbc.ConnectionImpl.execSQL(ConnectionImpl.java:2526)
      at com.mysql.jdbc.StatementImpl.executeUpdate(StatementImpl.java:1618)
      at com.mysql.jdbc.StatementImpl.executeUpdate(StatementImpl.java:1549)
      at com.mchange.v2.c3p0.impl.NewProxyStatement.executeUpdate(NewProxyStatement.java:64)
      at com.edu.excel.ImportExcel.main(ImportExcel.java:84)

# 问题分析

**主键已存在，建议更换主键。**

# 问题详解

在使用poi从excel表导入数据到数据库时，excel表中的数据主键在数据库中已经存在，建议更换主键（或者予以判断，当主键已存在时不再执行插入操作，执行更新操作）。









