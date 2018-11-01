# ubuntu 18.04  netplan yaml配置固定IP地址

### 问题分析

* ubuntu从17.10开始，已放弃在`/etc/network/interfaces`里固定IP的配置，即使配置也不会生效，而是改成`netplan`方式 ，配置写在`/etc/netplan/01-netcfg.yaml`或者类似名称的`yaml`文件里，18.04的server版本安装好以后，配置文件是：`/etc/netplan/50-cloud-init.yaml`，修改配置以后不用重启，执行 `netplan apply` 命令可以让配置直接生效。以前的重启网络服务命令`/etc/init.d/networking restart`或者`services network restrart`也都会提示为无效命令。

### 解决方案

* `$sudo nano /etc/netplan/50-cloud-init.yaml`配置文件可按如下内容修改。

      network:
        version: 2
        renderer: networkd
        ethernets:
          ens33:   #配置的网卡名称
            dhcp4: no    #dhcp4关闭
            dhcp6: no    #dhcp6关闭
            addresses: [192.168.2.8/24]   #设置本机IP及掩码
            gateway4: 192.168.2.254   #设置网关
            nameservers:
                addresses: [114.114.114.114, 8.8.8.8]   #设置DNS
