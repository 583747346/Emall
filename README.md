# Emall

[![](https://travis-ci.org/583747346/Emall.svg?branch=master)](https://github.com/583747346/Emall)
[![](https://codecov.io/gh/583747346/Emall/branch/master/graph/badge.svg)](https://codecov.io/gh/583747346/Emall)
![](https://img.shields.io/badge/springcloud-Hoxton.SR6-blue.svg)
![](https://img.shields.io/badge/springboot-2.2.8.RELEASE-orange.svg)

## 导言


## 前端项目--管理平台
https://github.com/583747346/Emall-master-admin

## 前期准备开始准备，
- [java8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) 
- [maven](http://maven.apache.org/) 
- [elasticsearch](https://www.elastic.co/cn/elasticsearch/)
- [logstash](https://www.elastic.co/cn/logstash)
- [rabbitmq](https://www.rabbitmq.com/)

## 开发环境搭建
代码克隆：https://github.com/583747346/Emall.git
maven下载依赖：maven install

## 应用列举(该项目所使用的三方应用)
|  服务           |   服务名         |  默认端口     | 备注                                            |
|----------------|-----------------|-----------|-------------------------------------------------|
|  关系型数据库    |   mysql         |  3306     | 一个应用服务单独一个数据库                          |
|  非关系型数据库   |  redis         |  6379     | 目前共用redis服务,根据key不同区分                   |
|  消息中间件      |  rabbitmq      |  5672     |  目前资源与路由使用                                |
|  注册与配置中心  |   nacos         |  8848     |  使用阿里外接nacos                                       |
|  日志收集       |   logstash      |  9411     |  共用                                           |
|  搜索引擎中间件  |   elasticsearch |  9200     |  共用                                           |
|  日志分析工具    |   kibana        |  5601     |  共用(日志可视化展现)                             |

## 项目服务介绍
|  服务           |   服务名         |  端口     | 备注                                            |
|----------------|-----------------|-----------|-------------------------------------------------|
|  认证服务模块     |   authentication-server     |  50003     | 用户认证     |
|  资源服务模块     |  authorization-server       |  50004     | 用户授权    |
|  核心公共模块     |  emall-core                 |            | 返回结果集，异常的定义等   |
|  web端公共模块    |   emall-web                |            |  前端请求相关，例：全局异常，等 |
|  注册中心         |   emall-eureka             |  8761      |  服务注册中心   |
|  网关管理服务模块  |   gateway-admin            |  40001     |  主要是对网关信息的管理  |
|  网关路由服务模块  |   gateway-web              |  40005     |  用于所有请求的关口    |
|  后端管理服务模块  |   emall-managementplat    |  50001      |  后端管理平台接口模块  |
|  前端管理服务模块  |   emall-deskfronton       |  50002      |   前端接口模块(APP端的相关接口)  |

## 用户模块

## 权限控制层级
角色——菜单（父子级菜单），菜单——资源（限定到某一个操作）

## 项目结构介绍

## 更新进度
### 下一步功能更新点
1.管理平台角色-菜单，菜单-资源功能的开发
2.商品ES测试
3.商品添加中，商品主题关联

## 联系交流
### 作者微信：
selectedBy
### 微信二维码：

### 微信交流群：
