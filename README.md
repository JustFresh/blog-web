# 项目名称 
AngularJS6+SpringBoot1.5.15前后端分离SPA博客系统实战

# 背景介绍
本人为一个略懂前端的后端程序猿，仅此希望以写博客的方式，首先锤炼个人技术，其次若能为大家带来一丝一毫的帮助，那更不甚欢喜。  
PS：个人技术有限，若有理解错误的地方，万望不吝指正，在此拜谢。

# 项目架构
SpringBoot1.5.5 MySQL JPA AngularJS6 NG-ZORRO前端UI框架  Cheditor富文本编辑器

# 使用说明
方法1.下载源码导入直接启动。  
	1.1.直接在GitHub下载对应的前后端源码（后端源码含有SQL语句，SQL位于blog-web/src/main/resources/doc/xda_blog.sql），  
	1.2.系统安装MySql，新建名为xda的数据库，使用Navicat工具导入步骤1.1的SQL文件。  
	1.3.eclipse导入后端项目源代码，修改blog-web/src/main/resources/application.properties文件中指向MySql数据库的账号和密码，右键blog-web项目的InitApp.java类，以SpringBoot方式启动后端项目即可（启动完毕可以在浏览器输入http://localhost:8090/swagger-ui.html）查看开放接口列表，若能正确查看到swagger接口列表页面，则正常启动。
	1.4.使用任意前端编辑器导入前端blog-web项目，打开DOS界面，cd切换到前端项目的硬盘地址，执行npm install下载所需前端依赖，知道依赖下载完成。修改前端blog-web/src/environments/environment.ts文件的SERVER_URL为步骤1.3的地址及端口号（若为同一台电脑启动，则改为http://localhost:8090），同时websocketServerUrl做相应修改。
	1.5.打开DOS，cd切换到前端blog-web项目目录下，执行npm start命令，待启动命令执行完毕，打开浏览器访问http://localhost:4200即可。
方法2：参照https://blog.csdn.net/u012459871/article/details/86628575地址的本人博客，逐步搭建环境及开发。

# 关于本人
	QQ： 991058975
	Email: justfresh@foxmail.com
	Site： http://www.xiudoua.com
	个人订阅号：秀逗啊
