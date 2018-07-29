# Mysql服务不见的解决办法 

* 打开cmd.exe程序的时候选择“用管理员身份打开”。

* 进入mysql的bin目录

            C:\Windows\system32>cd C:\Program Files (x86)\MySQL\MySQL Server 5.0\bin

* 执行mysqld-nt.exe -install命令

            C:\Program Files (x86)\MySQL\MySQL Server 5.0\bin>mysqld-nt.exe -install
            Service successfully installed.
            这个时候刷新服务列表mysql就出现了,启动就可以了。

* 或者可以直接在cmd中做如下操作启动mysql服务

            D:\MySQL\bin>net start mysql
