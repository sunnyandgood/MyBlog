````
Ctrl+F 删除java注释:  /\*{1,2}[\s\S]*?\*/

Ctrl+F 删除xml注释:  <!-[\s\S]*?-->

Ctrl+F 删除空白行:   ^\s*\n

Ctrl+F 删除代码中的注释和空行:   /\*{1,2}[\s\S]*?\*/|\/\/.+|^\s*\n

勾选 Regular expressions 选择正则表达式  ，替换replaceAll全部即可。
````
