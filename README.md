# struts2Demo
Java Struts2框架与mysql数据库实现商品和商品类别的增删改查操作
### @author 林剑敏
#### 数据库表结构
##### super_type数据表
```sql
# Host: localhost  (Version: 5.5.53)
# Date: 2017-03-27 22:28:59
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "super_type"
#

DROP TABLE IF EXISTS `super_type`;
CREATE TABLE `super_type` (
  `type_id` int(11) NOT NULL,
  `type_name` varchar(20) NOT NULL,
  KEY `type_id` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "super_type"
#

INSERT INTO `super_type` VALUES (1,'文具');

```
##### supermarket数据表
```sql
# Host: localhost  (Version: 5.5.53)
# Date: 2017-03-27 22:29:07
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "supermarket"
#

DROP TABLE IF EXISTS `supermarket`;
CREATE TABLE `supermarket` (
  `super_id` int(11) NOT NULL AUTO_INCREMENT,
  `super_name` varchar(20) NOT NULL,
  `super_price` double NOT NULL,
  `super_type_id` int(11) NOT NULL,
  `super_from` enum('1','2','3','4') NOT NULL,
  `super_condition` varchar(255) NOT NULL DEFAULT '',
  `super_status` enum('in','out') NOT NULL,
  PRIMARY KEY (`super_id`),
  KEY `SUP_PK_TYPE` (`super_type_id`),
  CONSTRAINT `SUP_PK_TYPE` FOREIGN KEY (`super_type_id`) REFERENCES `super_type` (`type_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Data for table "supermarket"
#

INSERT INTO `supermarket` VALUES (17,'铅笔',200,1,'1','a|c|','in');

```

### 插入商品类别截图 
![image](https://github.com/say-hello-user/struts2Demo/blob/master/image/type_add.png)
### 获取商品类别截图 
![image](https://github.com/say-hello-user/struts2Demo/blob/master/image/getType.png)
### 插入商品截图 
![image](https://github.com/say-hello-user/struts2Demo/blob/master/image/addMarket.png)
### 获取商品截图 
![image](https://github.com/say-hello-user/struts2Demo/blob/master/image/getMarket.png)
