# MovieSys
影院管理系统

待项目运行一次之后再导入测试数据, 项目运行时会自动创建表<br>
如果IDE没有装Lombok插件, 可能会标红, 但不影响运行, 问题不大

**一、SpringBoot直接运行**
1. 数据库初始化 <br>
    1.1 在mysql创建moviesys数据库，字符集utf8 <br>
    1.2  在src/resources/application-dev.yml里面将spring.datasource.password修改成数据库密码
2. 运行src/main/java/team/csjr/moviesys/MoviesysApplication.java的main函数
3. 页面访问：http://127.0.0.1：8080

**二、docker运行**
1. 确认centos里面安装了docker和docker-compose，centos版本要求6.8以上
2. cd /user/local
3. git clone https://gitee.com/ReMidDream/moviesys.git
4. cd moviesys
5. docker-compose up
4. 页面访问：http://服务器IP 例如: http://47.109.157.111

**三、图片上传路径处理**
1. 第一种方式运行时部署到云服务器src/resources/application-dev.yml 将serverIp 改成 服务器IP:8080
2. docker运行, 将src/resources/application-dev.yml 将serverIp 改成 服务器IP
3. 若使用**测试数据**无法显示出图片为正常情况, 按照正常操作后, 添加的数据均能正常显示

**四、测试帐号**
1. 用户： <br>
帐号： user 密码：123456
2. 管理员: <br>
帐号： admin 密码：123456

**五、登录处理时间过长**<br>
1. 如果在Linux里面, 第一种方式运行参考: https://blog.csdn.net/qq_33811662/article/details/81506222
<br>
2. 若Docker里面运行, 在服务器里面echo $JAVA_HOME, 记录下路径
把在docker-compose的services.app.volumes的
/usr/java/jdk1.8.0_191/jre/lib/security/java.security:/docker-java-home/jre/lib/security/java.security<br>
修改为<br>路径jre/lib/security/java.security:/docker-java-home/jre/lib/security/java.security


