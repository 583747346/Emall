# Emall

[![](https://travis-ci.org/583747346/Emall.svg?branch=master)](https://github.com/583747346/Emall)
[![](https://codecov.io/gh/583747346/Emall/branch/master/graph/badge.svg)](https://codecov.io/gh/583747346/Emall)
![](https://img.shields.io/badge/springcloud-Hoxton.SR6-blue.svg)
![](https://img.shields.io/badge/springboot-2.2.8.RELEASE-orange.svg)

## 导言
坚持开源，持续代码迭代，技术更新，分享学习

## 前端项目--管理平台
https://github.com/583747346/emall-admin-master/tree/master

## 前期准备开始准备，
- [java8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) 
- [maven](http://maven.apache.org/) 
- [elasticsearch](https://www.elastic.co/cn/elasticsearch/)
- [logstash](https://www.elastic.co/cn/logstash)
- [rabbitmq](https://www.rabbitmq.com/)
- [redis](https://redis.io/)

## 开发环境搭建
1.代码克隆地址：https://github.com/583747346/Emall.git  
2.maven下载依赖：maven install  
3.生成ide配置：IDE安装lombok插件(setting->plugins->lombok)  

## 项目启动
* 1.启动准备  
######1.确保mysql服务正常  
######2.启动redis服务  
######3.启动ElasticSearch、logstash  
######4.启动rabbitmq服务  
######5.启动nacos服务  

 ### 应用列举(该项目所使用的三方应用)
 |  服务           |   服务名         |  默认端口     | 备注                                            |
 |----------------|-----------------|-----------|-------------------------------------------------|
 |  关系型数据库    |   mysql         |  3306     | 一个应用服务单独一个数据库                          |
 |  非关系型数据库   |  redis         |  6379     | 目前共用redis服务,根据key不同区分                   |
 |  消息中间件      |  rabbitmq      |  5672     |  目前资源与路由使用                                |
 |  注册与配置中心  |   nacos         |  8848     |  使用阿里外接nacos                                       |
 |  日志收集       |   logstash      |  9411     |  共用                                           |
 |  搜索引擎中间件  |   elasticsearch |  9200     |  共用                                           |
 |  日志分析工具    |   kibana        |  5601     |  共用(日志可视化展现)                             |
 |  图片存储器     |   阿里云oss       |           |  阿里云OSS对象存储器                              |

* 2.数据库初始化  
  sql文件分别在各个微服务工程的db文件中，可导入脚本运行
* 3.项目启动顺序  
  emall-ums-service服务必须最先启动，其余工程没有先后次序

## 学习直通车  

## 项目服务介绍
|  服务           |   服务名         |  端口     | 备注                                            |
|----------------|-----------------|-----------|-------------------------------------------------|
|  认证服务模块     |   authentication-server     |  50003     | 用户认证     |
|  资源服务模块     |   authorization-server      |  50004     | 用户授权    |
|  核心公共模块     |   emall-core                |            | 返回结果集，异常的定义等   |
|  web端公共模块    |   emall-web                |            |  前端请求相关，例：全局异常，等 |
|  网关管理服务模块  |   gateway-admin            |  40001     |  主要是对网关信息的管理  |
|  网关路由服务模块  |   gateway-web              |  40005     |  用于所有请求的关口    |
|  后端管理服务模块  |   emall-managementplat    |  50001      |  后端管理平台接口模块  |
|  前端管理服务模块  |   emall-app-service       |  60000      |   前端接口模块(APP端的相关接口)  |
|  用户管理服务模块  |   emall-ums-service       |  20010      |   用户接口模块 |
|  商品管理服务模块  |   emall-goods-service     |  20020      |   商品接口模块 |
|  库存管理服务模块  |   emall-stock-service     |  20030      |   库存接口模块  |
|  会员管理服务模块  |   emall-member-service    |  20040      |   会员接口模块  |

## 项目结构介绍


## 更新进度
### 当前更新
1.商品模块的完善  
2.用户管理模块的完善  
3.前端管理平台开发：用户管理、商品管理
### 下一步功能更新点
1.库存模块开发  
2.订单模块设计与开发  
3.拆分服务(库存服务,订单服务，会员服务)

## 联系交流
### 作者微信：
selectedBy
### 微信二维码：

### 微信交流群：

