# 搭建伪分布式hadoop环境时DataNode不存在

### 1、环境描述：

* 虚拟机VMware-workstation-full-12.5.7.20721，CentOS-6.5-i386，伪分布式安装Hadoop。

### 2、问题描述：

    多次格式化文件系统时：
    $ bin/hadoop namenode -format
    会出现datanode无法启动。

### 3、问题产生原因：

* 执行文件系统格式化时，会在namenode数据文件夹（即配置文件中dfs.name.dir在本地系统的路径）中保存一个current/VERSION文件，记录namespaceID，标识了所格式化的namenode的版本。如果我们频繁的格式化namenode，那么datanode中保存（即配置文件中dfs.data.dir在本地系统的路径）的current/VERSION文件只是你第一次格式化时保存的namenode的ID，因此就会造成datanode与namenode之间的id不一致。

### 4、datanode启动日志：

    /home/xsj/hadoop/hadoop-2.2.0/logs/hadoop-xsj-datanode-xsj-virtual-machine.log.XXXX-XX-XX
    查看日志发现：
    ************************************************************/
    2018-07-17 21:30:59,973 ERROR org.apache.hadoop.hdfs.server.datanode.DataNode: java.io.IOException: 
    Incompatible namespaceIDs in /softWare/hadoop-2.2.0/tmp/dfs/data: 
    namenode clusterID=CID-92f4681c-20c8-47bf-aa88-ac2b1ae174be;
    datanode clusterID=CID-66f4681c-20c8-47bf-aa88-ac1b1ae198ne

### 5、解决方案：

* 把配置文件中dfs.data.dir在本地系统的路径下的current/VERSION文件中的namespaceID改为与dfs.name.dir在本地系统的路径下的current/VERSION文件中的namespaceID一样，例如：

      dfs.data.dir为/softWare/hadoop-2.2.0/tmp/dfs/data
      dfs.name.dir为/softWare/hadoop-2.2.0/tmp/dfs/name

  * 打开/softWare/hadoop-2.2.0/tmp/dfs/name/current/VERSION文件：
  
        #Tue Jul 17 14:24:18 PDT 2018
        storageID=DS-240922725-192.168.1.101-50010-1531774119103
        clusterID=CID-92f4681c-20c8-47bf-aa88-ac2b1ae174be
        cTime=0
        storageType=DATA_NODE
        layoutVersion=-47

 * 修改为：
 
        #Tue Jul 17 14:24:18 PDT 2018
        storageID=DS-240922725-192.168.1.101-50010-1531774119103
        clusterID=CID-66f4681c-20c8-47bf-aa88-ac1b1ae198ne
        cTime=0
        storageType=DATA_NODE
        layoutVersion=-47


### 6、重启后执行jps命令：

    2750 SecondaryNameNode
    4064 DataNode
    2886 ResourceManager
    2507 NameNode
    2983 NodeManager
    5336 Jps
