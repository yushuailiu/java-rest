基于java 11 和 spring boot语言的简单REST应用，Java入门学习示例、spring boot入门。
## 运行
首先下载代码
```
git clone git@github.com:yushuailiu/java-rest.git
```
然后修改配置，src/main/resources/application.properties
```
spring.jpa.hibernate.ddl-auto=none
spring.datasource.url=jdbc:mysql://localhost:3306/test?useSSL=false
spring.datasource.username=username
spring.datasource.password=password
```
新建数据库及表
```
create database test;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(60) NOT NULL DEFAULT '',
  `last_name` varchar(60) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8
```
安装依赖及启动
```
cd java-rest
mvn clean install
mvn clean package
java -jar target/javarest-1.0-SNAPSHOT.jar
```
## TODO
1. 添加测试
2. spring boot开发环境热更新
3. 接口测试
4. 配置区分不同开发环境