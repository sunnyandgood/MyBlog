# 解决org.apache.ibatis.binding.BindingException: Invalid bound statement (not found)错误

### 一、错误提示

    org.apache.ibatis.binding.BindingException: Invalid bound statement (not found)

### 二、问题分析（网上资料）

* 一般的原因是Mapper interface和xml文件的定义对应不上，需要检查包名，namespace，函数名称等能否对应上，需要比较细致的对比，经常有写错了一两个字母搞的很长时间找不到错误。

* 按以下步骤 一 一 执行：一般来说到此就可以排除错误了。

    * 1、检查xml文件所在的package名称是否和interface对应的package名称一一对应

    * 2、检查xml文件的namespace是否和xml文件的package名称一一对应

    * 3、检查函数名称能否对应上

    * 4、去掉xml文件中的中文注释

    * 5、随意在xml文件中加一个空格或者空行然后保存

### 三、自己的问题

* 用了Mybatis Plus的类库而导入的是Mybatis的类（`spring.xml`文件）

      <!--sqlsessionfactory-->
      <bean class="org.mybatis.spring.SqlSessionFactoryBean">
          <property name="configLocation" value="classpath:mybatis-config.xml"/>
          <property name="dataSource" ref="dataSource"/>
          <property name="typeAliasesPackage" value="com.edu.bean"/>
          <property name="mapperLocations" value="classpath:mapper/*.xml"/>
      </bean>
      
    >需要更改为：
    
      <!--sqlsessionfactory-->
      <bean class="com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean">
          <property name="configLocation" value="classpath:mybatis-config.xml"/>
          <property name="dataSource" ref="dataSource"/>
          <property name="typeAliasesPackage" value="com.edu.bean"/>
          <property name="mapperLocations" value="classpath:mapper/*.xml"/>
      </bean>


* 拓展：（之前有几次jar包冲突）

      <!-- https://mvnrepository.com/artifact/com.baomidou/mybatis-plus -->
      <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus</artifactId>
        <version>2.3</version>
      </dependency>

    >不能与以下jar包同时出现
    
      <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.4.1</version>
      </dependency>
      <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>1.3.2</version>
      </dependency>













