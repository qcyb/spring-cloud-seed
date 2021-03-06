# spring-cloud-seed
	├── USER-API                      // 公共API模块,可打成jar包供外部Feign分布式调用
	│   ├── src/main
	│   ├── ├──java/com/ycw/user
	│   ├── ├──├──service             // API接口
	│   ├── ├──├──vo                  // 接口返回对象
	│   ├── ├──├──├──param            // 接口入参对象
	├── pom.xml
	├── USER-SERVICE                  // SERVICE模块, 对API的具体实现
	│   ├── src/main
	│   ├── ├──java/com/ycw/user
	│   ├── ├──├──client              // 分布式调用的客户端
	│   ├── ├──├──fallback            // 分布式容错
	│   ├── ├──├──entity              // 实体类
	│   ├── ├──├──mapper              // mapper接口
	│   ├── ├──├──service.impl        // API接口的实现类
	│   ├── ├──resources
	│   ├── ├──├──mybatis
	│   ├── ├──├──├──mapper           // mapper.xml文件
	├── pom.xml
	├── USER-WEB                      // WEB模块
	│   ├── src/main
	│   ├── ├──java/com/ycw/user
	│   ├── ├──├──controller          // 控制层
	│   ├── ├──resources
	│   ├── ├──├──application.yml     // springboot配置文件
	│   ├── ├──├──bootstrap.yml       // 分布式注册中心cousul配置文件
	├── pom.xml

相关文章：
1. [服务注册中心Consul安装与配置（windows）](https://blog.csdn.net/qq_30133811/article/details/101377828)
2. [项目启动](https://blog.csdn.net/qq_30133811/article/details/101759846)
3. [为何要构建Api、Service、Web三层](https://blog.csdn.net/qq_30133811/article/details/101772734)
4. [Feign进行分布式服务调用](https://blog.csdn.net/qq_30133811/article/details/102387903)