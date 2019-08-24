# ifc

#### 项目介绍
兼容MySQL、Oracle，Thymeleaf升级到3.0，默认Session存入Redis等；
感谢fc作者 @lcg0124 的分享。
fc地址：
https://gitee.com/lcg0124/fc

### 改造说明
1、扩展已有的R类型，可以更方便的返回不同类型数据；

2、 **主键生成方案改造** （暂定sys_seq方案）；

4、配置权限：新增按钮时，CRUD公共按钮的权限默认值；

5、html引入文件改为全路径；搜索功能扩展；

6、公共js引入，并规范文件命名；常用js封装（前端页面间传值、js序列化方案调整等）；

7、 **代码生成调整** ：

    单表生成代码时，弹窗选择生成策略；
    包命名路径调整；
    加入js验证(长度限制，必输控制)；
    bootstrapTable的columns放到html中；列表都加上_list；
    新增/修改统一为一个_edit文件；js文件命名一同调整。
    Mapper生成默认路径改为“mybatis”目录下。
    js操作列：编辑、删除 html公共化处理；
    单表字段Constant生成；

8、默认排序设置；

9、默认进入登陆页，退出到登陆页。

10、 **Oracle兼容改造完成** ：

    去掉mybatis中mysql 的特殊符号；
    mybatis 特殊类型（如日期类型），insert的参数，加jdbcType；
    分页改为PageHelper，并封装分页操作；
    原mybatis中mysql自增主键改造；
    批量insert改为mysql和Oracle两套方案。
    代码生成的底层sql改成oracle兼容，代码生成工具类改成对应；
    代码生成模板，统一主键的命名规范；
    代码生成加上Oracle的类型判断处理；
    yml配置文件中加入oracle/mysql的类型配置。

11、 **同时支持root、非root部署。** 

#### 安装教程

1. MySQL建库fc后，直接运行脚本/db/db-mysql-fc.sql
2. Oracle建库orcl后，还需要创建用户std(不然要手动改脚本中的用户名)，直接运行脚本/db/db-mysql-fc.sql
3. 默认使用Redis存储Session

#### 使用说明

1. 单表代码生成策略
![输入图片说明](https://images.gitee.com/uploads/images/2018/1126/224630_89035c7d_395010.png "2.png")

2. 菜单中，CRUD按钮的默认值处理
![输入图片说明](https://images.gitee.com/uploads/images/2018/1126/224714_eb5fb24e_395010.png "1.png")

3. 规范生成代码文件命名
![输入图片说明](https://images.gitee.com/uploads/images/2018/1126/224828_09064256_395010.png "屏幕截图.png")

4. 部署到ROOT下
![输入图片说明](https://images.gitee.com/uploads/images/2018/1127/113749_29e80bb6_395010.png "屏幕截图.png")

5. 部署到非ROOT下
![输入图片说明](https://images.gitee.com/uploads/images/2018/1127/113737_e536e335_395010.png "屏幕截图.png")

#### 后续计划

1、数据字典改造，前端公共查询，缓存到redis；

2、菜单改为存取自Redis，排序问题；

3、整合hutool，规范utils；【已完成】

4、Mapper中支持继承map的封装后类型R；

5、mybatis逐步迁移到mybatis plus；

6、同时支持多数据源（目前是兼容，不是同时多数据源）；【已完成】

7、图片/文件上传到MongoDB

11、volecity换成beetl

12、thymeleaf换成beetl

#### 参与贡献

再次感谢fc作者 @lcg0124 的分享。
