# 解决MySQL乱码

* 1、打开MySQL的命令框，输入以下命令：

      show variables like 'char%'

* 2、找到MySQL的配置文件（my.ini）追加内容

  * 在[client]下追加：
  
        default-character-set=utf8

  * 在[mysql]下追加：
  
        default-character-set=utf8

  * 在[mysqld]下追加：
  
        character-set-server=utf8

* 3、重启MySQL服务，再在命令框输入`show variables like 'char%'`

      mysql> show variables like 'char%';
      +--------------------------+-------------------------------------------------+
      | Variable_name            | Value                                           |
      +--------------------------+-------------------------------------------------+
      | character_set_client     | utf8                                            |
      | character_set_connection | utf8                                            |
      | character_set_database   | utf8                                            |
      | character_set_filesystem | binary                                          |
      | character_set_results    | utf8                                            |
      | character_set_server     | utf8                                            |
      | character_set_system     | utf8                                            |
      | character_sets_dir       | C:\wamp64\bin\mysql\mysql5.7.14\share\charsets\ |
      +--------------------------+-------------------------------------------------+










