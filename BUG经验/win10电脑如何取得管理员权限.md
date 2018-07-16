### 系统获取最高管理员权限步骤：

* 1、在系统桌面点击右键—新建—文本文档；

* 2、打开文本文档，将一下代码复制进去；

        Windows Registry Editor Version 5.00
        [HKEY_CLASSES_ROOT\*\shell\runas]
        @="取得管理员所有权"
        "NoWorkingDirectory"=""
        [HKEY_CLASSES_ROOT\*\shell\runas\command]
        @="cmd.exe /c takeown /f \"%1\" && icacls \"%1\" /grant administrators:F"
        "IsolatedCommand"="cmd.exe /c takeown /f \"%1\" && icacls \"%1\" /grant
        administrators:F"
        [HKEY_CLASSES_ROOT\exefile\shell\runas2]
        @="取得管理员所有权"
        "NoWorkingDirectory"=""
        [HKEY_CLASSES_ROOT\exefile\shell\runas2\command]
        @="cmd.exe /c takeown /f \"%1\" && icacls \"%1\" /grant administrators:F"
        "IsolatedCommand"="cmd.exe /c takeown /f \"%1\" && icacls \"%1\" /grant
        administrators:F"
        [HKEY_CLASSES_ROOT\Directory\shell\runas]
        @="取得管理员所有权"
        "NoWorkingDirectory"=""
        [HKEY_CLASSES_ROOT\Directory\shell\runas\command]
        @="cmd.exe /c takeown /f \"%1\" /r /d y && icacls \"%1\" /grant administrators:F
        /t"
        "IsolatedCommand"="cmd.exe /c takeown /f \"%1\" /r /d y && icacls \"%1\" /grant
        administrators:F /t"
        
* 3、点击左上角：文件—另存为`管理员所有权.reg` ，双击，点 是 

* 4、提示成功添加到注册表中，点击确定；

* 5、找到需要处理的文件，右键点击“取得管理员所有权”，然后再执行操作。
