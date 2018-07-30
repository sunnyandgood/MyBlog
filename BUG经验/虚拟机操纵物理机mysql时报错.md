### 问题分析（一）

* ERROR manager.SqlManager: Error executing statement: com.mysql.jdbc.exceptions.jdbc4.CommunicationsException: Communications link failure


* 解决办法----关闭物理机的防火墙

    * 1、控制面板->系统和安全->Windows Defender 防火墙->关闭防火墙

    * 2、虚拟机可以ping通主机了！



### 问题分析（二）
* 物理机能ping通虚拟机,但是虚拟不能ping通物理机

*  解决办法

    * 1、控制面板->系统和安全->Windows Defender 防火墙->高级设置->入站规则

    * 2、找到配置文件类型为“公用”的“文件和打印共享(回显请求 – ICMPv4-In)”规则，设置为允许

    <div align="center"><img src="https://github.com/sunnyandgood/MyBlog/blob/master/BUG经验/img/解决物理机ping不通虚拟机.png"/></div>

    * 3、点击右边小框“启用规则”

    * 4、虚拟机可以ping通主机了！
