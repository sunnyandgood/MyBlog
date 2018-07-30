# ERROR manager.SqlManager: Error executing statement: com.mysql.jdbc.exceptions.jdbc4.CommunicationsException: Communications link failure

### 解决办法（一）----关闭物理机的防火墙

控制面板->系统和安全->Windows Defender 防火墙->关闭防火墙

### 解决办法（二）----实用

* 1、控制面板->系统和安全->Windows Defender 防火墙->高级设置->入站规则

* 2、找到配置文件类型为“公用”的“文件和打印共享(回显请求 – ICMPv4-In)”规则，设置为允许

<div align="center"><img src=""/></div>
