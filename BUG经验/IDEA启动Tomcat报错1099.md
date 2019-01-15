# IDEA启动Tomcat报错1099 is already in use

* IDEA中启动Tomcat报错，Error running Tomcat7.0.52: Address localhost:1099 is already in use 或者是 java.rmi.server.ExportException: Port already in use: 1099 ，表示1099端口被其他进程占用了。

### 解决方法：
* 1. win+R，运行，输入cmd，进入命令提示符
* 2. 输入netstat -aon | findstr 1099，找到占用1099端口的进程ID：PID
* 3. 输入taskkill -f -pid PID
* 4. 重启Tomcat

如果执行第3步时出现操作权限不够的提示，则在第1步进入命令提示符时，附件->右键->以管理员身份运行->命令提示符，然后再执行后面的步骤。

第3步也可以先用命令tasklist | findstr PID查看进程名，然后任务管理器->显示所有用户的进程->结束进程。
